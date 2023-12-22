package roles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.List;

import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer(String, String, String, String)}
     *   <li>{@link Customer#getPassword()}
     * </ul>
     */
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

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer(String, String, String, String)}
     *   <li>{@link Customer#setPassword(String)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // Arrange and Act
        Customer actualCustomer = new Customer("janedoe", "jane.doe@example.org", "iloveyou", "User Type");
        actualCustomer.setPassword("iloveyou");

        // Assert
        assertEquals("iloveyou", actualCustomer.getPassword());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Customer#Customer(String, String, String, String)}
     *   <li>{@link Customer#getOrders()}
     * </ul>
     */
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

