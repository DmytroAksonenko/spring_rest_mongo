package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;
import com.aksonenko.spring.data.PopCount;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
@RequiredArgsConstructor
public class PopDAOImpl implements PopDAO {

  private final MongoOperations db;

  @Override
  public List<PopData> getPopByFullName(String fullName) {
    Criteria criteria = new Criteria();
    criteria.andOperator(
        where("fullName").is(fullName),
        where("isPop").is(true)
    );

    return db.find(query(criteria), PopData.class);
  }

  @Override
  public HashMap<String, Integer> getTopNames() {

    MatchOperation matchOperation = Aggregation.match(
        Criteria.where("is_pep").is(true));

    GroupOperation groupOperation = Aggregation.group(
        "first_name_en").count().as("count");

    ProjectionOperation projectionOperation = Aggregation.project(
        "count").and("first_name_en").previousOperation();

    MatchOperation secondMatchOperation = Aggregation.match(
        new Criteria("count").gt(1));

    LimitOperation limitOperation = Aggregation.limit(10);

    SortOperation sortOperation = Aggregation.sort(
        Sort.by(Sort.Direction.DESC, "count", "first_name_en"));

    Aggregation aggregation = Aggregation.newAggregation(
        matchOperation, groupOperation, projectionOperation,
        secondMatchOperation, sortOperation, limitOperation);

    AggregationResults<PopCount> list = db.aggregate(
        aggregation, "pep", PopCount.class);

    List<PopCount> pops = list.getMappedResults();
    HashMap<String, Integer> map = new HashMap<>();

    for (PopCount pop : pops) {
      map.put(pop.getFirstName(), pop.getCount());
    }

    HashMap<String, Integer> sortedMap = map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .collect(Collectors.toMap(Map.Entry::getKey,
            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

    return sortedMap;

  }

}
