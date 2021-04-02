package com.service;

import com.model.Order;

public interface OrderService extends IBaseService<Order> {
    void delete(Long id);


}
