package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.laba2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/")
    public ModelAndView startPoint(HttpSession session, HttpServletRequest request) {
        session.invalidate();
        session = request.getSession(true);
        session.setMaxInactiveInterval(-1);
        if(session.isNew()){
            logger.debug("update course");
            courseService.updateRate();
        }
        return new ModelAndView("/menuPage");
    }

    @RequestMapping(path = "/menuPage")
    public String menuPage() {
        logger.debug("invocation show menu method");
        return "./menuPage";
    }
}