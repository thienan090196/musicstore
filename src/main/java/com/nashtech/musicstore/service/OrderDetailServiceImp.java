package com.nashtech.musicstore.service;

import com.nashtech.musicstore.model.OrderDetail;
import org.springframework.stereotype.Service;

@Service("orderDetailService")
public class OrderDetailServiceImp extends GenericServiceImp<OrderDetail, Integer> implements IOrderDetailService {
}
