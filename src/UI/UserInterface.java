package UI;
import java.util.*;
import UserInfo.UserInfo;
import Car.Car;
public class UserInterface {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        boolean flag = true;
        int currTime = 1;
        while(flag) {
            System.out.println("Hello user. Select any of the options to rent a car");
            displayDetails();
            int option = sc.nextInt();
            switch(option) {
                case 1: 
                {
                    System.out.println("Name: ");  
                    String nameOfUser = sc.nextLine(); 
                    System.out.println("No of hrs of rental: ");
                    int hrsOfRental = sc.nextInt();   
                    UserInfo user = new UserInfo(nameOfUser, hrsOfRental);
                    Car car = new Car();
                    car.displayCars();
                    System.out.println("Book a car of your need for rent: ");
                    String carName = sc.nextLine();
                    boolean check = car.isPresent(carName,currTime);
                    if(check) {
                        car.book(carName,currTime,currTime+hrsOfRental,nameOfUser);
                        System.out.println("Booked successfully");
                    } else {
                        System.out.println("Car is not available right now. Choose any other cars");
                    }
                }
                case 2: 
                {
                    System.out.println("Name: ");  
                    String nameOfUser = sc.nextLine();
                    UserInfo user = new UserInfo(nameOfUser);     
                    Car car = new Car();
                    boolean isBooked = car.book(nameOfUser,currTime,nameOfUser);
                    if(isBooked) {
                        System.out.println("Booked successfully");
                    } else {
                        System.out.println("Booking failure");
                    }
                }
            }
            currTime += 1;
        }
    }
    public static void displayDetails() {
        System.out.println("--------------------------------------");

        System.out.println("1. Rent");
        System.out.println("2. Emergency Rent");
        System.out.println("3. Book in Advance");

        System.out.println("--------------------------------------");
    }
}
