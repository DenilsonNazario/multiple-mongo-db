package com.example.multiple.mongo.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "vehicles")
@Data
@Builder
public class VehicleModel {

    @Id
    private String id;
    private String cor;
    private Double price;
}
