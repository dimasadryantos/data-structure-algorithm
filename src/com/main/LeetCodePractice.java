package com.main;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LeetCodePractice {

    public static void main(String[] args) throws IOException {
        // input = 15.94;16.00
        //out = NICKEL,PENNY

        // input = 17;16
        //out = ERROR

        //input = 35;35
        //out = ZERO

        // input = 45;50
        //output = FIVE


        List<String> resultChange = new ArrayList<>();

        String line1 = "15.94;16.00";
        String line2 = "17;16";
        String line3 = "45;50";
        String[] input = line1.split(";");
        float cash = Float.parseFloat(input[0]);
        float price = Float.parseFloat(input[1]);

        double change = price - cash;

        if (change < 0) {
            System.out.println("ERROR");
        } else if (change == 0) {
            System.out.println("ZERO");
        } else {
            System.out.println(findChange3(change));
        }

        //System.out.println(sumRecursive(6));
        //  basicRecurSive(5);
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reverseList(node);

        addReverseNumber();

        //  linkedListPalindrome(node);

        // reverseList2(node);

        isHappy(7);

        String data = "503 Service Unavailable: \\\"Error 503. Try again later.\\\"";
        String tes = data.replaceAll("[^A-Za-z0-9]", " ");
        String sp = tes.replaceAll("\\s+", " ");


        System.out.println(sp);

        System.out.println(isHappyNumber(2));


    }


    private static boolean isHappyNumber(int number) {
        Set<Integer> data = new HashSet<>();

        while (!data.contains(number)) {
            data.add(number);
            if (data.contains(1)) {
                return true;
            }
            number = findSumOfHappyNumber(number);

        }

        return false;
    }


    private static int findSumOfHappyNumber(int num) {
        int result = 0;
        while (num > 0) {
            int mods = num % 10;
            int counter = num / 10;
            result += mods * mods;
            num = counter;
        }
        return result;
    }


    public static boolean sleepIn(boolean weekday, boolean vacation) {
        if (!weekday || vacation) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean isHappy(int number) {
        Set<Integer> seen = new HashSet<>();
        while (number != 1 && !seen.contains(number)) {
            seen.add(number);
            number = getNext(number);
        }
        return number == 1;
    }

    private static int getNext(int number) {
        int totalSum = 0;
        while (number > 0) {
            int mod = number % 10;
            number = number / 10;
            totalSum += mod * mod;
        }
        return totalSum;
    }


    private static ListNode addReverseNumber() {
        String total = "807";
        ListNode front = new ListNode();
        char chars = total.charAt(total.length() - 1);
        front.value = Character.getNumericValue(chars);
        front.next = null;

        for (int i = total.length() - 2; i >= 0; i--) {
            char sum = total.charAt(i);
            int num = Character.getNumericValue(sum);

            ListNode temp = new ListNode();
            temp.value = num;
            temp.next = front;
            front = temp;
        }

        return front;
    }


    private static int countNode(ListNode head) {
        System.out.println("current value " + head.next);
        int counter = 0;
        ListNode current = head;

        while (current != null) {
            current = current.next;
            counter++;
        }
        return counter;
    }

    public static class ListNode {
        int value;
        ListNode next;

        ListNode() {
        }

        ListNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    /**
     * ex implementation =
     * input : 1,2,3,4,5
     * temp = 1,null
     * head = 2
     * head.next = temp = 1,null
     * temp = head = 2,1,null
     * nextNode = 3,4,5
     * head = 3
     */
    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }

        return prev;

    }


    public static boolean linkedListPalindrome(ListNode head) {
        StringBuilder builder = new StringBuilder();

        while (head != null) {
            builder.append(head.value);
            head = head.next;
        }

        int length = builder.toString().length();
        int last = length - 1;
        int index = 0;

        while (index <= last) {
            char firstChar = builder.charAt(index);
            char lastChar = builder.charAt(last);
            if (firstChar != lastChar) {
                return false;
            }
            index++;
            last--;
        }
        return true;
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversed = new ListNode();
        reversed.value = head.value;
        reversed.next = null;
        head = head.next;

        while (head != null) {
            ListNode current = new ListNode();
            current.value = head.value;
            current.next = reversed;
            reversed = current;
            head = head.next;
        }
        return reversed;
    }

    public static int sumRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = sumRecursive(n - 1);
        System.out.println(sum);
        return sum + 2;
    }


    private static void basicRecurSive(int index) {
        if (index == 0) {
            System.out.println("Done!");
        } else {
            basicRecurSive(index - 1);
            System.out.println(index);
        }
    }


    /**
     * int[] input2 = {0, 1, 0, 3, 12};
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        //1,3,12,0,0
        //1,3,12,3,12
        //zero = 2
        //index = 1,

        int countZero = 0;
        int index = 0;
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != 0) {
                nums[index] = nums[k];
                index++;
            } else {
                countZero++;
            }
        }

        int lastIndex = nums.length - 1;
        for (int h = 0; h < countZero; h++) {
            nums[lastIndex--] = 0;
        }
    }


    /**
     * nums = [1,2,3,1]
     * nums = [1,2,3,4]
     * nums = [1,1,1,3,3,4,3,2,4,2]
     * nums = [1,5,-2,-4,0]
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        //1, 2, 3, 1
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        boolean[] visited = new boolean[max - min + 1];
        for (int i : nums) {
            if (visited[i - min]) {
                return true;
            } else {
                visited[i - min] = true;
            }
        }
        System.gc();
        return false;
    }

    private static void arrayCopyExample() {
        int[] arr = {1, 2, 3, 0, 0, 0};
        int[] arr2 = {4, 5, 6};

        System.arraycopy(arr2, 0, arr, 3, 3);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void getSetValue() {
        Set<Integer> set = new HashSet<>();
        set.add(9);
        System.out.println("INSIDE SET " + set.iterator().next());
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }


    private static void joiningStringComma() {
        List<String> data = Arrays.asList("dimas a", "annisa");
        String separated = String.join(",", data);
        System.out.println(separated);
    }


    public static char findTheDifference(String s, String t) {
        if (s.equals("")) {
            return t.charAt(0);
        }
        int[] data = new int[26];
        int[] data2 = new int[26];

        for (char value : s.toCharArray()) {
            data[value - 'a']++;
        }

        for (char value : t.toCharArray()) {
            data2[value - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int check = Math.abs(data[i] - data2[i]);
            if (check == 1) {
                return (char) (i + 'a');
            }
        }
        return '-';
    }

    /**
     * twoString("hello", "world")
     *
     * @param input1
     * @param input2
     * @return
     */
    private static String twoString(String input1, String input2) {
        Set<Character> data = new HashSet<>();
        Set<Character> query = new HashSet<>();

        for (char value : input1.toCharArray()) {
            data.add(value);
        }

        for (char value : input2.toCharArray()) {
            query.add(value);
        }

        data.retainAll(query);

        if (!data.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }


    /**
     * Arrays.asList("ive", "got", "a", "lovely", "bunch", "of", "coconuts")
     * Arrays.asList("ive", "got", "some", "coconuts")
     *
     * @param magazine
     * @param note
     */
    public static void checkMagazine(List<String> magazine, List<String> note) {
        Map<String, Integer> data = new HashMap<>();
        for (String value : magazine) {
            data.put(value, data.get(value) == null ? 1 : data.get(value) + 1);
        }

        for (String value : note) {
            if (!data.containsKey(value)) {
                System.out.println("No");
                return;
            }
            if (data.get(value) < 1) {
                System.out.println("No");
                return;
            } else {
                data.put(value, data.get(value) - 1);
            }
        }
        System.out.println("Yes");
    }

    /**
     * int[] input = {1,2,3};
     * countSwaps(input);
     *
     * @param input
     */
    public static void countSwaps(int[] input) {

        //2,1,3
        int counter = 0;
        for (int i = 0; i < input.length; i++) {

            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    counter++;
                }
            }
        }

        System.out.println("Array is sorted in " + counter + " swaps.");
        System.out.println("First Element: " + input[0]);
        System.out.println("Last Element: " + input[input.length - 1]);
    }


    /**
     * Hackerank
     * makeAnagram("cde", "abc");
     *
     * @param a
     * @param b
     * @return
     */
    public static int makeAnagram(String a, String b) {
        int[] temp = new int[26];

        for (char value : a.toCharArray()) {
            temp[value - 'a']++;
        }

        for (char value : b.toCharArray()) {
            temp[value - 'a']--;
        }

        int counter = 0;
        for (int i = 0; i < 26; i++) {
            counter += Math.abs(temp[i]);
        }
        return counter;
    }


    /**
     * int[] input = {1, 2, 3, 1, 2, 3};
     * int k = 2;
     *
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) {
                return true;
            }
            sets.add(nums[i]);
            if (i - k >= 0) {
                sets.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean isAnagram3(String input1, String input2) {

        if (input1.length() != input2.length()) {
            return false;

        }
        int[] miyabi = new int[26];

        for (int i = 0; i < input1.length(); i++) {
            char chars = input1.charAt(i);
            miyabi[chars - 'a']++;
        }

        for (int i = 0; i < input2.length(); i++) {
            char chars = input2.charAt(i);
            miyabi[chars - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (miyabi[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            sb.insert(0, (char) (--columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.toString();
    }


    private static String findChange3(double change) {
        List<String> resultChange = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("########.##");
        int intChange = (int) (Double.parseDouble(df.format(change)) * 100);

        for (Denomination d : Denomination.values()) {
            if (intChange >= d.getValue()) {
                intChange -= d.getValue();
                resultChange.add(String.valueOf(d));
            }
        }


        return String.join(",", resultChange);
    }

    public enum Denomination {
        ONE_HUNDRED(10000),
        FIFTY(5000),
        TWENTY(2000),
        TEN(1000),
        FIVE(500),
        TWO(200),
        ONE(100),
        HALF_DOLLAR(50),
        QUARTER(25),
        DIME(10),
        NICKEL(5),
        PENNY(1);

        private final int value;
        private final String description;

        Denomination(int value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }

        public int getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }

    private static String findChange2(double change) {

        StringBuilder textChange = new StringBuilder();

        DecimalFormat df = new DecimalFormat("########.##");
        int intChange = (int) (Double.parseDouble(df.format(change)) * 100);

        while (intChange >= 0.01) {
            if (intChange >= 10000) {
                textChange.append("ONE HUNDRED,");
                intChange -= 10000;
            } else if (intChange >= 5000) {
                textChange.append("FIFTY,");
                intChange -= 5000;
            } else if (intChange >= 2000) {
                textChange.append("TWENTY,");
                intChange -= 2000;
            } else if (intChange >= 1000) {
                textChange.append("TEN,");
                intChange -= 1000;
            } else if (intChange >= 500) {
                textChange.append("FIVE,");
                intChange -= 500;
            } else if (intChange >= 200) {
                textChange.append("TWO,");
                intChange -= 200;
            } else if (intChange >= 100) {
                textChange.append("ONE,");
                intChange -= 100;
            } else if (intChange >= 50) {
                textChange.append("HALF DOLLAR,");
                intChange -= 50;
            } else if (intChange >= 25) {
                textChange.append("QUARTER,");
                intChange -= 25;
            } else if (intChange >= 10) {
                textChange.append("DIME,");
                intChange -= 10;
            } else if (intChange >= 5) {
                textChange.append("NICKEL,");
                intChange -= 5;
            } else if (intChange >= 1) {
                textChange.append("PENNY,");
                intChange -= 1;
            }
        }
        return textChange.substring(0, textChange.length() - 1);
    }


    /**
     * String input1 = "11010,00101001";
     * String input2 = "110011,1010";
     * String input3 = "0";
     *
     * @param input
     * @return
     */
    private static String sumBinary2(String input) {
        if (input.length() == 1 || input.charAt(0) == '0') {
            return "0";
        }
        String[] binary = input.split(",");
        String input1 = binary[0];
        String input2 = binary[1];

        StringBuilder result = new StringBuilder();

        int digit = 0;
        int i = input1.length() - 1;
        int j = input2.length() - 1;

        while (i >= 0 || j >= 0 || digit == 1) {
            digit += ((i >= 0) ? input1.charAt(i) - '0' : 0);
            digit += ((j >= 0) ? input2.charAt(j) - '0' : 0);
            result.insert(0, (char) (digit % 2 + '0'));
            digit /= 2;
            i--;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        if (result.charAt(0) == '0') {
            for (int k = 1; k < result.length(); k++) {
                char chars = result.charAt(k);
                builder.append(chars);
            }
            return builder.toString();
        }
        return result.toString();
    }


    /**
     * ()[]{}
     * (]
     *
     * @param input
     * @return
     */
    private static boolean validParentheses(String input) {
        Map<Character, Character> mapper = new HashMap<>();
        mapper.put(')', '(');
        mapper.put(']', '[');
        mapper.put('}', '{');

        //()()
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (mapper.containsKey(current)) {
                char topElement = stack.pop();
                if (topElement != mapper.get(current)) {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }

        return stack.isEmpty();
    }

    /**
     * Agoda Interview Question
     * String input = "abc0123456789";
     * int row = 2;
     * //row : a c 1 3 5 7 9
     * //row : b 0 2 4 6 8
     *
     * @param input
     * @param row
     * @return
     */
    private static String convertString(String input, int row) {
        List<Character> data = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            //abc0123456789
            //row =  a 0 3 6 9
            // row = b 1 4 7
            //row = c 2 5 8

            //row : a c 1 3 5 7 9
            //row :b 0 2 4 6 8
            data.add(input.charAt(i));
            int index = 1;
            for (int j = i + 1; j < input.length(); j++) {
                if (index == row) {
                    index = 1;
                    data.add(input.charAt(j));
                } else {
                    index++;
                }
            }
        }
        return data.toString();
    }


    /**
     * int[] input = {2, 3, -1, 8, 4};
     *
     * @param nums
     * @return
     */
    public static int findMiddleIndex(int[] nums) {
        int left = 0, right = 0;

        for (int num : nums)
            right += num;

        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) return i;
            left += nums[i];
        }
        return -1;
    }


    /**
     * input : abacabaabacaba
     *
     * @param s
     * @return
     */
    public static char firstNonRepeatingChar(String s) {
        Map<Character, Integer> data = new HashMap<>();
        //abacabad
        for (int i = 0; i < s.length(); i++) {
            char currentKey = s.charAt(i);
            if (!data.containsKey(currentKey)) {
                data.put(currentKey, i);
            } else {
                data.put(currentKey, Integer.MAX_VALUE);
            }
        }

        char result = '-';
        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> current : data.entrySet()) {
            if (current.getValue() < min) {
                min = current.getValue();
                result = current.getKey();
            }
        }
        return result;
    }


    public static List<List<String>> groupAnagrams(List<String> input) {
        // strs = ["eat","tea","tan","ate","nat","bat"]
        //  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Map<String, List<String>> dataMap = new HashMap<>();

        for (String value : input) {
            char[] current = value.toCharArray();
            Arrays.sort(current);
            //['a','e','t']
            String key = String.valueOf(current);
            //aet

            if (!dataMap.containsKey(key)) {
                dataMap.put(key, new ArrayList<>());
            }
            dataMap.get(key).add(value);
        }

        return new ArrayList<>(dataMap.values());

    }


    /**
     * //Input: pattern = "abba", s = "dog cat cat dog" ,true
     * <p>
     * //pattern = "abba", s = "dog cat cat fish" , false
     *
     * @param pattern
     * @param s
     * @return
     */
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        Map<Character, String> data = new HashMap<>();

        if (words.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            String value = words[i];

            if (!data.containsKey(key)) {
                if (data.containsValue(value)) {
                    return false;
                }
                data.put(key, value);
            } else if (!data.get(key).equals(value)) {
                return false;
            }
        }

        return true;

    }

    public static List<List<String>> validAnagram(String[] input) {

        // strs = ["eat","tea","tan","ate","nat","bat"]
        //  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

        Map<String, List<String>> dataMap = new HashMap<>();
        for (String value : input) {
            char[] current = value.toCharArray();
            Arrays.sort(current);
            String key = String.valueOf(current);
            if (!dataMap.containsKey(key)) {
                dataMap.put(key, new ArrayList<>());
            }
            dataMap.get(key).add(value);
        }
        return new ArrayList<>(dataMap.values());
    }

    /**
     * String input = "abca";
     * String input2 = "aba";
     * String input3 = "abc";
     * String input4 = "deeee";
     *
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {
        //abca
        //deeee
        int length = s.length() - 1;
        int start = 0;
        while (start < length) {
            if (s.charAt(start) == s.charAt(length)) {
                length--;
                start++;
            } else {
                return isPalindrome(s, start + 1, length) || isPalindrome(s, start, length - 1);
            }
        }
        return true;
    }


    public static boolean isPalindrome(String inputStr, int i, int j) {
        while (i < j) {
            if (inputStr.charAt(i++) != inputStr.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    /**
     * //s = "abc", t = "ahbgdc";
     * //true
     *
     * @param
     * @param
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        if (s.equals("")) {
            return true;
        }
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index)) {
                index++;
            }
            if (index == s.length()) {
                return true;
            }
        }
        return false;
    }


    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }


    /**
     * char[][] input = {
     * {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
     * {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
     * {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
     * {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
     * {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
     * {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
     * {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
     * {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
     * {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
     * };
     *
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentVal = board[i][j];
                if (currentVal != '.') {
                    if (!seen.add(currentVal + " found in row " + i) ||
                            !seen.add(currentVal + " found in column " + j) ||
                            !seen.add(currentVal + " found in sub box " + i / 3 + "." + j / 3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * int[] input = {2, 7, 11, 15};
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {
                    result = new int[]{i, j};
                }
            }
        }
        return result;
    }


    /**
     * int[] input = {0, 0, 1, 3, 2};
     * int[] input2 = {0};
     * int[] input3 = {0, 1};
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        int countZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            } else {
                countZero++;
            }
        }

        int indexLast = nums.length - 1;
        for (int i = 0; i < countZero; i++) {
            nums[indexLast--] = 0;
        }
    }

    /**
     * int[] input = {1, 2, 3};
     * int[] input2 = {4, 3, 2, 1};
     * int[] input3 = {0};
     * int[] input4 = {9};
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i]++ < 9) {
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNum = new int[digits.length + 1];
        newNum[0] = 1;

        return newNum;
    }


    public static int[] plusOne(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (i == digits.length - 1) {
                digits[i] = digits[i] + 1;
            }
        }
        return digits;
    }


    /**
     * int[] input = {2, 3, -2, 4};
     * int[] input2 = {-2, 0, -1};
     *
     * @param input
     * @return
     */
    public static int maxProduct(int[] input) {
        long result = Integer.MIN_VALUE;
        long findMax = Integer.MIN_VALUE;
        long findMin = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 0) {
                findMax = Math.max(input[i], findMax * input[i]);
                findMin = Math.min(input[i], findMin * input[i]);
            } else {
                long temp = findMax;
                findMax = Math.max(input[i], findMin * input[i]);
                findMin = Math.min(input[i], temp * input[i]);
            }
            result = Math.max(result, findMax);
        }
        return (int) result;
    }


    /**
     * Maximum Subarray contigious
     * Thrid loop
     * int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
     * int[] input2 = {-2, -1};
     *
     * @param nums
     * @return
     */
    public static int maxContiguousSubarraySum3(int[] nums) {
        int maximumSubArraySum = Integer.MIN_VALUE;

        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                // Let's investigate this window
                int windowSum = 0;

                // Add all items in the window
                for (int k = left; k <= right; k++) {
                    windowSum += nums[k];
                }
                // Did we beat the best sum seen so far?
                maximumSubArraySum = Math.max(maximumSubArraySum, windowSum);
            }
        }

        return maximumSubArraySum;
    }

    /**
     * Maximum Subarray contigious
     * Second loop
     *
     * @param nums
     * @return
     */
    public static int maxContiguousSubarraySum2(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int counter = 0;

            for (int j = i; j < nums.length; j++) {

                //loop and adding dari hasil penjumlahan
                counter += nums[j];

                max = Math.max(max, counter);
            }
        }

        return max;
    }


    /**
     * Maximum Subarray contigious
     * nums = [-2,1,-3,4,-1,2,1,-5,4]
     * //track value sebelum nya untuk menambahkan dan cari yg paling besar,
     * dengan current atau jumlah dengan value sebelum,,
     * karna bilangan negative di depan tidak ber pengaruh besar
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int[] table = new int[nums.length];
        table[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            table[i] = Math.max(nums[i], nums[i] + table[i - 1]);
            max = Math.max(max, table[i]);
        }
        return max;
    }

    /**
     * @param input
     * @return
     */
    public static int[] productExceptSelf2(int[] input) {
        int length = input.length;

        int[] resultArray = new int[length];

        resultArray[0] = 1;

        for (int i = 1; i < length; i++) {
            resultArray[i] = input[i - 1] * resultArray[i - 1];
        }

        int counter = 1;
        for (int j = length - 1; j >= 0; j--) {
            resultArray[j] = resultArray[j] * counter;
            counter = counter * input[j];
        }

        return resultArray;
    }

    /**
     * int[] input = {1, 2, 3, 4};
     * out : [24,12,8,6]
     *
     * @param input
     * @return
     */
    public static int[] productExceptSelf(int[] input) {
        int length = input.length;
        int[] leftArray = new int[length];
        int[] rightArray = new int[length];
        int[] resultArray = new int[length];

        leftArray[0] = 1;
        rightArray[length - 1] = 1;

        //1,2,3,4

        for (int i = 1; i < length; i++) {
            leftArray[i] = input[i - 1] * leftArray[i - 1];
        }//1,1,2,6

        for (int j = length - 2; j >= 0; j--) {
            rightArray[j] = input[j + 1] * rightArray[j + 1];
        }//24,12,4,1

        for (int k = 0; k < length; k++) {
            resultArray[k] = leftArray[k] * rightArray[k];
        }
        return resultArray;
    }


    /**
     * int[] input1 = {1, 2, 2, 1};
     * int[] input2 = {2, 2};
     * <p>
     * int[] input3 = {9, 4, 9, 8, 4};
     * int[] input4 = {4, 9, 5};
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> data = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        if (nums1.length > nums2.length) {
            for (int key : nums1) {
                data.put(key, data.getOrDefault(key, 0) + 1);
            }
            for (int j : nums2) {
                if (data.containsKey(j) && data.get(j) != 0) {
                    result.add(j);
                    data.put(j, data.get(j) - 1);
                }
            }
        } else {
            for (int key : nums2) {
                data.put(key, data.getOrDefault(key, 0) + 1);
            }
            for (int j : nums1) {
                if (data.containsKey(j) && data.get(j) != 0) {
                    result.add(j);
                    data.put(j, data.get(j) - 1);
                }
            }
        }

        int[] dataArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            dataArr[i] = result.get(i);
        }

        return dataArr;
    }

    /**
     * String input1 = "leetcode";
     *
     * @param input
     * @return
     */
    private static int firstUniqueChar(String input) {

        int[] checker = new int[26];

        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            checker[chars - 'a']++;
        }

        for (int j = 0; j < input.length(); j++) {
            char chars = input.charAt(j);
            if (checker[chars - 'a'] == 1) {
                return j;
            }
        }
        return -1;
    }


    /**
     * int input1 = 123;
     *
     * @param input
     * @return
     */
    public static int reverse(int input) {
        int reverse = 0;
        int pop;

        while (input != 0) {
            //get last number 123 = 3
            pop = input % 10;
            //get front number 123 = 12
            input /= 10;


            if (reverse > Integer.MAX_VALUE / 10) {
                return 0;
            }

            if (reverse < Integer.MIN_VALUE / 10) {
                return 0;
            }

            //0 * 10 = 0 + 3 = 3
            //3 * 10 = 30 + 2 = 32
            //32 * 10 = 320 + 1 = 321
            reverse = (reverse * 10) + pop;
        }
        return reverse;
    }


    /**
     * String input1 = "A man, a plan, a canal: Panama"; (true)
     * s = "race a car" (false)
     * <p>
     * Stack = LIFO
     * Queue = FIFO
     *
     * @param input
     * @return
     */
    private static boolean isPalindrome(String input) {
        if (input.equals("")) {
            return true;
        }
        Stack<Character> dataStack = new Stack<>();
        Queue<Character> dataQueue = new LinkedList<>();

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                dataStack.push(chars);
                dataQueue.add(chars);
            }
        }

        while (dataStack.size() > 0) {
            if (dataStack.pop() != dataQueue.remove()) {
                return false;
            }
        }
        return true;
    }


    /**
     * String input1 = "ana";
     * String input2 = "ana";
     * Best solution Anagram
     *
     * @param input1
     * @param input2
     * @return
     */
    private static boolean isAnagram(String input1, String input2) {
        if (input1.length() != input2.length()) {
            return false;
        }

        int[] arr = new int[26];

        for (char chars : input1.toCharArray()) {
            arr[chars - 'a']++;
        }
        for (char chars : input2.toCharArray()) {
            arr[chars - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }


    private static int singleNumber(int[] nums) {
        Set<Integer> data = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!data.contains(nums[i])) {
                data.add(nums[i]);
            } else {
                data.remove(nums[i]);
            }
        }
        return (int) data.toArray()[0];
    }

    /**
     * int[] input1 = {1, 2, 3, 4, 5, 6, 7};
     * K = 3 ;
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * Container with most water
     * <p>
     * Height = [1,8,6,2,5,4,8,3,7]
     * Area = Height * Width
     * Brute Force Solution O(n2)
     *
     * @return
     */
    public static int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {
                int width = j - i;
                int minHeight = Math.min(height[i], height[j]);
                int area = width * minHeight;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }


    /**
     * Container with most water
     * Height = [1,8,6,2,5,4,8,3,7]
     * Best solution
     * Two pointer
     *
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int indexJ = height.length - 1;
        int indexI = 0;
        int maxArea = Integer.MIN_VALUE;

        while (indexI < indexJ) {
            if (height[indexI] < height[indexJ]) {
                int minHeight = height[indexI];
                int width = indexJ - indexI;
                int area = width * minHeight;
                maxArea = Math.max(area, maxArea);
                indexI++;
            } else {
                int minHeight = height[indexJ];
                int width = indexJ - indexI;
                int area = width * minHeight;
                maxArea = Math.max(area, maxArea);
                indexJ--;
            }
        }
        return maxArea;
    }


    /**
     * Remove duplicates from sorted array
     * int[] input1 = {1, 1, 2};
     * int[] input = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] != nums[i + 1]) {
                nums[count] = nums[i + 1];
                count++;
            }
        }

        return count;
    }


    /**
     * prices = [7,1,5,3,6,4]
     * brute force solution
     *
     * @param prices
     * @return
     */
    public static int maxProfitBf(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] < prices[j]) {
                    int count = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, count);
                }
            }
        }
        return maxProfit;
    }

    /**
     * prices = [7,1,5,3,6,4]
     *
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length < 2) {
            return maxProfit;
        }

        int minimum = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minimum) {
                int substract = prices[i] - minimum;
                maxProfit = Math.max(maxProfit, substract);
            } else {
                minimum = prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * @param prices
     * @return
     */
    public static int maxProfitMedium(int[] prices) {
        //7, 1, 5, 3, 6, 4

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                int count = prices[i] - prices[i - 1];
                maxProfit += count;
            }
        }
        return maxProfit;
    }


    /**
     * My Approach Rotate Array
     * int[] input1 = {1, 2, 3, 4, 5, 6, 7};
     * K = 3
     *
     * @param nums
     * @param k
     */
    private static void rotateArray(int[] nums, int k) {

        int[] temp = new int[k];
        int last = nums.length - 1;
        int index = 0;
        for (int i = 0; i < k; i++) {
            temp[index++] = nums[last--];
        }

        Map<Integer, Integer> data = new HashMap<>();
        int indexArr = 0;
        for (int i = temp.length - 1; i >= 0; i--) {
            data.put(indexArr++, temp[i]);
        }

        for (int value : nums) {
            if (!data.containsValue(value)) {
                data.put(indexArr++, value);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int value = data.get(i);
            nums[i] = value;
        }

    }


    /**
     * Rotate array from the last
     *
     * @param inputArr
     * @param rotate
     * @return
     */
    public static int[] rotateRight(int[] inputArr, int rotate) {
        for (int i = 0; i < rotate; i++) {
            int last = inputArr[inputArr.length - 1];
            int j;
            for (j = inputArr.length - 1; j > 0; j--) {
                inputArr[j] = inputArr[j - 1];
            }
            inputArr[j] = last;
        }
        return inputArr;
    }


}
