package services;

import exceptions.NotFoundException;
import lombok.Getter;
import lombok.NonNull;
import models.CabDriver;
import models.RideTaker;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class CabDriverService {
    private final HashMap<String, CabDriver> cabDrivers;

    public CabDriverService(){
        this.cabDrivers = new HashMap<>();
    }

    public CabDriver createCabDriver(@NonNull final String name){
        String id = UUID.randomUUID().toString();
        CabDriver cabDriver = new CabDriver(id,name);
        cabDrivers.put(id,cabDriver);
        return cabDriver;
    }

    public CabDriver getCabDriver(@NonNull final String id){
        if(!cabDrivers.containsKey(id)){
            throw new NotFoundException();
        }
        return cabDrivers.get(id);
    }

    public CabDriver findEligibleDriver(@NonNull final RideTaker rideTaker){
        String cabDriverID = "";
        float bestRating = -1f;

        for(Map.Entry<String,CabDriver> cabDriverEntry: cabDrivers.entrySet()){
            CabDriver cabDriverEntryValue = cabDriverEntry.getValue();
            if( cabDriverEntryValue.getAvgRating() > rideTaker.getAvgRating() &&
                    cabDriverEntryValue.getAvgRating() > bestRating &&
                    !rideTaker.getOneStarRatings().contains(cabDriverEntryValue.getId()) &&
                    !cabDriverEntryValue.getOneStarRatings().contains(rideTaker.getId())){
                cabDriverID = cabDriverEntryValue.getId();
                bestRating = cabDriverEntryValue.getAvgRating();
            }
        }

        if(cabDriverID.equals("")){
            for(Map.Entry<String,CabDriver> cabDriverEntry: cabDrivers.entrySet()){
                CabDriver cabDriverEntryValue = cabDriverEntry.getValue();
                if(cabDriverEntryValue.getAvgRating() > bestRating &&
                        !rideTaker.getOneStarRatings().contains(cabDriverEntryValue.getId()) &&
                        !cabDriverEntryValue.getOneStarRatings().contains(rideTaker.getId())){
                    cabDriverID = cabDriverEntryValue.getId();
                    bestRating = cabDriverEntryValue.getAvgRating();
                }
            }
            if(cabDriverID.equals("")){
                throw new NotFoundException();
            }
        }

        return cabDrivers.get(cabDriverID);
    }
}
