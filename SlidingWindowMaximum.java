
import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    //time exceeds for larger inputs
    // public static int[] maxSlidingWindow(int[] nums, int k) {
    //     Deque<Integer> deque = new ArrayDeque<>();
    //     Deque<Integer> window = new ArrayDeque<>();
    //     int[] result = new int[nums.length - k + 1];
    //     int start = 0;
    //     int end = start + (k - 1);
    //     //initial window
    //     for (int i = start; i <= end; i++) {
    //         window.addLast(nums[i]);
    //     }
    //     //side window until the last element 
    //     while (end < nums.length) {
    //         int max = Integer.MIN_VALUE;
    //         //get max from current window
    //         for (int x : window) {
    //             max = Math.max(max, x);
    //         }
    //         //offer the max in window to queue
    //         deque.addLast(max);
    //         //slide the window
    //         end++;
    //         //if we reach end of nums
    //         if (end == nums.length) {
    //             break;
    //         }
    //         //slide window
    //         window.removeFirst();
    //         window.addLast(nums[end]);
    //     }
    //     int idx = 0;
    //     for (int x : deque) {
    //         result[idx++] = x;
    //     }
    //     return result;
    // }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            //slide window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            //remove small element indices , maintaining decreasing order
            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            //add curr index
            deque.offerLast(i);

            //record results
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 1, 3};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        for (int x : result) {
            System.out.print(x + " ");
        }
    }
}
