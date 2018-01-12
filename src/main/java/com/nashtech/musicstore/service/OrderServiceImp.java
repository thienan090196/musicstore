package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.Order;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImp extends GenericServiceImp<Order, Integer> implements IOrderService {
}
