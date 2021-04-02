package com.service;

import com.model.Order;
import com.model.Product;

public interface OrderService extends IBaseService<Order> {
    public void deleteTrue(Long id);
    public void softDelete(Long id);


}
