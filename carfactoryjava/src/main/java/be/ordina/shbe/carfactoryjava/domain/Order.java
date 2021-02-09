package be.ordina.shbe.carfactoryjava.domain;

public class Order {
    private String id;
    private String model;
    private int quantity;

    private Order() {
    }

    private Order(Builder builder) {
        this.quantity = builder.quantity;
        this.model = builder.model;
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
        private int quantity;
        private String model;

        private Builder() {

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
