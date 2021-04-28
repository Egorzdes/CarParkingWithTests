import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarCollectionTest {

    private CarCollection carCollection;

    @Before
    public void setUp() throws Exception {
        carCollection = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carCollection.add(new Car("BMW" + i, i));
        }
    }

    @Test
    public void containsCar() {
        assertTrue(carCollection.contains(new Car("BMW", 20)));
        assertFalse(carCollection.contains(new Car("BMW123", 20)));
    }

    @Test
    public void testForeach() {
        int index = 0;
        for (Car car : carCollection) {
            index++;
        }
        assertEquals(100, index);
    }
}