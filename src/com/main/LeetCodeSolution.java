package com.main;

import java.util.*;


public class LeetCodeSolution {

    private HashMap<Character, Character> mapping;

    public LeetCodeSolution() {
        this.mapping = new HashMap<>();
        this.mapping.put(')', '(');
        this.mapping.put('}', '{');
        this.mapping.put(']', '[');
    }

    /**
     * Check Parentheses using stack
     * leetCode
     * input : {[[]{}]()()
     * @param input
     * @return
     */
    public boolean validParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        //{[[]{}]()()

        for (int i = 0; i < input.length(); i++) {
            char toChar = input.charAt(i);

            if (this.mapping.containsKey(toChar)) {
                char topElement = stack.empty() ? '#' : stack.pop();

                if (topElement != this.mapping.get(toChar)) {
                    return false;
                }
            } else {
                stack.push(toChar);
            }
        }
        return stack.isEmpty();
    }




}
