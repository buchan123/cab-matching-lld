# Cab Matching Problem

## Description:-
A cab company has the list of cab rides after it gets completed.
After the journey both cab driver and ride taker provide rating to 
each other. Rating can be from 1 to 5 where 5 is the best rating and
1 is the worst rating.

Given a Ride taker name, find the eligible cab drivers for him based
on the historical data that is being given to you. The criterion ar
given below to choose eligible cab drivers :-
    
1. Avg rating of cab driver should be greater than average rating of 
ride taker (Choose with Highest Rating).
2. If no cab driver is found then consider best of all of them.
3. If any cab driver has provided 1 rating to a ride taker or vice versa
then they are not allowed to do a ride together.
   
## Input:-
Ride dats is given(Ride Taker Name, Rating given to ride taker, Driver name, Rating given to driver)

1. Ride 1 - (Ram 3, Bheem 5)
2. Ride 2 - (Laxman 5, Nakul 2)
3. Ride 3 - (Ram 4, Sahadev 2)
4. Ride 4 - (Bharat 3, Bheem 5)
5. Ride 5 - (Ram 3, Bheem 1)
6. Ride 6 - (Laxman 5,Sahadev 3)
7. Ride 7 - (Bharat 5, Nakul 5)

### Find Eligible drivers for :-
1. Ram
2. Laxman

## Output 
1. Nakul
2. Bheem

## Input :- 
7
Ram 3 Bheem 5
Laxman 5 Nakul 2
Ram 4 Sahadev 2
Bharat 3 Bheem 5
Ram 3 Bheem 1
Laxman 5 Sahadev 3
Bharat 5 Nakul 5
2
Ram
Laxman


    