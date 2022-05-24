
import java.util.NoSuchElementException;

public class SinglyLinkedList {
    class Node {
        public Object data;
        public Node next;

        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }

    class LinkedListIterator {
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        public LinkedListIterator() {
            position = null;
            previous = null;
            isAfterNext = false;
        }

        public Object next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }

            previous = position;
            isAfterNext = true;

            if(position == null) {
                position = head;
                return position.data;
            }
            position = position.next;
            return position.data;
        }

        public boolean hasNext() {
            if(position == null) {
                return head != null;
            }
            return position.next != null;
        }

        public void remove() {
            if(!isAfterNext) {
                throw new IllegalStateException();
            }
            if(position == head) {
                removeHead();
            } else {
                previous.next = position.next;
            }
            position = previous;
            isAfterNext = false;
        }

        public void add(Object element) {
            if(position == null) {
                prepend(element);
                position = head;
            } else {
                Node newNode = new Node(element);
                newNode.next = position.next;
                position.next = newNode;
                position = newNode;
            }
            isAfterNext = false;            
        }

        public void set(Object element) {
            if(!isAfterNext) {
                throw new IllegalStateException();
            }
            position.data = element;
        }
    } 

    Node head , tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public Object getHead() {
        if(head == null) {
            throw new NoSuchElementException("The list is empty");
        }
        return head.data;
    }

    public Object getTail() {
        if(head == null) {
            throw new NoSuchElementException("The list is empty");
        }
        return tail.data;
    }

    public void append(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void prepend(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public Object removeHead() {
        if(head == null) {
            throw new NoSuchElementException("List is empty, cannot remove head");
        }
        Object oldHead = head.data;
        head = head.next;
        return oldHead;
    }

    public Object removeTail() {
        if(head == null) {
            throw new NoSuchElementException("List is empty, cannot remove tail");
        }
        Object oldTail = tail.data;
        Node newTail = head;
        while(newTail.next != tail) {
            newTail = newTail.next;
        }
        tail = newTail;
        tail.next = null;
        return oldTail;
    }

    public void printList() {
        if(head == null) {
            throw new NoSuchElementException("The list is empty");
        }
        Node curNode = head;
        while(curNode != null) {
            System.out.printf("data: %d\n", curNode.data);
            curNode = curNode.next;
        }
    }

    public LinkedListIterator listIterator() {
        return new LinkedListIterator();
    }

}
