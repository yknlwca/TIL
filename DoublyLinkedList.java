

class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
    }

    Node() {

    }
}

class DoubleLinkedList {
    Node head;
    Node tail;
    int size;

    DoubleLinkedList() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    // 삽입
    void addLast(String data) {
        Node newNode = new Node(data);

        // newNode 먼저 연결
        newNode.next = tail;
        newNode.prev = tail.prev;

        // 헤더와 테일 연결
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    // 삭제
    void remove(int idx) {
        if (!(0 <= idx && idx < size)) {
            System.out.println("범위 벗어남");
            return;
        }

        Node curr = head.next;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        // 여기 오면 curr 는 삭제할 노드를 가리킴

        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;

        size--;
    }

    void printList() {
        Node curr = head.next;
        while (curr != tail) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class DoublyLinkedList {

    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.printList();
    }

}
