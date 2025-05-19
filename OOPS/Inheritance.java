package oops_simple_codes;

class Person {
    String name;
    void sayHi() {
        System.out.println("Hi, I'm " + name + ".");
    }
}

class Student extends Person {
    void study() {
        System.out.println("I'm studying.");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Harshit";
        s.sayHi();
        s.study();
    }
}
