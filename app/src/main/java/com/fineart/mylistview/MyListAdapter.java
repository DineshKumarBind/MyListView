package com.fineart.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dinesh on 2/11/2016.
 * Custom adapter class to provide adapter for listview.
 */
public class MyListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> dataSet;
LayoutInflater layoutInflater;
    /**
     * Public constructor of {@link #MyListAdapter}
     * @param context Context of origin activity.
     * @param dataSet Dataset to be shown in arraylist.
     */
    public MyListAdapter(Context context, ArrayList<String> dataSet) {
        this.context=context;
        this.dataSet=dataSet;
        layoutInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.list_item,null);
        }
        TextView tv= (TextView) convertView.findViewById(R.id.item_text);
        ImageView imv= (ImageView) convertView.findViewById(R.id.imageview);
        imv.setImageResource(R.mipmap.ic_launcher);
        tv.setText(dataSet.get(position));
        return convertView;
    }
    public void updateDataSet(String mdata){
        dataSet.add(mdata);
        this.notifyDataSetChanged();
    }
}
