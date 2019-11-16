package com.bootcamp;

public abstract class Employee {
    public String name;
    public double baseSalary;
    public static int employeeCounter;
    public Employee manager;
    public double bonusBudget;
    public int ID;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        employeeCounter++; // keep track of the employee number
        this.ID = employeeCounter;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int getEmployeeID() {
        return ID;
    }

    public Employee getManager() {
        return this.manager;
    }

    public boolean equals(Employee other) {
        return this.getEmployeeID() == other.getEmployeeID();
    }

    public String toString() {
        return this.getEmployeeID() + " " + this.getName();
    }

    public abstract String employeeStatus();
}
