package Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.GridView;

import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import com.liujiang.day07xmly.R;

import Base.HotRecommendsList;
import Base.HotRecommendsListListen;
import BaseItemLayout.Item;
import LogUtils.LogUtil;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/18.
 */
public class TuijianAdapter extends BaseAdapter {
    private List<Item> list=null;
    private List<HotRecommendsList> data=null;
    private List<HotRecommendsListListen> data2=null;
    private Context mContext=null;
    private ImageCacheHelper mImageCacheHelper=null;
    public TuijianAdapter(List<HotRecommendsList> data,Context context,ImageCacheHelper mImageCacheHelper) {
        mContext = context;
        this.data=data;
        this.mImageCacheHelper=mImageCacheHelper;
        list=new ArrayList<>();
    }
    public void setList(List<Item> list){
        this.list=list;
        notifyDataSetChanged();
    }

//    @Override
//    public int getItemViewType(int position) {
//        return list.get(position).getType();
//    }
//    @Override
//    public int getViewTypeCount() {
//        return ItemConfig.ITEM_TYPE_COUNT;
//
//    }

    @Override
    public int getCount() {
        //LogUtil.d("Tuijian","-----------getCount-----"+data.size());
        return data!=null?data.size():0;

        //return 1;
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
        //获取类型号
        int type=getItemViewType(position);
        //ViewHolder viewHolder=null;
        ViewHolder0 viewHolder0=null;
        //ViewHolder1 viewHolder1=null;
        //ViewHolder2 viewHolder2=null;
        if (convertView==null){
            viewHolder0=new ViewHolder0();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.tuijian_item0,parent,false);
            viewHolder0.mTextView1= (TextView) convertView.findViewById(R.id.item0_textView);
            viewHolder0.mGridView= (GridView) convertView.findViewById(R.id.gridView);
            convertView.setTag(viewHolder0);
           // switch (type){
//                case 0:
//                    viewHolder0=new ViewHolder0();
//                    convertView= LayoutInflater.from(mContext).inflate(R.layout.tuijian_item0,parent,false);
//                    viewHolder0.mTextView1= (TextView) convertView.findViewById(R.id.textView_item0);
//                    convertView.setTag(viewHolder0);
//                    break;
//                case 1:
//                    viewHolder1=new ViewHolder1();
//                    convertView= LayoutInflater.from(mContext).inflate(R.layout.item1,parent,false);
//                    viewHolder1.mTextView1= (TextView) convertView.findViewById(R.id.textView1_item1);
//                    viewHolder1.mTextView2= (TextView) convertView.findViewById(R.id.textView2_item1);
//                    convertView.setTag(viewHolder1);
//                    break;
//                case 2:
//                    viewHolder2=new ViewHolder2();
//                    convertView= LayoutInflater.from(mContext).inflate(R.layout.item2,parent,false);
//                    viewHolder2.mTextView1= (TextView) convertView.findViewById(R.id.textView1_item2);
//                    viewHolder2.mTextView2= (TextView) convertView.findViewById(R.id.textView2_item2);
//                    viewHolder2.mTextView3= (TextView) convertView.findViewById(R.id.textView3_item2);
//                    convertView.setTag(viewHolder2);
//                    break;
        //    }
        }else {
            viewHolder0= (ViewHolder0) convertView.getTag();
        }
        //赋值
        HotRecommendsList hotRecommendsList=data.get(position);
        viewHolder0.mTextView1.setText(hotRecommendsList.getTitle());
        data2=hotRecommendsList.getList();
        LogUtil.d("Tuijian","-------------tuiajin-position--"+position);
        LogUtil.d("Tuijian","-------------tuiajin-toStr--"+hotRecommendsList.toString());
        LogUtil.d("Tuijian","-------------tuiajin---"+data2.size());
        //HotRecommendsListListen hotRecommendsListListen = hotRecommendsList.getList().get(position);
        //GridViewAdapter adapter=new GridViewAdapter(data,mContext,position);
        GridViewAdapter adapter=new GridViewAdapter(data2,mContext,mImageCacheHelper);
        viewHolder0.mGridView.setAdapter(adapter);
//
        return convertView;
    }
    static class ViewHolder{

    }
    static class ViewHolder0{
        TextView mTextView1;
        GridView mGridView;
    }
    static class ViewHolder1{
        TextView mTextView1;
        TextView mTextView2;
    }
    static class ViewHolder2{
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
    }
}
