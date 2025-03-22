/*
 * Randomized queue. A randomized queue is similar to a stack or queue, 
 * except that the item removed is chosen uniformly at random among items
 * in the data structure. Create a generic data type RandomizedQueue that 
 * implements the following API:
 */

 import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;
    private Random random;

    public RandomizedQueue() {
        array = (Item[]) new Object[1];
        size = 0;
        random = new Random();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot enqueue null item");
        }
        if (size == array.length) {
            resize(2 * array.length);
        }
        array[size++] = item;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = random.nextInt(size);
        Item item = array[index];
        array[index] = array[size - 1];
        array[size - 1] = null; // Avoid loitering
        size--;
        if (size > 0 && size == array.length / 4) {
            resize(array.length / 2);
        }
        return item;
    }

    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        int index = random.nextInt(size);
        return array[index];
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            copy[i] = array[i];
        }
        array = copy;
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private Item[] items;
        private int current;
        private Random rnd;

        public RandomizedQueueIterator() {
            items = (Item[]) new Object[size];
            for (int i = 0; i < size; i++) {
                items[i] = array[i];
            }
            rnd = new Random();
            shuffle(items);
            current = 0;
        }

        private void shuffle(Item[] arr) {
            for (int i = arr.length - 1; i > 0; i--) {
                int j = rnd.nextInt(i + 1);
                Item temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        public boolean hasNext() {
            return current < items.length;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more items to return");
            }
            return items[current++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove operation is not supported");
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> rq = new RandomizedQueue<>();
        System.out.println("Initial isEmpty: " + rq.isEmpty());
        System.out.println("Initial size: " + rq.size());

        rq.enqueue(1);
        rq.enqueue(2);
        rq.enqueue(3);
        System.out.println("Size after enqueues: " + rq.size());

        System.out.println("Sample: " + rq.sample());

        System.out.println("Dequeue: " + rq.dequeue());
        System.out.println("Size after dequeue: " + rq.size());

        System.out.println("Iterator test:");
        for (Integer num : rq) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Multiple iterators test:");
        Iterator<Integer> it1 = rq.iterator();
        Iterator<Integer> it2 = rq.iterator();
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();
        while (it2.hasNext()) {
            System.out.print(it2.next() + " ");
        }
        System.out.println();

        try {
            rq.enqueue(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught enqueue null: " + e);
        }

        while (!rq.isEmpty()) {
            rq.dequeue();
        }
        System.out.println("Size after dequeue all: " + rq.size());

        try {
            rq.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Caught dequeue on empty: " + e);
        }

        try {
            Iterator<Integer> it = rq.iterator();
            it.next();
        } catch (NoSuchElementException e) {
            System.out.println("Caught iterator next on empty: " + e);
        }

        try {
            Iterator<Integer> it = rq.iterator();
            it.remove();
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught iterator remove: " + e);
        }
    }
}