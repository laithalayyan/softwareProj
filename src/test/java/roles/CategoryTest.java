package roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertTrue((new Category("Name")).isSearchproduct());
    }

    @Test
    void testConstructor2() {
        // Arrange and Act
        Category actualCategory = new Category("Name");
        actualCategory.setSearchproduct(true);

        // Assert
        assertEquals("Name", actualCategory.getName());
    }


}

