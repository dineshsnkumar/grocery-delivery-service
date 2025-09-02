package io.projects.grocery.delivery.service.domain.application.dto.track;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class TrackOrderQuery {
    private final UUID trackOrderId;
}
