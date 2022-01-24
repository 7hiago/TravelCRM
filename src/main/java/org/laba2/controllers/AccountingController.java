package org.laba2.controllers;

import org.laba2.dao.AccountingDAO;
import org.laba2.entities.Accounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/accounting")
public class AccountingController {

    private final AccountingDAO accountingDAO;

    @Autowired
    public AccountingController(AccountingDAO accountingDAO) {
        this.accountingDAO = accountingDAO;
    }

    @GetMapping("/showAccounting/{accountingId}")
    public ModelAndView showAccounting(@PathVariable("accountingId") int accountingId) {
        return new ModelAndView("accounting/showAccounting", "accounting", accountingDAO.getAccounting(accountingId));
    }

    @GetMapping("/{accountingId}/editAccounting")
    public ModelAndView editAccounting(@PathVariable("accountingId") int accountingId) {
        return new ModelAndView("./accounting/editAccounting", "command", accountingDAO.getAccounting(accountingId));
    }

    @PatchMapping("/saveEditedAccounting/{accountingId}")
    public ModelAndView saveEditedAccounting(@ModelAttribute Accounting accounting, @PathVariable("accountingId") int accountingId) {
        accountingDAO.updateAccounting(accountingId, accounting);
        return new ModelAndView("redirect:/accounting/showAccounting/{accountingId}");
    }
}
