package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.liujiang.day07xmly.R;

import java.util.List;

import Base.HotRecommendsList;
import Base.HotRecommendsListListen;
import LogUtils.LogUtil;
import NewView.ImageTextsButtons;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class GridViewAdapter extends BaseAdapter {
    private ImageCacheHelper mImageCacheHelper=null;
    private List<HotRecommendsListListen> list=null;
    private Context mContext=null;


    public GridViewAdapter(List<HotRecommendsListListen> list, Context context,ImageCacheHelper mImageCacheHelper) {
        this.list = list;
        mContext = context;
        this.mImageCacheHelper=mImageCacheHelper;

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
        ViewHolder viewHolder=null;
        if (convertView==null){
            viewHolder=new ViewHolder();
            convertView= LayoutInflater.from(mContext).inflate(R.layout.tuijian_gridview_item,parent,false);
            viewHolder.mImageTextsButtons= (ImageTextsButtons) convertView.findViewById(R.id.imageTextsBUtton);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        HotRecommendsListListen hotRecommendsListListen=list.get(position);
        ImageView imageView=viewHolder.mImageTextsButtons.getIv();

        mImageCacheHelper.loadImage(hotRecommendsListListen.getAlbumCoverUrl290(),imageView);
        viewHolder.mImageTextsButtons.setIv(imageView);
        viewHolder.mImageTextsButtons.setTextView1Text(hotRecommendsListListen.getTrackTitle());
        viewHolder.mImageTextsButtons.setTextView2Text(hotRecommendsListListen.getIntro());

        return convertView;
    }
    static class ViewHolder{
        private ImageTextsButtons mImageTextsButtons;
    }
}
