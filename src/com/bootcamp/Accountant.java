package com.bootcamp;

public class Accountant extends BusinessEmployee {
    public TechnicalLead teamSupporting;

    public Accountant(String name) {
        super(name);
        this.teamSupporting = null;
        // Whats the salary for accountant?
    }

    public TechnicalLead getTeamSupported() {
        return this.teamSupporting;
    }

    public void supportTeam(TechnicalLead lead) {
        this.teamSupporting = lead;
        double total_salary = 0;
        for (SoftwareEngineer member: lead.directReports) {
            total_salary = total_salary + member.getBaseSalary();
        }

        // set this account as the techlead's support
        lead.support = this;

        this.bonusBudget = total_salary + (total_salary * 0.10);
    }

    public boolean approveBonus(double bonus) {
        if(this.teamSupporting == null) {
            return false;
        }

        if( bonus > this.bonusBudget ) {
            return false;
        }

        return true;
    }

    public String employeeStatus() {
        return super.employeeStatus() + " is supporting " + this.teamSupporting.getName();
    }
}
