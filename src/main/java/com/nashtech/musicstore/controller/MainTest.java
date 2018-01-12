package com.nashtech.musicstore.controller;

import com.nashtech.musicstore.model.Album;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainTest {
    //public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String hashedPassword = encoder.encode("admin123");
//        System.out.println(encoder.matches(encoder.encode("admin123"), hashedPassword));
        //PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //System.out.println(passwordEncoder.encode("admin"));
//        BigDecimal decimal;
//        try {
//            decimal = new BigDecimal(32132);
//            System.out.println(decimal);
//        } catch (NumberFormatException e) {
//            System.out.println("Error");
//        }
//        String pattern = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
//        String email = "thienan090196@777gmail.com.cnx.dskj";
//        if (!email.matches(pattern)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
  //  }
}
