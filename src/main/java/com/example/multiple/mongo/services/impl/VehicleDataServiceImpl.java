package com.example.multiple.mongo.services.impl;

import com.example.multiple.mongo.models.VehicleModel;
import com.example.multiple.mongo.services.VehicleDataService;
import com.mongodb.client.model.CollationStrength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleDataServiceImpl implements VehicleDataService {

    @Qualifier("secondaryMongoTemplate")
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<VehicleModel> insert(List<VehicleModel> dealers) {
        return mongoTemplate.insert(dealers);
    }

    @Override
    public VehicleModel insert(VehicleModel dealer) {
        return mongoTemplate.insert(dealer, "vehicles");
    }

    @Override
    public VehicleModel findById(String id) {
        return mongoTemplate.findById(id, VehicleModel.class);
    }

    @Override
    public List<VehicleModel> findAll() {
        Query query = new Query();
        query.collation(Collation.of("en_US"));
        return mongoTemplate.find(query,VehicleModel.class, "vehicles");
    }
}
