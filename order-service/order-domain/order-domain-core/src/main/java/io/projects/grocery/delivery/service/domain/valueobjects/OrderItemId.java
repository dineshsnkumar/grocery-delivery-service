package io.projects.grocery.delivery.service.domain.valueobjects;

import io.projects.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {

    public OrderItemId(Long value) {
        super(value);
    }
}
