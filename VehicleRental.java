abstract class Vehicle {
    private String vehicleId;
    private String model;
    private boolean isRented;

    public Vehicle(String vehicleId, String model) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.isRented = false;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rent() {
        if (!isRented) {
            isRented = true;
        } else {
            System.out.println("Vehicle is already rented.");
        }
    }

    public void returnVehicle() {
        if (isRented) {
            isRented = false;
        } else {
            System.out.println("Vehicle is not currently rented.");
        }
    }

    public abstract double calculateRentalCost(int days);

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId='" + vehicleId + '\'' +
                ", model='" + model + '\'' +
                ", isRented=" + isRented +
                '}';
    }
}

// Car class extending Vehicle
class Car extends Vehicle {
    private double dailyRate;

    public Car(String vehicleId, String model, double dailyRate) {
        super(vehicleId, model);
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }
}

// Bike class extending Vehicle
class Bike extends Vehicle {
    private double hourlyRate;

    public Bike(String vehicleId, String model, double hourlyRate) {
        super(vehicleId, model);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateRentalCost(int hours) {
        return hours * hourlyRate;
    }
}

// Customer class
class Customer {
    private String customerId;
    private String name;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

// Rental class
class Rental {
    private Customer customer;
    private Vehicle vehicle;
    private int rentalDuration; // in days or hours, depending on the vehicle type

    public Rental(Customer customer, Vehicle vehicle, int rentalDuration) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDuration = rentalDuration;
    }

    public void startRental() {
        if (!vehicle.isRented()) {
            vehicle.rent();
            System.out.println("Rental started for vehicle: " + vehicle.getModel() + " by customer: " + customer.getName());
        } else {
            System.out.println("Vehicle is already rented.");
        }
    }

    public void endRental() {
        if (vehicle.isRented()) {
            vehicle.returnVehicle();
            double cost = vehicle.calculateRentalCost(rentalDuration);
            System.out.println("Rental ended. Total cost: $" + cost);
        } else {
            System.out.println("Vehicle was not rented.");
        }
    }

    @Override
    public String toString() {
        return "Rental{" +
                "customer=" + customer +
                ", vehicle=" + vehicle +
                ", rentalDuration=" + rentalDuration +
                '}';
    }
}

// Main class to demonstrate functionality
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create vehicles
        Car car1 = new Car("C001", "Toyota Corolla", 50);
        Bike bike1 = new Bike("B001", "Mountain Bike", 10);

        // Create customers
        Customer customer1 = new Customer("CU001", "John Doe");

        // Create rentals
        Rental rental1 = new Rental(customer1, car1, 3); // 3 days rental
        Rental rental2 = new Rental(customer1, bike1, 5); // 5 hours rental

        // Start and end rentals
        rental1.startRental();
        rental1.endRental();

        rental2.startRental();
        rental2.endRental();
    }
}
