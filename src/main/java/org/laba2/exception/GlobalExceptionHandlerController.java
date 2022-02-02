package org.laba2.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleCreateOrderException(NullPointerException exception) {
        logger.error("Have null in received data");
        return new ModelAndView("./error", "message", exception.getMessage());
    }

    @ExceptionHandler(DatabaseException.class)
    public ModelAndView handleDatabaseException(DatabaseException exception) {
        logger.error("Lost connection with database");
        return new ModelAndView("./error", "message", exception.getMessage());
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ModelAndView handle(Exception exception) {
//        logger.error("requested page not exist");
//        ModelAndView mv = new ModelAndView();
//        mv.addObject("message", exception.getMessage());
//        mv.setViewName("./error404");
//        return mv;
//    }

}
