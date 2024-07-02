package com.example.multiple.mongo;

import com.example.multiple.mongo.models.DealerModel;
import com.example.multiple.mongo.models.VehicleModel;
import com.example.multiple.mongo.services.DealerDataService;
import com.example.multiple.mongo.services.VehicleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private DealerDataService dealerService;

    @Autowired
    private VehicleDataService vehicleService;

    @Override
    public void run(String... args) throws Exception {

//        dealerService.insert(DealerModel.builder()
//                .id(UUID.randomUUID().toString())
//                .name("fulano Veiculos")
//                .document("1234-0001.17")
//                .build());
//
//        vehicleService.insert(VehicleModel.builder()
//                .id(UUID.randomUUID().toString())
//                .cor("red")
//                .price(35.000)
//                .build());


//        DealerModel dealers = dealerService.findById("a980652a-d654-4ba8-bdf2-5e18b7d73730");
        List<DealerModel> dealers = dealerService.findAll();

        List<VehicleModel> vehicles = vehicleService.findAll();

    }
}
