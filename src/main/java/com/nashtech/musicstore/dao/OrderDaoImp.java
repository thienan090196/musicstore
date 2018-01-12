package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.Order;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("orderDao")
@Transactional
public class OrderDaoImp extends GenericDaoImp<Order, Integer> implements IOrderDao {
}
