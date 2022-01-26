package org.laba2.controllers;

import org.laba2.dao.OrderDAO;
import org.laba2.dao.TouroperatorDAO;
import org.laba2.entities.Order;
import org.laba2.entities.Touroperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/touroperators")
public class TouroperatorController {

    private final TouroperatorDAO touroperatorDAO;

    @Autowired
    public TouroperatorController(TouroperatorDAO touroperatorDAO) {
        this.touroperatorDAO = touroperatorDAO;
    }

    @GetMapping("/showTouroperators")
    public ModelAndView showTouroperators() {
        return new ModelAndView("./touroperators/showTouroperators", "touroperators", touroperatorDAO.getTouroperators());
    }

    @GetMapping("/showTouroperator/{touroperatorId}")
    public ModelAndView showTouroperator(@PathVariable("touroperatorId") String touroperatorId) {
        return new ModelAndView("./touroperators/showTouroperator", "touroperator", touroperatorDAO.getTouroperator(touroperatorId));
    }

    //    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/createTouroperator")
    public ModelAndView createTouroperator() {
        return new ModelAndView("./touroperators/createTouroperator", "command", new Touroperator());
    }

    @PostMapping("/saveCreatedTouroperator")
    public ModelAndView saveCreatedTouroperator(@ModelAttribute Touroperator touroperator) {
        touroperatorDAO.createTouroperator(touroperator);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }

    @GetMapping("/{touroperatorId}/editTouroperator")
    public ModelAndView editTouroperator(@PathVariable("touroperatorId") String touroperatorId) {
        return new ModelAndView("./touroperators/editTouroperator", "command", touroperatorDAO.getTouroperator(touroperatorId));
    }

    @PatchMapping("/saveEditedTouroperator/{touroperatorId}")
    public ModelAndView saveEditedTouroperator(@ModelAttribute Touroperator touroperator, @PathVariable("touroperatorId") String touroperatorId) {
        touroperatorDAO.updateTouroperator(touroperatorId, touroperator);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }

    @DeleteMapping("/deleteTouroperator/{touroperatorId}")
    public ModelAndView deleteTouroperator(@PathVariable("touroperatorId") String touroperatorId) {
        touroperatorDAO.removeTouroperator(touroperatorId);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }
}
