class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    Node reverseInGroups(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;

        while (count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        return prev;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(8);
        list.insert(7);
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(2);
        list.insert(2);
        list.insert(1);

        int k = 4;

        list.display(list.head);

        list.head = list.reverseInGroups(list.head, k);

        list.display(list.head);
    }
}
