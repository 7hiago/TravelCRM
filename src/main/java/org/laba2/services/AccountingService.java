package org.laba2.services;

import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        float course = courseService.getCourse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).getRate();

        accounting.setAccountingId("AC-" + UUID.randomUUID());
        accounting.setTourPrice(accounting.getTourPrice() / course);
        accounting.setTourPaid(accounting.getTourPaid() / course);
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() / course);
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() / course);
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission() / 100));

        accountingDAO.createAccounting(accounting);
        return accounting.getAccountingId();
    }

    public Accounting getAccountingById(String accountingId) {
        float course = courseService.getCourse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).getRate();
        Accounting accounting = accountingDAO.getAccounting(accountingId);

        accounting.setTourPrice(accounting.getTourPrice() * course);
        accounting.setTourPaid(accounting.getTourPaid() * course);
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() * course);
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() * course);
        accounting.setProfit(Math.round(accounting.getProfit() * course));

        return accounting;
    }

    public void editAccounting(String accountingId, Accounting accounting) {
        float course = courseService.getCourse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))).getRate();

        accounting.setTourPrice(accounting.getTourPrice() / course);
        accounting.setTourPaid(accounting.getTourPaid() / course);
        accounting.setTouroperatorPrice(accounting.getTouroperatorPrice() / course);
        accounting.setTouroperatorPaid(accounting.getTouroperatorPaid() / course);
        accounting.setProfit(accounting.getTourPrice() * (accounting.getCommission()/100));

        accountingDAO.updateAccounting(accountingId, accounting);
    }

    public void deleteAccountingById(String accountingId) {
        accountingDAO.removeAccounting(accountingId);
    }
}