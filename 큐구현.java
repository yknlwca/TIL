package swea;

public class 큐구현 {

    static int[] queue = new int[10];
    static int front = -1;
    static int rear = -1;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            add(1);
        }
        for (int i = 0; i < 11; i++) {
            poll();
        }
    }

    public static boolean isFull() {
        return rear == queue.length - 1;
    }

    public static boolean isEmpty() {
        return front == rear;
    }

    // 삽입
    public static void add(int data) {
        if (isFull()) {
            System.out.println("큐 꽉");
            return;
        }
        queue[++rear] = data;
    }

    public static int poll() {

//        int item = queue[++front];
//
//        return item;
        if (isEmpty()) {
            System.out.println("큐 빔");
            return -1;
        }
        return queue[++front];
    }
}
