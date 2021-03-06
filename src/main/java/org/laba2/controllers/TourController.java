package org.laba2.controllers;

import org.apache.log4j.Logger;
import org.laba2.dto.TourDTO;
import org.laba2.services.TourService;
import org.laba2.services.TouroperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAspectJAutoProxy
@RequestMapping(value = "/tour")
public class TourController {

    private static final Logger logger = Logger.getLogger(TourController.class);

    @Autowired
    private TourService tourService;

    @Autowired
    private TouroperatorService touroperatorService;


    @GetMapping("/showTour/{tourId}")
    public String  showTour(@PathVariable("tourId") String tourId, Model model) {
        logger.debug("invocation show tour method");
        model.addAttribute("tourDTO", tourService.getTourDTOById(tourId));
        return "tour/showTour";
    }

    @GetMapping("/{tourId}/editTour")
    public String  editTour(@PathVariable("tourId") String tourId, Model model) {
        logger.debug("invocation edit tour method");
        model.addAttribute("touroperators", touroperatorService.getAvailableTouroperators());
        model.addAttribute("tourDTO", tourService.getTourDTOById(tourId));
        return "./tour/editTour";
    }

    @PatchMapping("/saveEditedTour/{tourId}")
    public ModelAndView saveEditedTour(@ModelAttribute TourDTO tourDTO, @PathVariable("tourId") String tourId) {
        logger.debug("invocation save edited tour method");
        tourService.editTour(tourId, tourDTO);
        return new ModelAndView("redirect:/tour/showTour/{tourId}");
    }
}
