package oops_simple_codes;

// Method Overloading (Compile time polymorphism)
class Calculator {
    int add(int a, int b) {return (a+b);}
    double add(double a, double b) {return (a+b);}
}

//Method Overriding (Run time polymorphism)
class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}
public class Polymorphism {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.sound();
    }
}
