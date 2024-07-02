package com.example.multiple.mongo.services;

import com.example.multiple.mongo.models.DealerModel;

import java.util.List;

public interface DealerDataService {

    List<DealerModel> insert(List<DealerModel> dealers);

    DealerModel insert(DealerModel dealer);

    DealerModel findById(String id);

    List<DealerModel> findAll();
}
