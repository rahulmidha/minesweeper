package com.dal.user.minesweeper.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.dal.user.minesweeper.GameDriver;

/**
 * Created by user on 08-10-2017.
 */

public class Grid extends GridView {

    public Grid(Context context, AttributeSet attrs) {
        super(context, attrs);

        GameDriver.getInstance().createGrid(context);

        setNumColumns(GameDriver.WIDTH);
        setAdapter(new GridAdapter());
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    private class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return GameDriver.getInstance().WIDTH * GameDriver.getInstance().HEIGHT;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return GameDriver.getInstance().getCellAt(position);
        }
    }
}
