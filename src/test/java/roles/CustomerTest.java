package roles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertEquals("iloveyou", (new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type")).getPassword());
        assertEquals("User Type",
                (new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type")).getUserType());
        assertEquals("janedoe",
                (new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type")).getUsername());
        assertEquals("jane.doe@example.org",
                (new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type")).getEmail());
    }

    @Test
    void testConstructor2() {
        // Arrange and Act
        Customer actualCustomer = new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type");
        actualCustomer.setPassword("iloveyou");

        // Assert
        assertEquals("iloveyou", actualCustomer.getPassword());
    }


    @Test
    void testConstructor3() {
        // Arrange and Act
        Customer actualCustomer = new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type");

        // Assert
        //List<Order> expectedOrders = actualCustomer.orders;
        List<Order> orders = actualCustomer.getOrders();
        //assertSame(expectedOrders, orders);
        assertEquals(Customer.customers, orders);
    }
}

