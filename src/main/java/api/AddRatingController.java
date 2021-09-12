package api;

import lombok.NonNull;
import models.CabDriver;
import models.RideTaker;
import services.AddRatingService;
import services.CabDriverService;
import services.RideTakerService;

import java.util.Map;

public class AddRatingController {
    private final CabDriverService cabDriverService;
    private final RideTakerService rideTakerService;
    private final AddRatingService addRatingService;

    public AddRatingController(@NonNull final CabDriverService cabDriverService,
                               @NonNull final RideTakerService rideTakerService,
                               @NonNull final AddRatingService addRatingService){
        this.cabDriverService = cabDriverService;
        this.rideTakerService = rideTakerService;
        this.addRatingService = addRatingService;
    }

    public void AddRating(@NonNull final String riderName,@NonNull final int riderRating,
                          @NonNull final String driverName,@NonNull final int driverRating){
        String cabDriverId = "";
        String rideTakerId = "";

        for(Map.Entry<String, CabDriver> cabDriverEntry: cabDriverService.getCabDrivers().entrySet()){
            if(cabDriverEntry.getValue().getName().equals(driverName)){
                cabDriverId = cabDriverEntry.getValue().getId();
            }
        }

        for(Map.Entry<String, RideTaker> rideTakerEntry: rideTakerService.getRideTakers().entrySet()){
            if(rideTakerEntry.getValue().getName().equals(riderName)){
                rideTakerId = rideTakerEntry.getValue().getId();
            }
        }

        CabDriver cabDriver;
        if(cabDriverId.equals("")){
            cabDriver = cabDriverService.createCabDriver(driverName);
        }else{
            cabDriver = cabDriverService.getCabDriver(cabDriverId);
        }

        RideTaker rideTaker;
        if(rideTakerId.equals("")){
            rideTaker = rideTakerService.createRideTaker(riderName);
        }else{
            rideTaker = rideTakerService.getRideTaker(rideTakerId);
        }
        addRatingService.addRating(rideTaker, riderRating,cabDriver, driverRating);
        System.out.println("Added New Rating");
    }

}
