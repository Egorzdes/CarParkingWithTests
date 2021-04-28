import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Car> cars = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            cars.add(new Car("BMW" + i, i));
        }
        for (Car car : cars) {
            System.out.println(car.getModel() + " " + car.getNumber());
        }
    }
}
