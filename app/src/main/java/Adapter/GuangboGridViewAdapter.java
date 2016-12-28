package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.List;
import Base.DiantaiName;

/**
 * Created by 三 on 2016/10/20.
 */
public class GuangboGridViewAdapter extends BaseAdapter {
    //private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private List<DiantaiName> mList=null;
    private OnCityClickListener onCityClickListener;
    DiantaiName mDiantaiName=null;
    private Context mContext=null;
    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public GuangboGridViewAdapter(List<DiantaiName> list, Context context) {
        mList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.guangbo_gridview_item1, parent, false);
            viewHolder.mButton = (Button) convertView.findViewById(R.id.text);
            //viewHolder.mImageView= (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.mImageView= (ImageView) convertView.findViewById(R.id.image);
            convertView.setTag(viewHolder);
        }else{
            viewHolder= (ViewHolder) convertView.getTag();
        }
        mDiantaiName=mList.get(position);

//        if (mDiantaiName.getName().equals("收起")){
//            //onCityClickListener.onItemClick(0);
//            viewHolder.mButton.setVisibility(View.GONE);
//            viewHolder.mImageView.setVisibility(View.VISIBLE);
//            viewHolder.mImageView.setImageResource(R.mipmap.ic_triangle_up);
//        }else {
//            //onCityClickListener.onItemClick(1);
//            viewHolder.mButton.setVisibility(View.GONE);
//            viewHolder.mImageView.setVisibility(View.VISIBLE);
//            viewHolder.mImageView.setImageResource(R.mipmap.ic_triangle_down);
//        }


        viewHolder.mButton.setText(mDiantaiName.getName());

        return convertView;
    }
    static class ViewHolder1{
        private ImageView mImageView;
        private TextView mTextView;
    }
    static class ViewHolder{
        private Button mButton;
        private ImageView mImageView;
    }

    public interface OnCityClickListener {
        void onItemClick(int a);

    }
}
