package org.laba2.controllers;

import org.laba2.dao.ManagerDAO;
import org.laba2.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/managers")
public class ManagerController {

    private final ManagerDAO managerDAO;

    @Autowired
    public ManagerController(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @GetMapping("/showManagers")
    public ModelAndView showManagers() {
        return new ModelAndView("./managers/showManagers", "managers", managerDAO.getManagers());
    }

    @GetMapping("/showManager/{managerId}")
    public ModelAndView showManager(@PathVariable("managerId") String managerId) {
        return new ModelAndView("./managers/showManager", "manager", managerDAO.getManager(managerId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createManager")
    public ModelAndView createManager() {
        return new ModelAndView("./managers/createManager", "command", new Manager());
    }

    @PostMapping("/saveCreatedManager")
    public ModelAndView saveCreatedManager(@ModelAttribute Manager manager) {
        managerDAO.createManager(manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @GetMapping("/{managerId}/editManager")
    public ModelAndView editManager(@PathVariable("managerId") String managerId) {
        return new ModelAndView("./managers/editManager", "command", managerDAO.getManager(managerId));
    }

    @PatchMapping("/saveEditedManager/{managerId}")
    public ModelAndView saveEditedManager(@ModelAttribute Manager manager, @PathVariable("managerId") String managerId) {
        managerDAO.updateManager(managerId, manager);
        return new ModelAndView("redirect:/managers/showManagers");
    }

    @DeleteMapping("/deleteManager/{managerId}")
    public ModelAndView deleteManager(@PathVariable("managerId") String managerId) {
        managerDAO.removeManager(managerId);
        return new ModelAndView("redirect:/managers/showManagers");
    }
}
