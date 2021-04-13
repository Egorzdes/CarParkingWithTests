import java.util.Arrays;

public class CarArrayList implements CarList {

    private Car[] cars = new Car[10];
    private int size = 0;


    @Override
    public Car get(int index) {
        checkIndex(index);
        return cars[index];
    }

    @Override
    public void add(Car car) {
        if (size >= cars.length) {
            cars = Arrays.copyOf(cars, cars.length * 2);
//            Car [] newCars = new Car[cars.length * 2];
//
//            for(int i = 0; i < cars.length; i++) {
//                newCars[i] = cars[i];
//            }
//            cars = newCars;
        }
        cars[size] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for(int i = 0; i < size; i++) {
            if(cars[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            cars[index] = cars[i + 1];
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        cars = new Car[10];
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}