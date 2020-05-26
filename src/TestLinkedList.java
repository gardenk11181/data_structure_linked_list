public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.remove(1);
        list.printAll();
        list.remove(0);
        list.printAll();
        list.remove(0);
        list.printAll();
    }
}


class MyLinkedList<T> implements ListInterface<T>{
    private Node<T> head;
    private int numItems;

    public MyLinkedList() {
        head = new Node<T>();
        numItems=0;
    }

    public void printAll() {
        for(Node<T> curr = head.getNext(); curr!=null; curr = curr.getNext()) {
            System.out.println(curr.getKey());
        }
    }

    public boolean isEmpty(){
        return numItems==0;
    }

    public int size() {
        return numItems;
    }
    public void add(T item) {
        add(numItems,item);
    }

    public void add(int index, T item) {
        Node<T> node = head;
        for(int i=0; i<index; i++) {
            node = node.getNext();
        }
        Node<T> newNode = new Node<T>();
        newNode.setKey(item);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        numItems++;
    }

    public void remove(int index) {
        if(numItems<=index) return;
        Node<T> node = head;
        for(int i=0; i<index; i++) {
            node = node.getNext();
        }
        node.setNext(node.getNext().getNext());
        numItems--;

    }
    public T get(int index) {
        if(numItems<=index) return null;
        Node<T> node = head;
        for(int i=0; i<index; i++) {
            node = node.getNext();
        }
        return node.getNext().getKey();
    }
    public void removeAll() {
        head = new Node<T>();
        numItems =0;
    }

}

class Node<T> {
    private T key;
    private Node<T> nextNode;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

}

interface ListInterface<T> {
    public boolean isEmpty();
    public int size();
    public void add(int index, T item);
    public void remove(int index);
    public T get(int index);
    public void removeAll();
}