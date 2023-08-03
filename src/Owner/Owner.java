package Owner;
import java.util.*;
public class Owner {

    public Map<String,String>history = new HashMap<>();
    public Map<String,Data>bookedCars = new HashMap<>();
    public Map<String,Data>userRating = new HashMap<>();
    protected List<Pair>cars = Arrays.asList(new Pair(true,"Sedan"),
    new Pair(true,"Prime"),
    new Pair(true,"Alto"),
    new Pair(true,"Swift"),
    new Pair(true,"Innova"));

    public void addInHistory(String name,String userName) {
        history.put(name,userName);
    }
}

