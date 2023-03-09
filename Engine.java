public class Engine {

    private FuelType fuelType;
    private double myFuel;
    private double maxFuel;

    public Engine(FuelType fuelType, double maxFuel) {
        this.fuelType = fuelType;
        this.myFuel = maxFuel;
        this.maxFuel = maxFuel;
    }
    

    public void refuel() {
        this.myFuel = maxFuel;   
    }

    public void go() {   
        if (this.myFuel > 0) {
            System.out.println("Current fuel level: " + this.myFuel);
            this.myFuel = this.myFuel - 1;    
        }
        else {
            throw new RuntimeException("Out of fuel :(");   
        }

    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}
