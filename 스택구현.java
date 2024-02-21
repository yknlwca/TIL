package swea;

public class 스택구현 {
    static int[] stack = new int[5];
    static int top = -1;

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
        pop();
    }

    // isEmpty
    public static boolean isEmpty() {
        return top == -1;
    }

    // isFull
    public static boolean isFull() {
        return top == stack.length - 1;
    }

    // 삽입 : push
    public static void push(int data) {
        if (isFull()) {
            System.out.println("더 이상 추가 불가");
            return;
        }
        stack[++top] = data;
    }

    // 삭제 : pop
    public static int pop() {
        if (isEmpty()) {
            System.out.println("데이터 없음");
            return -1;
        }
        return stack[top--];
    }
}
