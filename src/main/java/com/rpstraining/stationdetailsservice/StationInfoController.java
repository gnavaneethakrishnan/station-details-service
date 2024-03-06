package com.rpstraining.stationdetailsservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationInfoController {

    private List<StationDetails> stationList = Arrays.asList(
            new StationDetails(2986, "Madurai", "Chennai"),
            new StationDetails(6576, "Coimbatore", "Chennai"),
            new StationDetails(7873, "Uthagai", "Chennai")
    );

    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private StationDetailsRepository stationDetailsRepository;

    @GetMapping(value = "/{trainID}", produces = "application/json")
    public ResponseEntity<StationDetails> getStationDetails(@PathVariable("trainID") Integer trainID) {
//        StationDetails station = stationList.stream()
//                .filter(stationDetails -> stationDetails.getTrainID().equals(trainID))
//                .findFirst()
//                .orElseThrow(null);

        StationDetails station = stationDetailsRepository.findById(trainID)
                .orElseThrow(() -> new RuntimeException("station not found"));
        return new ResponseEntity<>(station, HttpStatus.OK);

    }

    @PostMapping("/newStation")
    public ResponseEntity<StationDetails> createStationDetails(@RequestBody StationDetails stationDetails) {
        StationDetails newStationDetails = stationDetailsRepository.save(stationDetails);
        return new ResponseEntity<>(newStationDetails, HttpStatus.CREATED);
    }


}
