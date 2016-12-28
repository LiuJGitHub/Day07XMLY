package Adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import LogUtils.LogUtil;
import NewView.ImageTextButton;
import NewView.TextImageView;

/**
 * Created by 三 on 2016/10/18.
 */
public class PagerItemAdapter extends PagerAdapter {
    private List<ImageTextButton>  data;

    public PagerItemAdapter(List<ImageTextButton> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        LogUtil.d("flag","---------PagerItemAdapter--"+data.size());
        return data.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageTextButton ret=data.get(position);
        container.addView(ret);
        return ret;

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView(data.get(position));
    }

    @Override
    public float getPageWidth(int position) {
        return (float) 0.25;
    }
}
