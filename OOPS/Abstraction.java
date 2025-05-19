package oops_simple_codes;

abstract class Vehicle {
    abstract void start();
}

class Bike extends Vehicle {
    void start() {
        System.out.println("Bike started with kick.");
    }
}

class Car extends Vehicle {
    void start() {
        System.out.println("Car started with button.");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Vehicle v1 = new Bike();
        v1.start();

        Vehicle v2 = new Car();
        v2.start();
    }
}
