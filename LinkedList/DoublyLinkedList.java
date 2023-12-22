public class DoublyLinkedList {
    Node head;
    Node tail;

     class Node {
        String data;
        Node next;
        Node previous;

        Node(String data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.addFirst("first");
        list.addFirst("2nd");
        list.addFirst("last");

        System.out.println("Doubly Linked List elements:");
        list.printList();
    }
}