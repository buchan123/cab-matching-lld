package api;

import exceptions.NoEligibleDriverFoundException;
import lombok.NonNull;
import models.RideTaker;
import services.CabDriverService;
import services.RideTakerService;

import java.util.Map;

public class MatchDriverWithRiderController {
    private final CabDriverService cabDriverService;
    private final RideTakerService rideTakerService;

    public MatchDriverWithRiderController(@NonNull final CabDriverService cabDriverService,
                                          @NonNull final RideTakerService rideTakerService){
        this.cabDriverService = cabDriverService;
        this.rideTakerService = rideTakerService;
    }

    public String MatchDriverWithRider(@NonNull final String riderName){
        for(Map.Entry<String, RideTaker> rideTakerEntry: rideTakerService.getRideTakers().entrySet()){
            if(rideTakerEntry.getValue().getName().equals(riderName)){
                return cabDriverService.findEligibleDriver(rideTakerEntry.getValue()).getName();
            }
        }
        throw new NoEligibleDriverFoundException();
    }
}
