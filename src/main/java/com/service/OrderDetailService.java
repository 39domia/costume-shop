package com.service;

import com.model.OrderDetail;

import java.util.Collection;

public interface OrderDetailService extends IBaseService<OrderDetail>{

    void saveAll(Collection<OrderDetail> orderDetails);
}
