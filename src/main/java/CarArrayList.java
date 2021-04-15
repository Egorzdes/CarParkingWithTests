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
        increaseArray();
//            Car [] newCars = new Car[cars.length * 2];
//
//            for(int i = 0; i < cars.length; i++) {
//                newCars[i] = cars[i];
//            }
//            cars = newCars;

        cars[size] = car;
        size++;
    }

    /**
     * Метод System.arraycopy
     * Обращается напрямую к памяти компьютера и берет разом
     * нужный объем данных и перемещает его в нужное нам место. Если у нас будет массив
     * на 1000 элементов и мы захотим вставить новый элемент в начало коллекции, то в реализации
     * без System.arraycopy придется 1000 раз сдвигать каждый раз по 1 элементу, а системный метод
     * arraycopy возьмет сразу всю 1000 элементов и вставит их за 1 шаг.
     * Первый параметр arraycopy - массив с которым работаем, второй - исходная позиция ,
     * третья - массив назначения, куда складываем элементы , четвертый - указание с какого элемента будем класть
     * элементы, пятый - длинна , сколько элементов нужно переместить
     */
    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(cars, index, cars, index + 1, size - index);
        cars[index] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (cars[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(cars, index + 1, cars, index, size - 1 - index);
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

    private void increaseArray() {
        if (size >= cars.length) {
            cars = Arrays.copyOf(cars, cars.length * 2);
        }
    }
}