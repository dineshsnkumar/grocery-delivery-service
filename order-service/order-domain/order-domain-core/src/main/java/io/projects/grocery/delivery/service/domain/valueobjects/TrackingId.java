package io.projects.grocery.delivery.service.domain.valueobjects;

import io.projects.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    protected TrackingId(UUID value) {
        super(value);
    }
}
