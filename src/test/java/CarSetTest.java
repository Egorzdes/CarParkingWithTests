import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarSetTest {

    private CarSet carSet;

    @Before
    public void setUp() throws Exception {
        carSet = new CarHashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("BMW" + i, i));
        }
    }

//    @Test
//    public void whenAddThreeSimilarObjectThenSizeIncreaseByOne() {
//        assertEquals(100, carSet.size());
//        assertTrue(carSet.add(new Car("BMW", 8)));
//        assertFalse(carSet.add(new Car("BMW", 8)));
//        assertFalse(carSet.add(new Car("BMW", 8)));
//        assertEquals(100, carSet.size());
//    }

    @Test
    public void whenSetClearedThenSizeZero() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

//    @Test
//    public void whenElementRemovedThenSizeDecreased() {
//        assertTrue(carSet.remove(new Car("Brand1", 33)));
//        assertEquals(100, carSet.size());
//        assertFalse(carSet.remove(new Car("Brand1", 33)));
//        assertEquals(99, carSet.size());
//    }
}