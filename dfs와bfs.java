package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 타입 지정할 수 있는 큐 구현
class Queue<T> {

    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> first;
    private Node<T> last;
    
    // enqueue
    public void add(T item) {
        Node<T> t = new Node<T>(item);

        if (last != null) {
            last.next = t;
        }
        last = t;
        if (first == null) {
            first = last;
        }
    }

    // dequeue
    public T remove() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        T data = first.data;
        first = first.next;

        if (first == null) {
            last = null;
        }
        return data;
    }

    // peek
    public T peek() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }
}

// 그래프 순회 구현
class Graph{
    // 정렬을 위한 인터페이스 사용
    class Node implements Comparable<Node>{
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<Node>();
        }

        @Override
        public int compareTo(Node o) {
            return this.data - o.data;
        }
    }


    Node[] nodes;

    // 그래프 만들기
    Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    // 간선 연결 메소드
    void addEdge(int i1, int i2) {
        // 노드 번호에서 1을 빼서 배열 인덱스 맞춰주기
        Node n1 = nodes[i1 - 1];
        Node n2 = nodes[i2 - 1];
        if (!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if (!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }

    }

    // 모든 노드의 marked를 순회 전 false로 초기화하는 메소드
    public void unmarkAll() {
        for(Node node : nodes) {
            node.marked = false;
        }
    }

    // 스택을 활용한 dfs 순회
    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;
        while (!stack.isEmpty()) {
            Node r = stack.pop();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    stack.push(n);
                }
            }
            visit(r);
        }
    }

    // bfs 순회
    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new Queue<Node>();
        queue.add(root);
        root.marked = true;
        while (!queue.isEmpty()) {
            Node r = queue.remove();
            for (Node n : r.adjacent) {
                if (!n.marked) {
                    n.marked = true;
                    queue.add(n);
                }
            }
            visit(r);
        }
    }

    // 재귀를 활용한 dfs 순회
    void dfsRec(Node r) {
        if (r == null) {
            return;
        }
        r.marked = true;
        visit(r);
        for (Node n : r.adjacent) {
            if (!n.marked) {
                dfsRec(n);
            }
        }
    }

    void dfsRec(int index) {
        Node r = nodes[index];
        dfsRec(r);
    }

    void dfsRec() {
        dfsRec(0);
    }

    // 방문한 노드 출력 함수
    void visit(Node node) {
        // 정점 번호는 1부터 시작
        System.out.print((node.data + 1) + " ");
    }
}

public class dfs와bfs {
    static BufferedReader bf;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 그래프 생성
        Graph g = new Graph(N);
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()) - 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.addEdge(a, b);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(g.nodes[i].adjacent); // Node 클래스의 compareTo 메소드에 의해 정렬됨
        }


        // DFS 실행 전 모든 노드의 marked를 false로 초기화
        g.unmarkAll();
        g.dfsRec(V);
        System.out.println();

        // BFS 실행 전 모든 노드의 marked를 false로 초기화
        g.unmarkAll();
        g.bfs(V);
    }
}
