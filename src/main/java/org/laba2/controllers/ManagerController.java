package org.laba2.controllers;

import org.laba2.entities.Manager;
import org.laba2.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/managers")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("/showManagers")
    public ModelAndView showManagers() {
        return new ModelAndView("./managers/showManagers", "managers", managerService.getAvailableManagers());
    }

    @GetMapping("/showManager/{managerId}")
    public ModelAndView showManager(@PathVariable("managerId") String managerId) {
        return new ModelAndView("./managers/showManager", "manager", managerService.getManagerById(managerId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createManager")
    public ModelAndView createManager() {
        return new ModelAndView("./managers/createManager", "command", new Manager());
    }

    @PostMapping("/saveCreatedManager")
    public ModelAndView saveCreatedManager(@ModelAttribute Manager manager) {
        managerService.createNewManager(manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @GetMapping("/{managerId}/editManager")
    public ModelAndView editManager(@PathVariable("managerId") String managerId) {
        return new ModelAndView("./managers/editManager", "command", managerService.getManagerById(managerId));
    }

    @PatchMapping("/saveEditedManager/{managerId}")
    public ModelAndView saveEditedManager(@ModelAttribute Manager manager, @PathVariable("managerId") String managerId) {
        managerService.editManager(managerId, manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @DeleteMapping("/deleteManager/{managerId}")
    public ModelAndView deleteManager(@PathVariable("managerId") String managerId) {
        managerService.deleteManager(managerId);
        return new ModelAndView("redirect:/managers/showManagers");
    }
}
