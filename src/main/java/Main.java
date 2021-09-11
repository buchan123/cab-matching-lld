import models.CabDriver;
import models.RideTaker;
import services.AddRatingService;
import services.CabDriverService;
import services.RideTakerService;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        CabDriverService cabDriverService = new CabDriverService();
        RideTakerService rideTakerService = new RideTakerService();
        AddRatingService addRatingService = new AddRatingService();

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String riderName = sc.next();
            int riderRating = sc.nextInt();
            String driverName = sc.next();
            int driverRating = sc.nextInt();

            String cabDriverId = "";
            String rideTakerId = "";

            for(Map.Entry<String, CabDriver> cabDriverEntry: cabDriverService.getCabDrivers().entrySet()){
                if(cabDriverEntry.getValue().getName().equals(driverName)){
                    cabDriverId = cabDriverEntry.getValue().getId();
                }
            }

            for(Map.Entry<String, RideTaker> rideTakerEntry: rideTakerService.getRideTakers().entrySet()){
                if(rideTakerEntry.getValue().getName().equals(riderName)){
                    rideTakerId = rideTakerEntry.getValue().getId();
                }
            }

            CabDriver cabDriver;
            if(cabDriverId.equals("")){
               cabDriver = cabDriverService.createCabDriver(driverName);
            }else{
                cabDriver = cabDriverService.getCabDriver(cabDriverId);
            }

            RideTaker rideTaker;
            if(rideTakerId.equals("")){
                rideTaker = rideTakerService.createRideTaker(riderName);
            }else{
                rideTaker = rideTakerService.getRideTaker(rideTakerId);
            }
            addRatingService.addRating(rideTaker, riderRating,cabDriver, driverRating);
        }

        n = sc.nextInt();
        for(int i=0;i<n;i++){
            String riderName = sc.next();

            for(Map.Entry<String, RideTaker> rideTakerEntry: rideTakerService.getRideTakers().entrySet()){
                if(rideTakerEntry.getValue().getName().equals(riderName)){
                    String output = cabDriverService.findEligibleDriver(rideTakerEntry.getValue()).getName();
                    System.out.println(output);
                }
            }
        }
    }
}
