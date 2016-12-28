package Fragments;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.MainAdapter;
import AsyncTasks.FindItemAsyncTask;
import Base.FindItem;
import Base.UrlPaths;
import CallBack.CallBackFindItem;
import LogUtils.LogUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager mainFragment_viewPager;
    private LinearLayout mainFragment_tabs;
    private LinearLayout mainFragment_indicator;//指示条

    private TextView[] textTabs=new TextView[5];
    //指示线
    private View[] lineIndicator=new View[5];
    //ViewPager数据源
    private List<FindItem> dataFindItem=new ArrayList<>();
    private List<Fragment> dataFragment=new ArrayList<>();
    private FragmentManager mFragmentManager;
    private Fragment mCurrentFragment,tuijianFragment,bangdanFragment,zhuboFragment,fenleiFragment,guangboFragment;

    @SuppressLint("ValidFragment")
    public MainFragment(FragmentManager mFragmentManager) {
        // Required empty public constructor
        this.mFragmentManager=mFragmentManager;
    }

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_main, container, false);
        mainFragment_viewPager= (ViewPager) ret.findViewById(R.id.mainFragment_viewPager);
        mainFragment_tabs= (LinearLayout) ret.findViewById(R.id.mainFragment_tabs);
        mainFragment_indicator= (LinearLayout) ret.findViewById(R.id.mainFragment_indicator);
        initFragment();
        initData();
        initViewPager();
        initTabs();
        initListener();

        return ret;
    }


    private void initFragment() {

        tuijianFragment= new TuijianFragment();
        bangdanFragment=new BangdanFragment();
        zhuboFragment=new ZhuboFragment();
        guangboFragment=new GuangboFragment();
        fenleiFragment=new FenleiFragment();
    }

    private void initListener() {
        //设置ViewPager的滑动监听
        mainFragment_viewPager.addOnPageChangeListener(this);
    }

    private void initTabs() {
        for (int i = 0; i < 5; i++) {
            TextView textView= (TextView) mainFragment_tabs.getChildAt(i);
            //设置Tag来区分
            textView.setTag(i);
            //监听
            textView.setOnClickListener(this);

            textTabs[i]=textView;
            //指示线
            View line = mainFragment_indicator.getChildAt(i);
            lineIndicator[i]=line;
        }
        //设置1位置是默认选中状态。
        textTabs[0].setTextColor(Color.RED);

    }
    private void initViewPager() {
        MainAdapter adapter=new MainAdapter(mFragmentManager,dataFragment);
        mainFragment_viewPager.setAdapter(adapter);
    }

    private void initData() {

        dataFragment.add(tuijianFragment);
        dataFragment.add(fenleiFragment);
        dataFragment.add(guangboFragment);
        dataFragment.add(bangdanFragment);
        dataFragment.add(zhuboFragment);

        new FindItemAsyncTask(new CallBackFindItem() {
            @Override
            public void sendItem(List<FindItem> list) {
                dataFindItem.addAll(list);
                initText(dataFindItem);
                LogUtil.d("flag","-------"+dataFindItem.size());
            }
        },dataFindItem).execute(UrlPaths.FIND_ITEM);
    }
    //给标题赋值
    private void initText(List<FindItem> dataFindItem) {
        for (int i = 0; i < mainFragment_tabs.getChildCount(); i++) {
            TextView textView= (TextView) mainFragment_tabs.getChildAt(i);
            textView.setText(dataFindItem.get(i).getTitle());
        }
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }


    //记录上次选中的位置
    private int lastIndex=0;
    //滑动状态发生改变
    @Override
    public void onPageSelected(int position) {
        textTabs[position].setTextColor(Color.RED);
        //指示线
        lineIndicator[position].setVisibility(View.VISIBLE);
        //将之前的指示线隐藏
        textTabs[lastIndex].setTextColor(0xff707070);
        lineIndicator[lastIndex].setVisibility(View.INVISIBLE);
        lastIndex=position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //
    @Override
    public void onClick(View v) {
        //接收Tag来区分
        int index= (int) v.getTag();
        //参数2：不进行平滑的滚动，直接就到指定界面，没有滑动效果。
        mainFragment_viewPager.setCurrentItem(index,false);
    }
}
