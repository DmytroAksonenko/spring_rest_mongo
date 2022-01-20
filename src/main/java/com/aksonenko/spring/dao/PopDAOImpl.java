package com.aksonenko.spring.dao;

import com.aksonenko.spring.data.PopData;
import com.aksonenko.spring.repository.PopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PopDAOImpl implements PopDAO {

    @Autowired
    private PopRepository repository;

    @Override
    public PopData getPopByFullName(String fullName) {
        PopData pop = repository.findByFullName(fullName);
        if (pop.isPop()) {
            return pop;
        } else {
            return null;
        }
    }

    @Override
    public HashMap<String, Integer> getTopNames() {
        List<PopData> pops = repository.findAll();
        HashMap<String, Integer> map = new HashMap<>();

        for (PopData pop : pops) {
            if (pop.isPop() == true) {
                if (map.containsKey(pop.getFirstName()) == false) {
                    map.put(pop.getFirstName(), 1);
                } else {
                    for (Map.Entry<String, Integer> entry : map.entrySet()) {
                        if (entry.getKey().equals(pop.getFirstName())) {
                            int count = entry.getValue();
                            map.replace(pop.getFirstName(), count + 1);
                        }
                    }
                }

            }
        }

        HashMap<String, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(10).collect(Collectors
                        .toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o2, LinkedHashMap::new));

        return sortedMap;
    }

}