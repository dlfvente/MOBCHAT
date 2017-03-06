/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import edu.upc.adapterviews.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author juanluis
 */
public class MyAdapter3 extends BaseAdapter {

  private Context mContext;
  private ArrayList<String> mStrings;

  public MyAdapter3(Context context, ArrayList<String> mStrings) {
    mContext = context;
    this.mStrings = mStrings;
  }

  public int getCount() {
    return mStrings.size();
  }

  public Object getItem(int arg0) {
    return mStrings.get(arg0);
  }

  public long getItemId(int arg0) {
    return arg0;
  }

  public View getView(int position, View convertView, ViewGroup parent) {
    
    ViewHolder viewHolder;
    
    if(convertView==null){
      if(getItemViewType(position) == 0)
        convertView = LayoutInflater.from(mContext).inflate(R.layout.row3_right, parent, false);
      if(getItemViewType(position) == 1)
        convertView = LayoutInflater.from(mContext).inflate(R.layout.row3_left, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.text  = (TextView)  convertView.findViewById(R.id.texto);
      viewHolder.hour  = (TextView)  convertView.findViewById(R.id.hora);
      convertView.setTag(viewHolder);
    }
    
    viewHolder = (ViewHolder)convertView.getTag();
    viewHolder.text.setText(mStrings.get(position));
    Date now = new Date();
    DateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
    viewHolder.hour.setText(dateFormat2.format(now));
    
    return convertView;
  }
  
  public class ViewHolder{
    TextView text;
    TextView hour;
  }
  
  @Override
  public int getItemViewType(int position) {
    return position % 2;
  }

  @Override
  public int getViewTypeCount() {
    return 2;
  }
  
  @Override
  public boolean isEnabled(int position) {
    return false;
  }

}
