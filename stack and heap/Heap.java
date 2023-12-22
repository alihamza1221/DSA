import java.util.ArrayList;
import java.util.List;

class Heap<T extends Comparable<T>> {
    List<T> list;

    public Heap() {
        list = new ArrayList<T>();
    }

    private int parent(int i) {
        // parent = i /2 for i = 1
        return (i - 1) / 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private void swap(int first, int second) {
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    public void Insert(T item) {
        list.add(item);
        upheap(list.size() - 1);
    }

    public void upheap(int index) {
        if (index == 0) {
            return;
        }
        int parent = parent(index);
        if (list.get(index).compareTo(list.get(parent)) < 0) {
            swap(index, parent);
            upheap(parent);
        }
    }

    public T remove() {
        T temp = list.get(0);
        T last = list.remove(list.size() - 1);
        if (list.size() > 0) {
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }

    private void downheap(int index) {
        int left = left(index);
        int right = right(index);
        int smallest;

        // Determine which child is smaller
        if (right < list.size() && list.get(right).compareTo(list.get(left)) < 0) {
            smallest = right;
        } else if (left < list.size()) {
            smallest = left;
        } else {
            return; // If there are no children, end the method
        }

        // If the smallest child is smaller than the root, swap them and recurse
        if (list.get(smallest).compareTo(list.get(index)) < 0) {
            swap(index, smallest);
            downheap(smallest);
        }
    }

    public void print() {
        System.out.println(list);
    }

    public void peek() {
        System.out.println(list.get(0));
    }

    // heap sort
    public ArrayList<T> heapSort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

}

class testClass {
    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.Insert(10);
        heap.Insert(25);
        heap.Insert(5);
        heap.Insert(30);
        heap.Insert(20);
        heap.Insert(15);

        heap.peek();
        heap.print();
        System.out.println(heap.heapSort());

    }
}
