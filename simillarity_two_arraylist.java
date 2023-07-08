/*
You are given two lists, A and B, containing integers. Your task is to determine whether all the elements in B are similar to the elements in A, allowing for any order of elements in both lists. In other words, you need to check if every element in B is present in A and if every element in A is also present in B, regardless of the order of elements in either list.

Write a function, check_similarity(a, b), that takes in two lists, A and B, and returns True if the condition is satisfied, and False otherwise.

Your solution should have the following characteristics:

The function should have a time complexity of O(n), where n is the length of the lists A and B.
The function should handle lists of any size.
The function should not modify the input lists.
Examples:

Given A = [1, 2, 3, 4] and B = [3, 4, 2, 1], the function should return True since all elements in B (3, 4, 2, 1) are present in A, and all elements in A are also present in B.
Given A = [1, 2, 3, 4] and B = [3, 4, 5], the function should return False since the element 5 in B is not present in A.
Given A = [1, 2, 2, 3] and B = [3, 2, 2, 1], the function should return True since all elements in B (3, 2, 2, 1) are present in A, and all elements in A are also present in B.

*/


public class MatchValues {
    public static void main(String[] args) {
        int[] A = {7, 7, 6};
        int[] B = {7, 6, 6};
        boolean areEqual = compareLists(A, B);
        System.out.println("Lists are equal: " + areEqual);
    }

    static boolean compareLists(int[] A, int[] B) {
        if (A.length != B.length) {
            return false;
        }

        Map<Integer, Integer> frequencyA = new HashMap<>();

        for (int num : A) {
            frequencyA.put(num, frequencyA.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> data: frequencyA.entrySet()) {
            System.out.println("Key = " + data.getKey() + " Value = " + data.getValue());
        }

        for (int num : B) {
            if (frequencyA.containsKey(num)) {
                frequencyA.put(num, frequencyA.get(num) - 1);
                if (frequencyA.get(num) == 0) {
                    frequencyA.remove(num);
                }
            } else {
                return false;
            }
        }

        return frequencyA.isEmpty();
    }
}
