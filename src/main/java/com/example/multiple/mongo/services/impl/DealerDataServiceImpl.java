package com.example.multiple.mongo.services.impl;

import com.example.multiple.mongo.models.DealerModel;
import com.example.multiple.mongo.services.DealerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DealerDataServiceImpl implements DealerDataService {

    @Qualifier("primaryMongoTemplate")
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<DealerModel> insert(List<DealerModel> dealers) {
        return mongoTemplate.insert(dealers);
    }

    @Override
    public DealerModel insert(DealerModel dealer) {
        return mongoTemplate.insert(dealer, "dealers");
    }

    @Override
    public DealerModel findById(String id) {
        return mongoTemplate.findById(id, DealerModel.class, "dealers");
    }

    @Override
    public List<DealerModel> findAll() {
        Query query = new Query();
        query.collation(Collation.of("en_US"));
        return mongoTemplate.find(query,DealerModel.class);
    }
}
