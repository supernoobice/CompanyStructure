package com.bootcamp;

public abstract class BusinessEmployee extends Employee {
    public double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public abstract double getBonusBudget();

    @Override
    public String employeeStatus() {
        return this.toString() + " with a budget of " + this.getBonusBudget();
    }
}
