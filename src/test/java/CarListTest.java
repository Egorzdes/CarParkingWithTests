import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarListTest {

    private CarList carList;

    @Before
    public void setUp() throws Exception {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("BMW" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {

        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {

        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Mazda", 77);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenReturnFalse() {
        Car car = new Car("Opel", 99);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBeZero() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenIndexOutOfBoundsThenThrowException() {
        carList.get(100);
    }

    @Test
    public void methodGetReturnsRightValue() {
        Car car = carList.get(0);
        assertEquals("BMW0", car.getModel());
    }


    @Test
    public void insertIntoMiddlePosition() {
        Car car = new Car("Audi", 1);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Audi", carFromList.getModel());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("Audi", 1);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("Audi", carFromList.getModel());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Audi", 1);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("Audi", carFromList.getModel());
    }
}