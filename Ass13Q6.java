class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeLinkedLists {
    public static Node mergeLists(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.next = mergeLists(a.next, b);
        } else {
            result = b;
            result.next = mergeLists(a, b.next);
        }

        return result;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a1 = new Node(5);
        Node a2 = new Node(10);
        Node a3 = new Node(15);
        a1.next = a2;
        a2.next = a3;

        Node b1 = new Node(2);
        Node b2 = new Node(3);
        Node b3 = new Node(20);
        b1.next = b2;
        b2.next = b3;

        Node mergedList = mergeLists(a1, b1);

        printList(mergedList);
    }
}
