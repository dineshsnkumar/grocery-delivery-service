package io.projects.grocery.delivery.service.domain.application.dto.track;

import io.projects.domain.valueobject.OrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TrackOrderResponse {
    @NotNull
    private final UUID trackOrderId;
    @NotNull
    private final UUID customerId;
    @NotNull
    private final OrderStatus orderStatus;
    private final List<String> failureMessages;
}
