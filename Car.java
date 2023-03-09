import java.util.ArrayList;

public class Car {
    private int maxCapacity;
    private ArrayList<Passenger> passengers = new ArrayList<>(maxCapacity);


    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    
    }

    public int getCapacity() {
        return this.maxCapacity;
    } 

    public int seatsRemaining() {
        return this.maxCapacity - passengers.size();
    }

    public void addPassenger(Passenger p) {
        if (passengers.size() < this.maxCapacity) {
            passengers.add(p);
        }
        else {
            throw new RuntimeException("Not enough seats :(");
        }
    }
    public void removePassenger(Passenger p) {
        if (passengers.contains(p)) {
            passengers.remove(p);
        }
        else {
            throw new RuntimeException("This passenger is not in this car");
        }
    }
    

    public void printManifest() {
        if (passengers.isEmpty()) {
            System.out.print("This car is EMPTY");
        }
        else {
            for (Passenger p : passengers) {
                System.out.println(getPassenger());
            }
        }
    }


    public static void main(String[] args) {
        Car myCar = new Car(2);
        Passenger p = new Passenger("Mary");
        try {
            myCar.addPassenger(p);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(myCar.seatsRemaining());
        System.out.println(myCar.getCapacity());
        try {
            myCar.printManifest();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        

}
}

// - a private `ArrayList` where it will store the `Passenger`s currently onboard, and an `int` for the `Car`'s maximum capacity
//     (since `ArrayList`s will expand as we add objects, we'll need to manually limit their size)
//  -   - a constructor, which takes in an initial value for the `Car`'s maximum capacity and initializes an appropriately-sized
//     `ArrayList`
//  - accessor-like methods `public int getCapacity()` and `public int seatsRemaining()` that return the maximum capacity
//     and remaining seats, respectively
//  - methods `public void addPassenger(Passenger p)` and `public void removePassenger(Passenger p)` to add or remove 
//     a `Passenger` from the `Car` (_Hint: don't forget to check that there are seats available if someone wants to board, 
//     and to confirm that the `Passenger` is actually onboard before trying to remove them! If you encounter a problem, 
//     throw a `RuntimeException`._)
//  - and a final method `public void printManifest()` that prints out a list of all `Passenger`s aboard the car 
//     (or "This car is EMPTY." if there is no one on board)