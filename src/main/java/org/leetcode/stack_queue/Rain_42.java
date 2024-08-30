package org.leetcode.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class Rain_42 {
    public static void main(String[] args) {
        Rain_42 rain42 = new Rain_42();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trap = rain42.trap(height);
        System.out.println(trap);
    }

    public int trap1(int[] height) {
        if (height.length <= 2) return 0;
        Deque<Integer> st = new LinkedList<>();
        st.push(0);
        int n = height.length;
        int cap = 0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int curIndex = st.pop();
                if (st.isEmpty()) continue;
                int h = Math.min(height[i], height[st.peek()]) - height[curIndex];
                int w = i - st.peek() - 1;
                cap += h * w;
            }
            st.push(i);
        }
        return cap;
    }

    // 单调栈
//    public int trap(int[] height) {
//        Deque<Integer> stack = new LinkedList<>();
//        int length = height.length;
//        int cap = 0;
//        for (int i = 0; i < length; i++) {
//            while (stack.size() > 1 && height[i] > height[stack.peek()]) {
//                int bottomIdx = stack.pop();
//                int w = i - stack.peek() - 1;
//                int l = Math.min(height[i], height[stack.peek()]) - height[bottomIdx];
//                if (l < 0) {
//                    stack.pop();
//                    break;
//                }
//                cap += (l * w);
////                if (stack.isEmpty()) {
////                    stack.push(bottomIdx);
////                    break;
////                } else {
////
////                }
//            }
//            stack.push(i);
//        }
//        return cap;
//    }

    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int length = height.length;
        int cap = 0;
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIdx = stack.pop();
                if (!stack.isEmpty()) {
                    int w = i - stack.peek() - 1;
                    int l = Math.min(height[i], height[stack.peek()]) - height[bottomIdx];
//                    if (l < 0) {
//                        stack.pop();
//                        break;
//                    }
                    cap += (l * w);
                }
//                if (stack.isEmpty()) {
//                    stack.push(bottomIdx);
//                    break;
//                } else {
//
//                }
            }
            stack.push(i);
        }
        return cap;
    }
}
