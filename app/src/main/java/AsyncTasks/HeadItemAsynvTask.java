package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import Base.FinditemHead1;
import Base.FinditemHead2;
import CallBack.CallBaackFindHead2;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/18.
 */
public class HeadItemAsynvTask extends AsyncTask<String,Void,List<FinditemHead2>> {

    private List<FinditemHead2> mList=null;
    private CallBaackFindHead2 mCallBaackFindHead2=null;

    public HeadItemAsynvTask(List<FinditemHead2> list, CallBaackFindHead2 callBaackFindHead2) {
        mList = list;
        mCallBaackFindHead2 = callBaackFindHead2;
    }

    @Override
    protected List<FinditemHead2> doInBackground(String... params) {
        byte[]data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            mList= JsonHelper.finditemHead2ListJson(new String(data));
            return mList;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<FinditemHead2> finditemHead2s) {
        super.onPostExecute(finditemHead2s);
        mCallBaackFindHead2.sendListData(finditemHead2s);
    }
}
