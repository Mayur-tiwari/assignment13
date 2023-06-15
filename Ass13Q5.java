class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class LinkedList {
    Node head;

    void deleteLastOccurrence(int key) {
        Node temp = head;
        Node lastOccurrence = null;

        while (temp != null) {
            if (temp.data == key) {
                lastOccurrence = temp;
            }
            temp = temp.next;
        }

        if (lastOccurrence != null) {
            if (lastOccurrence == head) {
                head = head.next;
            } else {
                temp = head;
                while (temp.next != lastOccurrence) {
                    temp = temp.next;
                }

                temp.next = lastOccurrence.next;
            }
        }
    }

    void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(2);
        list.insert(5);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        System.out.println("Original Linked List:");
        list.display();

        int key = 2;
        list.deleteLastOccurrence(key);

        System.out.println("Linked List after deleting last occurrence of " + key + ":");
        list.display();
    }
}
