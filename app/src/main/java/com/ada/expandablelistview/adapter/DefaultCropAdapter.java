package com.ada.expandablelistview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ada.expandablelistview.R;
import com.ada.expandablelistview.util.SelectorUtils;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ada on 2016/10/13.
 */
public class DefaultCropAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private HashMap<String,String> crop;
    private List<HashMap<String,String>> cropList;

    public DefaultCropAdapter(Context context, List<HashMap<String,String>> list) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.cropList=list;
    }

    @Override
    public int getCount() {
        return cropList.size();
    }

    @Override
    public Object getItem(int position) {
        return cropList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_gv_default_crops, null);
            holder =new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        crop= cropList.get(position);
        holder.txtDefault.setText(crop.get("VALUE"));
        String s=crop.get("COLOR");
        int color;
        if(s==null){
            color=Color.argb(255, 0,0,0);
        }else {
            String[] str = s.split(",");
            color = Color.argb(255, Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
        }
        GradientDrawable shape = SelectorUtils.getNotSelectedBgShape(color);
        holder.txtDefault.setBackground(shape);
        holder.txtDefault.setTextColor(color);
        return convertView;
    }

    static class ViewHolder {
        final TextView txtDefault;
        ViewHolder(View view) {
            txtDefault = (TextView) view.findViewById(R.id.item_default_crop);

        }
    }


}
