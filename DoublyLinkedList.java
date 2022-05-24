import java.util.NoSuchElementException;

public class DoublyLinkedList {
    class Node {
        public Object data;
        public Node next;
        public Node previous;

        public Node(Object data) {
            this.data = data;
            next = null;
            previous = null;
        }
    }

    Node head, tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public Object getHead() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    public Object getTail() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
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
        Object oldTailData = tail.data;
        newNode.previous = tail;
        tail.next = newNode;
        tail = newNode;
        System.out.printf("| Old tail: %s | New tail: %s |\n", oldTailData, tail.data);
    }

    public void prepend(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Object oldHeadData = head.data;
        newNode.next = head.next;
        head.previous = newNode;
        head = newNode;
        System.out.printf("| Old head: %s | New head: %s |\n", oldHeadData, head.data);
    }

    public void removeHead() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Object oldHeadData = head.data;
        head = head.next;
        head.previous = null;
        System.out.printf("| Removed old head: %s | Replaced with new head: %s |\n", oldHeadData, head.data);
    }

    public void removeTail() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Object oldTailData = tail.data;
        tail = tail.previous;
        tail.next = null;
        System.out.printf("| Removed old tail: %s | Replaced with new tail: %s |\n", oldTailData, head.data);
    }

    public int size() {
        if(head == null) {
            return 0;
        }
        Node curNode = head;
        int size = 1;
        while(curNode != null) {
            size++;
            curNode = curNode.next;
        }
        return size;
    }

    public void printList() {
        if(head == null) {
            throw new NoSuchElementException("List is empty");
        }
        Node curNode = head;
        int counter = 0;
        while(curNode != null) {
            System.out.printf("| Node: %d = %s |\n", counter++, curNode.data);
            curNode = curNode.next;
        }
    }

    public void printListReverse() {
        if(head == null) {
            throw new NoSuchElementException();
        }
        Node curNode = tail;
        int counter = size();
        while(curNode != null) {
            System.out.printf("| Node: %d = %s |\n", counter--, curNode.data);
        }
    }
}
