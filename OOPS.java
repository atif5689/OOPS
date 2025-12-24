                                                 < Object-Oriented Programming: OOPS >


OOPS (Object-Oriented Programming System) is a programming approach based on objects and classes.
It helps in organizing code by combining data and methods, making programs reusable and easy to maintain.

Java is not a purely object-oriented language.
It is an object-oriented language with some non-object features.
------------------------------------    -What is an Object?---------------------------------------------------------------------------------

An object is a real-world entity that has:

State → data (variables)

Behavior → actions (methods)

Example (Real life):

Object: Car

State: color, speed, brand

Behavior: start(), stop(), accelerate()

 -------------------------------------------------------------🔹 What is a Class?-------------------------------------------------------------

A class is a blueprint or template used to create objects. 
It defines the properties (variables) and behaviors (methods) that the objects will have.
 
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


example 1 :-  class Student {
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
 


example 2 :- 
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
        System.out.println(x);  // ❌ Compile-time error
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


------------------------------------------------------------------------ Polymorphism -----------------------------------------------------
polymorphism is a features  of object oriented  programming which allows different behaviours of an object in  different situationa this is called polymorphism .
 Polymorphism is derived from 2 Greek words: poly and morphs. 
The word "poly" means many and "morphs" means forms. So polymorphism means many forms.


Why Polymorphism is used?

Makes code flexible

Improves readability

Supports runtime decision making

Helps in code reusability

  ----- >>>>  Types of Polymorphism <<<<<<<<-----
   

Polymorphism allows the same method name to perform different actions based on the object.


There are two types of polymorphism in Java:

Compile-time Polymorphism(Method Overloading).
Runtime Polymorphism(Method Overriding).
We can perform polymorphism in Java by method overloading and method overriding.



------------------------------------------------------------------- ✅ Method Overloading-----------------------------------------------------

same class me same method name, but different parameters.

Method Overloading allows multiple methods with the same name but different parameter lists in a class.  

Java compiler parameters dekh kar decide karta hai kaunsa method call hoga, isliye ise
 => Compile-time Polymorphism kehte hain.


🔹 Rules of Method Overloading

Method overloading tab hota hai jab:

1.Parameters ka number different ho

2.Parameters ka type different ho

3.Parameters ka order different ho

❌ Sirf return type change karne se overloading nahi hoti



1 = Parameters ka number different ho

example => class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }
}


2 = Parameters ka type different ho
example => class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

class Main {
    public static void main(String[] args) {
        Calculator s = new Calculator();
      System.out.print(s.add(45,65));
     System.out.print(s.add(45.1,65.3));
   
    }
}


3 = Parameters ka order different ho

class Display {
    void show(int a, String b) {
        System.out.println(a + " " + b);
    }

    void show(String b, int a) {
        System.out.println(b + " " + a);
    }
}

------------------------------------------------------------ ✅ Method Overriding--------------------------------------------------------------

Method Overriding is redefining a parent class method in the child class with  same method name and parameters. 

👉 Method Overriding tab hoti hai jab child class, parent class ke method ko same name, same parameters ke saath redefine karti hai.

Ye Runtime Polymorphism ka example hai.


example ->  basic method overiding 

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}
                                                                      /// Without @verride keyword /////////////
class Dog extends Animal {
                         
    void sound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal obj = new Dog();
        obj.sound();
    }
}



example ->  Using @override keyword  


class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override                                                     ///// with @Override Keyword./////////////
    void sound() {
        System.out.println("Dog barks");
    }
}

class Main {
    public static void main(String[] args) {
        Animal obj = new Dog();
        obj.sound();
    }
}

🔹 Rules of Method Overriding

1️⃣ Method name same hona chahiye
2️⃣ Parameters same hone chahiye
3️⃣ Inheritance required (extends)
4️⃣ Access modifier reduce nahi kar sakte
5️⃣ static, final, private methods override nahi hote
6️⃣ Return type same ya covariant ho sakta hai




---------------------------------------------------------------- 🔹 Abstraction -----------------------------------------------------------------

1️⃣ What is Abstraction?

Abstraction is an Object-Oriented Programming concept that focuses on showing only essential features of an object and hiding the implementation details.

👉 It tells what an object does, not how it does it.

✔ Simple Definition

Abstraction is the process of hiding implementation details and showing only functionality to the user. 


2️⃣ Why do we need Abstraction?

Abstraction is used to:

Reduce complexity

Hide internal working

Improve security

Increase flexibility

Support loose coupling

✔ Real-Life Example

When you drive a car:

You use steering, accelerator, and brakes

You do not need to know how the engine works internally

This is abstraction.  

4️⃣ Abstract Class
🔸 What is an Abstract Class?

An abstract class is a class declared using the abstract keyword and may contain abstract and non-abstract methods.

🔸 Important Rules

Abstract class cannot be instantiated

It may contain:

Abstract methods (without body)

Normal methods (with body)

A subclass must override all abstract methods . 

example -> 
abstract class Animal {

    abstract void sound();   // abstract method

    void sleep() {           // normal method
        System.out.println("Animal is sleeping");
    }
}

class Dog extends Animal {

    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
        a.sleep();
    }
}


5️⃣ Interface
🔸 What is an Interface?

An interface is a blueprint of a class that contains only abstract methods (before Java 8).

🔸 Important Rules

Interface methods are public and abstract by default

Variables are public static final

A class uses implements keyword

Supports multiple inheritance


example ->
interface Vehicle {
    void start();
}

class Car implements Vehicle {

    public void start() {
        System.out.println("Car starts");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.start();
    }
}

 🔸 Explanation

Interface defines what to do

Class defines how to do

Implementation details are hidden


------------------------7️⃣ Advantages of Abstraction

✔ Hides unnecessary details
✔ Improves code maintainability
✔ Increases security
✔ Makes system flexible
✔ Supports loose coupling 

------------------------8️⃣ Disadvantages of Abstraction

❌ More code to write
❌ Can increase complexity for small programs