package org.laba2.controllers;

import org.apache.log4j.Logger;
import org.laba2.entities.Touroperator;
import org.laba2.services.TouroperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.prepost.PreAuthorize;
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
@EnableAspectJAutoProxy
@RequestMapping(value = "/touroperators")
public class TouroperatorController {

    private static final Logger logger = Logger.getLogger(TouroperatorController.class);

    @Autowired
    private TouroperatorService touroperatorService;

    @GetMapping("/showTouroperators")
    public ModelAndView showTouroperators() {
        logger.debug("invocation show touroperators method");
        return new ModelAndView("./touroperators/showTouroperators", "touroperators", touroperatorService.getAvailableTouroperators());
    }

    @GetMapping("/createTouroperator")
    public ModelAndView createTouroperator() {
        logger.debug("invocation create touroperator method");
        return new ModelAndView("./touroperators/createTouroperator", "command", new Touroperator());
    }

    @PostMapping("/saveCreatedTouroperator")
    public ModelAndView saveCreatedTouroperator(@ModelAttribute Touroperator touroperator) {
        logger.debug("invocation save created touroperator method");
        touroperatorService.createNewTouroperator(touroperator);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }

    @GetMapping("/{touroperatorId}/editTouroperator")
    public ModelAndView editTouroperator(@PathVariable("touroperatorId") String touroperatorId) {
        logger.debug("invocation edit touroperator method");
        return new ModelAndView("./touroperators/editTouroperator", "command", touroperatorService.getTouroperatorById(touroperatorId));
    }

    @PatchMapping("/saveEditedTouroperator/{touroperatorId}")
    public ModelAndView saveEditedTouroperator(@ModelAttribute Touroperator touroperator, @PathVariable("touroperatorId") String touroperatorId) {
        logger.debug("invocation save edited touroperator method");
        touroperatorService.editTouroperator(touroperatorId, touroperator);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }

    @DeleteMapping("/deleteTouroperator/{touroperatorId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView deleteTouroperator(@PathVariable("touroperatorId") String touroperatorId) {
        logger.debug("invocation delete touroperators method");
        touroperatorService.deleteTouroperator(touroperatorId);
        return new ModelAndView("redirect:/touroperators/showTouroperators");
    }
}
