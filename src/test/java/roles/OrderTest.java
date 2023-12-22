package roles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class OrderTest {
    /**
     * Method under test: {@link Order#Order(int, List)}
     */
    @Test
    void testConstructor() {
        // Arrange and Act
        Order actualOrder = new Order(1, new ArrayList<>());

        // Assert
        assertEquals(1, actualOrder.getOrderId());
        assertEquals(0.0d, actualOrder.getTotalPrice());
        assertTrue(actualOrder.getOrderedProducts().isEmpty());
    }

    /**
     * Method under test: {@link Order#Order(int, List)}
     */
    @Test
    void testConstructor2() {
        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(new Product("Name", 10.0d, "Category", 1));

        // Act
        Order actualOrder = new Order(1, productList);

        // Assert
        assertEquals(1, actualOrder.getOrderId());
        assertEquals(10.0d, actualOrder.getTotalPrice());
        assertEquals(1, actualOrder.getOrderedProducts().size());
    }

    /**
     * Method under test: {@link Order#Order(int, List)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConstructor3() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "roles.Product.getPrice()" because "product" is null
        //       at roles.Order.calculateTotalPrice(Order.java:66)
        //       at roles.Order.<init>(Order.java:48)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        ArrayList<Product> productList = new ArrayList<>();
        productList.add(null);

        // Act
        new Order(1, productList);

    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Order#Order(int, List)}
     *   <li>{@link Order#getOrderId()}
     * </ul>
     */
    @Test
    void testConstructor4() {
        // Arrange, Act and Assert
        assertEquals(1, (new Order(1, new ArrayList<>())).getOrderId());
    }
}

