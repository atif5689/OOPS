                                                 < Object-Oriented Programming: OOPS >


Object-Oriented Programming (OOP) is a programming style where we design programs using objects that represent real-world entities.

Java is a purely object-oriented language (almost everything is an object).

------------------------------------    -What is an Object?---------------------------------------------------------------------------------

An object is a real-world entity that has:

State → data (variables)

Behavior → actions (methods)

Example (Real life):

Object: Car

State: color, speed, brand

Behavior: start(), stop(), accelerate()

 -------------------------------------------------------------🔹 What is a Class?-------------------------------------------------------------

A class is a blueprint or template from which objects are created.
 
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving");
    }
}



--------------------------------------------------------⭐ Four Main Pillars of OOP in Java -----------------------------------------------

1️⃣ Encapsulation,

2️⃣ Inheritance,

3️⃣ Polymorphism,

4️⃣ Abstraction, 




------------------------------------------------------------- 1️⃣ Encapsulation,-------------------------------------------------------------


Encapsulation is an OOP concept that binds data and methods together and protects data from direct access.
 This  is the process of hiding data and allowing access to it only through methods.


example :-  class Student {
    private int age;                                        // data hidden

    
    public void setAge(int a) {
        if (a > 0) {
            age = a;                                            // setter - value set karega
        } else {
            System.out.println("Invalid age");
        }
    }

   
    public int getAge() {                                            // getter - value return karega
        return age;
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student();

        s.setAge(20);                                               // setter call
        System.out.println(s.getAge());                             // getter call
    }
}
 


example :- 
class Bank {

    private int balance;                                     // data hidden

    public void setBal(int a) {                                  // setter - value set karega
        if (a > 0) {
            balance = a;                                            
            System.out.println("Balance set successfully");
        } else {
            System.out.println("Invalid balance");
        }
    }

    public int getBal() {                                                     // getter - value return karega
        return balance;       
    }
}

class Main {
    public static void main(String[] args) {
        Bank b = new Bank();
 
        b.setBal(6500);                                                            // setter call
        System.out.println(b.getBal());                                          ///// getter call
    }
}



-----------------------------------------------------------------  2️⃣ Inheritance ----------------------------------------------------------

Inheritance is an OOP concept where one class acquires the properties and methods of another class.
It helps in code reusability, method overriding, and maintaining hierarchy.

Simple Definition

👉 Inheritance allows one class to reuse another class’s code.



example:-

class Animal{             ////////////  this is Superclass  it is also know as parent class 
    void eat(){
        System.out.println("eat food");
    }
    
}
class Dog extends Animal{                  ////////////////////// this is Subclass it is also known as child class 
    void dog(){
        System.out.println("dog bark ");
    }
    
    
}
class Main {
    public static void main(String[] args) {
     
     Dog a = new Dog();
     a.dog();
     a.eat();
     
    }
}




imp ques:- Can a child class access private members of a parent class? Why?

Ans :- No, a child class cannot access private members of a parent class because private members are
 restricted to the same class to ensure encapsulation.
    
 example :-
 class Parent {
    private int x = 10;
}

class Child extends Parent {
    void show() {
        // System.out.println(x);  // ❌ Compile-time error
    }
}
 

 Ques:- How can a child access parent’s private data?

✔ Indirectly, using public or protected methods (getters/setters)

example :- class Parent {
    private int x = 10;

    public int getX() {
        return x;
    }
}

class Child extends Parent {
    void show() {
        System.out.println(getX());  // ✅ Allowed
    }
}

Ques2:- Are constructors inherited in Java?

A constructor is used to create (initialize) an object of a class.
When a class is inherited, methods and variables can be inherited, but constructors cannot.  

easy defination :- 
Constructors are not inherited in Java, but the parent class constructor is invoked when a child class object is created.

Ques: Why constructors are not inherited?

A constructor has the same name as its class .


A child class has a different name, so it cannot inherit the parent’s constructor .

<<<<<Important Point (Very Important for Exams & Interviews)>>>>

Even though constructors are not inherited, the parent class constructor is called when an object of the child class is created.

example :- 
class Parent {
    Parent() {                                                ///////////  parent constructor/////////    
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    Child() {
        System.out.println("Child constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();                ////// child object is created   parent Constructor is automatically called //////////
    }
}


Ques:- Can inheritance exist without methods?


 Ans:-  Yes, inheritance can exist without methods because a child class can inherit
 only variables or constructors’ behavior from the parent class.  

 example:-      

class Parent {
    int x = 10;   // variable only
}

class Child extends Parent {
    int y = 20;
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
        System.out.println(obj.x);  // inherited variable
        System.out.println(obj.y);
    }
} 


QUes:- What happens if a class does not extend any class?

Ans:- If a class does not extend any class, Java automatically makes it a subclass of the Object class.

🔹 What Does the Class Get from Object?

Even if you don’t write extends Object, your class automatically inherits methods from Object, such as:

✔ toString()
✔ equals(Object obj)
✔ hashCode()
✔ getClass()
✔ clone()
✔ finalize() (deprecated)
✔ wait(), notify(), notifyAll()   

example:- 

class A {
}

public class Main {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.toString());
    }
}
  

  ques:- What is code reusability? 

  ANS:- Code reusability means using the same code again and again in different parts of a program without rewriting it.  


  QUES :- How many classes can a class extend in Java?  

Ans :- A class in Java can extend only ONE class. 

 🔹 Explanation (Clear & Simple)

Java does not support multiple inheritance with classes.
So a class cannot extend more than one class at the same time.  

example:-
class C extends A, B {   // ❌ ERROR
}  


Ques:- 🔹 Why Java Allows Only One Class?
  
 Ans :- To avoid the Diamond Problem, where ambiguity occurs if:

Two parent classes have the same method

Java doesn’t know which one to use  

example :- class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
}
 

 Ques :- 🔹 How to Achieve Multiple Inheritance in Java?

  ANS:- Java supports multiple inheritance using interfaces.  

  example :- 

  interface A {
    void display();
}

interface B {
    void display();
}

class C implements A, B {
    public void display() {
        System.out.println("Multiple inheritance using interface");
    }
}



Ques:- Types of inheritance supported by Java


Java supports the following types of inheritance:
Single Inheritance
One child class inherits from one parent class.

Multilevel Inheritance
A class inherits from another class which itself is inherited from another class.

Hierarchical Inheritance
Multiple child classes inherit from one parent class.

🚫 Not supported using classes:

Multiple inheritance

Hybrid inheritance

✅ These are possible using interfaces, not classes.
   

   Ques:- What is the use of the super keyword?

super is used to:

Access parent class variables

Call parent class methods

Call parent class constructor (super())

📌 It refers to the immediate parent class object.  


