package jackson.rick;

import java.util.List;

/**
 * Created by rickjackson on 2/24/17.
 */
public class LinkedList<E> {
    int size = 0;
    Node<E> first;
    Node<E> last;
    
    public LinkedList() {
        
    }
    
    public E removeFirst() {
        final Node<E> first = this.first;
        if (first == null)
            throw new NullPointerException();
        return unlinkFirst(first);
    }
    
    
    public boolean add(E e) {
        linkLast(e);
        return true;
    }
    
    public void add(int index, E e) {
        checkIndex(index);
        
        if (index == size) {
            linkLast(e);
        } else {
            linkBefore(e, elementNode(index));
        }
    }
    
    public E remove() {
        return removeFirst();
    }
    
    public E remove(int index) {
        checkIndex(index);
        return unlink(elementNode(index));
    }
    
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> n = this.first; n != null; n = n.next) {
                if (n.element == null) {
                    unlink(n);
                    return true;
                }
            }
        } else {
            for (Node<E> n = this.first; n != null; n = n.next) {
                if (o.equals(n.element)) {
                    unlink(n);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean contains(Object o) {
        return false;
    }
    
    public int find(Object o) {
        return 0;
    }
    
    public int size() {
        return size;
    }
    
    public E get(int index) {
        checkIndex(index);
        return elementNode(index).element;
    }
    
    @Override
    public Object clone() {
        return null;
    }
    
    public void sort() {
        
    }
    
    public void reverse() {
        
    }
    
    public List<E> slice(int fromIndex, int toIndex) {
        return null;
    }
    
    Node<E> elementNode(int index) {
        if (index < (size / 2)) {
            Node<E> first = this.first;
            
            for (int i = 0; i < index; i++) {
                first = first.next;
            }
            return first;
        } else {
            Node<E> last = this.last;
            
            for (int i = size - 1; i > index; i--) {
                last = last.previous;
            }
            return last;
        }
    }
    
    void linkBefore(E e, Node<E> previous) {
        final Node<E> oldNode = previous.previous;
        final Node<E> newNode = new Node<>(oldNode, e, previous);
        previous.previous = newNode;
        
        if (oldNode == null) {
            this.first = newNode;
        } else {
            oldNode.next = newNode;
        }
        size++;
    }
    
    void linkLast(E e) {
        final Node<E> oldLast = this.last;
        final Node<E> newLast = new Node<>(last, e, null);
        this.last = newLast;
        
        if (oldLast == null) {
            this.first = newLast;
        } else {
            oldLast.next = newLast;
        }
        size++;
    }
    
    E unlink(Node<E> node) {
        final Node<E> previous = node.previous;
        final E element = node.element;
        final Node<E> next = node.next;
        
        if (previous == null) {
            this.first = next;
        } else {
            previous.next = next;
            node.previous = null;
        }
        
        if (next == null) {
            this.last = previous;
        } else {
            next.previous = previous;
            node.next = null;
        }
        node.element = null;
        size--;
        
        return element;
    }
    
    private E unlinkFirst(Node<E> first) {
        final E element = first.element;
        final Node<E> next = first.next;
        first.element = null;
        first.next = null;
        this.first = next;
        
        if (next == null) {
            this.last = null;
        } else {
            next.previous = null;
        }
        size--;
        
        return element;
    }
    
    private boolean isIndex(int index) {
        return (index >= 0) && (index <= size);
    }
    
    private void checkIndex(int index) {
        if (!isIndex(index)) {
            throw new IndexOutOfBoundsException();
        }
    }
    
    private static class Node<E> {
        E element;
        Node<E> previous;
        Node<E> next;
        
        Node(Node<E> previous, E element, Node<E> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
}
