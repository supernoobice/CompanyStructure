package com.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoftwareEngineerTest {

    // Test ID # 1
    @Test
    void setCodeAccessCheckInFalse() {
        SoftwareEngineer engineer = new SoftwareEngineer("Test Engineer");
        // Set code access to false
        engineer.setCodeAccess(false);

        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        // Add SE to TL
        techlead.addReport(engineer);

        // Expects a false output
        assertFalse(engineer.checkInCode());
    }

    // Test ID # 2
    @Test
    void setCodeAccessCheckInTrue() {
        SoftwareEngineer engineer = new SoftwareEngineer("Test Engineer");
        // Set code access to false
        engineer.setCodeAccess(true);

        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        // Add SE to TL
        techlead.addReport(engineer);

        // Expects a TRUE output
        assertTrue(engineer.checkInCode());
    }

    // Test ID # 5
    @Test
    void softwareEngineerBonus20M() {
        Accountant accountant = new Accountant("Test Accountant");
        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        SoftwareEngineer se = new SoftwareEngineer("Test SE");
        BusinessLead bl = new BusinessLead("Test Businesslead");
        // A techlead must have at least one direct reporting SE
        techlead.addReport(se);
        accountant.supportTeam(techlead);
        bl.addReport(accountant, techlead);

        // Expects a false
        assertFalse(se.getManager().requestBonus(se, 20000000));
    }

    // Test ID # 6
    @Test
    void softwareEngineerBonus1000() {
        Accountant accountant = new Accountant("Test Accountant");
        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        SoftwareEngineer se = new SoftwareEngineer("Test SE");
        BusinessLead bl = new BusinessLead("Test Businesslead");
        // A techlead must have at least one direct reporting SE
        techlead.addReport(se);
        accountant.supportTeam(techlead);
        // Business lead must have direct reports of accountant and techlead
        bl.addReport(accountant, techlead);

        // Expects a True
        assertTrue(se.getManager().requestBonus(se, 1000));
    }
}