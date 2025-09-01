package io.projects.grocery.delivery.service.domain.application.dto.create;

import io.projects.grocery.delivery.service.domain.entity.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
public class CreateOrderCommand {
    @NonNull
    private final UUID customerId;
    @NonNull
    private final UUID orderId;
    @NonNull
    private final BigDecimal price;
    @NonNull
    private final List<OrderItem> orderItems;
    @NonNull
    private final OrderAddress orderAddress;
}
