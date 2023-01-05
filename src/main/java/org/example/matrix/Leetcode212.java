package org.example.matrix;

import java.util.ArrayList;
import java.util.List;

public class Leetcode212 {
    static char[] letter;

    static char[][] matrix;
    static boolean[][] visited;
    public static List<String> exist(char[][] board, List<String> word) {
        matrix = board;
//        letter = word.toCharArray();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        List<String> ans = new ArrayList<>();

        for(int k =0 ; k<word.size();k++) {
            letter = word.get(k).toCharArray();

            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    if (matrix[i][j] == letter[0]) {
                        visited = new boolean[rowLen][colLen];
                        boolean res = dfs(i, j, 0);
                        if (res == true){
//                            if(!ans.contains(word[k]))
//                            ans.add(word.get(k));
                        }

                    }
                }
            }
        }
        return ans;
    }
    public static boolean dfs(int rowLen, int colLen, int index) {
        if(index == letter.length) return true;
        if(rowLen < 0 || rowLen >= matrix.length) return false;
        if(colLen < 0 || colLen >= matrix[0].length) return false;
        if(visited[rowLen][colLen] == true) return false;
        if(matrix[rowLen][colLen] != letter[index]) return false;

        visited[rowLen][colLen] = true;
        //dfs for all 4 directions
        boolean top = dfs(rowLen-1, colLen, index + 1);
        boolean down = dfs(rowLen + 1, colLen, index + 1);
        boolean left = dfs(rowLen, colLen - 1, index + 1);
        boolean right = dfs(rowLen, colLen + 1, index + 1);

        boolean res = top || down || left || right;
        if(res == false)
            visited[rowLen][colLen] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'E', 'C'},
                {'E', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        List<String> s = new ArrayList<>();
        s.add("AEC");
        s.add("EEF");
        s.add("Z");
        System.out.println(exist(matrix, s));
    }
}
