package io.projects.domain.valueobject;

import java.util.UUID;

public class GroceryId extends BaseId<UUID> {
    protected GroceryId(UUID value) {
        super(value);
    }
}
