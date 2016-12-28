package Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.liujiang.day07xmly.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Adapter.GuangboAdapter;
import Adapter.GuangboGridViewAdapter;
import AsyncTasks.DaintaiNameAsynvTask;
import AsyncTasks.GuangboAsyncTask;
import Base.DiantaiName;
import Base.UrlPaths;
import BaseItemLayout.Item;
import CallBack.CallBackDiantaiName;
import CallBack.CallBackGuangbo;
import LogUtils.LogUtil;
import NewWork.MD5Helper;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuangboFragment extends Fragment  {

    private ListView guangbo_listView=null;
    private ProgressBar progressBar=null;
    private GridView guangbo_head_listView=null;
    public GuangboFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret = inflater.inflate(R.layout.fragment_guangbo, container, false);
        guangbo_listView= (ListView) ret.findViewById(R.id.guangbo_listView);
        progressBar= (ProgressBar) ret.findViewById(R.id.progressBar);
        initListView();
        initData();


        return ret;
    }

    private void initListView() {
        //头布局，尾部局
        View headView= LayoutInflater.from(getContext()).inflate(R.layout.guangbo_headview, guangbo_listView, false);
        guangbo_head_listView= (GridView) headView.findViewById(R.id.guangbo_head_listView);
        //gridlayout= (GridLayout) headView.findViewById(R.id.gridlayout);
        guangbo_listView.addHeaderView(headView);


//        String[]str=new String[]{"123","123","345","ert","657","xbx","123","123","345","ert","657","123","123","345","ert","657"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_dropdown_item_1line,str);
//        guangbo_listView.setAdapter(adapter);
        //当数据为空时
        guangbo_listView.setEmptyView(progressBar);
    }
    //private GuangboHeadAdapter guangboHeadAdapter=null;
    private GuangboGridViewAdapter guangboHeadAdapter=null;
    private GuangboAdapter mGuangboAdapter=null;
    private List<DiantaiName> namelist=new ArrayList<>();
    //private List<DiantaiName> namelist2=new ArrayList<>();
    private boolean flage=true;

    private  List<Item> itemlist=new ArrayList<>();
    private void initData() {
        new DaintaiNameAsynvTask(namelist, new CallBackDiantaiName() {
            @Override
            public void sendDaintaiName(final List<DiantaiName> list) {
                guangboHeadAdapter=new GuangboGridViewAdapter(namelist,getContext());
                //namelist.addAll(list);
                for (int i = 0; i < list.size(); i++) {
                    namelist.add(list.get(i));
                }
                DiantaiName diantaiName=new DiantaiName();
                if (flage){
                    diantaiName.setName("  ");
                    namelist.add(diantaiName);
                }else {
                    diantaiName.setName("  ");
                    namelist.add(diantaiName);
                }
                //guangboHeadAdapter=new GuangboHeadAdapter(lists,getContext());

                guangbo_head_listView.setAdapter(guangboHeadAdapter);



            }
        }).execute(UrlPaths.FIND_DINATAI_ITEM);

        Date dt= new Date();
        Long time= dt.getTime();
        Log.d("12121212", "doInBackground: "+time);
        String str= MD5Helper.getMD5(time.toString());
        Log.d("12121212", "doInBackground: "+str);
        new GuangboAsyncTask(itemlist, new CallBackGuangbo() {
            @Override
            public void sendGuangbo(List<Item> list) {
                itemlist.addAll(list);
                //LogUtil.d("JSONGUANGBO","------------------"+itemlist);
                mGuangboAdapter=new GuangboAdapter(getContext());
                guangbo_listView.setAdapter(mGuangboAdapter);
                mGuangboAdapter.setList(itemlist);

            }
        }).execute(UrlPaths.FIND_DINATAI_ITEM,"zpark.aishuoke.com.cn/interfaces/Index/index?apikey="+str);

    }

    //监听
    private int initLinstener(List<DiantaiName> list) {
        if (!flage){
            //diantaiName.setName("放开");
            flage=!flage;
            return 7;
        }else {
            //diantaiName.setName("收起");
            flage=!flage;
            return 15;
        }
}
}
