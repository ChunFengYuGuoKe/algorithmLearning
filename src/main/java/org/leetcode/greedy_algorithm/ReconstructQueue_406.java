package org.leetcode.greedy_algorithm;

import java.util.*;

public class ReconstructQueue_406 {
    public static void main(String[] args) {
        ReconstructQueue_406 reconstructQueue406 = new ReconstructQueue_406();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] result = reconstructQueue406.reconstructQueue1(people);
        System.out.println(Arrays.deepToString(result));
    }

    // 爽，只是改了一下比较函数，就对了

    /**
     * 贪在哪？贪在先排序，然后从高到低入队，高的人一定是在后面，而矮子后续插在前面对高的人是没有影响的
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高升序，同身高则按照前面比此人高的人数降序
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        System.out.println(Arrays.deepToString(people));
        // int[][] queue = Arrays.copyOf(people, people.length);
        List<int[]> queue = new ArrayList<>();
        for (int i = people.length - 1; i >= 0; i--) {
            queue.add(people[i][1], people[i]);
        }
        int[][] result = new int[people.length][2];
        int index = 0;
        for (int[] person : queue) {
            result[index++] = person;
        }
        return result;
    }

    public int[][] reconstructQueue1(int[][] people) {
        // 按照身高升序，同身高则按照前面比此人高的人数降序
        Arrays.sort(people, (person1, person2) -> {
            if (person1[0] != person2[0]) {
                return person1[0] - person2[0];
            } else {
                return person2[1] - person1[1];
            }
        });
        int[][] result = new  int[people.length][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < people.length; i++) {
                if (result[i] == null) {
                    spaces--;
                    if (spaces == 0) {
                        result[i] = person;
                    }
                }
            }
        }
        return result;
    }
}
