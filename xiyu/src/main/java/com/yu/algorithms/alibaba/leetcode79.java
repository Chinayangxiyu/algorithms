package com.yu.algorithms.alibaba;

/**
 * TODO
 * Description
 *
 * @author xiyu
 * @date 2021-01-24 16:17
 */
public class leetcode79 {

    public boolean exist(char[][] board, String word) {
        this.maxi = board.length;
        this.maxj = board[0].length;

        if(maxi * maxj < word.length()){
            return false;
        }


        this.board = board;
        this.word = word;

        for(int i = 0; i < maxi; i++){
            for(int j = 0; j < maxj; j++){
                if(board[i][j] == word.charAt(0) && find( i, j, 0)){
                    return true;
                }
            }
        }

        return false;

    }

    private char[][] board;
    private String word;
    private int maxi;
    private int maxj;
    public boolean find(int i, int j, int p){


        if(p == word.length()-1 && word.charAt(p) == board[i][j]){
            return true;
        }

        if(p > word.length()-1 || word.charAt(p) != board[i][j]){
            return false;
        }

        p++;
        char temp = board[i][j];
        board[i][j] = '0';

        if(i > 0 && find(i -1, j, p)){

            return true;
        }

        if(i < maxi-1 && find(i +1, j, p)){
            return true;

        }

        if(j > 0 && find(i, j-1, p)){
            return true;
        }

        if(j < maxj-1 && find(i, j+1, p)){
            return true;
        }

        board[i][j] = temp;

        return false;

    }
}
