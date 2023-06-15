class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    void deleteNode(int position) {
        // If the list is empty
        if (head == null)
            return;

        Node current = head;

        if (position == 1) {
            head = current.next;

            if (head != null)
                head.prev = null;

            return;
        }

        for (int i = 1; current != null && i < position; i++)
            current = current.next;

        if (current == null)
            return;

        if (current.prev != null)
            current.prev.next = current.next;

        if (current.next != null)
            current.next.prev = current.prev;
    }

    void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.head = new Node(1);
        Node second = new Node(3);
        Node third = new Node(4);

        dll.head.next = second;
        second.prev = dll.head;

        second.next = third;
        third.prev = second;

        int position = 3;

        System.out.println("Original Linked List:");
        dll.printList();

        dll.deleteNode(position);

        System.out.println("Updated Linked List after deleting node at position " + position + ":");
        dll.printList();
    }
}
