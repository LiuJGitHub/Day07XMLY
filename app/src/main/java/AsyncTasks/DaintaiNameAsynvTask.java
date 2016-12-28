package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import Base.DiantaiName;
import CallBack.CallBackDiantaiName;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/20.
 */
public class DaintaiNameAsynvTask extends AsyncTask<String,Void,List<DiantaiName>> {
    private List<DiantaiName> mList=null;
    private CallBackDiantaiName mCallBackDiantaiName=null;

    public DaintaiNameAsynvTask(List<DiantaiName> list, CallBackDiantaiName callBackDiantaiName) {
        mList = list;
        mCallBackDiantaiName = callBackDiantaiName;
    }

    @Override
    protected List<DiantaiName> doInBackground(String... params) {
        byte[] data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            mList= JsonHelper.daintaiNameJson(new String(data));
            return mList;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<DiantaiName> diantaiNames) {
        super.onPostExecute(diantaiNames);
        mCallBackDiantaiName.sendDaintaiName(diantaiNames);
    }
}
