package com.bootcamp;

import java.util.ArrayList;

public class BusinessLead extends BusinessEmployee {
    public int headCount;
    public ArrayList<Accountant> directReports;

    public BusinessLead(String name) {
        super(name);
        this.baseSalary = this.getBaseSalary() * 2.0;
        this.headCount = 10;
        this.directReports = new ArrayList<>();
    }

    public boolean hasHeadCount() {
        return this.directReports.size() < this.headCount;
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if(this.hasHeadCount()) {
            this.directReports.add(e);
            this.bonusBudget = this.getBonusBudget() + (e.getBaseSalary() * 1.1);

            // update accountant's support team
            e.supportTeam(supportTeam);
            e.manager = this;

            return true;
        }
        else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        if(bonus < this.getBonusBudget()) {
            Accountant employee = (Accountant) e;
            employee.bonusBudget += bonus; // employee gets the bonus
            this.bonusBudget -= bonus; // businesslead deducts from his bonus
            return true;
        }

        return false;
    }

    public boolean approveBonus(Employee e, double bonus) {
        int techLeadID = e.getManager().getEmployeeID();
        for ( Accountant accountant: this.directReports) {
            // find the TechLead of employee
            if(accountant.getTeamSupported().getEmployeeID() == techLeadID) {
                // can bonus be afforded ? Look at accountant
                if(accountant.approveBonus(bonus)) {
                    // reward
                    this.requestBonus(accountant, bonus);
                    return true;
                }
            }
        }
        return false;
    }

    public String getTeamStatus() {
        String managing = "";
        for (Accountant member: this.directReports) {
            managing += " - " + member.employeeStatus() + '\n';
        }
        return this.employeeStatus() + " and is managing: \n" + managing;
    }
}
