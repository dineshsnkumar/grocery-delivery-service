package io.projects.grocery.delivery.service.domain.entity;

import io.projects.domain.entity.AggregateRoot;
import io.projects.domain.valueobject.GroceryId;

import java.util.List;

public class Grocery extends AggregateRoot<GroceryId> {
    private List<Product> products;
    private boolean isActive;

    private Grocery(Builder builder) {
        super.setId(builder.groceryId);
        setProducts(builder.products);
        setActive(builder.isActive);
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public static final class Builder {
        private GroceryId groceryId;
        private List<Product> products;
        private boolean isActive;

        private Builder() {
        }

        public static Builder builer() {
            return new Builder();
        }

        public Builder id(GroceryId val) {
            groceryId = val;
            return this;
        }

        public Builder products(List<Product> val) {
            products = val;
            return this;
        }

        public Builder isActive(boolean val) {
            isActive = val;
            return this;
        }

        public Grocery build() {
            return new Grocery(this);
        }
    }
}
