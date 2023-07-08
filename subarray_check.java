/*
Problem Statement:

Design a function that determines whether a given array B is a sub-array of another array A. A sub-array B is defined as a sequence of elements that occur in array A in the same order and consecutively.

The function should take two arrays A and B as inputs and return a boolean value indicating whether B is a sub-array of A.

Examples:

Given A = {3, 2, 7, 1, 4, 6} and B = {7, 1, 4}, the function should return TRUE, as B is a sub-array of A.

Given A = {3, 2, 7, 1, 4, 6} and B = {7, 4, 1}, the function should return FALSE, as B is not a sub-array of A.

Given A = {7, 3, 2, 4, 6, 1} and B = {7, 4, 1}, the function should return FALSE, as B is not a sub-array of A.

Given A = {2, 2, 2, 2, 2, 7} and B = {2, 2, 2, 2, 7}, the function should return TRUE, as B is a sub-array of A.

Given A = {7, 1, 2, 1, 4, 6} and B = {7, 1, 4}, the function should return FALSE, as although all elements of B are present in A, they are not consecutive, resulting in B not being a sub-array of A.

Please design the function and ensure it adheres to the specified conditions for determining sub-arrays.
*/


public class SubArrayChceck {

    public static void main(String[] args) {
        int[] A = {2, 2, 2, 2, 2, 6};
        int[] B = {2, 2, 2, 2, 6};
        boolean isSubarray = subArray(A, B);
        System.out.println("B is a subarray of A: " + isSubarray);
    }

    static boolean subArray(int[] A, int[] B) {

        int k = 0;
        int index = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayListB = new ArrayList<>();

        for (int j : B) {
            arrayListB.add(j);
        }

        for (int i = 0; i < (A.length - B.length)+1; i++) {

            while (k < (index + B.length)){

                arrayList.add(A[k]);
                k++;
            }


            if (compareLists(arrayList, arrayListB)) {
                return true;
            }

            k = index + 1;
            arrayList.clear();
            index++;

        }

        return false;

    }

    static boolean compareLists(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.size() != B.size()) {
            return false;
        }

        Map<Integer, Integer> frequencyA = new HashMap<>();

        for (int num : A) {
            frequencyA.put(num, frequencyA.getOrDefault(num, 0) + 1);
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
