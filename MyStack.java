
import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    Deque<Integer> stack;

    public MyStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public int pop() {
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public void display() {
        for (int x : stack) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        System.out.println("Is the stack empty?" + stack.empty());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("The stack elements are");
        stack.display();
        System.out.println("Top is " + stack.top());
        stack.pop();
        System.out.println("After popping one ");
        stack.display();
        System.out.println("Is the stack empty?" + stack.empty());

    }
}
