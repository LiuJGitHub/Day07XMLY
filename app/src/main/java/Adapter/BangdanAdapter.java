package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import BaseItemLayout.BangdanItem1;
import BaseItemLayout.BangdanItem2;
import BaseItemLayout.BangdanItem3;
import BaseItemLayout.IItem2;
import BaseItemLayout.Item;
import BaseItemLayout.ItemConfig;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class BangdanAdapter extends BaseAdapter {
    private List<Item> list=null;
    private Context mContext=null;
    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    public BangdanAdapter(Context context) {
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
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.bangdan_item1, parent, false);
                    viewHolder0.mTextView1 = (TextView) convertView.findViewById(R.id.textView_item0);
                    convertView.setTag(viewHolder0);
                    break;
                case 1:
                    viewHolder1 = new ViewHolder1();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.bangdan_item2, parent, false);
                    viewHolder1.mImageView= (ImageView) convertView.findViewById(R.id.item2_imageView);
                    viewHolder1.mTextView1 = (TextView) convertView.findViewById(R.id.item2_text1);
                    viewHolder1.mTextView2 = (TextView) convertView.findViewById(R.id.item2_text2);
                    viewHolder1.mTextView3 = (TextView) convertView.findViewById(R.id.item2_text3);
                    convertView.setTag(viewHolder1);
                    break;
                case 2:
                    viewHolder2 = new ViewHolder2();
                    convertView = LayoutInflater.from(mContext).inflate(R.layout.bangdan_item3, parent, false);
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
        //设置数据
        switch (type) {
            case 0:
                BangdanItem1 bangdanItem1 = (BangdanItem1) list.get(position);
                viewHolder0.mTextView1.setText(bangdanItem1.getTitle());
                break;
            case 1:
                BangdanItem2 item1 = (BangdanItem2) list.get(position);
                viewHolder1.mTextView1.setText(item1.getTitle());
                viewHolder1.mTextView2.setText("1"+item1.getList().get(0).getTitle());
                viewHolder1.mTextView3.setText("2"+item1.getList().get(1).getTitle());
                mImageCacheHelper.loadImage(item1.getCoverPath(),viewHolder1.mImageView);
                break;
            case 2:
                BangdanItem3 item2 = (BangdanItem3) list.get(position);
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
