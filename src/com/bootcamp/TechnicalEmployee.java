package com.bootcamp;

public class TechnicalEmployee extends Employee {
    public int checkIns;

    public TechnicalEmployee(String name) {
        super(name, 75000);
        this.checkIns = 0;
    }

    public int getCheckIns() {
        return this.checkIns;
    }

    @Override
    public String employeeStatus() {
        return this.toString() + " has " + this.getCheckIns() + " successful check ins." ;
    }
}
