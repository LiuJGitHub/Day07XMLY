package AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import java.util.Date;
import java.util.List;
import BaseItemLayout.Item;
import CallBack.CallBackGuangbo;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;
import NewWork.MD5Helper;

/**
 * Created by 三 on 2016/10/21.
 */
public class GuangboAsyncTask extends AsyncTask<String,Void,List<Item>> {
    private List<Item> list=null;
    private CallBackGuangbo mCallBackGuangbo=null;

    public GuangboAsyncTask(List<Item> list, CallBackGuangbo callBackGuangbo) {
        this.list = list;
        mCallBackGuangbo = callBackGuangbo;
    }

    @Override
    protected List<Item> doInBackground(String... params) {
        byte[]data= HttpURLConnHelper.loadByteFromURL(params[0]);
//        Date dt= new Date();
//        Long time= dt.getTime();
//        Log.d("12121212", "doInBackground: "+time);
//        String str=MD5Helper.getMD5(time.toString());
//        Log.d("12121212", "doInBackground: "+str);
//        byte[]data2= HttpURLConnHelper.loadByteFromURL(params[1]);
//        String str1=new String(data2);
//                Log.d("12121212", "doInBackground: "+str1);
        if (data!=null){
            list= JsonHelper.guangboJson(new String(data));
            return list;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Item> items) {
        super.onPostExecute(items);
        mCallBackGuangbo.sendGuangbo(items);
    }
}
