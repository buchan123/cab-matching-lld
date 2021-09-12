package models;

import exceptions.InvalidRatingException;
import lombok.NonNull;

import java.util.HashMap;

public class CabDriver extends Person {

    public CabDriver(@NonNull final String id, @NonNull final String name){
        super(id,name);
    }

    public void AddRating(@NonNull final Integer rating, @NonNull final RideTaker rideTaker){
        if(rating > 5 || rating < 1){
            throw new InvalidRatingException();
        }

        if(rating == 1){
            this.getOneStarRatings().add(rideTaker.getId());
        }

        HashMap<String, Integer> ratingMap = new HashMap<>();
        ratingMap.put(rideTaker.getId(),rating);
        this.getRatings().add(ratingMap);
        this.RecomputeAvgRating(rating);
    }
}
