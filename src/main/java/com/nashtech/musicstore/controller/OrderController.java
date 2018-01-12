package com.nashtech.musicstore.controller;

import com.nashtech.musicstore.model.Account;
import com.nashtech.musicstore.model.Album;
import com.nashtech.musicstore.model.Order;
import com.nashtech.musicstore.model.OrderDetail;
import com.nashtech.musicstore.service.IAccountService;
import com.nashtech.musicstore.service.IGenreService;
import com.nashtech.musicstore.service.IOrderDetailService;
import com.nashtech.musicstore.service.IOrderService;
import com.nashtech.musicstore.utilities.ConstantValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

@Controller
@RequestMapping(value = "/checkout")
public class OrderController {

    @Autowired
    IGenreService genreService;

    @Autowired
    IAccountService accountService;

    @Autowired
    IOrderService orderService;

    @Autowired
    IOrderDetailService orderDetailService;

    @RequestMapping(value = "/viewShippingInfo", method = RequestMethod.GET)
    public String viewOrder(Model model,
                            HttpServletRequest request) {
        Account account = accountService.findByEmail(request.getUserPrincipal().getName());
        HttpSession session = request.getSession();
        HashMap<Integer, Album> listCart = (HashMap<Integer, Album>) session.getAttribute(ConstantValues.CART_SESSION);
        Order order = new Order();
        order.setUserId(account.getUserId());
        order.setAccount(account);
        order.setTotalOrder(new BigDecimal(0));
        for(Album album:listCart.values()) {
            order.setTotalOrder(order.getTotalOrder().add(album.getPrice().multiply(BigDecimal.valueOf(album.getQuantity()))));
        }
        order.setFirstName(account.getFirstName());
        order.setLastName(account.getLastName());
        order.setAddress(account.getAddress());
        order.setCity(account.getCity());
        order.setCountry(account.getCountry());
        order.setPhone(account.getPhone());
        order.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        order.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        model.addAttribute("genreList", genreService.getAll());
        model.addAttribute("title", "Checkout");
        model.addAttribute("order", order);
        return "checkout";
    }

    @RequestMapping(value = "/addShippingInfo", method = RequestMethod.POST)
    public String addNewOrder(@Validated @ModelAttribute("order") Order order,
                           BindingResult result,
                           Model model,
                           HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("genreList", genreService.getAll());
            model.addAttribute("title", "Checkout");
            model.addAttribute("order", order);
            return "checkout";
        }
        orderService.saveOrUpdate(order);
        HttpSession session = request.getSession();
        HashMap<Integer, Album> listCart = (HashMap<Integer, Album>) session.getAttribute(ConstantValues.CART_SESSION);
        for(Album album:listCart.values()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setAlbumId(album.getAlbumId());
            orderDetail.setAlbum(album);
            orderDetail.setOrderId(order.getOrderId());
            orderDetail.setOrder(order);
            orderDetail.setPrice(album.getPrice());
            orderDetail.setQuantity(album.getQuantity());
            orderDetail.setCreatedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            orderDetail.setModifiedAt(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            orderDetailService.saveOrUpdate(orderDetail);
        }
        session.removeAttribute(ConstantValues.CART_SESSION);
        return "redirect:/";
    }
}
