package AsyncTasks;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import Base.FindItem;
import CallBack.CallBackFindItem;
import LogUtils.LogUtil;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/17.
 */
public class FindItemAsyncTask extends AsyncTask<String,Void,List<FindItem>> {
    private FindItem findItem=null;
    private List<FindItem> list=new ArrayList<>();
    private CallBackFindItem callBackFindItem=null;

    public FindItemAsyncTask(CallBackFindItem callBackFindItem,List<FindItem> list) {
        this.callBackFindItem = callBackFindItem;
        this.list=list;
    }


    @Override
    protected List<FindItem> doInBackground(String... params) {
        byte[] str = HttpURLConnHelper.loadByteFromURL(params[0]);
        if (list!=null){
            list = JsonHelper.findItemJson(new String(str));
            LogUtil.d("flag","-------Async"+list.size());
            return list;
        }
        return null;

    }

    @Override
    protected void onPostExecute(List<FindItem> list) {
        super.onPostExecute(list);
        callBackFindItem.sendItem(list);
    }
}
