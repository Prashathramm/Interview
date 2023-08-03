package Car;
import java.util.*;
import Owner.*;
public class Car extends Owner {

    // Display Cars
    public void displayCars() {
        for(int i=0;i<super.cars.size();++i) {
            System.out.println(cars.get(i).name);
        }
    }    

    // Checking for Availability
    public boolean isPresent(String name,int currTime) {
        for(int i=0;i<cars.size();++i) {
            if(cars.get(i).name.equals(name) && bookedCars.get(name).endTime<=currTime) {
                if(cars.get(i).isAvailable) {
                    return true;
                }
            }
        }
        return false;
    }
    public void book(String name,int currTime,int endTime,String userName) {
        for(int i=0;i<cars.size();++i) {
            if(cars.get(i).name.equals(name)) {
                cars.get(i).isAvailable = false;
                bookedCars.put(name,new Data(currTime,endTime));
                super.addInHistory(name,userName);
            }
        }
    }
    public boolean book(String name,int currTime,String userName) {
        for(int i=0;i<cars.size();++i) {
            if(cars.get(i).isAvailable == false) {
                cars.get(i).isAvailable = true;
                bookedCars.put(name,new Data(currTime,0));
                return true;
            }
        }
        return false;
    }
    public void rateCar(String userName,String name,int rate) {
        if(userRating.get(name)==null) {
            userRating.put(name,rate);
        } else {
            userRating.put(name,Math.max(userRating.get(name),rate));
        }
    }
}