package com.example.multiple.mongo.services;

import com.example.multiple.mongo.models.VehicleModel;

import java.util.List;

public interface VehicleDataService {

    List<VehicleModel> insert(List<VehicleModel> dealers);

    VehicleModel insert(VehicleModel dealer);

    VehicleModel findById(String id);

    List<VehicleModel> findAll();
}
