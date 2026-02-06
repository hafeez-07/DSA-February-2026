
import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {

    Deque<Integer> queue;

    public MyQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }

    public int peek() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void display() {
        for (int x : queue) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(10);
        queue.push(20);
        queue.push(30);
        queue.display();
        queue.pop();
        queue.display();

    }
}
