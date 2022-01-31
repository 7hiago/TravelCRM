package org.laba2.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(path = "/menuPage")
    public String menuPage() {
        logger.debug("invocation show menu method");
        return "./menuPage";
    }
}
