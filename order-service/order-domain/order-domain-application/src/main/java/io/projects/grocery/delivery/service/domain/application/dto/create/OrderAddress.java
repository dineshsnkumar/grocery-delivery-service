package io.projects.grocery.delivery.service.domain.application.dto.create;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Builder
public class OrderAddress {
    @NonNull
    private final String street;
    @NonNull
    private final String city;
    @NonNull
    private final String state;
    @NonNull
    private final String country;
    @NonNull
    private final String postCode;

}
