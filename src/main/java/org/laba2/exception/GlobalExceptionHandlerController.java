package org.laba2.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandlerController.class);

    @ExceptionHandler(DatabaseException.class)
    public ModelAndView handleDatabaseException(DatabaseException exception) {
        logger.error("Lost connection with database");
        return new ModelAndView("./error500", "message", exception.getMessage());
    }

}