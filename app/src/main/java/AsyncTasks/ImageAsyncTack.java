package AsyncTasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.util.List;

import Base.FinditemHead1;
import CallBack.CallBaackFindHead1;
import LogUtils.LogUtil;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/18.
 */
public class ImageAsyncTack extends AsyncTask<String,Void,List<FinditemHead1>> {
    private List<FinditemHead1> mList=null;
    private CallBaackFindHead1 mCallBaackFindHead1=null;
    public ImageAsyncTack(CallBaackFindHead1 mCallBaackFindHead1,List<FinditemHead1> list) {
        this.mCallBaackFindHead1=mCallBaackFindHead1;
        mList = list;
    }

    @Override
    protected List<FinditemHead1> doInBackground(String... params) {
        byte[]data= HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data!=null){
            mList= JsonHelper.findListViewHead1Json(new String(data));
            LogUtil.d("flag","-------ImageAsync"+mList.size());
            return mList;
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<FinditemHead1> list) {
        super.onPostExecute(list);
        mCallBaackFindHead1.sendImagePath(list);
    }
}
