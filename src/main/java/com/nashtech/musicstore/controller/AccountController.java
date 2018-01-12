package com.nashtech.musicstore.controller;

import com.nashtech.musicstore.model.Account;
import com.nashtech.musicstore.service.IGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.Calendar;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    IGenreService genreService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "Login");
        return "login";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(Model model) {
//        model.addAttribute("genreList", genreService.getAll());
//        model.addAttribute("title", "Register");
//        Account account = new Account();
//        account.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        account.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        model.addAttribute("account", account);
//        return "register";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String addAccount(@ModelAttribute("account") Account acount, Model model, BindingResult result) {
//        if (result.hasErrors()) {
//            return "register";
//        }
//        return "/";
//    }
}
