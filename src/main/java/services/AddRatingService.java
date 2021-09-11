package services;

import lombok.NonNull;
import models.CabDriver;
import models.RideTaker;

public class AddRatingService {
    public void addRating(@NonNull final RideTaker rideTaker,
                          @NonNull final Integer rideTakerRating,
                          @NonNull final CabDriver cabDriver,
                          @NonNull final Integer cabDriverRating) {
        rideTaker.AddRating(rideTakerRating, cabDriver);
        cabDriver.AddRating(cabDriverRating, rideTaker);
    }
}
