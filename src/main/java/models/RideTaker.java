package models;

import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;

@Getter
public class RideTaker {
    private final String id;
    private final String name;
    private final HashMap<String ,Integer> ratings;
    private Float AvgRating;


    public RideTaker(@NonNull final String id, @NonNull final String name){
        this.id = id;
        this.name = name;
        this.ratings = new HashMap<>();
        this.AvgRating = 0f;
    }

    private void RecomputeAvgRating(@NonNull final Integer rating){
        this.AvgRating = (this.AvgRating + rating) / this.ratings.size();
    }

    public void AddRating(@NonNull final Integer rating, @NonNull final CabDriver cabDriver){
        this.ratings.put(cabDriver.getId(),rating);
        this.RecomputeAvgRating(rating);
    }
}