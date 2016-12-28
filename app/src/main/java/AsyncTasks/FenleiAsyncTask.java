package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import Base.FenleiItem;
import CallBack.CallBackFenleiItem;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class FenleiAsyncTask extends AsyncTask<String,Void,List<FenleiItem>> {
    private List<FenleiItem> list=null;
    private CallBackFenleiItem mCallBackFenleiItem=null;

    public FenleiAsyncTask(List<FenleiItem> list, CallBackFenleiItem callBackFenleiItem) {
        this.list = list;
        mCallBackFenleiItem = callBackFenleiItem;
    }

    @Override
    protected List<FenleiItem> doInBackground(String... params) {
        byte[] data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            list= JsonHelper.FenleiItemJson(new String(data));
            return list;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<FenleiItem> fenleiItems) {
        super.onPostExecute(fenleiItems);
        mCallBackFenleiItem.sendFenleiItem(fenleiItems);
    }
}
