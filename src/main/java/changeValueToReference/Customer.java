package changeValueToReference;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String name;
    private static Map<String, Customer> createdCustomers = new HashMap<>();

    private Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Customer create(String name) {
        if (createdCustomers.get(name) == null) {
            createdCustomers.put(name, new Customer(name));
        }
        return createdCustomers.get(name);
    }
}
