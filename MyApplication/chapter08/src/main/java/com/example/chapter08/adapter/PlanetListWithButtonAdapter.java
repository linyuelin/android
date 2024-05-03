package com.example.chapter08.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chapter08.R;
import com.example.chapter08.bean.Planet;
import com.example.chapter08.util.ToastUtil;

import java.util.List;


public class PlanetListWithButtonAdapter extends BaseAdapter {

    private Context mContext;
    private List<Planet> mPlaneList;

    public PlanetListWithButtonAdapter(Context mContext, List<Planet> mPlaneList) {
        this.mContext = mContext;
        this.mPlaneList = mPlaneList;
    }

    @Override
    public int getCount() {
        return mPlaneList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlaneList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list_with_button, null);
            holder = new ViewHolder();
            holder.iv_icon = convertView.findViewById(R.id.iv_icon);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_desc = convertView.findViewById(R.id.tv_desc);
            holder.btn_oper= convertView.findViewById(R.id.btn_oper);
            convertView.setTag(holder);
        }else {
         holder = (ViewHolder) convertView.getTag();
        }

        Planet planet = mPlaneList.get(position);
        holder.iv_icon.setImageResource(planet.image);
        holder.tv_name.setText(planet.name);
        holder.tv_desc.setText(planet.desc);
        holder.btn_oper.setOnClickListener(v -> {
            ToastUtil.show(mContext,"タップされた" + planet.name);
        });

        return convertView;
    }

    public final class ViewHolder{
        public ImageView iv_icon;
        public TextView tv_name;
        public TextView tv_desc;

        public Button btn_oper;
    }

}
