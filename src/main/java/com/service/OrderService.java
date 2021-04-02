package com.service;

import com.model.Order;

public interface OrderService extends IBaseService<Order> {
    void deleteTrue(Long id);

    void softDelete(Long id);


}
