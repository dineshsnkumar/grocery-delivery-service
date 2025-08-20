package io.projects.grocery.delivery.service.domain.valueobjects;

import io.projects.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {

    protected OrderItemId(Long value) {
        super(value);
    }
}
