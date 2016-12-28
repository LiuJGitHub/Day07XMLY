package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Base.ZhuboList;
import Base.ZhuboTitle;

/**
 * Created by 三 on 2016/10/20.
 */
public class ZhuboAdapter extends BaseAdapter {
    private List<ZhuboTitle> list=null;
    private List<ZhuboList> list2=new ArrayList<>();
    private Context mContext=null;

    public ZhuboAdapter(List<ZhuboTitle> list, Context context) {
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.tuijian_item0, parent, false);
            viewHolder.mTextView1 = (TextView) convertView.findViewById(R.id.item0_textView);
            viewHolder.mGridView = (GridView) convertView.findViewById(R.id.gridView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        list2=list.get(position).getList();
        viewHolder.mTextView1.setText(list.get(position).getTitle());
        GridViewZBAdapter adapter=new GridViewZBAdapter(list2,mContext);
        viewHolder.mGridView.setAdapter(adapter);
        return convertView;
    }

    static class  ViewHolder{
        TextView mTextView1;
        GridView mGridView;
    }
}
