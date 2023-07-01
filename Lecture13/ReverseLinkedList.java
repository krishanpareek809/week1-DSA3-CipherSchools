package Lecture13;

public class ReverseLinkedList {

    public static Node reverseLinkedList(Node head) {
        Node rest = null;
        Node presentNode = head;
        Node pastNode = null;

        while (presentNode != null) {
            rest = presentNode.next;
            presentNode.next = pastNode;
            pastNode = presentNode;
            presentNode = rest;
        }
        head = pastNode;
        return head;
    }

    public static void main(String[] args) {
        Node head = NodeUse.createRandomLinkedList(6);
        NodeUse.printLinkedList(head);

        Node newHead = reverseLinkedList(head);

        NodeUse.printLinkedList(newHead);
    }
}
