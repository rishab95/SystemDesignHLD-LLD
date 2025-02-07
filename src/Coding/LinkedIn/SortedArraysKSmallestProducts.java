package Coding.LinkedIn;

import java.util.*;

/**
 * Solve - Given two sorted integer arrays, find the smallest k products of the two arrays.
 * Input: arr1 = [-2, -1, 0, 1, 2], arr2 = [-3, -1, 2, 4, 5], k = 3
 * Output: [-10, -8, -6]
 * Explanation: -2 * 5, -2 * 4, 2 * -3
 */
public class SortedArraysKSmallestProducts {
    public List<Integer> solution(int[] nums1, int[] nums2, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        List<Integer> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        int n = nums1.length;
        int m = nums2.length;

        pq.offer(new int[]{nums1[0]*nums2[0], 0, 0});
        visited.add("0, 0");

        while(k > 0 && !pq.isEmpty()) {
            int[] current = pq.poll();
            int product = current[0];
            int i = current[1];
            int j = current[2];
            result.add(product);

            if (i + 1 < n && !visited.contains((i + 1) + ", " + j)) {
                pq.offer(new int[]{nums1[i + 1] * nums2[j], i + 1, j});
                visited.add((i + 1) + ", " + j);
            }

            if (j + 1 < m && !visited.contains((i + ", " + (j + 1)))) {
                pq.offer(new int[]{nums1[i] * nums2[j + 1], i, j + 1});
                visited.add((i + ", " + (j + 1)));
            }
        }
        return result;
    }
}
