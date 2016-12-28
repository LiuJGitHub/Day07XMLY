package Fragments;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.PagerImageAdapter;
import Adapter.PagerItemAdapter;
import Adapter.TuijianAdapter;
import AsyncTasks.HeadItemAsynvTask;
import AsyncTasks.HotRecommendsAsyncTask;
import AsyncTasks.ImageAsyncTack;
import Base.FinditemEditorRecommend;
import Base.FinditemHead1;
import Base.FinditemHead2;
import Base.HotRecommendsList;
import Base.UrlPaths;
import CallBack.CallBaackFindHead1;
import CallBack.CallBaackFindHead2;
import CallBack.CallBackHotRecommends;
import LogUtils.LogUtil;
import NewView.ImageTextButton;
import NewWork.ImageCacheHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class TuijianFragment extends Fragment {

    private ListView tuijian_listView;
    private ProgressBar progressBar;
    private ViewPager pagerImage,pagerItem;
    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    public TuijianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_tuijian, container, false);
        tuijian_listView= (ListView) ret.findViewById(R.id.tuijian_listView);
        progressBar= (ProgressBar) ret.findViewById(R.id.progressBar);
        initData();
        initListView();
//        initListener();
//        initHandler();
        return ret;
    }
    TuijianAdapter tuijianADapter=null;
    private void initListView() {
        //头布局，尾部局
        View headView= LayoutInflater.from(getContext()).inflate(R.layout.headview, tuijian_listView, false);
        pagerImage = (ViewPager) headView.findViewById(R.id.viewpager1);//图片
        pagerItem  = (ViewPager) headView.findViewById(R.id.viewpager2);//图标
        tuijian_listView.addHeaderView(headView);
//        View footView=LayoutInflater.from(getContext()).inflate(R.layout.footview, tuijian_listView, false);
//        tuijian_listView.addFooterView(footView);

//        //点击加载更多
//        LinearLayout addMore=(LinearLayout) footView.findViewById(R.id.addMore);
//        addMore.setOnClickListener(this);
//        TuijianAdapter adapter=new TuijianAdapter(getContext());
//        tuijian_listView.setAdapter(adapter);//数据源adapter
        String[]str=new String[]{"123","123","345","ert","657","xbx","123","123","345","ert","657","123","123","345","ert","657"};

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,str);
//        tuijian_listView.setAdapter(adapter);
        //当数据为空时
        tuijian_listView.setEmptyView(progressBar);
    }


    private List<FinditemHead1> mList=new ArrayList<>();
    private List<FinditemHead2> mList2=new ArrayList<>();
    private List<FinditemEditorRecommend> mList3=new ArrayList<>();
    private List<HotRecommendsList> mList4=new ArrayList<>();
    //listView获取数据
    private void initData() {
        //开异步，获取数据
        //获取头布局文件的地址
        new ImageAsyncTack(new CallBaackFindHead1() {
            @Override
            public void sendImagePath(List<FinditemHead1> list) {
                mList.addAll(list);
                LogUtil.d("flag","----------TuijianFrag"+mList.size());
                initPagerImageData(mList);
            }
        },mList).execute(UrlPaths.FIND_RECOMMEND_ITEM);
        //头布局第二部分
        new HeadItemAsynvTask(mList2, new CallBaackFindHead2() {
            @Override
            public void sendListData(List<FinditemHead2> list) {
                mList2.addAll(list);
                initPagerItem(mList2);
            }
        }).execute(UrlPaths.FIND_RECOMMEND_ITEM);
//        //解析小编推荐
//        new FinditemEditorRecommendAsyncTask(mList3, new CallBackEditor() {
//            @Override
//            public void sendEditor(List<FinditemEditorRecommend> list) {
//                mList3.addAll(list);
//                initEditorData(list);
//            }
//        }).execute(UrlPaths.FIND_RECOMMEND_ITEM);
        //听……
        new HotRecommendsAsyncTask(mList4, new CallBackHotRecommends() {
            @Override
            public void sendListHotRecommends(List<HotRecommendsList> list) {
                mList4.addAll(list);
                tuijianADapter=new TuijianAdapter(mList4,getContext(),mImageCacheHelper);
                tuijian_listView.setAdapter(tuijianADapter);
                LogUtil.d("flag","----------TuijianFrag mList4---"+mList4.size());
                LogUtil.d("flag","----------TuijianFrag tuijianADapter---"+tuijianADapter.toString());
            }
        }).execute(UrlPaths.FIND_RECOMMEND_ITEM,UrlPaths.FIND_RECOMMEND_ITEM2);
    }

    private void initEditorData(List<FinditemEditorRecommend> list) {

    }


    private void initPagerImageData(List<FinditemHead1> list) {
        List<ImageView> imageViews=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
                LogUtil.d("flag","----------TuijianFrag2"+mList.size());
                ImageView imageView=new ImageView(getContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //new LoadImageAsyncTask(imageView).execute(list.get(i).getPic());
                //三级缓存
                mImageCacheHelper.loadImage(list.get(i).getPic(),imageView);
                imageViews.add(imageView);
        }
        PagerImageAdapter adapterImage = new PagerImageAdapter(imageViews);
        pagerImage.setAdapter(adapterImage);
    }

       private void initPagerItem(List<FinditemHead2> list2) {
        //PagerListItemAdapter pagerLiseItemAdapter=new PagerListItemAdapter(getContext());

        List<ImageTextButton> newViews=new ArrayList<>();//自定义View
        for (int i = 0; i < list2.size(); i++) {
            LogUtil.d("flag","----------TuijianFrag2"+mList.size());
            ImageTextButton imageTextButton=new ImageTextButton(getContext());

            ImageView imageView=imageTextButton.getIv();
            mImageCacheHelper.loadImage(list2.get(i).getCoverPath(),imageView);
            imageTextButton.setIv(imageView);
            imageTextButton.setTextViewText(list2.get(i).getTitle());

            newViews.add(imageTextButton);

            LogUtil.d("flag","----------gridView.setAdapter"+list2);
        }
        PagerItemAdapter adapterItem=new PagerItemAdapter(newViews);
        pagerItem.setAdapter(adapterItem);
        LogUtil.d("flag","----------pagerItem.setAdapter");

    }
    //private int position=0;//位置
    private int position=Integer.MAX_VALUE/2;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(this.hasMessages(100)){
                this.removeMessages(100);//不让case是100的Message有过多的重复
            }
            switch (msg.what){
                case 100:
                    position++;
                    //因为现在数很大。
//                    if (position >= 3) {
//                        position=0;
//                    }
                    pagerImage.setCurrentItem(position);//设置ViewPager的位置
                    this.sendEmptyMessageDelayed(100,3000);//循环往替的执行
                    break;
                case 200:
                    if (this.hasMessages(100)) {//查看有没有100这个消息
                        //移除掉
                        this.removeMessages(100);
                    }
                    break;
                case 300:
                    //获取当前的位置
                    position=msg.arg1;
                    //发起自动轮播
                    this.sendEmptyMessageDelayed(100,3000);
                    break;
            }
        }
    };

    private void initHandler() {
        mHandler.sendEmptyMessageDelayed(100,3000);//三秒的延迟
    }
    private void initListener(){
        pagerImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                //之前的还原
//                indicators[lastIndes].setEnabled(true);
//
//                //指示球改变
//                indicators[position%3].setEnabled(false);
//                lastIndes=position%3;
                //参数2：arg1：position
                mHandler.sendMessage(mHandler.obtainMessage(300,position,0));//arg2没有用，随便赋值为0

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING://手正在滑动
                        //让轮播停掉
                        mHandler.sendEmptyMessage(200);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE://表示静止状态

                        break;
                    case ViewPager.SCROLL_STATE_SETTLING://设置，介于手动滑动和静止状态之间

                        break;
                }

            }
        });

    }


}
