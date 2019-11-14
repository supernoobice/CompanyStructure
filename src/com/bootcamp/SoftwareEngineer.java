package com.bootcamp;

public class SoftwareEngineer extends TechnicalEmployee {
    public boolean codeAccess;
    public int successfulCheckIns;
    public TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
        this.successfulCheckIns = 0;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return this.successfulCheckIns;
    }

    public TechnicalLead getManager() {
        return this.manager;
    }

    public boolean checkInCode() {
        if(manager.approveCheckIn(this)) {
            this.successfulCheckIns++;
            return true;
        }
        return false;
    }
}
