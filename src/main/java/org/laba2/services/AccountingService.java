package org.laba2.services;

import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountingService {

    private final AccountingDAO accountingDAO;

    @Autowired
    public AccountingService(AccountingDAO accountingDAO) {
        this.accountingDAO = accountingDAO;
    }

    public String createNewAccounting(Accounting accounting) {
        accounting.setAccountingId("AC-" + UUID.randomUUID());
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission()/100));
        accountingDAO.createAccounting(accounting);
        return accounting.getAccountingId();
    }

    public Accounting getAccountingById(String accountingId) {
        return accountingDAO.getAccounting(accountingId);
    }

    public void editAccounting(String accountingId, Accounting accounting) {
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission()/100));
        accountingDAO.updateAccounting(accountingId, accounting);
    }

    public void deleteAccountingById(String accountingId) {
        accountingDAO.removeAccounting(accountingId);
    }

}
