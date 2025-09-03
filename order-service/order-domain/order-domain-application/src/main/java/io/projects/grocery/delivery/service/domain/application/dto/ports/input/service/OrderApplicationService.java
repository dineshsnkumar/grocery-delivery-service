package io.projects.grocery.delivery.service.domain.application.dto.ports.input.service;

import io.projects.grocery.delivery.service.domain.application.dto.create.CreateOrderCommand;
import io.projects.grocery.delivery.service.domain.application.dto.create.CreateOrderResponse;
import io.projects.grocery.delivery.service.domain.application.dto.track.TrackOrderQuery;
import io.projects.grocery.delivery.service.domain.application.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {
    CreateOrderResponse createOrder(@Valid CreateOrderCommand createOrderCommand);
    TrackOrderResponse track(@Valid TrackOrderQuery trackOrderQuery);
}
