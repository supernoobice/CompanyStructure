package com.bootcamp;

import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee implements TechManager {
    public int headCount;
    public ArrayList<SoftwareEngineer> directReports;
    public BusinessLead lead;
    public Accountant support;

    public TechnicalLead(String name) {
        super(name);
        this.baseSalary = this.getBaseSalary() * 1.3;
        this.headCount = 4;
        this.directReports = new ArrayList<>();
        this.lead = null;
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        // loop through direct reports
        for(SoftwareEngineer se : this.directReports) {
            if(se.getEmployeeID() == e.getEmployeeID() && e.codeAccess) {
                // found!
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasHeadCount() {
        return this.directReports.size() < this.headCount;
    }

    @Override
    public boolean addReport(SoftwareEngineer e) {
        int left = this.directReports.size() - this.headCount;
        if(left != 0) {
            this.directReports.add(e);
            e.manager = this;
            return true;
        }
        return false;
    }

    public boolean requestBonus(Employee e, double bonus) {
        this.lead = (BusinessLead) this.support.getManager();
        if(this.lead.approveBonus(e, bonus) ) {
            e.bonusBudget += bonus;
            return true;
        }
        return false;
    }

    public String getTeamStatus() {
        String managing = "";
        for (SoftwareEngineer member: this.directReports) {
            managing += " - " + member.employeeStatus() + '\n';
        }
        return this.employeeStatus() + " and is managing: \n" + managing;
    }

}
