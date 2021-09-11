package models;

import exceptions.InvalidRatingException;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class RideTaker {
    private final String id;
    private final String name;
    private Integer ratingCount;
    private final ArrayList<String> oneStarRatings;
    private Float AvgRating;


    public RideTaker(@NonNull final String id, @NonNull final String name){
        this.id = id;
        this.name = name;
        this.ratingCount = 0;
        this.oneStarRatings = new ArrayList<>();
        this.AvgRating = 0f;
    }

    private void RecomputeAvgRating(@NonNull final Integer rating){
        this.ratingCount += 1;
        this.AvgRating = (this.AvgRating*(this.ratingCount - 1) + rating) / this.ratingCount;
    }

    public void AddRating(@NonNull final Integer rating, @NonNull final CabDriver cabDriver){
        if(rating > 5 || rating < 1){
            throw new InvalidRatingException();
        }
        if(rating == 1){
            this.oneStarRatings.add(cabDriver.getId());
        }
        this.RecomputeAvgRating(rating);
    }
}
