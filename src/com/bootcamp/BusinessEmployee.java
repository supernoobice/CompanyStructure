package com.bootcamp;

public class BusinessEmployee extends Employee {
    public double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return this.bonusBudget;
    }

    @Override
    public String employeeStatus() {
        return this.toString() + " with a budget of " + this.getBonusBudget();
    }
}
