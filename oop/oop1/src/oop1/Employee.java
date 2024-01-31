package oop1;

import java.util.ArrayList;

//a) Employee class
abstract class Employee {
 // i) Properties
 protected int id;
 protected String name;

 // ii) Constructor
 public Employee(int id, String name) {
     this.id = id;
     this.name = name;
 }

 // iii) Display method
 public void display() {
     System.out.println("Employee ID: " + id);
     System.out.println("Employee Name: " + name);
 }

 // iv) Abstract method
 public abstract void calculateNetSalary();
}

//b) PermanentEmp class
class PermanentEmp extends Employee {
 // i) Properties
 private double basicSal;
 private double commission;

 // ii) Constructor
 public PermanentEmp(int id, String name, double basicSal) {
     super(id, name);
     this.basicSal = basicSal;
     this.commission = 0.15 * basicSal;
 }

 // iii) Override calculateNetSalary method
 @Override
 public void calculateNetSalary() {
     double netSalary = basicSal + commission;
     System.out.println("Basic Salary: " + basicSal);
     System.out.println("Commission: " + commission);
     System.out.println("Net Salary: " + netSalary);
 }

 // iv) Override display method
 public void display() {
     super.display();
     calculateNetSalary();
 }
}

//c) TemporaryEmp class
class TemporaryEmp extends Employee {
 // i) Properties
 private int otHrs;
 private double otRate;
 private double minWage;

 // ii) Constructor
 public TemporaryEmp(int id, String name, int otHrs, double otRate) {
     super(id, name);
     this.otHrs = otHrs;
     this.otRate = otRate;
     this.minWage = 15000.0;
 }

 // iii) Override calculateNetSalary method
 @Override
 public void calculateNetSalary() {
     double netSalary = minWage + (otHrs * otRate);
     System.out.println("Minium Wage: " + minWage);
     System.out.println("Net Salary: " + netSalary);
 }

 // iv) Override display method
 public void display() {
     super.display();
     calculateNetSalary();
 }
}

//d) DemoApp class
 class DemoApp {
 public static void main(String[] args) {
     // i) Create an ArrayList of PermanentEmp class and add two PermanentEmp objects
     ArrayList<PermanentEmp> permanentEmpList = new ArrayList<>();
     permanentEmpList.add(new PermanentEmp(181, "Nimal", 56888.8));
     permanentEmpList.add(new PermanentEmp(182, "Anal", 74888.0));

     // ii) Call calculateNetSalary and display method for both objects using foreach loop
     for (PermanentEmp emp : permanentEmpList) {
         emp.display();
     }

     // iii) Do the same for TemporaryEmp class
     ArrayList<TemporaryEmp> temporaryEmpList = new ArrayList<>();
     temporaryEmpList.add(new TemporaryEmp(201, "Sunil", 10, 1850.8));
     temporaryEmpList.add(new TemporaryEmp(202, "Piyal", 8, 2300.0));

     for (TemporaryEmp emp : temporaryEmpList) {
         emp.display();
     }
 }
}
