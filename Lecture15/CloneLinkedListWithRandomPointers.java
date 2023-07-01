package Lecture15;

import Lecture13.Node;
import jdk.internal.util.xml.impl.Input;

import static Lecture14.DLLOperations.head;

public class CloneLinkedListWithRandomPointers {
    Node original = head;

    while(original!=null&&original.next!=null)
    {
        Input cloneNode = new Node(original.getData());
        Input oriiginal = null;
        oriiginal.next = cloneNode;
        Input next = null;
        cloneNode.next = next;
        original = original.next.next;
    }

    original.next=new Node(original.getData());original=head;

    while(original!=null&&original.next!=null)
    {
        if (original.random != null) {
            original.next.random = original.random.next;
        }
        original = original.next.next;
    }original=head;
    Node copy = head.next;
    Node newHead = head.next;

    while(original.next!=null&&copy.next!=null)
    {
        original.next = original.next.getNext();
        copy.next = copy.next.next;
        original = original.next;
        copy = copy.next;
    }original.next=null;return newHead;

}
