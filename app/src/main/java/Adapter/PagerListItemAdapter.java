package Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import AsyncTasks.LoadItemAsyncTask;
import Base.FinditemHead2;
import CallBack.CallBackBitmap;
import LogUtils.LogUtil;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/18.
 */
public class PagerListItemAdapter extends BaseAdapter {

    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private List<FinditemHead2> mFinditemHead2s=null;
    private Context mContext=null;

    public PagerListItemAdapter( Context context) {
        //mFinditemHead2s = finditemHead2s;
        mContext = context;
    }

    public void setList(List<FinditemHead2> mFinditemHead2s){
        this.mFinditemHead2s=mFinditemHead2s;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mFinditemHead2s!=null?mFinditemHead2s.size():0;
    }

    @Override
    public Object getItem(int position) {
        return mFinditemHead2s.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.tuijian_item1,parent,false);
            viewHolder.mImageView= (ImageView) convertView.findViewById(R.id.imageView_item1);
            viewHolder.mTextView= (TextView) convertView.findViewById(R.id.textView_item1);
            convertView.setTag(viewHolder);

        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
            LogUtil.d("flag","-----------PageAdapter"+mFinditemHead2s.get(position));
            viewHolder.mTextView.setText(mFinditemHead2s.get(position).getTitle());
            mImageCacheHelper.loadImage(mFinditemHead2s.get(position).getCoverPath(),viewHolder.mImageView);
//            final ViewHolder finalViewHolder=viewHolder;
//            new LoadItemAsyncTask(new CallBackBitmap() {
//                @Override
//                public void sendBItmap(Bitmap bitmap) {
//                    finalViewHolder.mImageView.setImageBitmap(bitmap);
//
//                }
//            }).execute(mFinditemHead2s.get(position).getCoverPath());

        return convertView;
    }

    static class ViewHolder{
        TextView mTextView;
        ImageView mImageView;
    }

}
