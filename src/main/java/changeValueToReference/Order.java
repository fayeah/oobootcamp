package changeValueToReference;

public class Order {
    private Customer customer;

    public Order(String customerName) {
        this.customer = Customer.create(customerName);
    }

    public String getCustomerName() {
        return customer.getName();
    }

    public Customer getCustomer() {
        return customer;
    }
}
