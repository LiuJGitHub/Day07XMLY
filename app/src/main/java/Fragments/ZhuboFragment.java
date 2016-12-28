package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.List;

import Adapter.ZhuboAdapter;
import AsyncTasks.ZhuboAsynvTask;
import Base.UrlPaths;
import Base.ZhuboTitle;
import CallBack.CallBackZhubo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhuboFragment extends Fragment {


    private ListView zhubo_listView=null;
    private ProgressBar progressBar=null;
    private int page=1;
    public ZhuboFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret=inflater.inflate(R.layout.fragment_zhubo, container, false);
        zhubo_listView= (ListView) ret.findViewById(R.id.zhubo_listView);
        progressBar= (ProgressBar) ret.findViewById(R.id.progressBar);
        initData();
        initListView();
        return ret;
    }

    private void initListView() {

        View footView=LayoutInflater.from(getContext()).inflate(R.layout.zhubo_footview, zhubo_listView, false);
        zhubo_listView.addFooterView(footView);

        //点击加载更多
        final LinearLayout addMore=(LinearLayout) footView.findViewById(R.id.addMore);
        addMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page++;
                if (page>=3){
                    addMore.setVisibility(View.GONE);
                    page=2;
                }
               initData();
            }
        });
        zhubo_listView.setEmptyView(progressBar);
    }

    private List<ZhuboTitle> zhubolist=new ArrayList<>();
    private ZhuboAdapter mZhuboAdapter=null;
    private void initData() {
        new ZhuboAsynvTask(zhubolist, new CallBackZhubo() {
            @Override
            public void sendZhuboItem(List<ZhuboTitle> list) {
                zhubolist.addAll(list);
                mZhuboAdapter=new ZhuboAdapter(zhubolist,getContext());
                zhubo_listView.setAdapter(mZhuboAdapter);
            }
        }).execute(UrlPaths.FIND_ZHUBO_ITEM+page);

    }

}
