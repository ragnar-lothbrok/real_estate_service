package com.assignment.realestate.service.impl;

import com.assignment.realestate.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Map<String,String>> findAllLocations() {
        List<Tuple> tupleList  = entityManager.createNativeQuery("select * from v_all_locations", Tuple.class).getResultList();
        List<String> columnNames = new ArrayList<>();
        if (tupleList.stream().count() > 0) {
            columnNames.addAll(tupleList.get(0).getElements().stream().map(tupleElement -> tupleElement.getAlias()).collect(Collectors.toList()));
        }
        List<Map<String,String>> values = new ArrayList<>();

        for (Tuple tuple : tupleList) {
            Map<String,String> tupleValues = new HashMap<>();
            for (int i = 0; i < columnNames.size(); i++) {
                tupleValues.put(columnNames.get(i), Objects.nonNull(tuple.get(columnNames.get(i))) ? tuple.get(columnNames.get(i)).toString() : null);
            }
            values.add(tupleValues);
        }
        return values;
    }
}
