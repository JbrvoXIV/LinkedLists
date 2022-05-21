public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.append(13);
        list.append(29);
        list.append(19);
        list.append(30);
        list.append(22);
        list.printList();
        System.out.printf("%d\n", list.getHead());
        System.out.printf("%d\n", list.getTail());
        System.out.printf("Old Head: %d\n", list.removeHead());
        System.out.printf("Old Tail: %d\n", list.removeTail());
        list.printList();
        System.out.printf("Old Head: %d\n", list.removeHead());
        System.out.printf("Old Tail: %d\n", list.removeTail());
        list.printList();
    }
}