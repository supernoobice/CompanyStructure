package com.bootcamp;

public class Main {

    public static void main(String[] args) {
        SoftwareEngineer e1 = new SoftwareEngineer("XX");
        SoftwareEngineer e2 = new SoftwareEngineer("XX");
        TechnicalLead e3 = new TechnicalLead("AHA");

        e3.addReport(e1);
        e3.addReport(e2);
        System.out.println(e1.employeeStatus());
        System.out.println(e2.employeeStatus());
        System.out.println(e3.employeeStatus());
        System.out.println(e3.getTeamStatus());
        System.out.println(e1.getManager().getName());
    }
}
