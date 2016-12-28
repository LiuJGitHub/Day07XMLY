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
import Base.FenleiItem;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class GridView2Adapter extends BaseAdapter {
    ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private List<FenleiItem> list=null;
    private Context mContext=null;

    public GridView2Adapter(List<FenleiItem> list, Context context) {
        this.list = list;
        mContext = context;
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
        if (convertView==null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fenlei_gridview_item0, parent, false);
            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.fenlei_text);
            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.fenlei_image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        FenleiItem finFenleiItem=list.get(position);
        mImageCacheHelper.loadImage(finFenleiItem.getCoverPath(),viewHolder.mImageView);
        viewHolder.mTextView.setText(finFenleiItem.getTitle());
        return convertView;
    }
    static class ViewHolder{
        TextView mTextView;
        ImageView mImageView;
    }
}
