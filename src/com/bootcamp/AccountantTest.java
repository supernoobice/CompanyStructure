package com.bootcamp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountantTest {

    // Test ID # 3
    @Test
    void approveBonusFalse() {
        Accountant accountant = new Accountant("Test Accountant");
        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        SoftwareEngineer se = new SoftwareEngineer("Test SE");
        // A techlead must have at least one direct reporting SE
        techlead.addReport(se);
        accountant.supportTeam(techlead);

        // Expects false
        assertFalse(accountant.approveBonus(20000000));
    }

    // Test ID # 4
    @Test
    void approveBonusTrue() {
        Accountant accountant = new Accountant("Test Accountant");
        TechnicalLead techlead = new TechnicalLead("Test Techlead");
        SoftwareEngineer se = new SoftwareEngineer("Test SE");
        // A techlead must have at least one direct reporting SE
        techlead.addReport(se);
        accountant.supportTeam(techlead);

        // Expects true
        assertTrue(accountant.approveBonus(1000));
    }
}