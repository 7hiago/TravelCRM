package org.laba2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(path = "/menuPage")
    public String successLogin() {
        return "./menuPage";
    }


}
