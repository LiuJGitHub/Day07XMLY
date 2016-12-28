package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Base.FenleiItem;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class FenleiAdapter extends BaseAdapter {
    //private List<FenleiItem> mList1=null;
    private Context mContext=null;
    private List<FenleiItem> data=new ArrayList<>();
    private List<List<FenleiItem>> mList1=null;
    public FenleiAdapter( List<List<FenleiItem>> mList1, Context context) {
        this.mList1 = mList1;
        mContext = context;
    }
    @Override
    public int getCount() {
//        int count=mList1.size()/6;
//        if (mList1.size()%6>0){
//            count++;
//        }
//        return count;
        return mList1.size();
    }

    @Override
    public Object getItem(int position) {
        return mList1.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fenlei_item0, parent, false);
//            viewHolder.mTextView = (TextView) convertView.findViewById(R.id.fenlei_text);
//            viewHolder.mImageView = (ImageView) convertView.findViewById(R.id.fenlei_image);
            viewHolder.mGridView= (GridView) convertView.findViewById(R.id.fenlei_gridView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        data=mList1.get(position);

        //GridView2Adapter adapter=new GridView2Adapter(data,mContext);
        GridView2Adapter adapter=new GridView2Adapter(data,mContext);

        viewHolder.mGridView.setAdapter(adapter);

        return convertView;
    }
    static class ViewHolder{
        GridView mGridView;
    }
}
