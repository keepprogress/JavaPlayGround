package com.nick.playground.testRun;

import java.util.Arrays;

public class solutionToMoveArray {
    public static void main(String[] args) {
        int[][]mat = {{1,2},{3,4}};
        matrixReshape( mat, 1,4);
    }
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] reshapeMatrix = new int[r][c];
        int index = 0;
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                reshapeMatrix[i][j] = mat[index/n][index%n];
                index++;
            }
        }
        return new int[2][2];
    }
}
