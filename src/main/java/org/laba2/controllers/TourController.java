package org.laba2.controllers;

import org.laba2.dao.TourDAO;
import org.laba2.entities.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy
@RequestMapping(value = "/tour")
public class TourController {

    private final TourDAO tourDAO;

    @Autowired
    public TourController(TourDAO tourDAO) {
        this.tourDAO = tourDAO;
    }

    @GetMapping("/showTour/{tourId}")
    public ModelAndView showTour(@PathVariable("tourId") String tourId) {
        return new ModelAndView("tour/showTour", "tour", tourDAO.getTour(tourId));
    }

    @GetMapping("/{tourId}/editTour")
    public ModelAndView editTour(@PathVariable("tourId") String tourId) {
        return new ModelAndView("./tour/editTour", "command", tourDAO.getTour(tourId));
    }

    @PatchMapping("/saveEditedTour/{tourId}")
    public ModelAndView saveEditedTour(@ModelAttribute Tour tour, @PathVariable("tourId") String tourId) {
        tourDAO.updateTour(tourId, tour);
        return new ModelAndView("redirect:/tour/showTour/{tourId}");
    }
}
