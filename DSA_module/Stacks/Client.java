package com.collection.DSA_module.Stacks;

public class Client {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(6);
        stack.push(7);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.size+"  length of stack");
        System.out.println(stack.top()+"  top of stack");
        System.out.println(stack.getMin()+"  min of stack");
        System.out.println(stack.pop()+" removed from stack");
        System.out.println(stack.getMin()+"  min of stack");
    }
}
