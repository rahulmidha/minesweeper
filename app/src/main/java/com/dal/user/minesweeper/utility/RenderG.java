package com.dal.user.minesweeper.utility;

import android.util.Log;

/**
 * Created by user on 07-10-2017.
 */

public class RenderG {

    public static void print( final int[][] grid , final int width , final int height ){
        for( int x = 0 ; x < width ; x++ ){
            String printedText = "| ";
            for( int y = 0 ; y < height ; y++ ){
                printedText += String.valueOf(grid[x][y]).replace("-1", "B") + " | ";
            }
            Log.e("",printedText);
        }
    }
}
