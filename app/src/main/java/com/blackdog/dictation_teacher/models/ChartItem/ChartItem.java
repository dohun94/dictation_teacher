package com.blackdog.dictation_teacher.models.ChartItem;

import android.content.Context;
import android.view.View;

import com.github.mikephil.charting.data.ChartData;

/**
 * baseclass of the chart-listview items
 * @author philipp
 *
 */
public abstract class ChartItem {
    
    protected static final int TYPE_BARCHART = 0;
    protected static final int TYPE_LINECHART = 1;
    protected static final int TYPE_PIECHART = 2;
    protected static final int TYPE_COMBINEDCHART = 3;
    protected static final int TYPE_BUBBLECHART = 4;
    
    protected ChartData<?> mChartData;
    
    public ChartItem(ChartData<?> cd) {
        this.mChartData = cd;
    }
    
    public abstract int getItemType();
    
    public abstract View getView(int position, View convertView, Context c);
}
