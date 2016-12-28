package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.List;

import Base.ZhuboList;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/20.
 */
public class GridViewZBAdapter extends BaseAdapter {
    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private List<ZhuboList> list=null;
    private Context mContext=null;
    private ZhuboList zhuboList=null;
    public GridViewZBAdapter(List<ZhuboList> list2, Context context) {
        this.list=list2;
        this.mContext=context;
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
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.zhubo_gridview_item0, parent, false);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.textView);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        zhuboList=list.get(position);
        viewHolder.mTextView.setText(zhuboList.getNickname());
        mImageCacheHelper.loadImage(zhuboList.getSmallLogo(),viewHolder.mImageView);
        return convertView;
    }
    static class ViewHolder{
        private ImageView mImageView;
        private TextView mTextView;
        //private Button mButton;
    }
}
