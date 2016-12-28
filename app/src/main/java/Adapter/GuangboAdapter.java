package Adapter;

import android.content.Context;
import android.gesture.GestureUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import BaseItemLayout.BangdanItem1;
import BaseItemLayout.BangdanItem2;
import BaseItemLayout.BangdanItem3;
import BaseItemLayout.GuangboItem;
import BaseItemLayout.GuangboTitle;
import BaseItemLayout.Item;
import BaseItemLayout.ItemConfig;
import LogUtils.LogUtil;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/21.
 */
public class GuangboAdapter extends BaseAdapter {
    private List<Item> list=null;
    private Context mContext=null;
    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    public GuangboAdapter(Context context) {
        mContext = context;
        list=new ArrayList<>();
    }
    public void setList(List<Item> list){
        this.list=list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }
    @Override
    public int getViewTypeCount() {
        return ItemConfig.ITEM_TYPE_COUNT;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取类型号
        int type=getItemViewType(position);
        ViewHolder0 viewHolder0=null;
        ViewHolder1 viewHolder1=null;
        ViewHolder2 viewHolder2=null;

        if (convertView==null){
            switch (type) {
                case 0:
                    viewHolder0 = new ViewHolder0();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.guangbo_item1, parent, false);
                    viewHolder0.mTextView1 = (TextView) convertView.findViewById(R.id.item1_textView);
                    convertView.setTag(viewHolder0);
                    break;
                case 1:
                    viewHolder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.guangbo_item2, parent, false);
                    viewHolder1.mImageView= (ImageView) convertView.findViewById(R.id.item2_imageView);
                    viewHolder1.mTextView1 = (TextView) convertView.findViewById(R.id.item2_text1);
                    viewHolder1.mTextView2 = (TextView) convertView.findViewById(R.id.item2_text2);
                    viewHolder1.mTextView3 = (TextView) convertView.findViewById(R.id.item2_text3);
                    convertView.setTag(viewHolder1);
                    break;
                case 2:
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.guangbo_item3, parent, false);
                    convertView.setTag(viewHolder2);
                    break;
            }
        }else {
            switch (type) {
                case 0:
                    viewHolder0 = (ViewHolder0) convertView.getTag();
                    break;
                case 1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case 2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;
            }
        }

        //LogUtil.d("JSONADAPTER","------------"+list);
        //设置数据
        switch (type) {
            case 0:

                Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                LogUtil.d("TIME","-------- ---"+hour);
                if (hour>0&&hour<12){
                    //GuangboTitle guangboTitle = (GuangboTitle) list.get(position);
                    viewHolder0.mTextView1.setText("早安·北京");
                }else if (hour>12&&hour<18){
                    viewHolder0.mTextView1.setText("午安·北京");
                }else {
                    viewHolder0.mTextView1.setText("晚安·北京");
                }

                break;
            case 1:
                GuangboItem item1 = (GuangboItem) list.get(position);
                viewHolder1.mTextView1.setText(item1.getName());
                viewHolder1.mTextView2.setText(item1.getProgramName());
                float count=item1.getPlayCount()/10000.0f;
                viewHolder1.mTextView3.setText(count+"万人");
                mImageCacheHelper.loadImage(item1.getCoverLarge(),viewHolder1.mImageView);
                break;
            case 2:
                //BangdanItem3 item2 = (BangdanItem3) list.get(position);
                break;
        }
        return convertView;
    }
    static class ViewHolder0{
        TextView mTextView1;
    }
    static class ViewHolder1{
        private ImageView mImageView;
        TextView mTextView1;
        TextView mTextView2;
        TextView mTextView3;
    }
    static class ViewHolder2{
    }

}
