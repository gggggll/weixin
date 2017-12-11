package com.example.lenovo.weixin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2017/12/6.
 */

public class WeChatAdapter extends BaseAdapter {
    private Context mContext;
    private List<WeChatMessage> mData;

    public WeChatAdapter(Context context,List<WeChatMessage> data)
    {
        this.mContext=context;
        this.mData=data;
    }
    public void Refresh()
    {
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int Index) {
        return mData.get(Index);
    }

    @Override
    public long getItemId(int Index) {
        return Index;
    }

    @Override
    public View getView(int Index, View mView, ViewGroup mParent) {
        TextView Content;
        switch(mData.get(Index).getType())
        {
            case WeChatMessage.MessageType_Time:
                mView= LayoutInflater.from(mContext).inflate(R.layout.senttime, null);
                Content=(TextView)mView.findViewById(R.id.Time);
                Content.setText(mData.get(Index).getContent());
                break;
            case WeChatMessage.MessageType_From:
                mView=LayoutInflater.from(mContext).inflate(R.layout.accept, null);
                Content=(TextView)mView.findViewById(R.id.From_Content);
                Content.setText(mData.get(Index).getContent());
                break;
            case WeChatMessage.MessageType_To:
                mView=LayoutInflater.from(mContext).inflate(R.layout.sent, null);
                Content=(TextView)mView.findViewById(R.id.To_Content);
                Content.setText(mData.get(Index).getContent());
                break;
        }
        return mView;
    }
}
