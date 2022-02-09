package org.laba2.services;

import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountingService {

    private final CourseService courseService;

    private final AccountingDAO accountingDAO;

    @Autowired
    public AccountingService(AccountingDAO accountingDAO, CourseService courseService) {
        this.accountingDAO = accountingDAO;
        this.courseService = courseService;
    }

    public String createNewAccounting(Accounting accounting) {
        accounting.setAccountingId("AC-" + UUID.randomUUID());
        accounting.setTourPrice(accounting.getTourPrice() / courseService.getRate());
        accounting.setTourPaid(accounting.getTourPaid() / courseService.getRate());
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() / courseService.getRate());
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() / courseService.getRate());
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission() / 100));

        accountingDAO.createAccounting(accounting);
        return accounting.getAccountingId();
    }

    public Accounting getAccountingById(String accountingId) {
        Accounting accounting = accountingDAO.getAccounting(accountingId);

        accounting.setTourPrice(accounting.getTourPrice() * courseService.getRate());
        accounting.setTourPaid(accounting.getTourPaid() * courseService.getRate());
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() * courseService.getRate());
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() * courseService.getRate());
        accounting.setProfit(Math.round(accounting.getProfit() * courseService.getRate()));

        return accounting;
    }

    public void editAccounting(String accountingId, Accounting accounting) {
        accounting.setTourPrice(accounting.getTourPrice() / courseService.getRate());
        accounting.setTourPaid(accounting.getTourPaid() / courseService.getRate());
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() / courseService.getRate());
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() / courseService.getRate());
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission()/100));

        accountingDAO.updateAccounting(accountingId, accounting);
    }

    public void deleteAccountingById(String accountingId) {
        accountingDAO.removeAccounting(accountingId);
    }
}
