package com.bootcamp;

public class SoftwareEngineer extends TechnicalEmployee {
    public boolean codeAccess;
    public TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
        this.checkIns = 0;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return this.checkIns;
    }

    public TechnicalLead getManager() {
        return this.manager;
    }

    public boolean checkInCode() {
        if(manager.approveCheckIn(this)) {
            this.checkIns++;
            return true;
        }
        return false;
    }
}
