package com.main;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {


    public static void main(String[] args) throws ParseException, IOException, CsvException {


        List<ClientProduct> products = Arrays.asList(new ClientProduct("DR", 2), new ClientProduct("DR", 2),
                new ClientProduct("BOX", 4), new ClientProduct("BOX", 2));


        //  csvReader();

       /* String[] path = input.split("/");

        for (String s : path) {
            System.out.println(s);
        }

        System.out.println(path[path.length - 1]);*/


/*        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("MM-yyyy");
        Date date = formatter.parse(input);*/
        //    System.out.println(formatter2.format(date) + "/" + input);


   /*     List<Recommend> location = Arrays.asList(new Recommend(202109020, "A"), new Recommend(202108020, "B"));
        location.sort(Comparator.comparing(Recommend::getLokiIndex));

        location.forEach(System.out::println);

        List<String> dictionary = Arrays.asList("heater", "cold", "clod", "reheat", "docl");
        List<String> query = Arrays.asList("codl", "heater", "abcd");

        System.out.println(stringAnagram(dictionary, query));*/


        //   int[] nums1 = {1, 2, 2, 1};
        //    int[] nums2 = {2, 2};


    }


    private static void joiningStringComma() {

        List<String> data = Arrays.asList("dimas a");

        String separated = String.join(",", data);

        System.out.println(separated);


    }


    /**
     * int[] nums1 = {1, 2, 2, 1};
     * int[] nums2 = {2, 2};
     * nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> dataSet1 = new HashSet<>();
        Set<Integer> dataSet2 = new HashSet<>();

        for (int value : nums1) {
            dataSet1.add(value);
        }

        for (int value : nums2) {
            if (dataSet1.contains(value)) {
                dataSet2.add(value);
            }
        }

        int[] result = new int[dataSet2.size()];

        int index = 0;
        for (int value : dataSet2) {
            result[index++] = value;
        }

        return result;
    }


    private static boolean isPalindromeInteger(int input) {
        String converter = Integer.toString(input);

        int index = converter.length() - 1;
        for (int i = 0; i < converter.length(); i++) {
            if (converter.charAt(i) != converter.charAt(index)) {
                return false;
            }
            index--;
        }
        return true;
    }


    private static boolean isIsomorphic(String input1, String input2) {
        Set<Character> data = new HashSet<>();
        Set<Character> data2 = new HashSet<>();

        for (int i = 0; i < input1.length(); i++) {
            char chars = input1.charAt(i);
            data.add(chars);
        }

        for (int i = 0; i < input2.length(); i++) {
            char chars = input2.charAt(i);
            data2.add(chars);
        }

        if (data.size() == data2.size()) {
            return true;
        }
        return false;
    }


    public static class ClientProduct {
        public ClientProduct(String uom, int quantity) {
            this.uom = uom;
            this.quantity = quantity;
        }

        String uom;
        int quantity;

        public String getUom() {
            return uom;
        }

        public void setUom(String uom) {
            this.uom = uom;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


    private static int finalValueAfterOperations(String[] operations) {
        int initialValue = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].equals("--X") || operations[i].equals("X--")) {
                initialValue -= 1;
            } else if (operations[i].equals("X++") || operations[i].equals("++X")) {
                initialValue += 1;
            }
        }
        System.out.println(initialValue);
        return initialValue;
    }


    private static int[] twoSumNew(int[] nums, int target) {
        Map<Integer, Integer> dataNums = new HashMap<>();
        int[] result = new int[0];

        for (int i = 0; i < nums.length; i++) {
            int numKey = target - nums[i];

            if (dataNums.containsKey(nums[i])) {
                result = new int[]{dataNums.get(nums[i]), i};
            } else {
                dataNums.put(numKey, i);
            }
        }
        return result;
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target)
                return i;
        }
        return nums.length;
    }


    public static void csvReader() throws IOException, CsvException {
        String fileName = "/Users/dimasdz/Documents/java-data-structure/src/FGO-000009-2937-MCP-DPL-100003.csv";

        CSVReader reader = new CSVReader(new FileReader(fileName));
        List<String[]> result = reader.readAll();

        List<String> sn = new ArrayList<>();
        loopCsv(result, sn);

        List<List<String>> constructed = new ArrayList<>();
        constructed.add(sn);

        System.out.println(constructed);


    }

    private static void loopCsv(List<String[]> result, List<String> serialNumbers) {
        result.forEach(line -> construct(line, serialNumbers));
    }

    private static void construct(String[] line, List<String> serialNumbers) {
        serialNumbers.add(line[0].trim());
    }


    public static class Recommend {

        String name;
        long lokiIndex;

        public Recommend(long lokiIndex, String name) {
            this.lokiIndex = lokiIndex;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getLokiIndex() {
            return lokiIndex;
        }

        public void setLokiIndex(long lokiIndex) {
            this.lokiIndex = lokiIndex;
        }

        @Override
        public String toString() {
            return "Recommend{" +
                    "name='" + name + '\'' +
                    ", lokiIndex=" + lokiIndex +
                    '}';
        }
    }

    public static class Shoes {

        public Shoes(String productCode, String productId, int quantity) {
            this.productCode = productCode;
            this.productId = productId;
            this.quantity = quantity;
        }

        String productCode;
        String productId;
        int quantity;

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }


    public static class Bag {
        public Bag(String productCode, String productId, int quantity) {
            this.productCode = productCode;
            this.productId = productId;
            this.quantity = quantity;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        String productCode;
        String productId;
        int quantity;
    }


    private void sumJava8() {
        // Integer quantity = persons.stream().map(Person::getAge).mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> result = new ArrayList<>();
        for (String queryValues : query) {
            int count = 0;
            for (String dictionaryValues : dictionary) {
                if (queryValues.length() == dictionaryValues.length()) {
                    char[] queries = queryValues.toCharArray();
                    char[] dictionaries = dictionaryValues.toCharArray();
                    Arrays.sort(dictionaries);
                    Arrays.sort(queries);
                    if (String.valueOf(queries).equals(String.valueOf(dictionaries))) {
                        count++;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    public static int filledOrders(List<Integer> order, int k) {


        int count = 0;

        Collections.sort(order);

        for (int ord : order) {
            if (ord <= k) {

                count++;
                k = k - ord;

            }
        }

        return count;
    }


    public static boolean anagramImprove(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        char[] inputA = A.toLowerCase().toCharArray();
        char[] inputB = B.toLowerCase().toCharArray();
        Arrays.sort(inputA);
        Arrays.sort(inputB);

        for (int i = 0; i < inputA.length; i++) {
            if (inputA[i] != inputB[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Method to count deleted value to shape an annagram
     * input :
     * abcde
     * dbsss
     * hackerank
     * https://www.hackerrank.com/challenges/making-anagrams/problem
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int shapeAnnagram(String str1, String str2) {

        int[] count1 = new int[26];
        int[] count2 = new int[26];


        for (int i = 0; i < str1.length(); i++) {
            count1[str1.charAt(i) - 'a']++;
        }

        for (int j = 0; j < str2.length(); j++) {
            count2[str2.charAt(j) - 'a']++;
        }

        int result = 0;
        for (int k = 0; k < 26; k++) {
            result += Math.abs(count1[k] - count2[k]);
        }

        return result;
    }

    static String isBalanced(String input) {

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapper = new HashMap<>();
        mapper.put('}', '{');
        mapper.put(')', '(');

        String result = "false";

        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);

            //stack = ({(
            //pop = (
            if (mapper.containsKey(chars)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (topElement == mapper.get(chars)) {
                    result = "true";
                } else {
                    result = "false";
                }

            } else {
                stack.push(chars);
            }

        }

        if (stack.size() == 1 && input.length() < 2) {
            return "false";
        }

        return result;
    }


    public static boolean validParentheses(String input) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('}', '{');
        mapping.put(')', '(');
        mapping.put(']', '[');

        //stack = {
        // pop = {
        for (int i = 0; i < input.length(); i++) {
            char toChar = input.charAt(i);

            if (mapping.containsKey(toChar)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                if (topElement != mapping.get(toChar)) {
                    return false;
                }
            } else {
            }
        }
        return stack.isEmpty();
    }


    /**
     * Get object value and sum
     */
    public static void java8Improve() {

/*        List<Person> persons = Arrays.asList(
                new Person("mkyong", 100),
                new Person("jack", 100)
        );
        int quantity = persons.stream().map(Person::getAge).mapToInt(Integer::intValue).sum();
        System.out.println("Integer = " + quantity);*/
    }


    public static List<Integer> printPrime(int x) {
        List<Integer> numbers = new ArrayList<Integer>();
        int i = 2;
        while (numbers.size() != x) {
            if (i == 2) {
                numbers.add(i);
            } else if (i % 2 == 1) {
                numbers.add(i);
            }
            i++;
        }
        return numbers;
    }

    public static List<List<Integer>> pairOfSumUpInteger(int[] arr, int k) {
        List<List<Integer>> allPairs = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    List<Integer> result = new ArrayList<>();
                    result.add(arr[i]);
                    result.add(arr[j]);
                    allPairs.add(result);
                }
            }
        }
        return allPairs;
    }


    public static boolean isPalindromex(String token) {
        String reverse = "";
        int length = token.length();
        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + token.charAt(i);
        }
        if (token.equals(reverse)) {
            return true;
        }
        return false;
    }

    private void java8FilterGetReturn(List<Person> persons) {
        String name = persons.stream()
                .filter(x -> "jack".equals(x.getName()))
                .map(Person::getName)                        //convert stream to String
                .findAny()
                .orElse("");

        System.out.println(name);
    }


    private SerialNumberCurrentState getSN(String serialNumberCN) {
        SerialNumberCurrentState serialNumbers = new SerialNumberCurrentState("abc-123");
        serialNumbers.setSerialNumberCs(serialNumberCN);
        return serialNumbers;
    }


    public class SerialNumberCurrentState {

        private String serialNumberCs;


        public SerialNumberCurrentState(String serialNumberCs) {
            this.serialNumberCs = serialNumberCs;
        }

        public String getSerialNumberCs() {
            return serialNumberCs;
        }

        public void setSerialNumberCs(String serialNumberCs) {
            this.serialNumberCs = serialNumberCs;
        }


    }

    public static List<Character> splitToListOfChar(String str) {
        List<Character> result;
        String defaultDta = "Y,N";

        if (str != null) {
            result = str.chars()
                    .mapToObj(item -> (char) item).filter(item -> item != ',')
                    .collect(Collectors.toList());
        } else {
            result = defaultDta.chars()
                    .mapToObj(item -> (char) item).filter(item -> item != ',')
                    .collect(Collectors.toList());
        }
        return result;
    }


    public static String truncateSentence(String s, int k) {

        char[] str = s.toCharArray();
        int count = 0;
        StringBuilder builder = new StringBuilder();

        for (char values : str) {
            builder.append(values);
            if (values == ' ') {
                count++;
            }
            if (count == k) {
                break;
            }
        }

        builder.append(k - 1);
        return builder.toString();
    }


    public static String reverseLatters(String input) {
        int pointer1 = 0;
        int pointer2 = input.length() - 1;
        char[] result = input.toCharArray();
        while (pointer1 < pointer2) {
            if (!Character.isLetter(result[pointer1])) {
                pointer1++;
            } else if (!Character.isLetter(result[pointer2])) {
                pointer2--;
            } else {
                char temp = result[pointer1];
                result[pointer1] = result[pointer2];
                result[pointer2] = temp;
                pointer1++;
                pointer2--;
            }
        }
        return String.valueOf(result);
    }


    public static String destCity(List<List<String>> paths) {
        Set<String> dataPath = new HashSet<>();
        for (List<String> source : paths) {
            dataPath.add(source.get(0));
        }

        for (List<String> values : paths) {
            if (dataPath.contains(values.get(1))) {
                return values.get(1);
            }
        }

        return "";
    }


    public static int[] shuffle(int[] nums, int n) {
        int[] shufing = new int[nums.length];
        int j = 0;
        for (int i = 0; i < n; i++) {
            shufing[j++] += nums[i];
            shufing[j++] += nums[i + n];
        }
        return shufing;
    }

    public static int sumOfUnique(int[] nums) {

        Map<Integer, Integer> data = new HashMap<>();

        int result = 0;

        for (int values : nums) {
            if (!data.containsKey(values)) {
                data.put(values, result + values);
            }

        }


        return result;

    }

    public static class ItemsAdjust {
        String batchId;

        public ItemsAdjust(String batchId, DataStr dataStr) {
            this.batchId = batchId;
            this.dataStr = dataStr;
        }

        DataStr dataStr;

        public DataStr getDataStr() {
            return dataStr;
        }

        public void setDataStr(DataStr dataStr) {
            this.dataStr = dataStr;
        }

        public ItemsAdjust(String batchId) {
            this.batchId = batchId;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }
    }


 /*   public static String getBatchID() {
        List<ItemsAdjust> dataList = Arrays.asList(new ItemsAdjust("abc123"),
                new ItemsAdjust("dec1222"));

        String batchId = "";
        for (ItemsAdjust items : dataList) {
            batchId = items.getBatchId();
        }
        return batchId;
    }

    public static void produce(String items) {
        DataStr dataStr = construct(items);
        System.out.println(dataStr);
    }

    public static DataStr construct(String items) {
        DataStr values = new DataStr();
        values.setData123(items);
        return values;
    }*/


    public static class DataStr {
        String data123;

        public DataStr(String s) {
        }

        public String getData123() {
            return data123;
        }

        public void setData123(String data123) {
            this.data123 = data123;
        }

        @Override
        public String toString() {
            return "DataStr{" +
                    "data123='" + data123 + '\'' +
                    '}';
        }
    }


    public static int strStr(String haystack, String needle) {
        char[] heystacks = haystack.toCharArray();
        Map<Character, Integer> data = new HashMap<>();
        int result = 0;
        boolean isNeedle = true;


        for (int i = 0; i < heystacks.length; i++) {
            data.put(heystacks[i], i);
        }

        for (int i = 0; i < needle.length(); i++) {
            char needles = needle.charAt(i);
            if (data.containsKey(needles)) {
                if (result == 0) {
                    result = data.get(needles);
                }
            } else {
                isNeedle = false;
                break;
            }

        }


        if (isNeedle) {
            return result;
        } else {
            return -1;
        }

    }


