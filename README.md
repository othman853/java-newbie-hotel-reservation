# Java 8 Newbie Hotel Reservation Implementation

For learning purposes

 - Trying to be simple
 - Trying to apply the best of OO
 - Trying to use some Java 8 features
 - Writing tests first

**** 

## Project Configuration:

##### This HotelReservation solution has been developed using Java 8, IntelliJ Idea 15 Community Edition and Gradle.

 - The only IDE plugin added to the gradle file is the 'idea' plugin, therefore, if you wish to open and run it in
Eclipse or any other IDE, please, apply the plugin on build.gradle file accordingly.

 - Tests were written using JUnit.

 - The application has a text file containing all inputs from the problem located under the package:
 `src.main.java.com.yrachid.reservations.resources`

 - ##### It is also possible to specify your own file by passing its path through command line arguments.

**** 

## Solution's Architecture:

It might be easier to explain and understand the architecture if we look under its packages:

 - ##### io
     - `FileReader`
          
         > Reads all lines from a file in the file system

     - `StreamBasedFileReader`
          
          > Reads all lines form a file using the Java 8 API, returning all read values into a Collection of Strings.

 - ##### parsing
      - `PatternParser`
          
          > Parses a String pattern into objects, like a deserialization process

      - `CustomerTypePatternParser`
          
          > Parses the Customer Type inside of a given pattern. Returns REGULAR or REWARDS represented by the CustomerType
          > Enum when one of them can be found. If both patterns are absent, throws an Exception.

 - ##### repositories
      - `HotelRepository`
          > Specifies how the data about hotels should be provided by other domains of the solution.

      - `InMemoryRepository`
          > Hardcoded date of Hotels related to the problem are returned according to the HotelRepository Interface

 - ##### exceptions 
 
> This package contains all custom exceptions of this solution

 - ##### data
      - `SmallestComparator`
          > Similar to Comparable interface, intends to make an implementor able to say who is the smallest between itself
          > and another instance of its same type

      - `CustomerType`
          > Represents customer types: Regular and Rewards

      - `DayType`
          > Represents day types: Weekday and Weekend

      - `Hotel`
          > Data Class to represent Hotels with name, rating and a list prices

      - `HotelPrice`
          > Represents a Hotel price regarding the day and customer types and the corresponding value for such aspects

      - `Reservation`
          > Represents a Reservation regarding customer type and the multiple reservation dates

      - `ReservationPrice`
          > Represents a Reservation Price which is the result of the accumulation of the
          > values of hotel prices that match the Reservation details (customer type and dates)


 - ##### business
     - `PriceCalculator`
         > Calculates the price of a reservation

     - `CheapestPriceCalculator`
         > Calculates the price of a reservation given the hotel prices available on the system

 - ##### app
    - `Runner`
        > Contains the main method. It is responsible for preparing the app to run, mainly by resolving dependencies.

    - `HotelReservation`
        > The application beginning. Where everything is wired together to solve the problem.
 
