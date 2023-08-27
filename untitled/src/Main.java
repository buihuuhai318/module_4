import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        Integer[] arr1 = {0, 1, 1};
//        Integer[] arr2 = {1, 2, 2};
//        Integer[] arr3 = {1, 3, 4};
//        List<Integer> list1 = List.of(arr1);
//        List<Integer> list2 = List.of(arr2);
//        List<Integer> list3 = List.of(arr3);
//        List<List<Integer>> highways = new ArrayList<>();
//        highways.add(list1);
//        highways.add(list2);
//        highways.add(list3);
//        System.out.println(solve(4, 3, highways));


        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(10);
//        list.add(100);
        list.add(678);
        list.add(17576);

//        System.out.println(solve("aaabbbccddd"));
        System.out.println(solve(5, list));
//        Character a = 'Z';
////        System.out.println(a.charValue());

    }


    public static List<String> solve(int t, List<Integer> kArray) {
        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<String> list = Arrays.asList((word.split("")));
        List<String> result = new ArrayList<>();
        for (Integer integer : kArray) {
            String s = "";
            if (integer % 26 == 0) {
                int n = integer / 26;
                int count = 1;
                while (n >= 26) {
                    n = n / 26;
                    count++;
                }
                for (int j = 0; j < count; j++) {
                    s += "Z";
                }
            } else {
                if (integer < 26) {
                    result.add(list.get(integer - 1));
                } else {
                    int a = integer / 26;
                    int b = a * 26;
                    int c = integer - b ;
                    s += "A";

                    while (a )


                }
            }
            if (s != "") {
                result.add(s);
            }


        }
        return result;
    }


//    public static List<String> solve(int t, List<Integer> kArray) {
//        String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//        List<String> list = Arrays.asList((word.split("")));
//        List<String> result = new ArrayList<>();
//        for (Integer integer : kArray) {
//            if (integer <= 26) {
//                result.add(list.get(integer - 1));
//            } else {
//                int a = integer / 26;
//                String s = "";
//                if (a < 26) {
//                    s += (list.get(a - 1));
//                    s += (list.get(integer % 26 - 1));
//                } else {
//                    while (a >= 26) {
//                        a = a / 26;
//                        s += "A";
//                        if (a >= 26) {
//                            continue;
//                        } else {
//                            s += list.get(a - 1);
//                            if (integer % 26 == 0) {
//                                for (int i = 0; i < s.length(); i++) {
//
//                                }
//                            } else {
//                                s += (list.get(integer % 26 - 1));
//                            }
//
//                        }
//                    }
//                }
//                result.add(s);
//            }
//        }
//        result.set(result.size() - 1, result.get(result.size() - 1).trim());
//        return result;
//    }
//

//    public static int solve(int n, String s) {
//        String result = "";
//        boolean flag = true;
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            result = "";
//            for (int j = i; j < s.length(); j++) {
//                flag = true;
//                result += s.charAt(j);
//                if (result.length() > 1) {
//                    for (int k = 0; k < result.length(); k++) {
//                        if (result.charAt(k) != result.charAt(result.length() - 1 - k)) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if (flag) {
//                        list.add(result);
//                    }
//                }
//
//            }
//        }
//        boolean flag1 = true;
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size(); j++) {
//                if (s.contains((list.get(i) + list.get(j)))) {
//                    for (String value : list) {
//                        if ((list.get(i) + list.get(j)).equals(value)) {
//                            flag1 = false;
//                            break;
//                        }
//                    }
//                    if (flag1) {
//                        list.add((list.get(i) + list.get(j)));
//                    }
//                }
//            }
//        }
//        return list.size();
//    }


//    public static int solve(int N, int K, List<List<Integer>> highways) {
//        int count = 0;
//        for (int i = 0; i < highways.size() - 1; i++) {
//            List<Integer> list = highways.get(i);
//            if (list.get(2) == K) {
//                count++;
//            } else if (list.get(2) < K) {
//                for (int j = i + 1; j < highways.size(); j++) {
//                    List<Integer> list2 = highways.get(j);
////                    System.out.println(list2.get(2));
////                    System.out.println(list.get(2));
//                    if (list.get(1).equals(list2.get(0))) {
//                        if (list.get(2) + list2.get(2) == K) {
//                            count += 2;
//                        }
//                    }
//
//                }
//            }
//        }
//
//        if (count == 0) {
//            return -1;
//        } else {
//            return count;
//        }
//    }

//    public static String solve(String S) {
//        Map<String, Integer> map = new HashMap<>();
//        String result = "";
//        for (int i = 0; i < S.length(); i++) {
//            if (map.containsKey(String.valueOf(S.charAt(i)))) {
//                map.put(String.valueOf(S.charAt(i)), map.get(String.valueOf(S.charAt(i))) + 1);
//            } else {
//                map.put(String.valueOf(S.charAt(i)), 1);
//            }
//        }
//        int count = 0;
//        for (Integer n : map.values()) {
//            if (n % 2 != 0) {
//                count++;
//            }
//        }
//        if (count == 0) {
//            return "0";
//        } else {
//            result += (count - 1);
//            return result;
//        }
//
//    }

//


}