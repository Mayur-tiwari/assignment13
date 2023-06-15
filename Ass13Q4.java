class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    // Function to reverse every alternate k nodes
    Node reverseAlternateKNodes(Node head, int k) {
        Node current = head;
        Node prev = null;
        Node next = null;

        int count = 0;

        // Reverse first k nodes of the linked list
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Connect the reversed sublist to the remaining list
        if (head != null) {
            head.next = current;
        }

        // Skip k nodes
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.next;
            count++;
        }

        // Recursively reverse the next alternate k nodes
        if (current != null) {
            current.next = reverseAlternateKNodes(current.next, k);
        }

        // Return the new head of the reversed list
        return prev;
    }

    // Function to print the linked list
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);

        int k = 3;

        System.out.println("Original Linked List:");
        list.printList(list.head);

        Node newHead = list.reverseAlternateKNodes(list.head, k);

        System.out.println("Reversed Linked List:");
        list.printList(newHead);
    }
}
