package main;

import java.util.ArrayList;
import java.util.Iterator;

public class LinkedList2 implements Iterable<Node<String>>
{
    public Node<String> head;
    public Node<String> tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node<String> _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node<String> find(String _value) {
        Node<String> current = this.head;
        while (current != null) {
            if (current.value.equals(_value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ArrayList<Node<String>> findAll(int _value)
    {
        ArrayList<Node<String>> nodes = new ArrayList<Node<String>>();
        Node<String> current = this.head;
        while (current != null) {
            if (current.value.equals(_value)) {
                nodes.add(current);
            }
            current = current.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.head != null) {
            if (this.head.value.equals(_value)) {
                this.head = this.head.next;
                if (this.head != null) {
                    this.head.prev = null;
                }
            }
            else if (this.tail.value.equals(_value)) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            else {
                Node<String> current = this.head;
                while (current != null && !current.value.equals(_value)) {
                    current = current.next;
                }
                if (current != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                else {
                    if (this.head == null) {
                        this.tail = null;
                    }
                    return false;
                }
            }
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public void removeAll(int _value)
    {
        if (this.head != null) {
            Node<String> current = this.head;
            while (current != null) {
                if (this.head == null) {
                    this.tail = null;
                    break;
                }
                if (current.value.equals(_value)) {
                    if (current == this.head) {
                        this.head = this.head.next;
                        if (this.head != null) {
                            this.head.prev = null;
                        }
                    }
                    else if (current == this.tail) {
                        this.tail = this.tail.prev;
                        this.tail.next = null;
                    }
                    else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                current = current.next;
            }
        }
    }

    public void clear()
    {
        if (this.head != null) {
            while (this.head != this.tail) {
                this.head = this.head.next;
            }
            this.head = null;
            this.tail = null;
        }
    }

    public int count()
    {
        Node<String> current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    public void insertAfter(Node<String> _nodeAfter, Node<String> _nodeToInsert)
    {
        if (_nodeAfter == this.head) {
            if (this.head == null || this.head == this.tail) {
                this.addInTail(_nodeToInsert);
            }
            else {
                this.head.next.prev = _nodeToInsert;
                _nodeToInsert.next = this.head.next;
                this.head.next = _nodeToInsert;
                _nodeToInsert.prev = this.head;
            }
        }
        else if (_nodeAfter == this.tail) {
            addInTail(_nodeToInsert);
        }
        else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            if (this.head != null) {
                this.head.prev = _nodeToInsert;
            }
            this.head = _nodeToInsert;
        }
        else {
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
        }
    }

    public boolean check() {
        Node<String> current = this.head;
        Node<String> rcurrent = this.tail;
        int forward = 0, backward = 0;
        while (current != null) {
            current = current.next;
            forward++;
        }

        while (rcurrent != null) {
            rcurrent = rcurrent.prev;
            backward++;
        }

        return forward == backward;
    }

    public void display() {
        Node<String> current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public void displayHeadAndTail() {
        System.out.println("Head: " + this.head + " Tail: " + this.tail);
    }

    private class NodeIterator implements Iterator<Node<String>> {
        Node<String> current = head;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Node<String> next() {
            if (hasNext()) {
                Node<String> _current = current;
                current = current.next;
                return _current;
            }
            return null;
        }
    }

    @Override
    public Iterator<Node<String>> iterator() {
        return new NodeIterator();
    }
}

class Node<T>  {
    public T value;
    public Node<T> next;
    public Node<T> prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }

    public void display() {
        if (prev == null && next == null) {
            System.out.println("prev: null" + " curr: " + this.value + " next: null");
        }
        else if (prev == null) {
            System.out.println("prev: null" + " curr: " + this.value + " next: " + next.value);
        }
        else if (next == null) {
            System.out.println("prev: " + prev.value + " curr: " + this.value + " next: null");
        }
        else {
            System.out.println("prev: " + prev.value + " curr: " + this.value + " next: " + next.value);
        }
    }
}