
import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        //if the minStack is empty directly push it 
        //or if the current val is smaller than/ equal (bcs duplicate may exist after popping) top of minstack , push it 
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }

    }

    public void pop() {
        if (!stack.isEmpty()) {
            int popped = stack.pop();
            if (popped == minStack.peek()) {
                minStack.pop();
            }
        }

    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();

    }

    public void display() {
        for (int x : stack) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(10);
        stack.push(30);
        stack.push(50);
        stack.push(60);
        stack.push(20);
        stack.push(40);
        System.out.println("Stack elements are : ");
        stack.display();
        System.out.println("Pop one element");
        stack.pop();
        stack.display();
        System.out.println("Top of stack is " + stack.top());
        System.out.println("Min element is :" + stack.getMin());

    }
}
