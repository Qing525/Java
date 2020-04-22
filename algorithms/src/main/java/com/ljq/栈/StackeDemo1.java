package com.ljq.栈;

import java.util.Stack;

/**
 * @author : lijq
 * @date : 2020/4/6 15:57
 */
public class StackeDemo1 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        newStack(stack);
    }

    private static void newStack(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.empty()) {
            newStack.add(stack.pop());
        }
        while (!newStack.empty()) {
            System.out.println(newStack.pop());
        }

    }
}
