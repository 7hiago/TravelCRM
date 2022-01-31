package org.laba2.controllers;

import org.apache.log4j.Logger;
import org.laba2.entities.Accounting;
import org.laba2.services.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAspectJAutoProxy
@RequestMapping(value = "/accounting")
public class AccountingController {

    private static final Logger logger = Logger.getLogger(AccountingController.class);

    @Autowired
    private AccountingService accountingService;

    @GetMapping("/showAccounting/{accountingId}")
    public ModelAndView showAccounting(@PathVariable("accountingId") String accountingId) {
        logger.debug("invocation show accounting method");
        return new ModelAndView("accounting/showAccounting", "accounting", accountingService.getAccountingById(accountingId));
    }

    @GetMapping("/{accountingId}/editAccounting")
    public ModelAndView editAccounting(@PathVariable("accountingId") String accountingId) {
        logger.debug("invocation edit accounting method");
        return new ModelAndView("./accounting/editAccounting", "command", accountingService.getAccountingById(accountingId));
    }

    @PatchMapping("/saveEditedAccounting/{accountingId}")
    public ModelAndView saveEditedAccounting(@ModelAttribute Accounting accounting, @PathVariable("accountingId") String accountingId) {
        logger.debug("invocation save edited accounting method");
        accountingService.editAccounting(accountingId, accounting);
        return new ModelAndView("redirect:/accounting/showAccounting/{accountingId}");
    }
}
