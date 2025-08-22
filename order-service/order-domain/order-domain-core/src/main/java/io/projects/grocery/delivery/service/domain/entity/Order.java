package io.projects.grocery.delivery.service.domain.entity;

import io.projects.domain.entity.AggregateRoot;
import io.projects.domain.valueobject.*;
import io.projects.grocery.delivery.service.domain.exceptions.OrderDomainException;
import io.projects.grocery.delivery.service.domain.valueobjects.OrderItemId;
import io.projects.grocery.delivery.service.domain.valueobjects.StreetAddress;
import io.projects.grocery.delivery.service.domain.valueobjects.TrackingId;

import java.util.List;
import java.util.UUID;

public class Order extends AggregateRoot<OrderId> {
    private final CustomerId customerId;
    private final GroceryId groceryId;
    private final StreetAddress streetAddress;
    private final Money price;
    private final List<OrderItem> items;

    private TrackingId trackingId;
    private OrderStatus orderStatus;
    private List<String> failureMessages;

    private Order(Builder builder) {
        super.setId(builder.orderId);
        customerId = builder.customerId;
        groceryId = builder.groceryId;
        streetAddress = builder.streetAddress;
        price = builder.price;
        items = builder.items;
        trackingId = builder.trackingId;
        orderStatus = builder.orderStatus;
        failureMessages = builder.failureMessages;
    }


    public CustomerId getCustomerId() {
        return customerId;
    }

    public GroceryId getGroceryId() {
        return groceryId;
    }

    public StreetAddress getStreetAddress() {
        return streetAddress;
    }

    public Money getPrice() {
        return price;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public TrackingId getTrackingId() {
        return trackingId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    public void initializeOrder(){
        setId(new OrderId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        orderStatus = OrderStatus.PENDING;
        initializeOrderItems();
    }

    public void validateOrder(){
        validateTotalPrice();
        validateItemPrice();
    }

    private void validateItemPrice() {
        if (price != null && !price.isGreaterThanZero()){
            throw new OrderDomainException("Price must not greater than zero and should not be bull");
        }
    }

    private void validateTotalPrice() {
        Money orderItemSubTotal = items.stream().map(orderItem -> {
            validateItemPrice(orderItem);
            return orderItem.getSubTotal();
        }).reduce(Money.ZERO, Money::add);

        if (!price.equals(orderItemSubTotal)){
            throw new OrderDomainException("Price price" + price + " is not equal to subtotal price " + orderItemSubTotal);
        }
    }

    private void validateItemPrice(OrderItem orderItem) {

    }


    private void initializeOrderItems() {
        long itemId = 1;
        for ( OrderItem orderItem: items){
            orderItem.initializeOrderItem(super.getId(), new OrderItemId(itemId++));
        }
    }

    public static final class Builder {
        private OrderId orderId;
        private CustomerId customerId;
        private GroceryId groceryId;
        private StreetAddress streetAddress;
        private Money price;
        private List<OrderItem> items;
        private TrackingId trackingId;
        private OrderStatus orderStatus;
        private List<String> failureMessages;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder orderId(OrderId val) {
            orderId = val;
            return this;
        }

        public Builder customerId(CustomerId val) {
            customerId = val;
            return this;
        }

        public Builder groceryId(GroceryId val) {
            groceryId = val;
            return this;
        }

        public Builder streetAddress(StreetAddress val) {
            streetAddress = val;
            return this;
        }

        public Builder price(Money val) {
            price = val;
            return this;
        }

        public Builder items(List<OrderItem> val) {
            items = val;
            return this;
        }

        public Builder trackingId(TrackingId val) {
            trackingId = val;
            return this;
        }

        public Builder orderStatus(OrderStatus val) {
            orderStatus = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
