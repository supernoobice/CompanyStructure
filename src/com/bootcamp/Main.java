package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        TechnicalEmployee employee = new TechnicalEmployee("Jeff");
        System.out.println(employee.getBaseSalary());
        System.out.println(employee.employeeStatus());

        TechnicalEmployee lbc = new TechnicalEmployee("LBC");
        System.out.println(lbc.employeeStatus());

        TechnicalLead tech = new TechnicalLead("Jojo");
        System.out.println(tech.getBaseSalary());
    }
}
