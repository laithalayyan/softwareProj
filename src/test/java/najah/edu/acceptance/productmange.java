package najah.edu.acceptance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static roles.Product.manageProducts;

public class productmange {
/*
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @Test
    public void testManageProducts_AddProduct() {
        // Input data for the test
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke the function to be tested
        int result = manageProducts();

        // Assert the output and result
        String expectedOutput = "\nProduct Management\n1. Add Product\n2. Delete Product\n3. List Products\n4. Back\nChoose an option: ";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        assertEquals(1, result);
    }

    @Test
    public void testManageProducts_DeleteProduct() {
        // Input data for the test
        String input = "2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Invoke the function to be tested
        int result = manageProducts();

        // Assert the output and result
        String expectedOutput = "\nProduct Management\n1. Add Product\n2. Delete Product\n3. List Products\n4. Back\nChoose an option: ";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
        assertEquals(2, result);
    }

    // Similarly, you can write tests for other cases (List Products, Back, and Invalid choice)
*/
}


