package be.ordina.shbe.carfactory.controller.resource;

public class Order {

    private String id;
    private int quantity;
    private String model;

    private Order() {
    }

    private Order(Builder builder) {
        this.id = builder.id;
        this.quantity = builder.quantity;
        this.model = builder.model;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getModel() {
        return model;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private int quantity;
        private String model;

        private Builder() {

        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }
}
