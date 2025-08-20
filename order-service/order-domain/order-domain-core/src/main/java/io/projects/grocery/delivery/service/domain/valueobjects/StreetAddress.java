package io.projects.grocery.delivery.service.domain.valueobjects;

import io.projects.domain.valueobject.BaseId;

import java.util.Objects;
import java.util.UUID;

public class StreetAddress {
    private final UUID id;
    private final String steet;
    private final String postalCode;
    private final String city;
    private final String country;

    public StreetAddress(UUID id, String steet, String postalCode, String city, String country) {
        this.id = id;
        this.steet = steet;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getSteet() {
        return steet;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StreetAddress that = (StreetAddress) o;
        return Objects.equals(steet, that.steet) && Objects.equals(postalCode, that.postalCode) && Objects.equals(city, that.city) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steet, postalCode, city, country);
    }
}
