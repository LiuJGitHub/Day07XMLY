package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.BangdanAdapter;
import AsyncTasks.BangdanAsyncTask;
import AsyncTasks.LoadImage2AsyncTask;
import AsyncTasks.LoadImage3AsyncTask;
import Base.UrlPaths;
import BaseItemLayout.BangdanItem2;
import BaseItemLayout.BangdanItem3;
import BaseItemLayout.Item;
import CallBack.CallBackBangdanItem2List;
import CallBack.CallBackImagePath;
import LogUtils.LogUtil;
import NewWork.ImageCacheHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class BangdanFragment extends Fragment {
    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private ListView bangdan_listView=null;
    private ProgressBar progressBar=null;
    private ImageView imageHear=null;
    public BangdanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret=inflater.inflate(R.layout.fragment_bangdan, container, false);
        bangdan_listView= (ListView) ret.findViewById(R.id.bangdan_listView);
        progressBar= (ProgressBar) ret.findViewById(R.id.progressBar);
        initData();
        initListView();
        return ret;
    }
    private void initListView() {
        //头布局，尾部局
        View headView= LayoutInflater.from(getContext()).inflate(R.layout.fenlei_headview,bangdan_listView, false);
        imageHear = (ImageView) headView.findViewById(R.id.imageView);//图片
        bangdan_listView.addHeaderView(headView);
        //当数据为空时
//        String[]str=new String[]{"123","123","345","ert","657","xbx","123","123","345","ert","657","123","123","345","ert","657"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,str);
//        bangdan_listView.setAdapter(adapter);

        bangdan_listView.setEmptyView(progressBar);


}
    private List<BangdanItem2> bangdanlist=null;
    private BangdanAdapter adapter=null;
    private List<Item> itemlis=null;
    private void initData() {
        //获取头布局
        new LoadImage3AsyncTask(new CallBackImagePath() {
            @Override
            public void sendImagePath(String str) {
                mImageCacheHelper.loadImage(str,imageHear);
            }
        }).execute(UrlPaths.FIND_BANGDAN_ITEM);
        //
        new BangdanAsyncTask(bangdanlist, new CallBackBangdanItem2List() {
            @Override
            public void sendBangdanItem2List(List<BangdanItem2> list) {
                adapter=new BangdanAdapter(getContext());
                bangdan_listView.setAdapter(adapter);
                itemlis=new ArrayList<Item>();
                String str=" ";
                for (int i = 0; i < list.size(); i++) {
                    if (i==0){
                        str=list.get(i).getBangdanItem1().getTitle();
                        itemlis.add(list.get(i).getBangdanItem1());
                    }else{
                        LogUtil.d("tuijian", "-----------: "+str);
                        str=list.get(i-1).getBangdanItem1().getTitle();
                        if (!str.equals(list.get(i).getBangdanItem1().getTitle())){
                            BangdanItem3 bangdanItem3=new BangdanItem3();
                            itemlis.add(bangdanItem3);
                            itemlis.add(list.get(i).getBangdanItem1());
                        }
                    }

                    itemlis.add(list.get(i));
                }
                adapter.setList(itemlis);
            }
        }).execute(UrlPaths.FIND_BANGDAN_ITEM);

    }
}
