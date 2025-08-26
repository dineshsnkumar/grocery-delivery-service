package io.projects.grocery.delivery.service.domain;

import io.projects.grocery.delivery.service.domain.entity.Grocery;
import io.projects.grocery.delivery.service.domain.entity.Order;
import io.projects.grocery.delivery.service.domain.events.OrderCancelledEvent;
import io.projects.grocery.delivery.service.domain.events.OrderCreatedEvent;
import io.projects.grocery.delivery.service.domain.events.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent initiateOrder(Order order, Grocery grocery);
    OrderPaidEvent payOrder(Order order);
    void approveOrder(Order order);
    void cancelOrder(Order order, List<String> failureMessages);
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

}
