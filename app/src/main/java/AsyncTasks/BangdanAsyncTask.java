package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import BaseItemLayout.BangdanItem2;
import CallBack.CallBackBangdanItem2List;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class BangdanAsyncTask extends AsyncTask<String,Void,List<BangdanItem2>> {
    private List<BangdanItem2> mList=null;
    private CallBackBangdanItem2List mCallBackBangdanItem2List=null;

    public BangdanAsyncTask(List<BangdanItem2> list, CallBackBangdanItem2List callBackBangdanItem2List) {
        mList = list;
        mCallBackBangdanItem2List = callBackBangdanItem2List;
    }

    @Override
    protected List<BangdanItem2> doInBackground(String... params) {
        byte[] data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            mList= JsonHelper.bangdanItemJson(new String(data));
            return mList;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<BangdanItem2> bangdanItem2s) {
        super.onPostExecute(bangdanItem2s);
        mCallBackBangdanItem2List.sendBangdanItem2List(bangdanItem2s);
    }
}
