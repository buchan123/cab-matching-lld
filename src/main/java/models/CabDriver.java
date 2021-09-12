package models;

import exceptions.InvalidRatingException;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class CabDriver {
    private final String id;
    private final String name;
    private final ArrayList<String> oneStarRatings;
    private final ArrayList<HashMap<String, Integer>> ratings;
    private Float AvgRating;

    public CabDriver(@NonNull final String id, @NonNull final String name){
        this.id = id;
        this.name = name;
        this.oneStarRatings = new ArrayList<>();
        this.ratings = new ArrayList<>();
        this.AvgRating = 0f;
    }

    private void RecomputeAvgRating(@NonNull final Integer rating){
        this.AvgRating = (this.AvgRating*(this.ratings.size() - 1) + rating) / this.ratings.size();
    }

    public void AddRating(@NonNull final Integer rating, @NonNull final RideTaker rideTaker){
        if(rating > 5 || rating < 1){
            throw new InvalidRatingException();
        }

        if(rating == 1){
            this.oneStarRatings.add(rideTaker.getId());
        }

        HashMap<String, Integer> ratingMap = new HashMap<>();
        ratingMap.put(rideTaker.getId(),rating);
        this.ratings.add(ratingMap);
        this.RecomputeAvgRating(rating);
    }
}
