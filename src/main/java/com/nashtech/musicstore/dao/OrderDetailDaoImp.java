package com.nashtech.musicstore.dao;

import com.nashtech.musicstore.model.OrderDetail;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository("orderDetailDao")
@Transactional
public class OrderDetailDaoImp extends GenericDaoImp<OrderDetail, Integer> implements IOrderDetailDao {
}
