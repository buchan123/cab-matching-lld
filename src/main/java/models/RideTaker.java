package models;

import exceptions.InvalidRatingException;
import lombok.NonNull;

import java.util.HashMap;


public class RideTaker extends Person {
    public RideTaker(@NonNull final String id, @NonNull final String name){
        super(id,name);
    }

    public void AddRating(@NonNull final Integer rating, @NonNull final CabDriver cabDriver){
        if(rating > 5 || rating < 1){
            throw new InvalidRatingException();
        }

        if(rating == 1){
            this.getOneStarRatings().add(cabDriver.getId());
        }

        HashMap<String, Integer> ratingMap = new HashMap<>();
        ratingMap.put(cabDriver.getId(),rating);
        this.getRatings().add(ratingMap);
        this.RecomputeAvgRating(rating);
    }
}
