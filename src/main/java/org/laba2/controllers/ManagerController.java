package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.entities.Manager;
import org.laba2.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/managers")
public class ManagerController {

    private static final Logger logger = LogManager.getLogger(ManagerController.class);

    @Autowired
    private ManagerService managerService;

    @GetMapping("/showManagers")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView showManagers() {
        logger.debug("invocation show managers method");
        return new ModelAndView("./managers/showManagers", "managers", managerService.getAvailableManagers());
    }

    @GetMapping("/showManager/{managerId}")
    public ModelAndView showManager(@PathVariable("managerId") String managerId) {
        logger.debug("invocation show manager method");
        return new ModelAndView("./managers/showManager", "manager", managerService.getManagerById(managerId));
    }

    @GetMapping("/createManager")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView createManager() {
        logger.debug("invocation create manager method");
        return new ModelAndView("./managers/createManager", "command", new Manager());
    }

    @PostMapping("/saveCreatedManager")
    public ModelAndView saveCreatedManager(@ModelAttribute Manager manager) {
        logger.debug("invocation save created manager method");
        managerService.createNewManager(manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @GetMapping("/{managerId}/editManager")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView editManager(@PathVariable("managerId") String managerId) {
        logger.debug("invocation edit manager method");
        return new ModelAndView("./managers/editManager", "command", managerService.getManagerById(managerId));
    }

    @PatchMapping("/saveEditedManager/{managerId}")
    public ModelAndView saveEditedManager(@ModelAttribute Manager manager, @PathVariable("managerId") String managerId) {
        logger.debug("invocation save edited manager method");
        managerService.editManager(managerId, manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @DeleteMapping("/deleteManager/{managerId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteManager(@PathVariable("managerId") String managerId) {
        logger.debug("invocation delete manager method");
        managerService.deleteManager(managerId);
        return new ModelAndView("redirect:/managers/showManagers");
    }
}
