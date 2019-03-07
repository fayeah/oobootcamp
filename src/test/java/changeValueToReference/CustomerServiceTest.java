package changeValueToReference;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {
    @Test
    void should_return2_given_same_customer_has_2_orders() {
        String customer = "test";
        List<Order> orderList = new ArrayList<>();
        Order order1 = new Order(customer);
        Order order2 = new Order(customer);
        Order order3 = new Order("abc");

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);

        assertEquals(2, CustomerService.numberOfOrdersFor(orderList, customer));
        assertSame( order1.getCustomer(), order2.getCustomer());
    }
}