package com.dal.user.minesweeper.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.dal.user.minesweeper.R;

/**
 * Created by user on 08-10-2017.
 */

public class Cell extends BaseCell {

    public Cell( Context context , int x , int y ){
        super(context);

        setPosition(x,y);

        }
// this method will make a square
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("Minesweeper" , "Cell::onDraw");
        drawButton(canvas);

        if( isFlagged() ){
            drawFlag(canvas);
        }else if( isRevealed() && isBomb() && !isClicked() ){
            drawNormalBomb(canvas);
        }else {
            if( isClicked() ){
                if( getValue() == -1 ){
                    drawBombExploded(canvas);
                }else {
                    drawNumber(canvas);
                }
            }else{
                drawButton(canvas);
            }
        }
    }
    private void drawBombExploded(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.explosion);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawFlag( Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.flag);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawButton(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.empty);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawNormalBomb(Canvas canvas ){
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.mine);
        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }

    private void drawNumber( Canvas canvas ){
        Drawable drawable = null;

        switch (getValue() ){
            case 0:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case0);
                break;
            case 1:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case1);
                break;
            case 2:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case2);
                break;
            case 3:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case3);
                break;
            case 4:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case4);
                break;
            case 5:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case5);
                break;
            case 6:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case6);
                break;
            case 7:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case7);
                break;
            case 8:
                drawable = ContextCompat.getDrawable(getContext(), R.drawable.case8);
                break;
        }

        drawable.setBounds(0,0,getWidth(),getHeight());
        drawable.draw(canvas);
    }


}
