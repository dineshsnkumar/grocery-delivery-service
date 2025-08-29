package io.projects.grocery.delivery.service.domain;

import io.projects.grocery.delivery.service.domain.entity.Grocery;
import io.projects.grocery.delivery.service.domain.entity.Order;
import io.projects.grocery.delivery.service.domain.events.OrderCancelledEvent;
import io.projects.grocery.delivery.service.domain.events.OrderCreatedEvent;
import io.projects.grocery.delivery.service.domain.events.OrderPaidEvent;
import io.projects.grocery.delivery.service.domain.exceptions.OrderDomainException;
import lombok.extern.slf4j.Slf4j;

import java.time.ZonedDateTime;
import java.util.List;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService{

    @Override
    public OrderCreatedEvent initiateOrder(Order order, Grocery grocery) {
        validateGrocery(grocery);
        order.validateOrder();
        order.initializeOrder();
        log.info("Order with {} id is initiated", order.getId().getValue());
        return new OrderCreatedEvent(order, ZonedDateTime.now());
    }


    @Override
    public OrderPaidEvent payOrder(Order order) {
        order.pay();
        log.info("Order with {} id is payed", order.getId().getValue());
        return new OrderPaidEvent(order, ZonedDateTime.now());
    }

    @Override
    public void approveOrder(Order order) {
        order.approve();
        log.info("Order with {} id is approved", order.getId().getValue());
    }

    @Override
    public void cancelOrder(Order order, List<String> failureMessages) {
        order.initCancel(failureMessages);
        log.info("Order with {} id is cancelling", order.getId().getValue());
    }

    @Override
    public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
        order.cancel(failureMessages);
        log.info("Order with {} id is cancelled", order.getId().getValue());
        return new OrderCancelledEvent(order, ZonedDateTime.now());
    }

    private void validateGrocery(Grocery grocery) {
        if(!grocery.isActive()){
           throw  new OrderDomainException("Grocery with id " + grocery.getId() + " is not currently active");
        }
    }
}
