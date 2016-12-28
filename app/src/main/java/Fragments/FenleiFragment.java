package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.FenleiAdapter;
import AsyncTasks.FenleiAsyncTask;
import AsyncTasks.LoadImage2AsyncTask;
import Base.FenleiItem;
import Base.UrlPaths;
import CallBack.CallBackFenleiItem;
import CallBack.CallBackImagePath;
import LogUtils.LogUtil;
import NewWork.ImageCacheHelper;

/**
 * A simple {@link Fragment} subclass.
 */
public class FenleiFragment extends Fragment {

    private ListView fenlei_listView=null;
    private ProgressBar progressBar=null;
    private ImageView imageHear=null,imageFoot=null;
    public FenleiFragment() {
        // Required empty public constructor
    }

    private FenleiAdapter mFenleiAdapter=null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_fenlei, container, false);
        fenlei_listView= (ListView) ret.findViewById(R.id.fenlei_listView);
        progressBar= (ProgressBar) ret.findViewById(R.id.progressBar);

        initData();
        initListView();

        return ret;
    }

    private void initListView() {
        //头布局，尾部局
        View headView= LayoutInflater.from(getContext()).inflate(R.layout.fenlei_headview,fenlei_listView, false);
        imageHear = (ImageView) headView.findViewById(R.id.imageView);//图片
        fenlei_listView.addHeaderView(headView);
//       View footView=LayoutInflater.from(getContext()).inflate(R.layout.fenlei_foot, fenlei_listView, false);
//        imageFoot= (ImageView) footView.findViewById(R.id.imageFoot);
//        fenlei_listView.addFooterView(footView);

        //当数据为空时
        fenlei_listView.setEmptyView(progressBar);
        LogUtil.d("Fenlei","------------数据空");
    }

    private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    private List<FenleiItem> mList1=new ArrayList<>();
    private void initData() {
        //获取头布局
        new LoadImage2AsyncTask(new CallBackImagePath() {
            @Override
            public void sendImagePath(String str) {
                mImageCacheHelper.loadImage(str,imageHear);
                LogUtil.d("Fenlei","------------头布局图片");
            }
        }).execute(UrlPaths.FIND_FENLEI_ITEM);
        new FenleiAsyncTask(mList1, new CallBackFenleiItem() {
            @Override
            public void sendFenleiItem(List<FenleiItem> list) {
                List<FenleiItem> list2=new ArrayList<FenleiItem>();
                List<List<FenleiItem>>lists=new ArrayList<List<FenleiItem>>();
                for (int i = 0; i < list.size(); i++) {
                    //mList1.add(list.get(i));
                    list2.add(list.get(i));
                    if (i%6==5||i==list.size()-1){
                        //mFenleiAdapter=new FenleiAdapter(mList1,getContext());
                        lists.add(list2);
                        list2=new ArrayList<FenleiItem>();
                    }
                }
                mFenleiAdapter=new FenleiAdapter(lists,getContext());
                fenlei_listView.setAdapter(mFenleiAdapter);
            }
        }).execute(UrlPaths.FIND_FENLEI_ITEM);
    }

}
