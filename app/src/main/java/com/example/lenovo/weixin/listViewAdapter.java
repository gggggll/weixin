package com.example.lenovo.weixin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/12/4.
 */

public class listViewAdapter extends BaseAdapter {
    private List<Map<String, Object>> data;
    private LayoutInflater layoutInflater;
    private Context context;
    public listViewAdapter(Context context,List<Map<String, Object>> data){
        this.context=context;
        this.data=data;
        this.layoutInflater=LayoutInflater.from(context);
    }
    public final class Zujian{
        public ImageView imageView1;
        public TextView name;
        public TextView mess;
        public TextView date;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Zujian zujian=null;
        if(convertView==null){
            zujian=new Zujian();
            //获得组件，实例化组件
            convertView=layoutInflater.inflate(R.layout.weixin_list, null);
            zujian.imageView1=(ImageView)convertView.findViewById(R.id.imageView1);
            zujian.name=(TextView)convertView.findViewById(R.id.name);
            zujian.mess=(TextView)convertView.findViewById(R.id.mess);
            zujian.date=(TextView)convertView.findViewById(R.id.date);
            convertView.setTag(zujian);
        }else{
            zujian=(Zujian)convertView.getTag();
        }
        //绑定数据
        zujian.imageView1.setBackgroundResource((Integer)data.get(position).get("imageView1"));
        zujian.name.setText((String)data.get(position).get("name"));
        zujian.mess.setText((String)data.get(position).get("mess"));
        zujian.date.setText((String)data.get(position).get("date"));
        return convertView;
    }
}
