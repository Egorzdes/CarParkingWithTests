public class CarLinkedList implements CarList {

    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car get(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            last = new Node(secondLast, car, null);
            secondLast.next = last;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        if (index < 0 || index > size) { // проверяем индекс если за пределами коллекции то бросаем исключение
            throw new IndexOutOfBoundsException();
        }
        if (index == size) { // если индекс равен размеру коллекции вставляем объект в конец
            add(car);
            return;
        }
        Node nodeNext = getNode(index); // индекс не является последним элементом, нужно получить ссылки на соседние
        Node nodePrevious = nodeNext.previous; // получаем ссылки на предыдущий элемент, обратившись к переменной previous у предыдущего элемента
        Node newNode = new Node(nodePrevious, car, nodeNext); /* создаем новую ветку, которую вставляем между объектами previous и next,
        далее переписываем ссылки у элементов previous и next чтобы они ссылались на новую ветку;
        */
        nodeNext.previous = newNode; // предыдущий элемент равен новой ветке
        if (nodePrevious != null) { // если Node previous равен null , тогда переменной first присв. значение newNode
            nodePrevious.next = newNode; // следующий элемент равен новой ветке
        } else {
            first = newNode;

        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if(node.value.equals(car)) {
              return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        Node node = getNode(index);
        Node nodeNext = node.next;
        Node nodePrevious = node.previous;
        if(nodeNext != null) {
            nodeNext.previous = nodePrevious;
        } else {
            last = nodePrevious;
        }
        if(nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
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
        first = null;
        last = null;
        size = 0;
    }

    // у первого элемента будет вызван метод next, в итоге получим элемент по нужному индексу
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    /*
    Если класс не использует методы класса,
    внутри которого он находится, то его следует сделать статическим
     */
    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }
    }
}