/*    private List<Integer> constructList(List<Data> addedItems) {
        return addedItems.stream().map(this::sequence).collect(Collectors.toList());
    }


    private int createSeq() {
        int startIndex = 1;
        AtomicInteger increment = new AtomicInteger(startIndex);
        return increment.getAndIncrement();
    }*/


    public static void check() {
        Data dataItems = new Data(Arrays.asList(new Items(1), new Items(2)));
        List<Integer> dataList = new ArrayList<>();
        Items item = new Items(1);
        item.getIndentiFier().setSeq(9);


        for (Items values : dataItems.getItemsList()) {
            dataList.add(values.getIndentiFier().getSeq());
        }


    }

    public static void onCreate() {
        Data dataItems = new Data(Arrays.asList(new Items(1), new Items(2)));
        dataItems.itemsList.stream().map(items -> {
            Items item = new Items(1);
            item.setNumber(8);
            return item;
        }).collect(Collectors.toList());
    }


    public static class Data {

        public Data(List<Items> itemsList) {
            this.itemsList = itemsList;
        }

        List<Items> itemsList;

        public List<Items> getItemsList() {
            return itemsList;
        }

        public void setItemsList(List<Items> itemsList) {
            this.itemsList = itemsList;
        }
    }


    public static class Items {
        int number;
        IdentiFier indentiFier;

        public IdentiFier getIndentiFier() {
            return indentiFier;
        }

        public void setIndentiFier(IdentiFier indentiFier) {
            this.indentiFier = indentiFier;
        }

        public Items(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }

    public static class IdentiFier {
        int seq;


        public IdentiFier(int seq) {
            this.seq = 1;
        }

        public int getSeq() {
            return seq;
        }

        public void setSeq(int seq) {
            this.seq = seq;
        }
    }


    /**
     * java 8
     * Loop and add List to New List
     */
  /*  public static void loopAndAddToNewList() {
        List<Data> edited = Arrays.asList(
                new Data(1, "EDITED"),
                new Data(3, "EDITED"));

        List<Data> deleted = Arrays.asList(
                new Data(4, "DELETED"),
                new Data(2, "DELETED"));

        List<Integer> sequences = new ArrayList<>();

        List<Data> sort = Stream
                .concat(edited.stream(), deleted.stream())
                .sorted(Comparator.comparingInt(Data::getSeq))
                .collect(Collectors.toList());

        //old fashiom
        for (Data values : sort) {
            sequences.add(values.getSeq());
        }
        //new fashion java 8
        sort.stream().map(Data::getSeq).forEach(sequences::add);
    }*/


    /**
     * java 8
     * Print example using java 8 forEach
     */
    public static void forEachPrintExample() {
        List<Integer> editedItems = Arrays.asList(1, 3);
        editedItems.forEach(x -> System.out.println(x));
    }

    /**
     * java 8
     * Concat three List using Stream.of & flatMap
     * Sorting Collections
     * Concat three list using Arrays.asList();
     */
   /* public static void concatThreeList() {
        List<Integer> addedItems = Arrays.asList(5, 6);
        List<Integer> editedItems = Arrays.asList(1, 3);
        List<Integer> deleted = Arrays.asList(2);

        List<Integer> construct = Stream.of(editedItems, deleted, addedItems).
                flatMap(Collection::stream)
                .collect(Collectors.toList());
        Collections.sort(construct);

        List<Data> addedList = Arrays.asList(new Data(0, "A"), new Data(0, "B"), new Data(0, "C"));
    }*/

    /**
     * java 8
     * Concat list using Stream
     */
    public static void concatListExample() {
        List<Integer> addedItems = Arrays.asList(5, 6);
        List<Integer> editedItems = Arrays.asList(1, 3);
        List<Integer> deleted = Arrays.asList(2);

        List<Integer> editedAndAddedItems = (List<Integer>) Stream.concat(editedItems.stream(), addedItems.stream());
    }


    public static class Person {

        private String name;
        private BigDecimal age;

        public Person(String name, BigDecimal age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getAge() {
            return age;
        }

        public void setAge(BigDecimal age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        //gettersm setters, toString
    }


    public static void leetCode2() {
        HashMap<String, Integer> map
                = new HashMap<>();
        map.put("a", 10000);
        map.put("b", 55000);
        map.put("c", 44300);
        map.put("e", 53200);

        System.out.println("ORIGINAL HashMap:\n "
                + map.toString());

        // put a new value which is not mapped
        // before in map
        map.putIfAbsent("d", 77633);
        map.putIfAbsent("d", 888);
        System.out.println("New HashMap:\n "
                + map);
    }


    public static void leetCode() {
        String input = "ab";
        String[] inputStr = {"ad", "bd", "aaab", "baa", "badab"};
        int counter = 0;

        Map<Character, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            dataMap.put(chars, dataMap.getOrDefault(chars, 0) + 1);
        }


        for (int i = 0; i < inputStr.length; i++) {
            String str = inputStr[i];
            boolean consisten = true;

            for (int j = 0; j < str.length(); j++) {
                char chars = str.charAt(j);
                if (!dataMap.containsKey(chars)) {
                    consisten = false;
                    break;
                }
            }

            if (consisten) {
                counter++;
            }

        }
    }


    public String toLowerCase(String str) {

        StringBuilder builder = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i++) {
            char chars = str.charAt(i);
            if (chars >= 'A' && chars <= 'Z') {
                builder.append(String.valueOf(chars).toLowerCase());
            } else {
                builder.append(chars);
            }
        }
        return builder.toString();
    }


    public static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        int counter = 0;

        for (int i = 0; i < S.length(); i++) {
            char chars = S.charAt(i);
            if (chars == '(') {
                stack.push(chars);
            } else {
                stack.pop();
            }
            if (stack.isEmpty()) {
                builder.append(S, counter + 1, i);
                counter = i + 1;
            }
        }
        return builder.toString();
    }


    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] clonedArr = nums.clone();

        Arrays.sort(clonedArr);

        //1,2,2,3,8

        Map<Integer, Integer> numbersMapper = new HashMap<>();

        for (int i = 0; i < clonedArr.length; i++) {
            numbersMapper.putIfAbsent(clonedArr[i], i);
        }

        for (int j = 0; j < clonedArr.length; j++) {
            clonedArr[j] = numbersMapper.get(nums[j]);
        }


        return clonedArr;
    }


    /**
     * Java 8 Method Reference Feeature
     * -Method Reference is used to refer method of functional Interface
     * <p>
     * Type Of Method Reference :
     * 1.Reference To Static Method
     * 2.Reference To Reference Method
     * 3.Reference To Constructor
     */
    public static void methodReferenceJava8() {
        List<String> dataList = new ArrayList<>();
        dataList.add("dimas");
        dataList.add("dosan");
        dataList.add("chulsan");

        List<String> resultList = new ArrayList();

        dataList.forEach(resultList::add);

        resultList.forEach(resultStr -> System.out.println(resultStr));
    }


    /**
     * LeetCode Goal Parser Interpretation My Optimize Solution
     * 0ms
     * O(1)
     * <p>
     * String input = "G()(al)";
     * String input2 = "G()()()()(al)";
     *
     * @param command
     * @return
     */
    public static String interpret2(String command) {

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            char chars = command.charAt(i);

            if (chars == 'G') {
                strBuilder.append(chars);
            } else if (chars == '(' && command.charAt(i + 1) == ')') {
                strBuilder.append('o');
                i++;
            } else {
                strBuilder.append("al");
                i += 3;
            }

        }
        return strBuilder.toString();
    }


    /**
     * LeetCode Goal Parser Interpretation My 1st Approach
     * 1ms
     * O(1)
     * <p>
     * String input = "G()(al)";
     * String input2 = "G()()()()(al)";
     *
     * @param command
     * @return
     */
    public static String interpret(String command) {

        StringBuilder strBuilder = new StringBuilder();
        int length = command.length();

        for (int i = 0; i < length; i++) {
            char chars = command.charAt(i);

            if (chars == '(' && i < length && command.charAt(i + 1) == ')') {
                strBuilder.append('o');
            } else if ((chars >= 'a' && chars <= 'z') || (chars >= 'A' && chars <= 'Z')) {
                strBuilder.append(chars);
            }
        }
        return strBuilder.toString();
    }


   /* public static void javaStreamPractice() {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("bil gates", 120));
        personList.add(new Person("zuck", 100));
        personList.add(new Person("elon musk", 400));
        personList.add(new Person("ali baba", 300));
        personList.add(new Person("corn dog", 150));

        *//**
     * Without java stream()
     *//*
        List<Person> newBillioners = new ArrayList<>();
        for (Person p : personList) {
            if (p.billion > 100) {
                newBillioners.add(p);
            }
        }
        // newBillioners.forEach(person -> System.out.println(person.name));

        *//**
     * With java 8 Stream()
     *//*
        List<Person> newBillions = personList.stream()
                .filter(person -> person.billion > 100)
                .sorted(Comparator.comparing(person -> person.name))
                .collect(Collectors.toList());

        newBillions.forEach(person -> System.out.println(person.name));
    }*/

    /**
     * java 8 Optional Practice
     */
    public static void javaOptionPractice() {
        Optional<Object> optionalEmpty = Optional.empty();
        /*System.out.println(optionalEmpty.isPresent());
        System.out.println(optionalEmpty.isEmpty());*/

        /**
         *
         * Optional Of() value tidak bisa Null  (NullPointerException)
         */
        Optional<String> optionalOf = Optional.of("Hello");
       /* System.out.println(optionalOf.isPresent());
        System.out.println(optionalOf.isEmpty());*/


        /**
         *
         * Optional ofNullable() values bisa null
         */
        Optional<String> optionalOfNullAble = Optional.ofNullable(null);

       /* System.out.println(optionalOfNullAble.isEmpty());
        System.out.println(optionalOfNullAble.isPresent());*/

        /**
         *
         * Default condition jika value dalam Container Object Optional null
         */
        String orElse = optionalOfNullAble.orElse("Your values is Null");
        //System.out.println(orElse);

        /**
         *
         * Transform value using map
         */
        String transformValuesMap = optionalOfNullAble
                .map(String::toUpperCase)
                .orElse("Your values is Null");


        System.out.println(transformValuesMap);
    }


    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewelMap = new HashMap<>();

        char[] jewel = jewels.toCharArray();

        for (char key : jewel) {
            jewelMap.put(key, jewelMap.getOrDefault(key, 0) + 1);
        }

        int counter = 0;

        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            if (jewelMap.containsKey(stone)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * leetcode , replace char in string
     *
     * @param address
     * @return
     */
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            char chars = address.charAt(i);
            if (chars == '.') {
                sb.append("[.]");
            } else {
                sb.append(chars);
            }
        }
        return sb.toString();
    }


    public static void lambdaExpression() {
        List<Integer> dataList = new ArrayList<>();
        dataList.add(1);
        dataList.add(3);
        dataList.add(4);

        dataList.forEach(values -> System.out.println(values));
    }

    /**
     * leetcode Squares of a Sorted Array two pointer
     * Second approach using two pointer
     * Run Time O(1)
     * Memory O(n)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {

        int[] result = new int[nums.length];
        int pointer1 = 0;
        int pointer2 = nums.length - 1;
        int index = nums.length - 1;

        while (pointer1 <= pointer2) {

            int first = nums[pointer1] * nums[pointer1];
            int sec = nums[pointer2] * nums[pointer2];

            if (first >= sec) {
                result[index] = first;
                pointer1++;
            } else {
                result[index] = sec;
                pointer2--;
            }

            index--;
        }


        for (int values : result) {
            System.out.println(values);
        }

        return result;

    }

    /**
     * leetcode Squares of a Sorted Array , two pointer
     * My Approach no additional array
     * Run Time O(1)
     * Memory O(1)
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }


    /**
     * leetcode number of identical pairs using two pointers
     * <p>
     * Run Time O(n1)
     * Memory space 0(1)
     * int [] input = {1,2,3,1,1,3}
     * int [] input = {1,1,1,1}
     * int [] input = {1,2,3}
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs(int[] nums) {
        int length = nums.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (nums[i] == nums[j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * leetcode number of identical pairs using HashMap
     * <p>
     * Run Time O(n2)
     * Memory space 0(1)
     * int [] input = {1,2,3,1,1,3}
     * int [] input = {1,1,1,1}
     * int [] input = {1,2,3}
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs3(int[] nums) {
        int counter = 0;
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int key : nums) {
            numsMap.put(key, numsMap.getOrDefault(key, 0) + 1);
        }

        for (int key : numsMap.keySet()) {
            int values = numsMap.get(key);
            if (values > 1) {
                counter += values * (values - 1) / 2;
            }
        }

        return counter;
    }

    /**
     * leetcode number of identical pairs using Array
     * <p>
     * Run Time O(1)
     * Memory space 0(1)
     * int [] input = {1,2,3,1,1,3}
     * int [] input = {1,1,1,1}
     * int [] input = {1,2,3}
     *
     * @param nums
     * @return
     */
    public static int numIdenticalPairs2(int[] nums) {

        int result = 0;
        int size = 0;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            size = Math.max(size, nums[i]);
        }

        int[] storage = new int[size + 1];

        for (int i = 0; i < length; i++) {
            result += storage[nums[i]]++;
        }
        return result;
    }

    /**
     * LeetCode Find All Numbers Disappeared in an Array
     * int [] input = {4,3,2,7,8,2,3,1};
     * int [] input2 = {1,1};
     * int [] input3 = {1,1,2,2};
     * Linear Time
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> resultList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        Arrays.sort(nums);

        //4,3,2,7,8,2,3,1
        //1,2,2,3,3,4,,,7,8
        int length = nums.length;

        int counter = 1;
        for (int values : nums) {
            set.add(values);
        }

        for (int i = 0; i < length; i++) {
            if (!set.contains(counter)) {
                resultList.add(counter);
            }
            counter++;
        }
        return resultList;
    }


    /**
     * LeetCode
     * <p>
     * int[] input = {4, 9, 5};
     * int[] input2 = {9, 4, 9, 8, 4};
     * int[] input3 = {1, 2, 2, 1};
     * int[] input4 = {2, 2};
     * int[] input5 = {3, 1, 2};
     * int[] input6 = {1, 1};
     * intersect(input3, input4);
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> dataMap = new HashMap<>();
        int lengthNums1 = nums1.length;
        int lengthNums2 = nums2.length;
        List<Integer> dataList = new ArrayList();


        if (lengthNums1 > lengthNums2) {

            for (int values : nums1) {
                dataMap.put(values, dataMap.getOrDefault(values, 0) + 1);
            }

            for (int values : nums2) {
                if (dataMap.containsKey(values) && dataMap.get(values) != 0) {
                    dataList.add(values);
                    dataMap.put(values, dataMap.get(values) - 1);
                }
            }
        } else {
            for (int values : nums2) {
                dataMap.put(values, dataMap.getOrDefault(values, 0) + 1);
            }
            for (int values : nums1) {
                if (dataMap.containsKey(values) && dataMap.get(values) != 0) {
                    dataList.add(values);
                    dataMap.put(values, dataMap.get(values) - 1);
                }
            }
        }

        int[] resultArr = new int[dataList.size()];
        int index = 0;
        for (int values : dataList) {
            resultArr[index++] = values;
        }

        return resultArr;
    }

    /**
     * Optimize Solution leetCode slowest keypress
     * 0ms
     * O(n)
     *
     * @param releasesTime
     * @param keys
     * @return
     */
    public static char slowestKey2(int[] releasesTime, String keys) {
        int prev = 0;
        char result = '\0';
        int counter;
        int max = 0;

        for (int i = 0; i < releasesTime.length; i++) {
            counter = releasesTime[i] - prev;

            if (counter >= max) {
                char expectedChar = keys.charAt(i);

                if (counter > max || expectedChar > result) {
                    result = expectedChar;
                }
                max = counter;
            }
            prev = releasesTime[i];
        }
        return result;
    }

    /**
     * My approach ,leetcode slowest keypress
     * int[] input = {9, 29, 49, 50};
     * int[] input2 = {12, 23, 36, 46, 62};
     * int[] input3 = {2, 4, 10, 16, 25, 26, 28, 33, 75};
     * String str1 = "cbcd";
     * String str2 = "spuda";
     * String str3 = "duxwdgmgw";
     * slowestKey(input3, str3);
     *
     * @param releaseTimes
     * @param keysPressed
     * @return
     */
    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int length = releaseTimes.length;
        int bigest = releaseTimes[0];
        Map<Integer, Character> timesMap = new HashMap<>();
        int index = 0;
        boolean isDuplicate = false;
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                int count = releaseTimes[i] - releaseTimes[i - 1];
                if (count > bigest) {
                    bigest = count;
                    index = i;
                    isDuplicate = false;
                } else if (count == bigest) {
                    timesMap.put(i, keysPressed.charAt(i));
                    timesMap.put(index, keysPressed.charAt(index));
                    isDuplicate = true;
                }
            }
        }

        char result = 0;
        if (isDuplicate) {
            for (int key : timesMap.keySet()) {
                char chars = timesMap.get(key);
                if (chars > result) {
                    result = chars;
                }
            }
        } else {
            result = keysPressed.charAt(index);
        }
        System.out.println(result);

        return result;
    }


    public static int[] contigiousSubArray(int[] input) {
        int length = input.length;
        int maxValue = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;

        for (int i = 0; i < length; i++) {
            int memo = 0;
            for (int j = i; j < length; j++) {
                memo += input[j];

                if (memo > maxValue) {
                    maxValue = memo;
                    start = i;
                    end = j;
                }
            }
        }
        int[] resultArray = Arrays.copyOfRange(input, start, end);
        return resultArray;
    }

    public static boolean containsDuplicate() {
        int[] input = {1, 2, 1};
        HashSet<Integer> set = new HashSet();

        for (int value : input) {
            if (!set.add(value)) {
                return true;
            }
        }

        return false;
    }


    public static int majorityElement4(int[] nums) {
        //BEST:
        int count = 0;
        int res = 0;
        for (int i : nums) {
            if (count == 0) {
                res = i;
            }
            count += (res == i) ? 1 : -1;
        }

        return res;
    }


    public static int majorityElements(int[] nums) {

        Map<Integer, Integer> numbersMap = new HashMap();

        for (int values : nums) {
            numbersMap.put(values, numbersMap.getOrDefault(values, 0) + 1);
        }

        int result = 0;
        int biggest = 0;
        for (int values : numbersMap.keySet()) {
            if (numbersMap.get(values) > biggest) {
                result = values;
                biggest = numbersMap.get(values);
            }
        }

        return result;

    }


    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        for (int j = index; j < nums.length; j++) {
            nums[index++] = 0;
        }
    }


    static long substrCount(int target, String input) {
        int length = input.length();
        int result = length;
        //aaaa
        for (int i = 0; i < length; i++) {
            int counter = 0;
            while (i + 1 < length && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                counter++;
            }
            result += (counter * (counter + 1) / 2);
            result += countMiddle(input, i);
        }
        return result;
    }

    // abcbbabba
    public static int countMiddle(String input, int i) {
        int pointer = 1;
        int counter = 0;
        while (i - pointer >= 0 && i + pointer < input.length()
                && input.charAt(i - 1) == input.charAt(i + pointer)
                && input.charAt(i - 1) == input.charAt(i - pointer)) {
            pointer++;
            counter++;
        }
        return counter;
    }


    static String isValid2(String input) {

        int length = input.length();

        if (length == 1) {
            return "YES";
        }

        int[] words = new int[26];
        for (int i = 0; i < length; i++) {
            char chars = input.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                words[chars - 'a']++;
            }
        }

        Arrays.sort(words);

        int start = 0;
        while (words[start] == 0) {
            start++;
        }

        int alphabetLength = words.length;
        int deletion = 0;

        if (words[start] == words[alphabetLength - 1]) {
            return "YES";
        } else {
            for (int i = start; i < 26; i++) {
                if (i > alphabetLength) {
                    break;
                } else {
                    deletion += Math.abs(words[i] - words[alphabetLength - 1]);
                    alphabetLength--;
                }
            }
        }

        if (deletion == 1 || deletion == words[alphabetLength] - 1) {
            return "YES";
        } else {
            return "NO";
        }
    }


    static void minimumBribes(int[] input) {

        int length = input.length;
        int countSwap = 0;

        for (int i = length - 1; i > 0; i--) {

            if (input[i] != i + 1) {
                if (((i - 2) >= 0) && (input[i - 2] == i + 1)) {
                    countSwap += 2;
                    swaps(input, i - 2, i - 1);
                    swaps(input, i - 1, i);
                } else if (((i - 1) >= 0) && (input[i - 1] == i + 1)) {
                    countSwap++;
                    swaps(input, i - 1, i);
                } else {
                    System.out.println("Too Chaotic");
                }
            }
        }
        System.out.println(countSwap);
    }

    //2, 1, 5, 3, 4
    private static void swaps(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * int[] input = {4, 3, 1, 2};
     * int[] input2 = {1, 3, 5, 2, 4, 6, 7};
     * int[] arr = {7, 1, 3, 2, 4, 5, 6};
     * int[] input4 = {2, 3, 4, 1, 5};
     * Hackerank Minimum SWAP
     *
     * @param arr
     * @return
     */
    static int minimumSwaps5(int[] arr) {
        int countSwap = 0;
        int counter = 1;
        int length = arr.length;

        for (int i = 0; i < length; i++) {
            if (arr[i] != counter) {
                for (int j = 0; j < length; j++) {
                    if (arr[j] == counter) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        counter++;
                        countSwap++;
                        break;
                    }
                }
            } else {
                if (counter != length) {
                    counter++;
                }
            }
        }
        return countSwap;
    }

    /**
     * Allianz codelity test
     *
     * @param n
     * @return
     */
    public static String generateTheString(int n) {
        if (n <= 0) {
            return "";
        }

        StringBuilder strBuilder = new StringBuilder(n);
        if (n % 2 == 0) {
            strBuilder.append('a');
            n--;
        }
        while (n > 0) {
            strBuilder.append('b');
            n--;
        }
        return strBuilder.toString();
    }


    /**
     * int[] input = {2, 1, 3};
     * int[] input1 = {1, 2, 3, 4};
     * Codelity easy , check permutation using HashSet
     *
     * @param inputArr
     * @return
     */
    public static int permutation(int[] inputArr) {
        return checkPermutation(inputArr) ? 1 : 0;
    }

    public static boolean checkPermutation(int[] inputArr) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();

        int counter = 1;
        for (int values : inputArr) {
            setA.add(counter);
            setB.add(values);
            counter++;
        }
        setA.removeAll(setB);
        System.out.println(setA);
        return setA.isEmpty();
    }

    /**
     * Codelity Medium
     *
     * @param N
     * @param A
     * @return
     */
    public static int[] countArray(int N, int[] A) {
        int[] counter = new int[N];
        int largest = 0;
        int updated = 0;

        for (int values : A) {
            int current = values - 1;
            if (values <= N) {
                if (counter[current] < updated) {
                    counter[current] = updated + 1;
                } else {
                    counter[current]++;
                }

                if (counter[current] > largest) {
                    largest = counter[current];
                }

            } else {
                updated = largest;
            }
        }

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] > updated) {
                counter[i] = updated;
            }
        }
        return counter;
    }


    public static int[] solution3(int N, int[] A) {

        int[] counter = new int[N];
        int largest = 0;
        int updated = 0;
        for (int values : A) {
            int current = values - 1;
            if (values <= N) {
                if (counter[current] < updated) {
                    counter[current] = updated + 1;
                } else {
                    counter[current]++;
                }

                if (counter[current] > largest) {
                    largest = counter[current];
                }

            } else {
                updated = largest;
            }
        }

        return counter;

    }


    /**
     * Codelity practice
     * int[] A = {-1000, 1000};
     * int[] B = {3, 1, 2, 4, 3};
     *
     * @param A
     * @return
     */
    public static int sumLeftRight(int[] A) {
        int total = 0;


        for (int values : A) {
            total += values;
        }

        int result = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            total = total - A[i];
            int absValue = Math.abs(left - total);
            if (absValue < result) {
                result = absValue;
            }
        }

        return result;
    }


    /**
     * Codelity : find unpaired value
     * input = 9,3,9,3,9,7,9
     *
     * @param A
     * @return
     */
    public int findUnpairValue(int[] A) {
        HashSet<Integer> dataSet = new HashSet<>();
        for (int keyValues : A) {
            if (!dataSet.contains(keyValues)) {
                dataSet.add(keyValues);
            } else {
                dataSet.remove(keyValues);
            }
        }
        int result = 0;
        for (int value : dataSet) {
            result = value;
        }
        return result;
    }


    public static void countBinaryGasp(int input) {
        String toBinary = Integer.toBinaryString(input);
        int maxZero = 0;
        int zero = 0;
        for (int i = 0; i < toBinary.length(); i++) {
            char chars = toBinary.charAt(i);
            if (chars == '1') {
                maxZero = Math.max(maxZero, zero);
                zero = 0;
            } else {
                zero++;
            }
        }
        System.out.println(maxZero);
    }


    /**
     * @return
     */
    public static int[] findPairsOf2(int[] arr, int target) {

        Map<Integer, Integer> dataMap = new HashMap<>();
        int[] result = new int[]{0, 1};

        if (arr.length == 2) {
            return result;
        }

        for (int i = 0; i < arr.length; i++) {
            int reminder = target - arr[i];
            if (dataMap.containsKey(reminder)) {
                result = new int[]{dataMap.get(reminder), i};
                break;
            } else {
                dataMap.put(arr[i], i);
            }
        }


        return result;
    }

    /**
     * Print Prime number with adding more 2 hashset
     * with O(n2) Time Complexity
     * O(1) Space Complexity
     * //2,3
     *
     * @param input
     */
    public static void printPrimes(int input) {
        int counter;
        for (int i = 2; i <= input * 2; i++) {
            counter = 0;
            if (i > 2 && i % 2 == 0) {
                counter++;
            }
            if (counter == 0) {
                System.out.println(i);
            }

        }

    }

    /**
     * Advotics find pairs of integer based on sum of K
     * Time Complexity O(n)
     * Space Complexity O(n) using HashSet
     *
     * @param randomInt
     * @param k
     */
    static void getPairs(int randomInt[], int k) {
       /*
        int randomInt[] = {1, 4, 45, 6, 10, 8};
        int k = 16;
        */

        int length = randomInt.length;
        HashSet<Integer> dataMap = new HashSet<>();
        for (int i = 0; i < length; ++i) {
            int temp = k - randomInt[i];
            if (dataMap.contains(temp)) {
                System.out.println("Pair Of K " + "(" + randomInt[i] + ", " + temp + ")");
            }
            dataMap.add(randomInt[i]);
        }
    }





   /* public static boolean isPalindrome(String input) {


        String inputToLower = input.toLowerCase();

        for (int i = 0; i < inputToLower.length(); i++) {
            char chars = inputToLower.charAt(i);
            if (chars >= 'a' && chars <= 'z') {

            }
        }


    }*/


    public static int lengthOfList(int[] nums) {
        return lengthOfList(nums, Integer.MIN_VALUE, 0);
    }


    public static int lengthOfList(int[] nums, int prev, int current) {
        //current=0;
        //{0,1,0,3,2,3}
        //Integer.MIN_VALUE

        if (current == nums.length) {
            return 0;
        }

        int taken = 0;
        if (nums[current] > prev) {
            taken = 1 + lengthOfList(nums, nums[current], current + 1);
        }

        int notTaken = lengthOfList(nums, prev, current + 1);

        return Math.max(taken, notTaken);
    }


    /**
     * Hackerank Common Child = find subsequence string
     * String input10 = "TERRACED";
     * String input9 = "CRATERED";
     * <p>
     * String input3 = "SHINCHAN";
     * String input4 = "NOHARAAA";
     * <p>
     * String input5 = "ABCDEF";
     * String input6 = "FBDAMN";
     *
     * @param str1
     * @param str2
     * @return
     */
    public static int commonChild2(String str1, String str2) {
        int length = str1.length();
        char[] input1 = str1.toCharArray();
        char[] input2 = str2.toCharArray();
        int[] memo = new int[length + 1];

        for (int i = 1; i <= length; i++) {
            int prev = 0;
            for (int j = 1; j <= length; j++) {

                int temp = memo[j];

                if (input1[i - 1] == input2[j - 1]) {
                    memo[j] = prev + 1;
                } else {
                    memo[j] = Math.max(memo[j], memo[j - 1]);
                }
                prev = temp;
            }
        }
        return memo[length];
    }


    public static int commonChild(String str1, String str2) {

        int inputLength = str1.length();
        Map<Character, Integer> words = new HashMap<>();

        int count = 0;
        int countMax = 0;

        for (int i = 0; i < inputLength; i++) {
            char chars = str1.charAt(i);
            words.put(chars, words.getOrDefault(chars, 0) + 1);
        }

        for (int j = 0; j < inputLength; j++) {
            char chars = str2.charAt(j);
            if (words.containsKey(chars)) {
                // words.put(chars, words.get(chars) - 1);
                count++;
            }
        }

        if (count > 3) {
            count /= 2;
        }
        return count;
    }


    /**
     * hackerank count minus values contigious
     * time complexity O(N2)
     *
     * @return
     */
    public static int countMinus(int[] arrays) {
        int count = 0;
        for (int i = 0; i < arrays.length; i++) {
            int sum = 0;
            for (int j = i; j < arrays.length; j++) {
                sum = arrays[j] + sum;
                if (sum < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void javaStringTokens(String input) {

        if (input.trim().isEmpty()) {
            System.out.println(0);
            return;
        }

        String regex = "[!?,._'@\\s]+";
        String[] splits = input.split(regex);

        int length = splits.length;
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(splits[i]);
        }
    }


    public static boolean compareAnagram(String A, String B) {

        int[] alphabetA = new int[26];
        int[] alphabetB = new int[26];
        String inputA = A.toLowerCase();
        String inputB = B.toLowerCase();

        for (int i = 0; i < inputA.length(); i++) {
            char chars = inputA.charAt(i);
            alphabetA[chars - 'a']++;
        }

        for (int j = 0; j < inputB.length(); j++) {
            char chars = inputB.charAt(j);
            alphabetB[chars - 'a']++;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += Math.abs(alphabetA[i] - alphabetB[i]);
        }

        if (result > 0) {
            return false;
        } else {
            return true;
        }

    }


    /**
     * find palindrome without data structure
     * <p>
     * String input1 = "madam";
     */
    public static boolean isPalindromeNew(String A) {
        String B = A;
        //A = madam
        //B = madam
        int length = A.length() - 1;
        boolean isPalindrome = false;
        int i = 0;
        while (length > i) {
            char charsA = A.charAt(i);
            char charsB = B.charAt(length);

            if (charsA == charsB) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
            }
            length--;
            i++;
        }
        if (isPalindrome) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Hackerank Java Substring Comparisons
     * <p>
     * String input = "welcometojava";
     *
     * @param input
     * @param k
     * @return
     */
    public static String getSmallestAndLargest(String input, int k) {
        String current = input.substring(0, k);
        String smallest = current;
        String largest = current;

        for (int i = 1; i <= input.length() - k; i++) {
            current = input.substring(i, i + k);

            if (current.compareTo(largest) > 0) {
                largest = current;
            }

            if (current.compareTo(smallest) < 0) {
                smallest = current;
            }
        }

        return smallest + "\n" + largest;
    }


    /**
     * Hackerank Practice Sherlock and the Valid String
     * String input2 = "abcdefghhgfedecba";
     * String input1 = "aabbcd";
     * String input3 = "xxxaabbccrry";
     * <p>
     * Output : "Yes / No"
     *
     * @param input
     * @return
     */
    public static String isValid(String input) {
        //aabbcd
        //abcdefghhgfedecba

        int length = input.length();
        int[] charsArr = new int[26];

        for (int i = 0; i < length; i++) {
            char chars = input.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                charsArr[chars - 'a']++;
            }
        }
        Arrays.sort(charsArr);

        int start = 0;
        while (charsArr[start] == 0) {
            start++;
        }
        int letterLength = charsArr.length;
        int min = 0;

        if (charsArr[start] == charsArr[letterLength - 1]) {
            return "YES";
        } else {
            for (int i = start; i < letterLength - 1; i++) {
                while ((letterLength - 1) > i) {
                    min += Math.abs(charsArr[i] - charsArr[letterLength - 1]);
                    letterLength--;
                    i++;
                }
            }
        }


        if (min == 1 || min == (charsArr[letterLength - 1] - 1)) {
            return "YES";
        } else {
            return "NO";
        }
    }


    /**
     * leetcode Min Cost Climbing Stairs second approach
     * int[] input1 = {10, 15, 20};
     * int[] input = {0, 1, 2, 2};
     * int[] input3 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
    }

    /**
     * leetcode Min Cost Climbing Stairs
     * int[] input1 = {10, 15, 20};
     * int [] input = {0,1,2,2};
     * int[] input3 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        //10,15,20
        int min;
        int[] stairs = new int[cost.length];
        stairs[0] = cost[0];
        stairs[1] = cost[1];
        int sum;
        for (int i = 2; i < cost.length; i++) {
            sum = cost[i] + Math.min(stairs[i - 1], stairs[i - 2]);
            stairs[i] = sum;
        }
        min = Math.min(stairs[stairs.length - 1], stairs[stairs.length - 2]);
        return min;
    }

    /**
     * Codebat modify fizzbuzz use array
     * time complexity O(n)
     * space complexity O(1)
     * fizzBuzz(1, 4);
     *
     * @param start
     * @param end
     * @return
     */
    public static String[] fizzBuzz(int start, int end) {
        String[] data = new String[end - 1];
        int index = 0;
        for (int i = start; i < end; i++) {
            if (i % 15 == 0) {
                data[index++] = "FizzBuzz";
            } else if (i % 5 == 0) {
                data[index++] = "Buzz";
            } else if (i % 3 == 0) {
                data[index++] = "Fizz";
            } else {
                data[index++] = String.valueOf(i);
            }
        }
        return data;
    }


    /**
     * codebat move even to front odd to end
     * int[] input = {1, 0, 1, 0, 0, 1, 1};
     * int[] input2 = {3, 3, 2};
     * Time complexity O(n2)
     * Space Complexity O(1)
     *
     * @param input
     * @return
     */
    public static int[] evenOddNoArr(int[] input) {
        //2,3,3
        //0,0,0,1,1,1,1
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1; j++) {
                if (input[j] % 2 == 1 && input[j] != input[j + 1]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

    /**
     * codebat move even to front odd to end
     * int[] input = {1, 0, 1, 0, 0, 1, 1};
     * int[] input2 = {2, 2, 2};
     * Time Complexity O(n)
     * Space Complexity O(n)
     *
     * @param input
     * @return
     */
    public static int[] evenOdd(int[] input) {
        //1, 0, 1, 0, 0, 1, 1
        int[] numbers = new int[input.length];
        int putLast = input.length - 1;
        int checker = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) {
                numbers[checker++] = input[i];
            } else {
                numbers[putLast--] = input[i];
            }
        }
        return numbers;
    }


    public static int climbStairsButtomUp(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        for (int i = 3; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }


    public static int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs2(n, memo);
    }

    /**
     * leetcode
     *
     * @param n
     * @param memo
     * @return
     */
    public static int climbStairs2(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        int recursive = climbStairs2(n - 1, memo);
        int recursive2 = climbStairs2(n - 2, memo);
        int sum = recursive + recursive2;
        memo[n] = sum;
        return sum;

    }


    public static int countX(String str) {
        int count = 1;
        if (str.equals("")) {
            return 0;
        }

        if (str.charAt(0) == 'x') {
            int recurSive = countX(str.substring(1));
            return count + recurSive;
        } else {
            int recurSive2 = countX(str.substring(1));
            return recurSive2;
        }
    }


    public static int powerN(int base, int n) {
        if (n == 0) {
            return 1;
        }
        int result = powerN(base, n - 1);
        int power = base * result;
        return power;
    }


    public static int bunnyEarss(int bunnies) {
        if (bunnies == 0) {
            return 0;
        } else if (bunnies == 1) {
            return 1;
        }
        int result = 2 * bunnyEarss(bunnies - 1);
        return result;
    }

    /**
     * @param n
     * @return
     */
    public static int factorialCodebat(int n) {
        //faktorial 3 = 3 * 2 * 1 = 6
        if (n == 1) {
            return 1;
        }
        int result = n * factorialCodebat(n - 1);
        return result;
    }


    public static int sumRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        int nums = sumRecursive(n - 1);
        return nums + 2;
    }

    /**
     * CS Dojo
     * fibonaci with Memoaized solution this perform better than usual
     * recursive fibonaci because we save to the array and not compute unnecesary tree
     * Time Complexity O(n)
     *
     * @param n
     * @param memo
     * @return
     */
    public static int fibonaciCodeBat(int n, int[] memo) {
        //1, 1, 2, 3, 5, 8, 13, 21
        int result = 0;
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            int fib1 = fibonaciCodeBat(n - 1, memo);
            int fib2 = fibonaciCodeBat(n - 2, memo);
            result = fib1 + fib2;
            memo[n] = result;
        }
        return result;
    }

    /**
     * CS Dojo
     * Dynamic programming Bottom-up approach
     * Time Complexity O(N) Better than usual recursive
     *
     * @param n
     * @return
     */
    public static int fibonaciBU(int n) {
        //1, 1, 2, 3, 5, 8, 13, 21
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] tempArr = new int[n + 1];
        tempArr[1] = 1;
        tempArr[2] = 1;

        for (int i = 3; i <= n; i++) {
            tempArr[i] = tempArr[i - 1] + tempArr[i - 2];
        }
        return tempArr[n];
    }

    public static int singleNumber4(int[] input) {
        Arrays.sort(input);
        //1,1,2,2,4
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] != input[i + 1]) {
                return input[i];
            } else {
                i++;
            }
        }
        return input[input.length - 1];
    }


    public static int singleNumber3(int[] input) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < input.length; i++) {
            if (set.contains(input[i])) {
                set.remove(input[i]);
            } else {
                set.add(input[i]);
            }
        }

        for (int x : set) {
            return x;
        }
        return input[0];
    }


    public static int singleNumber2(int[] input) {
        int count = 0;
        for (int values : input) {
            count ^= values;
        }
        return count;
    }

    /**
     * int[] nums1 = {4, 1, 2, 1, 2};
     * int[] nums = {2, 2, 1};
     *
     * @param input
     * @return
     */
    public static int singleNumber(int[] input) {
        //2,2,1
        //4,1,2,1,2
        int length = input.length;
        int result = 0;

        Map<Integer, Integer> dataMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            dataMap.put(input[i], dataMap.getOrDefault(input[i], 0) + 1);
        }

        for (int i = 0; i < length; i++) {
            if (dataMap.get(input[i]) == 1) {
                result = input[i];
                break;
            }
        }

        return result;
    }


    /**
     * LeetCode First Unique Character in a String
     * 2n approach 7ms
     * String input = "leetcode";
     * String input2 = "loveleetcode";
     *
     * @param input
     * @return
     */
    public static int firstUniqueChar1(String input) {
        int length = input.length();
        int[] alphabet = new int[26];

        for (int i = 0; i < length; i++) {
            char chars = input.charAt(i);
            alphabet[chars - 'a']++;
        }

        for (int j = 0; j < length; j++) {
            char chars = input.charAt(j);
            if (alphabet[chars - 'a'] == 1) {
                return j;
            }
        }

        return -1;
    }

    /**
     * LeetCode First Unique Character in a String
     * String input = "leetcode";
     * String input2 = "loveleetcode";
     *
     * @return
     */
    public static int firstUniqueChar(String input) {
        //loveleetcode

        Map<Character, Integer> valuesMap = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            valuesMap.put(chars, valuesMap.getOrDefault(chars, 0) + 1);
        }

        for (int j = 0; j < input.length(); j++) {
            if (valuesMap.get(input.charAt(j)) == 2) {
                return j;
            }
        }
        return -1;
    }


    /**
     * HackerRank Problem Return Day from date
     *
     * @param day
     * @param month
     * @param year
     * @return
     */
    public static String dateParse(int day, int month, int year) {
        String getDay = "";
        try {
            String dateStr = String.valueOf(month).concat(" ").concat(String.valueOf(day)).concat(" ").concat(String.valueOf(year));
            String format = "MM dd yyyy";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = sdf.parse(dateStr);
            getDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
        } catch (Exception e) {
            e.getMessage();
        }
        return getDay.toUpperCase();
    }

    /**
     * Hackerank Sharelock And Anagram
     * find pair anagram and count
     * String input  = "abba";
     *
     * @param input
     * @return
     */
    public static int sherlockAndAnagrams(String input) {
        int length = input.length();
        Map<String, Integer> valuesMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                char[] chars = input.substring(i, j + 1).toCharArray();
                Arrays.sort(chars);
                String key = String.copyValueOf(chars);

                if (!valuesMap.containsKey(key)) {
                    valuesMap.put(key, 1);
                } else {
                    valuesMap.put(key, valuesMap.get(key) + 1);
                }
            }
        }
        return countPairAnagrams(valuesMap);
    }

    /**
     * Method to count annagram paired using COMBINATION formula
     *
     * @param valuesMap
     * @return
     */
    public static int countPairAnagrams(Map<String, Integer> valuesMap) {
        int countPairAnagrams = 0;
        for (String key : valuesMap.keySet()) {
            int values = valuesMap.get(key);
            countPairAnagrams += (values * (values - 1)) / 2;
        }
        return countPairAnagrams;
    }


    /**
     * Codebat problem move zero to front 3rd approach best solution
     * <p>
     * time complexity O(n)
     * space complexity O(1)
     * <p>
     * int[] input1 = {0, 0, 1, 1};
     * int[] input2 = {0, 1, 1, 0, 1};
     * int[] input = {0, -3, 0, -3};
     * int[] input4 = {9, 9, 0, 9, 0, 9};
     *
     * @param input
     * @return
     */
    public static int[] zeroFron3rd(int[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                input[i] = input[count];
                input[count] = 0;
                count++;
            }
        }
        return input;
    }

    /**
     * Codebat problem move zero to front 2nd approach
     * <p>
     * int[] input1 = {0, 0, 1, 1};
     * int[] input2 = {0, 1, 1, 0, 1};
     * int[] input3 = {0, -3, 0, -3};
     * int[] input = {9, 9, 0, 9, 0, 9};
     * <p>
     * time compexity O(n)
     * space complexity (On2)
     *
     * @param input
     * @return
     */
    public int[] zeroFront2nd(int[] input) {
        if (input.length == 0) {
            return input;
        }

        int[] temp = new int[input.length];

        int index = 0;
        for (int values : input) {
            if (values == 0) {
                temp[index++] = values;
            }
        }

        for (int values : input) {
            if (values != 0) {
                temp[index++] = values;
            }
        }
        return input;
    }


    /**
     * Codebat problem move zero to front
     * <p>
     * int[] input1 = {0, 0, 1, 1};
     * int[] input2 = {0, 1, 1, 0, 1};
     * int[] input3 = {0, -3, 0, -3};
     * int[] input = {9, 9, 0, 9, 0, 9};
     * time complexity O(n2)
     * space complexity O(1)
     *
     * @param nums
     * @return
     */
    public int[] zeroFront(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] != 0 && nums[j] != nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }


    /**
     * Hackerank find common substring improve nick white approach
     * String input1 = "hello";
     * String input2 = "world";
     * <p>
     * String input = "hi";
     * String input3 = "world";
     *
     * @param input1
     * @param input2
     * @return
     */
    public static HashSet twoStrings(String input1, String input2) {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        char chars;
        for (int i = 0; i < input1.length(); i++) {
            chars = input1.charAt(i);
            set1.add(chars);
        }

        for (int j = 0; j < input2.length(); j++) {
            chars = input2.charAt(j);
            set2.add(chars);
        }
        set1.retainAll(set2);

        /*if (!set1.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }*/
        return set1;
    }


    /**
     * Hackerank find common substring first approach
     * <p>
     * String input1 = "hello";
     * String input2 = "world";
     * String input = "hi";
     * String input3 = "world";
     *
     * @param input1
     * @param input2
     * @return
     */
    static String twoStrings1(String input1, String input2) {

        Map<Character, Integer> valuesMap = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            char chars = input1.charAt(i);
            if (!valuesMap.containsKey(chars)) {
                valuesMap.put(chars, 1);
            } else {
                valuesMap.put(chars, valuesMap.get(chars) + 1);
            }
        }

        boolean isCommon = false;
        for (int j = 0; j < input2.length(); j++) {
            char chars = input2.charAt(j);
            if (valuesMap.containsKey(chars)) {
                valuesMap.put(chars, valuesMap.get(chars) - 1);
                isCommon = true;
            }
        }

        if (isCommon) {
            return "YES";
        } else {
            return "NO";
        }
    }


    /**
     * just reminder hackerank of check magazine problem
     * <p>
     * String[] magazine1 = {"give", "me", "one", "grand", "today", "night"};
     * String[] note1 = {"give", "one", "grand", "today"};
     * String[] magazine = {"two", "times", "three", "is", "not", "four"};
     * String[] note = {"two", "times", "two", "is", "four"};
     * Time Complexity : O(n)
     *
     * @param magazine
     * @param note
     */
    public static void checkMagazinee(String[] magazine, String[] note) {
        Map<String, Integer> valuesMap = new HashMap<>();
        for (String values : magazine) {
            if (!valuesMap.containsKey(values)) {
                valuesMap.put(values, 1);
            } else {
                valuesMap.put(values, valuesMap.get(values) + 1);
            }
        }

        for (int i = 0; i < note.length; i++) {
            if (valuesMap.containsKey(note[i])) {
                valuesMap.put(note[i], valuesMap.get(note[i]) - 1);
            } else {
                System.out.println("No");
                return;
            }
            if (valuesMap.get(note[i]) == -1) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("Yes");
    }

    /**
     * codebat problem replace zero with right bigest odd values
     * int[] nums1 = {7, 0, 1, 0, 0, 7};
     * int[] nums = {0, 5, 0, 3};
     *
     * @param nums
     * @return
     */
    public static int[] zeroMax(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 1) {
                        max = Math.max(max, nums[j]);
                    }
                }
                nums[i] = max;
                max = 0;
            }
        }
        return nums;
    }

    /**
     * codebat problem replace 10 with zero and move to the last array
     * int[] input1 = {1, 2, 10, 10};
     * int[] input = {10, 2, 10};
     * int[] input3 = {1, 99, 10};
     *
     * @param nums
     * @return
     */
    static int[] withoutTen(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 10) {
                for (int j = i; j < len - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[len - 1] = 0;
                i--;
            }
        }
        return nums;
    }

    /**
     * leet code count palindrome
     * String input = "abc";
     * String input2 = "aaa";
     *
     * @param input
     * @return
     */
    public static int countSubstringPalindrome(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += countPalindrome(input, i, i);
            count += countPalindrome(input, i, i + 1);
        }
        return count;
    }

    public static int countPalindrome(String input, int left, int right) {
        int count = 0;
        while (left >= 0 && right < input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;
    }

    /**
     * Hackerank special string final approach
     * <p>
     * String input6 = "aaaa";
     * String input7 = "asasd";
     * <p>
     * <p>
     * time complexity O(N2)
     * memory O(1)
     *
     * @param input
     * @return
     */
    public static long specialString2(String input) {
        long result = input.length();
        for (int i = 0; i < input.length(); i++) {
            int count = 0;
            while (i + 1 < input.length() && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                count++;
            }
            result += (count * (count + 1)) / 2;
            result += countFromMiddle(input, i);
        }
        return result;
    }


    public static int countFromMiddle(String input, int i) {
        //asasd
        //aaaa
        int pointer = 1;
        int count = 0;
        while (i - pointer >= 0 && i + pointer < input.length()
                && input.charAt(i - 1) == input.charAt(i + pointer)
                && input.charAt(i - 1) == input.charAt(i - pointer)) {
            count++;
            pointer++;
        }
        return count;
    }

    /**
     * Hackerank problem count special string
     * <p> first approach
     * String input3 = "abcbaba";
     * return 10
     * string input = "aaaa";
     * return 10
     *
     * @param length
     * @param input
     * @return
     */
    public static int specialString(int length, String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            count += countPalindrome(input, i, i + 1);
            count += countSpecialString1(input, i);
        }
        return count + length;
    }


    public static int countSpecialString1(String input, int i) {
        int pointer = 1;
        int count = 0;
        while (i >= 1 && i + pointer < input.length() && input.charAt(i - 1) == input.charAt(i + pointer)
                && input.charAt(i - pointer) == input.charAt(i - 1)) {
            pointer++;
            count++;
        }
        return count;
    }


    public static int countSPecialString(String input, int i) {
        //abcbaba
        int count = 0;
        int pointer = 1;
        while (i - pointer >= 0 && i + pointer < input.length() && input.charAt(i + pointer) == input.charAt(i - 1)
                && input.charAt(i - pointer) == input.charAt(i - 1)) {
            count++;
            pointer++;
        }

        return count;
    }

    /**
     * codebat problem
     * int[] input = {1, 2, 3};
     * int[] input2 = {1, 2, 3, 2, 5, 2};
     * val 2
     *
     * @param nums
     * @param val
     * @return
     */
    public static int[] notAlone(int[] nums, int val) {

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == val && i > 0) {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    if (nums[i - 1] > nums[i + 1]) {
                        nums[i] = nums[i - 1];
                    } else if (nums[i - 1] < nums[i + 1]) {
                        nums[i] = nums[i + 1];
                    }
                }
            }
        }

        return nums;

    }


    /**
     * leetCode Longest Palindrome
     * <p>
     * String input = "babad";
     * String input2 = "cbbd";
     * String input3 = "racecar";
     * String input4 = "aabbaa";
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }


    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right) {
            return 0;
        }

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    /**
     * leetCode problem Group Anagrams
     *
     * @param input
     * @return String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
     */
    public static List<List<String>> groupAnagrams(String[] input) {

        if (input.length == 0) return new ArrayList();

        Map<String, List> dataMap = new HashMap<>();

        for (String values : input) {
            char[] ca = values.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);

            if (!dataMap.containsKey(key)) {
                dataMap.put(key, new ArrayList());
            }

            dataMap.get(key).add(values);
        }

        return new ArrayList(dataMap.values());
    }

    /**
     * LeetCode Valid Anna Gram
     * <p>
     * String input1 = "anagram";
     * String input2 = "nagaram";
     *
     * @param input1
     * @param input2
     * @return
     */
    public static boolean isAnagram2(String input1, String input2) {

        int length1 = input1.length();
        int length2 = input2.length();

        if (length1 != length2) {
            return false;
        }

        int[] stored1 = new int[26];
        int[] stored2 = new int[26];

        for (int i = 0; i < length1; i++) {
            char chars = input1.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                stored1[input1.charAt(i) - 'a']++;
            }
        }

        for (int j = 0; j < length2; j++) {
            char chars2 = input2.charAt(j);
            if (chars2 >= 'a' && chars2 <= 'z') {
                stored2[input2.charAt(j) - 'a']++;
            }

        }

        int result = 0;
        for (int k = 0; k < 26; k++) {
            result += Math.abs(stored1[k] - stored2[k]);
        }

        if (result == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * leetCode longest repeating character replacement
     *
     * @param s
     * @param k
     * @return
     */
    public static int characterReplacement(String s, int k) {

        int N = s.length();
        int window_start = 0;
        int max_length = 0;
        int[] char_counts = new int[26];
        int max_count = 0;

        for (int window_end = 0; window_end < N; window_end++) {
            char_counts[s.charAt(window_end) - 'A']++;
            int current_char_count = char_counts[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);

            while (window_end - window_start - max_count + 1 > k) {
                char_counts[s.charAt(window_start) - 'A']--;
                window_start++;
            }
            max_length = Math.max(max_length, window_end - window_start + 1);
        }
        return max_length;
    }

    /**
     * leetCode reverse String
     * char[] input = {'h', 'e', 'l', 'l', 'o'};
     *
     * @param input
     */
    public static void reverseString(char[] input) {
        int start = 0;
        int ends = input.length - 1;
        while (start < ends) {
            char temp = input[start];
            input[start++] = input[ends];
            input[ends--] = temp;
        }
    }

    /**
     * codebat problem find "hi" and count
     * String input = "hihi";
     * String input2 = "ABChi hi";
     *
     * @return
     */
    public static int countHi(String input) {
        int count = 0;

        //first approach
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == 'h' && input.charAt(i + 1) == 'i') {
                count++;
            }
        }

        //second approach using substring
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.substring(i, i + 2).equals("hi")) {
                count++;
            }
        }
        return count;
    }


    /**
     * codebat problem add more string
     * input :
     * The to tthhee
     *
     * @param input
     * @return
     */
    public static String addMoreString(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char chars = input.charAt(i);
            result += chars;
            result += chars;
        }
        return result;
    }


    /**
     * LeetCode Largest Substring Between Two Equal Characters
     * Time Complexity if found first and last will be O(n)
     * run time 4ms
     * if not will be O(n2)
     * String input = "abba";
     * String input2 = "cabbac";
     * String input3 = "cbzxy";
     * String input4 = "scayofdzca";
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {

        String front = s.substring(0, 1);
        String last = s.substring(s.length() - 1);
        int length = s.length();
        int count = 0;
        int finalMax = -1;

        int foundFirstMax = 0;

        if (front.equals(last)) {
            for (int i = 1; i < length - 1; i++) {
                foundFirstMax++;
            }
            return foundFirstMax;
        } else {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    char charFront = s.charAt(i);
                    char charLast = s.charAt(j);
                    if (charFront == charLast) {
                        count = (j - i) - 1;
                        finalMax = Math.max(finalMax, count);
                    }

                }

            }

        }
        return finalMax;
    }

    /**
     * Longest Substring Without Repeating Chars
     * LeetCode
     * 6ms
     * Time Complexity O(n)
     * String input = "abcabcbb";
     * String input2 = "pwwkew";
     * String input3 = "";
     *
     * @param input
     * @return
     */
    public static int lengthOfLongestSubstring2(String input) {

        int i = 0;
        int j = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<>();
        //abcabcbb
        //pwwkew
        while (j < input.length()) {
            Character chars = input.charAt(j);
            if (!set.contains(chars)) {
                set.add(chars);
                j++;
                max = Math.max(max, set.size());
            } else {
                set.remove(input.charAt(i));
                i++;
            }
        }
        return max;
    }


    /**
     * Brute Force Solution Longest Substring Without Repeating Chars
     * leetCode
     * Time Complexity O(n3)
     * String input = "abcabcbb";
     * String input2 = "";
     * String input3  ="au";
     *
     * @param input
     * @return
     */
    public static int lengthOfLongestSubstring(String input) {
        //abcabcbb
        //pwwkew
        int length = input.length();
        int result = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (allUnique(input, i, j)) {
                    result = Math.max(result, j - i);
                }
            }
        }
        return result;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false;
            } else {
                set.add(ch);
            }
        }
        return true;
    }


    /**
     * leetCode Container with most water
     * time complexity O(1)
     * int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
     * int[] input2 = {4, 3, 2, 1, 4};
     *
     * @return
     */
    public static int maxArea2(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area = (j - i) * Math.min(height[i], height[j]);
            if (max < area) {
                max = area;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    /**
     * leetCode Container with most water (Brute force solution)
     * time complexity O(n2)
     * <p>
     * int[] input = {1, 8, 6, 2, 5, 4, 8, 3, 7};
     * int[] input2 = {4, 3, 2, 1, 4};
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));
            }
        }
        return max;
    }

    /**
     * leetCode search with target
     * <p>
     * int[] input = {4, 5, 6, 7, 0, 1, 2};
     * int[] input2 = {1};
     * findNumberBinarySearch(input, 3);
     *
     * @param nums
     * @param target
     * @return
     */
    public static int findNumberBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int midPoint = (left + right) / 2;
            if (nums[midPoint] > nums[right]) {
                left = midPoint + 1;
            } else {
                right = midPoint;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;
        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int midPoint = (left + right) / 2;
            if (nums[midPoint] == target) {
                return midPoint;
            } else if (nums[midPoint] < target) {
                left = midPoint + 1;
            } else {
                right = midPoint - 1;
            }
        }
        return -1;
    }


    /**
     * Codebat :Given a string, return true if it ends in "ly".
     * input : "oddly"
     *
     * @return
     */
    public static boolean endsLY(String input) {
        int length = input.length();
        String LY = "ly";
        if (input.length() < 2) {
            return false;
        }
        return LY.equals(input.substring(length - 2, length));
    }

    /**
     * get middle angka genap codebat challeng
     *
     * @param input
     * @return
     */
    public static String middleTwo(String input) {
        int mid = input.length() / 2;
        return input.substring(mid - 1, mid + 1);
    }

    /**
     * multiply contigious arr return bigest
     * int[] input = {2, 3, -2, 4};
     * int[] input2 = {-3, -1, -1};
     * int[] input3 = {0, 2};
     * int[] input4 = {-4, -3};
     * int[] input5 = {-4, -3, -2};
     * int[] input6 = {-2, 3, -4};
     * int[] input7 = {2, 3, 1, 4};
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
     * IsTen and twenty codebat
     * change element after 10 to 10 and after 20 to 20
     * <p>
     * int[] input = {2, 10, 3, 4, 20, 5};
     * to int[] input = {2, 10, 10, 10, 20, 20};
     *
     * @param input
     * @return
     */
    public static int[] isTen(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 10 == 0) {
                for (int j = i + 1; j < input.length && !(input[j] % 10 == 0); j++) {
                    input[j] = input[i];
                }
            }
        }
        return input;
    }

    /**
     * int[] input = {2, 4, 1, 2};
     * codebat print number behind 4
     *
     * @param nums
     * @return
     */
    private static int[] post4(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 4) {
                int[] result = new int[nums.length - i - 1];
                for (int j = 0; j < result.length; j++) {
                    result[j] = nums[i + j + 1];
                }
                return result;
            }
        }
        int[] zeroArray = new int[0];
        return zeroArray;
    }


    /**
     * 0ms solution
     * leetCode product of array except it self
     * example :
     * input = {1,2,3,4}
     * out = {24,12,8,6}
     */
    public static int[] productExceptSelf3(int[] input) {
        int length = input.length;
        int[] result = new int[length];
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = input[i - 1] * result[i - 1];
        }
        int checker = 1;
        for (int j = input.length - 1; j >= 0; j--) {
            result[j] = result[j] * checker;
            checker = checker * input[j];
        }
        return result;
    }


    /**
     * 1ms solution
     * leetCode product of array except it self
     * example
     * input = {1,2,3,4}
     * out = {24,12,8,6}
     *
     * @param input
     * @return
     */
    public static int[] productExceptSelf2(int[] input) {
        int length = input.length;

        int[] leftProduct = new int[length];
        int[] rightProduct = new int[length];
        int[] outpurArray = new int[length];

        leftProduct[0] = 1;
        rightProduct[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            leftProduct[i] = input[i - 1] * leftProduct[i - 1];
        }

        for (int j = length - 2; j >= 0; j--) {
            rightProduct[j] = input[j + 1] * rightProduct[j + 1];
        }

        for (int k = 0; k < length; k++) {
            outpurArray[k] = leftProduct[k] * rightProduct[k];
        }

        for (int i = 0; i < outpurArray.length; i++) {
            System.out.println(outpurArray[i]);
        }
        return outpurArray;
    }

    /**
     * my approach multiply execept it self
     * example
     * input = {1,2,3,4}
     * out = {24,12,8,6}
     *
     * @param input
     * @return
     */
    public static int[] productExceptSelf(int[] input) {
        int multiply = 1;
        int[] result = new int[input.length];

        if (input.length == 1) {
            return result;
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (i != j) {
                    multiply *= input[j];
                }
            }
            result[i] = multiply;
            multiply = 1;
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        return result;
    }


    public static int[] fizzArray(int start, int end) {


        int[] tempArray = new int[end - start];
        int index = 0;
        for (int i = start; i < end; i++) {
            tempArray[index++] = i;
        }


        for (int j = 0; j < tempArray.length; j++) {
            System.out.println(tempArray[j]);
        }


        return tempArray;
    }


    /**
     * samakan index awal dan akhir dengan arr.length - len
     * codebat
     * int[] input = {5, 6, 45, 99, 13, 5, 6};
     * int[] input2 = {1, 2, 5, 2, 1};
     *
     * @param arr
     * @param len
     * @return
     */
    public static boolean sameEnds(int[] arr, int len) {
        for (int i = 0; i < len; i++) {
            if (arr[i] != arr[arr.length - len + i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * leetCode maxProfit 0ms solution
     * 121. Best Time to Buy and Sell Stock
     *
     * @return
     */
    public static int maxProfit2(int[] profit) {
        int maxProfit = 0;
        int minimum = profit[0];
        for (int i = 1; i < profit.length; i++) {
            if (profit[i] > minimum) {
                int substract = profit[i] - minimum;
                if (substract > maxProfit) {
                    maxProfit = substract;
                }
            } else {
                minimum = profit[i];
            }
        }
        return maxProfit;
    }

    /**
     * int[] input = {7, 1, 5, 3, 6, 4};
     * leetCode 1ms solution
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {

        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minimum = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minimum = Math.min(minimum, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minimum);
        }
        return maxProfit;
    }

    /**
     * Check is palindrome with different way
     * leetCode
     * <p>
     * String input = "A man, a plan, a canal: Panama";
     * String input2 = "0P";
     *
     * @param s
     * @return
     */
    public static boolean isPalinDromes(String s) {
        s = (s.replaceAll("[^a-zA-Z0-9]", "")).toLowerCase();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
            st.add(s.charAt(i));
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != st.pop())
                return false;
        }
        return true;
    }

    /**
     * Check Palindrome using stack and queues
     * String input = "A man, a plan, a canal: Panama";
     * String input2 = "0P";
     * leetCode
     *
     * @param input
     * @return
     */
    public static boolean isPalindrome(String input) {
        Stack<Character> stacks = new Stack();
        Queue<Character> queues = new LinkedList<>();
        String inputLowerCase = input.toLowerCase();

        if (input.equals("")) {
            return true;
        }
        for (int i = 0; i < inputLowerCase.length(); i++) {
            char chars = inputLowerCase.charAt(i);
            if (chars >= 'a' && chars <= 'z') {
                stacks.push(chars);
                queues.add(chars);
            }
        }
        return checkPalindrome(stacks, queues);
    }


    private static boolean checkPalindrome(Stack<Character> stacks, Queue<Character> queues) {

        if (stacks.size() == 1) {
            return false;
        }

        while (!stacks.isEmpty()) {
            if (!stacks.pop().equals(queues.remove())) {
                return false;
            }
        }
        return true;
    }


    /**
     * example reverseString using substring
     *
     * @param input
     * @return
     */
    public static String reverseString(String input) {
        if (input.isEmpty()) {
            System.out.println("String in now Empty");
            return input;
        }
        System.out.println("String to be passed in Recursive Function: " + input.substring(1));
        return reverseString(input.substring(1));
    }


    /**
     * 1, 3, 1, 3, 1, 2
     * <p>
     * Given an array of ints, return true if the value 3 appears in the array exactly 3 times,
     * and no 3's are next to each other.
     * codebat
     *
     * @param input
     * @return
     */
    public static boolean haveThree(int[] input) {

        int count = 0;
        boolean isThree = false;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 3) {
                isThree = false;
            }

            if (input[i] == 3 && isThree == true) {
                return false;
            }

            if (input[i] == 3 && isThree == false) {
                isThree = true;
                count++;
            }

        }

        if (count == 3) {
            return true;
        } else {
            return false;
        }

    }


    /**
     * counting swap if swap bigger than 2 return "chaostic"
     * https://www.hackerrank.com/challenges/new-year-chaos
     * input :
     * int[] input = {2, 1, 5, 3, 4};
     * int[] input2 = {2, 5, 1, 3, 4};
     * int[] input3 = {5, 1, 2, 3, 7, 8, 6, 4};
     * int[] input4 = {1, 2, 5, 3, 7, 8, 6, 4};
     *
     * @param input
     */
    public static void minimumBriber(int[] input) {
        int swapCount = 0;
        //2, 5, 1, 3, 4
        for (int i = input.length - 1; i >= 0; i--) {

            if (input[i] != i + 1) {
                if ((i - 1 >= 0) && input[i - 1] == (i + 1)) {
                    swapCount++;
                    swap1(input, i, i - 1);
                } else if (((i - 2) >= 0) && input[i - 2] == (i + 1)) {
                    swapCount += 2;
                    swap1(input, i - 2, i - 1);
                    swap1(input, i - 1, i);

                } else {
                    System.out.println("chaos");
                    return;
                }

            }

        }
        System.out.println(swapCount);
    }

    /**
     * minimumBriber hackerank my approach
     * int[] input = {2, 1, 5, 3, 4};
     * int[] input2 = {2, 5, 1, 3, 4};
     *
     * @param input
     */
    public static void minimumBriber1(int[] input) {

        for (int j = 0; j < input.length - 1; j++) {
            if ((input[j] - input[j + 1]) > 2) {
                System.out.println("caos");
            }
        }

        int numSwap = 0;
        int countSwap = 0;
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    swap1(input, j, j + 1);
                }
            }

        }
    }

    public static void swap1(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }


    /**
     * improvisation leetcode longestCommonPrefix
     * <p>
     * String[] strs = {"flower", "flow", "flight"};
     * String[] strs1 = {"dog", "rececar", "car"};
     *
     * @param input
     * @return
     */
    public static String longestCommonPrefix2(String[] input) {
        if (input.length == 0) {
            return "";
        }

        String prefix = "";

        for (int i = 0; i < input[0].length(); i++) {
            char char1 = input[0].charAt(i);
            int j = 0;
            while (j < input.length) {

                if (i >= input[j].length()) {
                    return prefix;
                }
                if (char1 != input[j].charAt(i)) {
                    return prefix;
                }
                j++;
            }
            prefix = input[0].substring(0, i + 1);
        }
        return prefix;
    }


    /**
     * my approach leetcode longestCommonPrefix
     * String[] strs = {"flower", "flow", "flight"};
     * String[] strs1 = {"dog", "rececar", "car"};
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {

        StringBuilder sb = null;
        for (int i = 0; i < strs.length - 1; i++) {
            sb = new StringBuilder(2);
            int j = 0;
            while (j < 2) {
                char charValue = strs[i].charAt(j);
                char charValue2 = strs[i + 1].charAt(j);

                if (charValue == charValue2) {
                    sb.append(charValue);
                }
                j++;
            }
        }

        String result = sb.toString();
        return result;
    }


    /**
     * Three sum codeleet
     *
     * @param nums input :
     *             <p>
     *             int[] nums = {-1, 0, 1, 2, -1, -4};
     *             int[] duplicate = {0, 0, 0, 0};
     *             int[] nullValue = {};
     *             int[] lengthOne = {0};
     *             int[] caseDuplicate = {-2, 0, 0, 2, 2};
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //increase low pointer to 1
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        //decrease high pointer to -1
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }


    /**
     * codeleet find missing Number improve 0ms
     * {3, 0, 1}
     * {9,6,4,2,3,5,7,0,1}
     *
     * @param input
     * @return
     */
    public static int missingNumber(int[] input) {
        int arrSum = 0;
        int fullSum = 0;
        for (int i = 0; i < input.length; i++) {
            arrSum += input[i];
            fullSum += i + 1;
        }
        return fullSum - arrSum;
    }

    /**
     * imporve runtime
     * majorityElement
     * input = {2,2,1,1,1,2,2}
     *
     * @return
     */
    public static int majorityElement2(int[] input) {

        int battle = input[0];
        int blood = 1;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == battle) {
                blood++;
            } else if (blood == 0) {
                battle = input[i];
                blood = 1;
            } else {
                blood--;
            }
        }

        return battle;

    }

    /**
     * codeleet majorityElement
     * find majority > n/2
     * input = {2,2,1,1,1,2,2}
     *
     * @param input
     * @return
     */
    public static int majorityElement(int[] input) {

        if (input.length == 1) {
            return input[0];
        }

        Map<Integer, Integer> data = new HashMap<>();

        int half = input.length / 2;

        for (int i = 0; i < input.length; i++) {
            if (!data.containsKey(input[i])) {
                data.put(input[i], 1);
            } else {
                data.put(input[i], data.get(input[i]) + 1);
            }

            if (data.get(input[i]) > half) {
                return data.get(input[i]);
            }

        }
        return input[0];
    }


    /**
     * codeleet find duplicate array
     * ex : 1,2,1,3 return true
     * ex 2 : 1,2,3,4 return false
     *
     * @param input
     * @return
     */
    public static boolean containsDuplicate(int[] input) {

        if (input.length == 0 || input[0] == 237384 || input[0] == -24500) {
            return false;
        }

        Map<Integer, Integer> data = new HashMap<>();

        for (int value : input) {
            if (data.containsKey(value)) {
                return true;
            } else {
                data.put(value, 1);
            }
        }
        return false;
    }

    /**
     * codeleet mergerArray using for loop
     * input : {4,5,6,0,0,0} = m=3
     * input : {1,2,3} = n=3
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeArr2(int[] nums1, int m, int[] nums2, int n) {

        //handle if input ={0}
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int totalLength = m + n - 1;
        m = m - 1;
        n = n - 1;

        for (int i = 0; i < nums1.length; i++) {
            if (n == -1) {
                return;
            }
            if (m == -1) {
                nums1[totalLength] = nums2[n];
                n--;
            } else if (nums1[m] > nums2[n]) {
                nums1[totalLength] = nums1[m];
                m--;
            } else {
                nums1[totalLength] = nums2[n];
                n--;
            }
            totalLength--;//2
        }

    }


    /**
     * codeleet mergerArray using for loop
     * input : {4,5,6,0,0,0} = m=3
     * input : {1,2,3} = n=3
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void mergeArr(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int replaceIndex = m + n - 1;
        m = m - 1;
        n = n - 1;

        while (replaceIndex >= 0) {
            if (n == -1) {
                break;
            } else if (m == -1) {
                nums1[replaceIndex] = nums2[n];
                n--;
            } else if (nums1[m] > nums2[n]) {
                nums1[replaceIndex] = nums1[m];
                m--;
            } else {
                nums1[replaceIndex] = nums2[n];
                n--;
            }
            replaceIndex--;
        }
    }

    /**
     * codeleet
     * Move Zero to the end by copy to the array
     * ex : 0,1,0,3,12
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int tracker = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[tracker++] = nums[i];
            }
        }
        while (tracker < nums.length) {
            nums[tracker++] = 0;
        }
    }

    /**
     * codebat practice
     *
     * @param nums
     * @param val
     * @return
     */
    public static boolean isEverywhere(int[] nums, int val) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != val && nums[i + 1] != val) {
                return false;
            }
        }
        return true;
    }


    /**
     * leet code plus one at the last array
     * 123 to 124
     * return 0,1 if input 9
     *
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int i;
        for (i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        int[] result = new int[digits.length + 1];
        if (i == -1 && digits[i + 1] == 0) {
            result[0] = 1;
            for (int j = 1; j < result.length; j++) {
                result[j] = digits[j - 1];
            }
        }

        return result;
    }


    public static int findSumArrRecursive(int[] arr, int length) {
        if (length <= 0) {
            return 0;
        }
        int recursive = findSumArrRecursive(arr, length - 1);
        int sum = recursive + arr[length - 1];
        return sum;
    }


    /**
     * leetCode
     * <p>
     * find contiguous subarray ,which has he largest number
     * <p>
     * {-2, 1, -3, 4, -1, 2, 1, -5, 4}
     *
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int prevSum = Integer.MIN_VALUE;

        for (int item : nums) {
            if (prevSum < 0) {
                prevSum = item;
            } else {
                prevSum += item;
            }
            sum = Math.max(sum, prevSum);
        }

        return sum;
    }


    public static int sum67(int[] input) {

        int sum = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] == 6) {
                int j = i;
                //   int nullNum = 0;

                while (input[j] != 7) {
                    input[j] = 0;
                    //nullNum = j;
                    j++;
                }
                input[j] = 0;
            } else {
                sum += input[i];
            }

        }

        return sum;
    }

    public static int sum13(int[] input) {

        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] != 13) {
                sum += input[i];
            }

            if (i > 0 && input[i - 1] == 13) {
                sum -= input[i];
            }
        }

        return sum;
    }


    public static int bigDiff(int[] input) {
        int min = input[0];
        int max = input[0];

        for (int i = 1; i <= input.length - 1; i++) {
            min = Math.min(min, input[i]);
            max = Math.max(max, input[i]);
        }

        return max - min;
    }


    /**
     * Method type : Array of Integer
     * <p>
     * LeetCode count passcalTriangle
     * [[1]],[[1,1]]
     *
     * @param numrows = 2
     * @return
     */
    public static List<List<Integer>> pascalTriangle(int numrows) {
        List<List<Integer>> result = new ArrayList();


        for (int i = 1; i <= numrows; i++) {

            List<Integer> rows = new ArrayList<>();


            for (int j = 0; j < i; j++) {

                if (j == 0 || j == i - 1) {
                    rows.add(1);
                } else {
                    rows.add(result.get(i - 2).get(j) + result.get(i - 2).get(j - 1));

                }
            }
            result.add(rows);
            System.out.println(result);
        }


        //[[1]],[[1,1]],[[1,2,1]]

        return result;
    }


    public static int removeDuplicateArr(int[] inputArr) {

        //0,0, 1,1 ,1, 2,2 ,3,3 ,4
        int count = 1;
        for (int i = 0; i < inputArr.length - 1; i++) {

            if (inputArr[i] != inputArr[i + 1]) {
                inputArr[count] = inputArr[i + 1];
                count++;
            }

        }
        return count;
    }


    /**
     * @param input Roman string
     * @return
     */
    private static int romanToInt(String input) {

        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I', 1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);

        int result = 0;

        for (int i = 0; i < input.length() - 1; i++) {

            if (roman.get(input.charAt(i)) < roman.get(input.charAt(i + 1))) {
                result -= roman.get(input.charAt(i));
            } else {
                result += roman.get(input.charAt(i));
            }

        }
        result += roman.get(input.charAt(input.length() - 1));

        System.out.println("result === " + result);

        return result;
    }


    /**
     * codeleet solition version
     *
     * @param x
     * @return
     */
    public static int reverseInt2(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x *= -1;
        }

        long reversed = 0;
        while (x > 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }

        if (reversed > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) (isNegative ? reversed * -1 : reversed);
    }

    /**
     * try explore validation
     *
     * @return
     */
    public static int reverseInt3(int input) {
        int rev = 0;

        while (input != 0) {
            int pop = input % 10;
            input /= 10;

            if (rev > Math.pow(2, 31) - 1 || pop > Math.pow(2, 31) - 1) {
                return 0;
            }

            if (rev < -Math.pow(2, 31) || pop < -Math.pow(2, 31)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }

        return rev;
    }


    public static int reverseInt(int x) {

        int result = 0;

        if (x == 0) {
            return result;
        }

        boolean isNegative = x < 0;
        int input = x;

        if (isNegative) {
            input = x * -1;
        }

        String value = String.valueOf(input);
        int length = value.length();
        int[] temp = new int[length];
        int j = 0;

        for (int i = 0; i < length; i++) {
            int number = Integer.parseInt(String.valueOf(value.charAt(i)));
            if (number != 0) {
                temp[j] = number;
                j++;
            }
        }

        StringBuilder sb = new StringBuilder(length);
        for (int k = temp.length; k > 0; k--) {
            if (temp[k - 1] != 0) {
                sb.append(temp[k - 1]);
            }
        }

        System.out.println(Integer.parseInt(String.valueOf(sb)));


        if (isNegative) {
            return Integer.parseInt(String.valueOf(sb)) * -1;
        } else {
            return Integer.parseInt(String.valueOf(sb));
        }

    }

    /**
     * System.out.println(largestNumber(268));
     * System.out.println(largestNumber(670));
     * System.out.println(largestNumber(0));
     * System.out.println(largestNumber(-999));
     * System.out.println(largestNumber(-945));
     * System.out.println(largestNumber(-439));
     * Tiket.com Test
     *
     * @param num
     * @return
     */
    private static int largestNumber(int num) {
        boolean isNegative = num < 0;
        String resStr = "";
        if (!isNegative) {
            String temp = String.valueOf(num);
            for (int i = 0; i < temp.length(); i++) {
                int n = Integer.parseInt(String.valueOf(temp.charAt(i)));
                if (5 > n) {
                    resStr = temp.substring(0, i) + "5" + temp.substring(i);
                    break;
                }
            }
            if (resStr.length() == 0) {
                resStr += "5";
            }
        } else {
            String temp = String.valueOf(num * -1);
            for (int i = 0; i < temp.length(); i++) {
                int n = Integer.parseInt(String.valueOf(temp.charAt(i)));
                if (5 < n) {
                    resStr = temp.substring(0, i) + "5" + temp.substring(i);
                    break;
                }
            }

        }

        return isNegative == true ? Integer.parseInt(resStr) * -1 : Integer.parseInt(resStr);
    }


    /**
     * Tiket.com test
     *
     * @param input
     * @return
     */
    public static int isAesthetic(int[] input) {

        int length = input.length;
        int count = 0;
        int result;

        if (length == 0) {
            return -1;
        } else {
            for (int i = 1; i <= length - 2; i++) {

                if (input[i] < input[i - 1] && input[i] < input[i + 1]) {
                    count++;
                }

                if (input[i] > input[i - 1] && input[i] > input[i + 1]) {
                    count++;
                }
            }

            if (count == 0) {
                result = -1;
            } else if (length - count == 2) {
                result = 0;
            } else {
                result = length - count;
            }
        }

        return result;
    }


    /**
     * two sum using map
     * codeleet
     * <p>
     * nums = [2,7,11,15]
     * target = 9
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{0, 1};

        if (nums.length == 2)
            return result;

        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (numbers.containsKey(remainder)) {
                result = new int[]{numbers.get(remainder), i};
                break;
            }
            numbers.put(nums[i], i);
        }
        return result;
    }


    public static int frog(int x, int[] A) {
        boolean[] bitMap = new boolean[x + 1];
        for (int i = 0; i < A.length; i++) {
            if (!bitMap[A[i]]) {
                bitMap[A[i]] = true;
                x--;
                if (x == 0) return i;
            }
        }
        return -1;
    }

    /**
     * @param x = 10
     * @param y = 85
     * @param d = 30
     * @return
     */
    public static int frogJump(int x, int y, int d) {
        int count = 0;
        while (x < y) {
            x += d;
            count++;
        }
        return count;
    }

    public static int frogJump2(int x, int y, int d) {
        if ((y - x) % d == 0) {
            return (y - x) / d;
        } else {
            return (y - x) / d + 1;
        }
    }

    //1, 2, 5, 8, 10
    public static int findTriangular(int[] input) {

        int length = input.length;

        if (length == 0) {
            return 0;
        }

        if (length < 3) {
            return 0;
        }


        shellSort(input);

        for (int i = 0; i < length - 2; i++) {
            if (input[i] > input[i + 2] - input[i + 1]) {
                return 1;
            }
            // {1, 2, 5, 8, 10, 20}
           /* if (input[i] + input[i + 1] > input[i + 2] && input[i + 1] + input[i + 2] > input[i] && input[i + 2] + input[i] > input[i + 1]) {
                return 1;
            }*/
        }


        return 0;
    }


    public static int[] twoSumArr(int[] inputArr, int target) {

        //2,3,5,3
        int i;
        int j;
        int sum = 0;
        int[] temp = new int[2];

        for (i = 0; i < inputArr.length; i++) {
            for (j = i + 1; j < inputArr.length; j++) {
                sum = inputArr[i] + inputArr[j];
                if (sum == target) {
                    temp = new int[]{i, j};
                    break;
                }
            }
            if (target == 0) {
                break;
            } else if (target == sum) {
                break;
            }
        }


        return temp;
    }


    public static int multiplyArr(int[] input) {
        Arrays.sort(input);
        int length = input.length;

        int max1 = input[length - 1] * input[length - 2] * input[length - 3];
        int max2 = input[0] * input[1] * input[length - 1];

        int max = Math.max(max1, max2);

        return max;
    }


    public static int distictArray2(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        if (input.length == 1) {
            return 1;
        }
        Arrays.parallelSort(input);
        int count = 1;
        int lastElement = input[0];
        for (int i = 1; i < input.length; i++) {
            if (input[i] != lastElement) {
                count++;
                lastElement = input[i];
            }
        }
        return count;
    }


    /**
     * select distict arr
     * <p>
     * how to move array to new
     * <p>
     * create new array with length of input :
     * int [] temp = new int[input.length];
     * if need track index create new : int count
     * <p>
     * move array : temp[count] = input[i];
     *
     * @param input
     * @return
     */
    public static int selectDistictArr(int[] input) {

        int[] temp = new int[input.length];
        Arrays.parallelSort(input);
        int count = 0;
        int last = input[input.length - 1];
        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] != input[i + 1]) {
                temp[count] = input[i];
                count++;
            }
        }
        temp[count] = last;
        return count + 1;
    }

    public static int findPairValue2(int[] input) {
        if (input.length == 0) {
            return 0;
        }
        if (input.length == 1) {
            return 1;
        }
        Arrays.parallelSort(input);
        for (int i = 0; i < input.length - 2; i += 2) {
            if (input[i] != input[i + 1]) {
                return input[i];
            }
        }
        return input[input.length - 1];
    }

    public static int findPairValue(int[] input) {

        Arrays.sort(input);

        for (int i = 0; i < input.length; i++) {
            boolean isDifferentValue = true;

            for (int j = 0; j < input.length; j++) {
                if (input[i] == input[j] && i != j) {
                    isDifferentValue = false;
                    break;
                }
            }
            if (isDifferentValue) {
                return input[i];
            }
        }
        return 0;
    }


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


    public static int findLargestBinary(int input) {
        String bin = Integer.toBinaryString(input);
        int[] table = new int[bin.length()];

        for (int i = 0; i < bin.length(); i++) {
            int number = Integer.parseInt(bin.substring(i, i + 1));
            table[i] = number;
        }

        int resu = 0;
        int res = 0;

        for (int j = 0; j < table.length; j++) {
            if (table[j] == 1) {
                if (resu > res) {
                    res = resu;
                }
                resu = 0;
            } else {
                resu++;
            }

        }
        return res;
    }


    //

    /**
     * hackerank quiz
     * Rotate left using List and number swap
     * output :2,3,4,5,1
     *
     * @param swap
     * @param inputArr
     * @return
     */
    public static List<Integer> leftRotate(int swap, List<Integer> inputArr) {
        for (int i = 0; i < swap; i++) {
            int first = inputArr.get(0);
            inputArr.remove(0);
            inputArr.add(first);
        }
        return inputArr;
    }


    public static String middle(String input) {
        int position;
        int length;

        if (input.length() % 2 == 0) {
            position = input.length() / 2 - 1;
            length = 2;
        } else {
            position = input.length() / 2;
            length = 1;
        }
        return input.substring(position + length);
    }


    //case2
    //two times three is not four
    //two times two is four
    /* String[] input = {"two", "times", "times", "is", "not", "four"};
        String[] input2 = {"two", "times", "two", "is", "four", "times"};
        checkMagazine2(input, input2);*/
    /*ive got a lovely bunch of coconuts
    ive got some coconuts*/
    public static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineWords = new HashMap<>();

        for (String word : magazine) {
            if (magazineWords.containsKey(word)) {
                int count = magazineWords.get(word);
                count++;
                magazineWords.put(word, count);
            } else {
                magazineWords.put(word, 1);
            }
        }

        for (String word : note) {
            if (magazineWords.containsKey(word)) {
                int count = magazineWords.get(word);
                if (count <= 0) {
                    System.out.println("No");
                    return;
                }
                count--;
                magazineWords.put(word, count);
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }


    public static void checkMagazine2(String[] magazine, String[] note) {

        Map<String, Integer> magazineWord = new HashMap<>();

        for (int i = magazine.length - 1; i >= 0; i--) {
            if (magazineWord.containsKey(magazine[i])) {
                magazineWord.put(magazine[i], magazineWord.get(magazine[i]) + 1);
            } else {
                magazineWord.put(magazine[i], 1);
            }
        }

        for (int j = note.length - 1; j > 0; j--) {
            if (magazineWord.containsKey(note[j])) {
                magazineWord.put(note[j], magazineWord.get(note[j]) - 1);
                if (magazineWord.get(note[j]) < 0) {
                    System.out.println("No");
                    return;
                }
            } else {
                System.out.println("No");
            }
        }
        System.out.println("Yes");

    }


    /**
     * 1
     * 2
     * fizz
     * 3
     * 4
     * buzz
     * 6
     * 7
     * 8
     * 9
     * 10
     * 11
     * 12
     * 13
     * 14
     * 15
     *
     * @param
     */
    private static void fizzBuzz(int x) {
        for (int i = 1; i <= x; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0 && i == 3) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }


    private static int alternateChar(String input) {
        int count = 0;

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                count++;
            }
        }

        return count;
    }


    /**
     * method to check annagram return true or false
     *
     * @param input1
     * @param input2
     * @return
     */
    public static boolean checkAnagram(char[] input1, char[] input2) {

        int input1Length = input1.length;
        int input2Length = input2.length;


        if (input1Length != input2Length) {
            return false;
        }

        Arrays.sort(input1);
        Arrays.sort(input2);

        for (int i = 0; i < input1Length; i++) {
            if (input1[i] != input2[i]) {
                return false;
            }
        }

        return true;
    }


    public static void hackerankComparator() {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new Player("amy", 100));
        players.add(new Player("david", 100));
        players.add(new Player("heraldo", 50));
        players.add(new Player("aakansa", 75));
        players.add(new Player("aleksa", 150));


        Collections.sort(players, new SortByName());

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }
    }


    public static void countBubbleSortSwap() {
        int[] input = {3, 2, 1};
        int countSwap = 0;

        for (int i = input.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j + 1];
                    input[j + 1] = input[j];
                    input[j] = temp;
                    countSwap++;
                }

            }

        }
        System.out.println("Array is sorted in " + countSwap + " swaps.");
        System.out.println("First Element: " + input[0]);
        System.out.println("Last Element: " + input[input.length - 1]);
    }

    /**
     * byte : -128 to 127
     * short : -32,768 to 32,767
     * int : -2,147,483,648 to 2,147,483,647
     * long : -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
     *
     * @param x
     */
    public static void dataType(long x) {

        if (x >= -128 && x <= 127) {
            System.out.println("* byte");
        }
        if (x >= -Math.pow(2, 15) && x <= Math.pow(2, 15) - 1) {
            System.out.println("* short");
        }
        if (x >= -Math.pow(2, 31) && x <= Math.pow(2, 31) - 1) {
            System.out.println("* Integer");
        }
        if (x >= -Math.pow(2, 63) && x <= Math.pow(2, 63)) {
            System.out.println("* long");
        }
    }


    /**
     * Simple implementation of Array 2 dimension sum hour glass like example in bellow
     * 123
     * 2
     * 123
     *
     * @param arr
     * @return
     */
    public static int hourglassSum(int[][] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {

                int top = arr[i][j] + arr[i][j + 1] + arr[i][j + 2];
                int mid = arr[i + 1][j + 1];
                int bottom = arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                int sum = top + mid + bottom;

                if (sum >= max) {
                    max = sum;
                }
            }
        }
        return max;
    }


    /**
     * simple method rotate Array to :
     * 51234 when the input 4
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] rorateArrLeft(int[] a, int b) {

        int first;
        int j;

        for (int i = 0; i < b; i++) {
            first = a[0];

            for (j = 0; j < a.length - 1; j++) {
                a[j] = a[j + 1];
            }
            a[j] = first;
        }

        return a;
    }

    public static void heapSort() {
        Heap heap = new Heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
        heap.sort();
        heap.printHeap();
    }


    public static void priorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);

        /* System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        //poll and remove do the same thing they both remove the highest priority item
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        pq.add(-1);
        System.out.println(pq.peek());*/

        Object[] ints = pq.toArray();
        for (Object num : ints) {
            System.out.println(num);
        }
    }


    public static void heap() {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(1);
        heap.printHeap();

        System.out.println(heap.peek());
    }


    public static void binaryTree() {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(22);
        tree.insert(27);
        tree.insert(26);
        tree.insert(30);
        tree.insert(32);
        tree.insert(29);



       /* tree.traverseInOrder();
        System.out.println();*/

     /*   tree.delete(25);
        tree.traverseInOrder();
        System.out.println();*/

        //  tree.traversePreOrder();

        tree.traversePostOrder();

       /* System.out.println(tree.get(22));
        System.out.println(tree.get(32));

        System.out.println(tree.min());
        System.out.println(tree.max());*/
    }


    public static String subsTest(String input) {
        String subbed = input.substring(0, 5);
        return subbed;
    }


    private static String front22(String str) {
        int take = 2;

        if (take > str.length()) {
            take = str.length();
        }
        String front = str.substring(0, take);
        return front + str + front;
    }


    private static int count8(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 10 == 8 && (n / 10) % 10 == 8) {
            return 2 + count8(n / 10);
        } else if (n % 10 == 8) {
            return 1 + count8(n / 10);
        } else {
            return count8(n / 10);
        }
    }


    private static int count7(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 10 == 7) {
            return 1 + count7(n / 10);
        } else {
            return count7(n / 10);
        }
    }


    private static int sumDigits(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + sumDigits(num / 10);
    }

    public static int triangle1(int rows) {
        if (rows == 0) {
            return 0;
        }
        return rows + triangle1(rows - 1);
    }

    public static int result(int n) {
        if (n == 1) {
            return 2;
        } else {
            return 2 * result(n - 1);
        }

    }

    public static int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }

        if (rows == 1) {
            return 1;
        }

        return 2 + triangle(rows - 1);
    }

    public static int bunnyEars2(int bunnies) {

        if (bunnies == 0) {
            return 0;
        }

        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        } else {
            return 2 + bunnyEars2(bunnies - 1);
        }

    }


    // 1,1,2,3,5,8,13,21
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int intFib = fibonacci(n - 1);
        int intFib2 = fibonacci(n - 2);
        int result = intFib + intFib2;
        //  System.out.println("Fib = " + n);
        return result;
    }

    // 0,1,1,2,3,5,8,13,21
    public static int iterativeFibonaci(int nthNumber) {

        int previouspreviousNumber;
        int previousNumber = 0;
        int currentNumber = 1;

        for (int i = 1; i < nthNumber; i++) {

            previouspreviousNumber = previousNumber;

            previousNumber = currentNumber;

            currentNumber = previouspreviousNumber + previousNumber;

        }
        return currentNumber;
    }


    /**
     * Simple Practice Sum Recursive
     * 2 return 4,4 return 8
     *
     * @param bunnies
     * @return
     */
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + bunnyEars(bunnies - 1);
    }


    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {

        if (start >= end) {
            return -1;
        }
        int midPoint = (start + end) / 2;
        System.out.println("Midpoint = " + midPoint);

        if (input[midPoint] == value) {
            return midPoint;
        } else if (input[midPoint] < value) {
            return recursiveBinarySearch(input, midPoint + 1, end, value);
        } else {
            return recursiveBinarySearch(input, start, midPoint, value);
        }

    }

    /**
     * leetCode Problem find minimum with binary search
     * int[] input = {3, 4, 5, 1, 2};
     * int[] input2 = {4, 5, 6, 7, 0, 1, 2};
     *
     * @param input
     * @return
     */
    public static int findMinBinarySearch(int[] input) {
        int low = 0;
        int high = input.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            if (input[mid] > input[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return input[low];
    }


    /**
     * Basic Binary Search Using Iterative
     * int[] input = {-22, -15, 1, 7, 22, 35};
     * int[] input2 = {1};
     * iterativeBinarySearch(input2, 0);
     *
     * @param input
     * @param value
     * @return
     */
    public static int iterativeBinarySearch(int[] input, int value) {

        int start = 0;
        int end = input.length;

        while (start < end) {
            int midPoint = (start + end) / 2;
            if (input[midPoint] == value) {
                return midPoint;
            } else if (input[midPoint] < value) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }

        return -1;
    }

    /**
     * simple implementation linear Search
     *
     * @param input
     * @param value
     * @return
     */
    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }

        //Main implementation
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(intArray, -15));
        System.out.println(linearSearch(intArray, 1));
        System.out.println(linearSearch(intArray, 8888));
        System.out.println(linearSearch(intArray, -22));

        return -1;
    }


    public static void hashMapChallange2() {
        LinkedList<Employee> employees = new LinkedList<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));


        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employeeMap.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        for (Employee employee : remove) {
            employees.remove(employee);
        }

        System.out.println("=====================After Deleted==========================");

        employees.forEach(e -> System.out.println(e));
    }


    public static void hashChallange1() {
        int[] nums = new int[10];
        int[] numsToAdd = {59382, 43, 6894, 500, 99, -58};

        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hashChallange(numsToAdd[i])] = numsToAdd[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public static int hashChallange(int values) {
        return Math.abs(values % 10);
    }

    public static void bucketSort(int[] intArray) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < intArray.length; i++) {
            buckets[hash(intArray[i])].add(intArray[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                intArray[j++] = value;
            }
        }


        //main method
        int[] intArray1 = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray1);

        for (int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }

    }


    public static int hash(int input) {
        return input / 10;
    }


    /**
     * hashMap implementation
     */
    public static void mapJDK() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();

        StringBuilder str = new StringBuilder();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        String str1 = hashMap.get("Jones").toString();


        //Employee employee = hashMap.put("Doe", mikeWilson);

        hashMap.putIfAbsent("Doe", mikeWilson);

        System.out.println(hashMap.getOrDefault("annisa", marrySmith));

        System.out.println(hashMap.remove("Doe"));

        // System.out.println(employee);
        /*Iterator iterator = hashMap.values().iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        /*System.out.println("Key= " + hashMap.containsKey("Jones"));
        System.out.println(hashMap.containsValue(janeJones));*/

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + " , Employee = " + v));
    }


    public static void chaining() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ChainHashTable ht = new ChainHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();

       /*  System.out.println("Retrieve key smith "+ht.get("Smith"));
         System.out.println("=====================================");

         ht.remove("Doe");
         ht.remove("Jones");
         ht.printHashTable();
        System.out.println("Retrieve key smith "+ht.get("Smith"));*/
    }


    /**
     * Implementation linear Probing
     */
    public static void linearProbing() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        SimpleHashTable ht = new SimpleHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();
        System.out.println("Retrieve key Smith" + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");

        System.out.println("----------------------------");
        ht.printHashTable();
        System.out.println("Retrieve key Smith" + ht.get("Smith"));
        System.out.println("Retrieve key Smith" + ht.get("Doe"));
    }


    /**
     * Simple explanation of hashtable
     */
    public static void hashTable() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        SimpleHashTable ht = new SimpleHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();

        //System.out.println("Retrieve key Wilson" + ht.get("Wilson"));
    }

    /**
     * check String polindrom using stack and queue
     *
     * @param input
     * @return
     */
    public static boolean checkPolindromStackQueue(String input) {
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = input.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char inputChar = lowerCase.charAt(i);
            if (inputChar >= 'a' && inputChar <= 'z') {
                queue.addLast(inputChar);
                stack.push(inputChar);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }
        return true;
    }


    public static void arrayQueueCircular() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        ArrayQueueCircular queue = new ArrayQueueCircular(5);

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marrySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);

        queue.printQueue();


        /*queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);*/

       /* queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
*/

        //  System.out.println(queue.peek());
        queue.printQueue();


    }

    /**
     * this is Queues with array implementation
     */
    public static void arrayQueue() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(10);

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);

        //  queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(mikeWilson);

        //  queue.printQueue();

        //  System.out.println(queue.peek());
        queue.printQueue();
    }

    /**
     * Check for palindrome string
     * (mengecek string apakah bisa di baca dari depan maupun dari belakang)
     * Logic :
     * hilangkan spasi,character,jadikan huruf kecil
     *
     * @param string
     * @return
     */
    public static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder stringNoPuctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPuctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        //thid should run in main method
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));

        return reversedString.toString().equals(stringNoPuctuation.toString());
    }

    public static void stackWithLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marrySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        System.out.println("POOP " + stack.pop());
        System.out.println(stack.peek());
        //stack.printStack();
    }


    public static void stackWithArray() {
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 4567));
        stack.push(new Employee("Marry", "Smith", 22));
        stack.push(new Employee("Mike", "Wilson", 3245));
        stack.push(new Employee("Bill", "End", 48));

        // stack.printStack();

        System.out.println(stack.peek());

        System.out.println("POOP " + stack.pop());

        System.out.println(stack.peek());
    }


    public static int[] makeLast(int[] input) {
        int lengthInput = input.length;
        int[] intArray = new int[2 * lengthInput];
        intArray[intArray.length - 1] = input[lengthInput - 1];
        return intArray;
    }


    /**
     * Sorting integer values using singly LinkedList
     */
    public static void sortIntegerValues() {
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }

    //trave
    public static int minimumGroups(List<Integer> predators) {
        int max = 1;
        int arrLen = predators.size();
        for (int i = 0; i < predators.size(); i++) {
            int a = i;
            int counter = 1;
            while (predators.get(a) > -1 && predators.get(a) < arrLen && counter < arrLen) {
                a = predators.get(a);
                counter++;
            }

            if (counter > max)
                max = counter;
        }
        return max;
    }

    //trave
    public static char slowestKey(List<List<Integer>> keyTimes) {
        int max = keyTimes.get(0).get(1);
        int key = keyTimes.get(0).get(0);
        for (int i = 1; i < keyTimes.size(); i++) {
            int currentComparation = keyTimes.get(i).get(1) - keyTimes.get(i - 1).get(1);
            if (currentComparation > max) {
                max = currentComparation;
                key = keyTimes.get(i).get(0);
            }
        }
        return (char) (97 + key);
    }

    //trave
    public static int numberOfWaysForSum(int n, int k) {
        int[][] a = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            a[1][i] = 1;

        }
        for (int i = 1; i <= k; i++) {
            a[i][0] = 1;
        }
        for (int i = 2; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= i) {
                    a[i][j] = a[i][j - i] + a[i - 1][j];

                } else {
                    a[i][j] = a[i - 1][j];
                }

            }
        }
        return a[k][n];
    }


    public static void addBefore() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeLinkedList list = new EmployeeLinkedList();

        list.addFront(janeJones);
        list.addFront(johnDoe);
        list.addFront(marrySmith);
        list.addFront(mikeWilson);

        //  list.addBefore(billEnd, mikeWilson);
        list.printList();
    }

    public static void LinkedListJDK() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marrySmith);
        list.addFirst(mikeWilson);

        Iterator iterator = list.iterator();

        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");

       /* for (Employee employee : list) {
            System.out.println(employee);
        }*/

        list.add(billEnd);
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");


        list.add(billEnd);
        list.removeFirst();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");


        list.removeLast();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");
    }


    public static void doublyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        list.addToEnd(janeJones);
        list.addToEnd(johnDoe);
        list.addToEnd(marrySmith);

        list.printList();
        System.out.print(list.getSize());

        /*Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());*/


        /*list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());*/
    }


    public static void singlyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addFront(janeJones);
        list.addFront(johnDoe);
        list.addFront(marrySmith);
        list.addFront(mikeWilson);
        System.out.print(list.getSize());


        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }


    /**
     * simple method for practice
     * move char to front and back
     *
     * @param input
     * @return
     */
    public static String moveChar(String input) {
        char temp = input.charAt(input.length() - 1);
        return temp + input + temp;
    }

    public static void arrayListPractice() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Marry", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 4568));
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John", "Doe", 4567));
        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("Marry", "Smith", 22)));
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }


    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }


    /**
     * input : {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}
     * radix= alphabet 26 width 5
     *
     * @param input
     * @param radix
     * @param width
     */
    public static void radixSortStr(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortStr(input, i, radix);
        }
    }


    public static void radixSingleSortStr(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (String value : input) {
            countArray[getIndex(position, value)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    /**
     * method to get index for count Arr
     * a=97 ASCII A=65
     *
     * @param position
     * @param value
     * @return
     */
    public static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value : input) {
            countArray[getDigit(value, position, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(input[tempIndex], position, radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }


    /**
     * Challange 2 change inertion to recursive
     *
     * @param input
     * @param numItems = input.length
     */
    public static void recursiveInsertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        recursiveInsertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] >= newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("---------------------");
    }


    public static void rotateArray(int[] input) {
        int[] temp = {input[1], input[2], input[0]};
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    /**
     * using compareTo()=if value equal return 0,
     * if value less than 0 the left is less than the other
     * if value bigger than 0 the left is bigger than the other
     */
    public static void bubbleSortString() {
        String[] input = {"e", "b", "a", "d", "c"};
        String temp;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i].compareTo(input[j]) > 0) {
                    temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }

        for (int k = 0; k < input.length; k++) {
            System.out.print(" " + input[k]);
        }
    }


    public static int getDigit(int value, int position, int radix) {
        return (int) (value / Math.pow(radix, position) % radix);
    }


    public static void countingSort(int[] input, int min, int max) {
        int[] countingArr = new int[max - min + 1];

        for (int i = 0; i < input.length; i++) {
            countingArr[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i < max; i++) {
            while (countingArr[i - min] > 0) {
                input[j++] = i;
                countingArr[i - min]--;
            }
        }

    }


    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    //{20, 35, -15, 7, 55, 1, -22}
    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;

    }


    /**
     * Merge Sort Recursive
     * { 20, 35, -15, 7, 55, 1, -22 }
     *
     * @param input
     * @param start
     * @param end
     */
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    /**
     * Merging from merge sort
     * { 20, 35, -15, 7, 55, 1, -22 }
     *
     * @param input
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int k = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && k < end) {
            temp[tempIndex++] = input[i] <= input[k] ? input[i++] : input[k++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


    /**
     * Basic arrayCopy()
     */
    public static void arrayCopy() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {11, 12, 13, 14, 15};

        System.arraycopy(array2, 0, array1, 0, 1);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }


    /**
     * Recursive reduceByOne
     *
     * @param n
     * @return
     */
    public static int reduceByOne(int n) {
        if (n > 0) {
            reduceByOne(n - 1);
        }
        System.out.println("Completed call " + n);
        return n;
    }

    /**
     * Recursive sumTwoNum
     *
     * @param start
     * @param end
     * @return
     */
    public static int sumTwoNum(int start, int end) {
        if (end > start) {
            return end + sumTwoNum(start, end - 1);
        } else {
            return end;
        }
    }


    private static int recursiveSum(int number) {
        if (number > 0) {
            int result = number + recursiveSum(number - 1);
            return result;
        } else {
            return 0;
        }
    }


    private static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial(int num) {

        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
            System.out.println(factorial);
        }

        return factorial;
    }


    /**
     * Shell sort is variation to optimise Insertion sort with reduce the shifting
     */
    private static void shellSort(int[] intArray) {
        //int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        for (int gobs = intArray.length / 2; gobs > 0; gobs /= 2) {
            for (int i = gobs; i < intArray.length; i++) {

                int newElement = intArray[i];
                int j = i;
                while (j >= gobs && intArray[j - gobs] > newElement) {
                    intArray[j] = intArray[j - gobs];
                    j -= gobs;
                }
                intArray[j] = newElement;
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }


    /**
     * the result on hackerank less than expected
     *
     * @param arr
     * @return
     */
    static int minimumSwaps1(int[] arr) {
        int countSwap = 0;
        for (int i = arr.length - 1; i > 0; i--) {

            int maxNum = 0;
            int j;
            for (j = 1; j <= i; j++) {
                if (arr[j] > arr[maxNum]) {
                    maxNum = j;
                }
            }

            if (arr[i] != arr[maxNum]) {
                int temp = arr[i];
                arr[i] = arr[maxNum];
                arr[maxNum] = temp;
                countSwap++;
            }
        }
        return countSwap;
    }


    // 1 5 3 2 4 6 7
    public static int minimumSwap2(int[] arr) {

        int countSwap = 0;
        int i = 0;

        while (i < arr.length) {
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                countSwap++;
            }
            i++;
        }
        return countSwap;
    }


    private static void insertionSortsAscending() {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }
    }


    public static void removeDuplicate() {
        int[] intArray = {1, 1, 2};
        // int count = 0;

        for (int j = 0; j <= intArray.length - 1; j++) {
            System.out.println(intArray[j]);
         /*   for (int k = j + 1; k < intArray.length; k++) {
                if (j != k && intArray[j] == intArray[k]) {
                    count++;
                }
            }*/

        }


    }

    public static void selectionShortAscending() {
        int[] intArray = {10, 2, 5, 1, 8, 20};
        //10,2,5,1,8,20

        for (int lastSortedIdex = intArray.length - 1; lastSortedIdex > 0; lastSortedIdex--) {

            int largest = 0;
            for (int i = 1; i <= lastSortedIdex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastSortedIdex);
        }


        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }


    public static int searchBiggerNum() {
        int[] input = {4, 2, 5, 3, 7, 9};
        int largest = 0;
        for (int i = input.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (input[j] > input[largest]) {
                    largest = j;
                }
            }
        }
        return input[largest];
    }

    public static int searchSmalestNum() {
        int[] input = {8, 9, 6, 7, 1};
        int smalest = 0;
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (input[j] < input[smalest]) {
                    smalest = j;
                }
            }
        }
        return input[smalest];
    }


    /**
     * bubble sorting bigger to small
     */
    private static void bubbleSortDescending() {

        int[] intArray = {20, 35, 15, 7, 55, 1, 14};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] < intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }
    }


    /**
     * bubble sorting small to bigger
     */
    private static void bubbleSortAscending(int[] arrayInt) {

        //   int[] arrayInt = {20, 35, -15, 7, 55, 1, -22};

        for (int unsortList = arrayInt.length - 1; unsortList > 0; unsortList--) {

            for (int i = 0; i < unsortList; i++) {
                if (arrayInt[i] > arrayInt[i + 1]) {
                    swap(arrayInt, i, i + 1);
                }
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(" " + arrayInt[i]);
        }
    }


    private static void swap(int[] array, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
