import api.AddRatingController;
import api.MatchDriverWithRiderController;
import exceptions.NoEligibleDriverFoundException;
import services.AddRatingService;
import services.CabDriverService;
import services.RideTakerService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        final CabDriverService cabDriverService = new CabDriverService();
        final RideTakerService rideTakerService = new RideTakerService();
        final AddRatingService addRatingService = new AddRatingService();

        AddRatingController addRatingController = new AddRatingController(cabDriverService,
                rideTakerService, addRatingService);
        MatchDriverWithRiderController matchDriverWithRiderController = new MatchDriverWithRiderController(cabDriverService,
                rideTakerService);

        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            String riderName = sc.next();
            int riderRating = sc.nextInt();
            String driverName = sc.next();
            int driverRating = sc.nextInt();
            addRatingController.AddRating(riderName,riderRating,driverName,driverRating);
        }


        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            String riderName = sc.next();
            try{
                String driverName = matchDriverWithRiderController.MatchDriverWithRider(riderName);
                System.out.println("Driver :"+driverName);
            }
            catch (NoEligibleDriverFoundException e){
                System.out.println("No Eligible Drivers Found");
            }
        }
    }
}
