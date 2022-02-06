package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.entities.Accounting;
import org.laba2.services.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/accounting")
public class AccountingController {

    private static final Logger logger = LogManager.getLogger(AccountingController.class);

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

    @PostMapping("/saveEditedAccounting/{accountingId}")
    public String saveEditedAccounting(@ModelAttribute("command") @Valid Accounting accounting, BindingResult bindingResult, @PathVariable("accountingId") String accountingId) {
        logger.debug("invocation save edited accounting method");
        if (bindingResult.hasErrors()) {
            logger.debug("save has error");
            return "./accounting/editAccounting";
        } else {
            logger.debug("save has not error");
            accountingService.editAccounting(accountingId, accounting);
        }
        return "redirect:/accounting/showAccounting/{accountingId}";
    }
}
