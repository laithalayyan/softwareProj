package roles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Category#Category(String)}
     *   <li>{@link Category#isSearchproduct()}
     * </ul>
     */
    @Test
    void testConstructor() {
        // Arrange, Act and Assert
        assertTrue((new Category("Name")).isSearchproduct());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Category#Category(String)}
     *   <li>{@link Category#setSearchproduct(boolean)}
     * </ul>
     */
    @Test
    void testConstructor2() {
        // Arrange and Act
        Category actualCategory = new Category("Name");
        actualCategory.setSearchproduct(true);

        // Assert
        assertEquals("Name", actualCategory.getName());
    }

    /**
     * Method under test: {@link Category#addcatTEG(String)}
     */
    @Test
    void testAddcatTEG() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        Category.addcatTEG("Name");
    }
}

