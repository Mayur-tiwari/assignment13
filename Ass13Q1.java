class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public LinkedList createNewList(LinkedList list1, LinkedList list2) {
        LinkedList newList = new LinkedList();
        Node temp1 = list1.head;
        Node temp2 = list2.head;

        while (temp1 != null && temp2 != null) {
            if (temp1.data >= temp2.data) {
                newList.insert(temp1.data);
            } else {
                newList.insert(temp2.data);
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return newList;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.insert(5);
        list1.insert(2);
        list1.insert(3);
        list1.insert(8);

        list2.insert(1);
        list2.insert(7);
        list2.insert(4);
        list2.insert(5);

        LinkedList newList = new LinkedList();
        newList = newList.createNewList(list1, list2);

        newList.printList();

        list1 = new LinkedList();
        list2 = new LinkedList();

        list1.insert(2);
        list1.insert(8);
        list1.insert(9);
        list1.insert(3);

        list2.insert(5);
        list2.insert(3);
        list2.insert(6);
        list2.insert(4);

        newList = new LinkedList();
        newList = newList.createNewList(list1, list2);

        newList.printList();
    }
}
