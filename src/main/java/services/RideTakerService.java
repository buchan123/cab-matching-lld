package services;

import exceptions.NotFoundException;
import lombok.Getter;
import lombok.NonNull;
import models.RideTaker;

import java.util.HashMap;
import java.util.UUID;

@Getter
public class RideTakerService {
    private final HashMap<String, RideTaker> rideTakers;

    public RideTakerService(){
        this.rideTakers = new HashMap<>();
    }

    public RideTaker createRideTaker(@NonNull final String name){
        String id = UUID.randomUUID().toString();
        RideTaker rideTaker = new RideTaker(id,name);
        rideTakers.put(id,rideTaker);
        return rideTaker;
    }

    public RideTaker getRideTaker(@NonNull final String id){
        if(!rideTakers.containsKey(id)){
            throw new NotFoundException();
        }
        return rideTakers.get(id);
    }
}
