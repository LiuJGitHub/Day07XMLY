package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import Base.ZhuboList;
import Base.ZhuboTitle;
import CallBack.CallBackZhubo;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/20.
 */
public class ZhuboAsynvTask extends AsyncTask<String,Void,List<ZhuboTitle>> {

    private List<ZhuboTitle> list=null;
    private CallBackZhubo mCallBackZhubo=null;

    public ZhuboAsynvTask(List<ZhuboTitle> list, CallBackZhubo callBackZhubo) {
        this.list = list;
        mCallBackZhubo = callBackZhubo;
    }

    @Override
    protected List<ZhuboTitle> doInBackground(String... params) {
        byte[] data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            list= JsonHelper.zhuboItemJson(new String(data));
            return list;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<ZhuboTitle> zhuboTitles) {
        super.onPostExecute(zhuboTitles);
        mCallBackZhubo.sendZhuboItem(zhuboTitles);
    }
}
