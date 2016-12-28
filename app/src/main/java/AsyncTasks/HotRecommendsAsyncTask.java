package AsyncTasks;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import Base.HotRecommends;
import Base.HotRecommendsList;
import CallBack.CallBackHotRecommends;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class HotRecommendsAsyncTask extends AsyncTask<String,Void,List<HotRecommendsList>> {
    private List<HotRecommendsList> list;

    private CallBackHotRecommends mCallBackHotRecommends=null;

    public HotRecommendsAsyncTask(List<HotRecommendsList> list, CallBackHotRecommends callBackHotRecommends) {
        this.list = list;
        mCallBackHotRecommends = callBackHotRecommends;
    }

    @Override
    protected List<HotRecommendsList> doInBackground(String... params) {
        List<HotRecommendsList> list2=new ArrayList<>();
        byte[] data= HttpURLConnHelper.loadByteFromURL(params[0]);

            list2= JsonHelper.finditemEditorRecommendJson(new String(data));
            list.addAll(list2);
        byte[] data2= HttpURLConnHelper.loadByteFromURL(params[1]);
            list2=new ArrayList<>();
            list= JsonHelper.hotRecommendsJson(new String(data2));
        list.addAll(list2);
        return list;
    }

    @Override
    protected void onPostExecute(List<HotRecommendsList> hotRecommendses) {
        super.onPostExecute(hotRecommendses);
        mCallBackHotRecommends.sendListHotRecommends(hotRecommendses);
    }
}
