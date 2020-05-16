package com.andrew.controller.exceptioncontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 记录全局异常信息
 *
 * @author andrew
 * @date 2020/1/7
 */
@ControllerAdvice
public class ExceptionController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(Exception.class)
    public String clientException(Exception e, Model model){
        String errorMessage = e.getMessage();
        model.addAttribute("error",errorMessage);
        logger.error(errorMessage);
        return "redirect:500.html?errorMessage";
    }

}
