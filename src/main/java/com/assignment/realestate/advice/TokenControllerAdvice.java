package com.assignment.realestate.advice;

import com.assignment.realestate.service.LoginService;
import com.assignment.realestate.threadlocal.ContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(assignableTypes = {com.assignment.realestate.controller.UserActivityController.class,
        com.assignment.realestate.controller.UserController.class,
        com.assignment.realestate.controller.ApartmentController.class,
        com.assignment.realestate.controller.BuildingController.class,
        com.assignment.realestate.controller.PinCodeController.class,
        com.assignment.realestate.controller.CountryController.class,
        com.assignment.realestate.controller.SocietyController.class,})
@Slf4j
public class TokenControllerAdvice {

    @Autowired
    private LoginService loginService;


    @ModelAttribute
    public void populateModelAttributes(HttpServletRequest request, Model model) {
        String token = request.getHeader("Authorization");
        ContextHolder.setUserId(1);
        model.addAttribute("USER_ID", 1);
        if (token != null) {
            try {
                token = token.replace("Bearer ", "");
                Integer userId = loginService.getUserIdFromToken(token);
                model.addAttribute("USER_ID", userId);
                ContextHolder.setUserId(userId);
            } catch (Exception e) {
                log.error("exception occurred while parsing token",e);
            }
        }
    }
}
