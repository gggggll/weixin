package com.example.lenovo.weixin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by lenovo on 2017/11/4.
 */

public class FragmentOne extends Fragment {


   /* @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1,container,false);
}*/

    private ListView listView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment1 , container, false);
        listView = (ListView)view.findViewById(R.id.listView1);
        List<Map<String, Object>> list=getData();
        listView.setAdapter(new listViewAdapter(getActivity(), list));
        /*listViewAdapter adapter=new listViewAdapter(getContext(),list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getActivity(), Chat.class);

                startActivity(intent);

            }

        });*/
        return view;
    }
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ListView listView = (ListView) getActivity().findViewById(R.id.listView1);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                /*Intent intent = new Intent();
                intent.setActivity(getActivity(), Chat.class);
                startActivity(intent);
                Toast.makeText(getActivity(),"gdgf",Toast.LENGTH_SHORT).show();
                expressItemClick();*/

                Intent intent=new Intent(getActivity(),Chat.class);
                startActivity(intent);
            }

        });
    }

    /*private void expressItemClick() {
        Intent intent=new Intent(getActivity(),FragmentTwo.class);
        startActivity(intent);
    }*/

    public List<Map<String, Object>> getData(){
        List<Map<String, Object>> list=new ArrayList<Map<String,Object>>();


            Map<String, Object> map = new HashMap<String, Object>();
            map.put("imageView1", R.drawable.cat);
            map.put("name", "松鼠");
        map.put("mess", "很简单啊，你继续定义一种布局类型，然后再写一个布局就可以了");
        map.put("date", "昨天");
            list.add(map);
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("imageView1", R.drawable.contact2);
        map2.put("name", "大卫");
        map2.put("mess", "你好");
        map2.put("date", "前天");
        list.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("imageView1", R.drawable.contact1);
        map3.put("name", "萝卜");
        map3.put("mess", "你好");
        map3.put("date", "大前天");
        list.add(map3);
        return list;
    }




}
 /*switch(parent.getId()){
                    case R.id.listView1:
                        expressItemClick(1);
                            break;
                }
                Intent intent=new Intent(getActivity(),Chat.class);
                startActivity(intent);
                Toast.makeText(this,"fdgrttr",Toast.LENGTH_SHORT).show();

            }*/