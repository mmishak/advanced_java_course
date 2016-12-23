import java.util.*;

public class LFUCache<E> implements Iterable<E> {

    private final int CAPACITY = 10;

    public class Value {
        private E value;
        private int frequency;

        Value(E value) {
            this.value = value;
            this.frequency = 0;
        }

        Value(E value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public E getValue() {
            return value;
        }

        int getFrequency() {
            return frequency;
        }

        void incFrequency() {
            this.frequency++;
        }
    }

    private Map<Integer, Value> cache = new LinkedHashMap<>();

    public void add(int key, E value) {
        if (isFull()) {
            int removedKey = getLFUKey();
            cache.remove(removedKey);
        }
        addNewValue(key, value);
    }

    public E get(int key) {
        if (cache.containsKey(key)) {
            Value data = cache.get(key);
            data.incFrequency();
            cache.put(key, data);
            return data.value;
        }
        return null;
    }

    private void addNewValue(int key, E value){
        cache.put(key, new Value(value));
    }

    private boolean isFull(){
        return cache.size() == CAPACITY;
    }

    public void clear() {
        cache.clear();
    }

    public int getLFUKey(){
        int min = Integer.MAX_VALUE;
        int key = -1;
        for (Map.Entry<Integer, Value> item : cache.entrySet()) {
            if (item.getValue().getFrequency() < min) {
                min = item.getValue().getFrequency();
                key = item.getKey();
            }
        }
        return key;
    }

    public Iterator<E> iterator() {
        return new LFUCacheIterator();
    }

    private class LFUCacheIterator implements Iterator<E> {
        Iterator<Map.Entry<Integer, Value>> itr = cache.entrySet().iterator();

        @Override
        public boolean hasNext() {
            return itr.hasNext();
        }

        @Override
        public E next() {
            return itr.next().getValue().value;
        }
    }
}
