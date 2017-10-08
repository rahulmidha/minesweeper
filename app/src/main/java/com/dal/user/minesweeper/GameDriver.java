package com.dal.user.minesweeper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.dal.user.minesweeper.utility.BombGen;
import com.dal.user.minesweeper.utility.RenderG;
import com.dal.user.minesweeper.views.grid.Cell;

/**
 * Created by user on 07-10-2017.
 */

public class GameDriver {

    private static GameDriver instance;
    private Context context;
    private Cell[][] MinesweeperGrid = new Cell[WIDTH][HEIGHT];

    public static final int BOMB_NUMBER = 10;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 16;

    public static GameDriver getInstance() {
        if (instance == null) {
            instance = new GameDriver();
        }
        return instance;
    }

    private GameDriver(){ }

    public void createGrid(Context context){
        Log.e("GameDriver","createGrid is working");
        this.context = context;

        // create the Grid and store it
        int[][] GeneratedGrid = BombGen.generate(BOMB_NUMBER,WIDTH, HEIGHT);
        RenderG.print(GeneratedGrid,WIDTH,HEIGHT);
        setGrid(context,GeneratedGrid);
    }

    private void setGrid( final Context context, final int[][] grid ){
        for( int x = 0 ; x < WIDTH ; x++ ){
            for( int y = 0 ; y < HEIGHT ; y++ ){
                if( MinesweeperGrid[x][y] == null ){
                    MinesweeperGrid[x][y] = new Cell( context , x,y);
                }
                MinesweeperGrid[x][y].setValue(grid[x][y]);
                MinesweeperGrid[x][y].invalidate();
            }
        }
    }

    public View getCellAt(int position) {
        int x = position % WIDTH;
        int y = position / WIDTH;

        return MinesweeperGrid[x][y];
    }
}
