package org.laba2.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private static final Logger logger = LogManager.getLogger(MainController.class);

    @RequestMapping(value = "/")
    public ModelAndView startPoint(HttpSession session, HttpServletRequest request) {
        logger.debug("invalidate session");
        session.invalidate();
        logger.debug("create new session");
        session = request.getSession(true);
        session.setMaxInactiveInterval(-1);
        return new ModelAndView("/menuPage");
    }

    @RequestMapping(path = "/menuPage")
    public String menuPage() {
        logger.debug("invocation show menu method");
        return "./menuPage";
    }
}