package models;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

@Getter
public class Person {
    private final String id;
    private final String name;
    private final ArrayList<HashMap<String, Integer>> ratings;
    private final ArrayList<String> oneStarRatings;
    private Float AvgRating;

    public Person(@NonNull final String id, @NonNull final String name){
        this.id = id;
        this.name = name;
        this.ratings = new ArrayList<>();
        this.oneStarRatings = new ArrayList<>();
        this.AvgRating = 0f;
    }

    public void RecomputeAvgRating(@NonNull final Integer rating){
        this.AvgRating = (this.AvgRating*(this.ratings.size() - 1) + rating) / this.ratings.size();
    }
}
