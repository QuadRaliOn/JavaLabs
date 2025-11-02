import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
/**
 * @param <T> тип елементів у множині
 */
public class SinglyLinkedSet<T> implements Set<T> {
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private int size;

    public SinglyLinkedSet() {
        head = null;
        size = 0;
    }

    public SinglyLinkedSet(T element) {
        this();
        add(element);
    }

    public SinglyLinkedSet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public boolean add(T value) {
        if (contains(value))
            return false; // унікальність
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur != null) {
            if ((o == null && cur.value == null) || (o != null && o.equals(cur.value))) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> cur = head;
        while (cur != null) {
            if ((o == null && cur.value == null) || (o != null && o.equals(cur.value)))
                return true;
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = head;
            Node<T> previous = null;
            boolean canRemove = false;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (current == null) throw new NoSuchElementException();
                T value = current.value;
                previous = current;
                current = current.next;
                canRemove = true;
                return value;
            }

            @Override
            public void remove() {
                if (!canRemove) throw new IllegalStateException();
                SinglyLinkedSet.this.remove(previous.value);
                canRemove = false;
            }
        };
    }


    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        Node<T> cur = head;
        int i = 0;
        while (cur != null) {
            arr[i++] = cur.value;
            cur = cur.next;
        }
        return arr;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if (a.length < size)
            a = (E[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        Node<T> cur = head;
        int i = 0;
        Object[] result = a;
        while (cur != null) {
            result[i++] = cur.value;
            cur = cur.next;
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c)
            if (!contains(o)) return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean changed = false;
        for (T e : c)
            if (add(e)) changed = true;
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        Node<T> prev = null;
        Node<T> cur = head;
        while (cur != null) {
            if (!c.contains(cur.value)) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                size--;
                changed = true;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c)
            if (remove(o)) changed = true;
        return changed;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> cur = head;
        while (cur != null) {
            sb.append(cur.value);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
