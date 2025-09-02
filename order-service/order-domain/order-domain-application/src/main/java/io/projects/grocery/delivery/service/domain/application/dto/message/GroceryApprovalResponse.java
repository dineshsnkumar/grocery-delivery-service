package io.projects.grocery.delivery.service.domain.application.dto.message;

import io.projects.domain.valueobject.OrderApprovalStatus;
import io.projects.domain.valueobject.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GroceryApprovalResponse {
    private String id;
    private String sagaId;
    private String orderId;
    private String groceryId;
    private Instant createdAt;
    private OrderApprovalStatus paymentStatus;
    private List<String> failureMessages;
}
