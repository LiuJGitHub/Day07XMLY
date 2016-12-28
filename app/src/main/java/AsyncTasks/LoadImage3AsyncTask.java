package AsyncTasks;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import CallBack.CallBackImagePath;
import LogUtils.LogUtil;
import NewWork.HttpURLConnHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class LoadImage3AsyncTask extends AsyncTask<String,Void,String> {
    private CallBackImagePath callBackImagePath;
    //private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    //是ViewPager中要显示图片的ImageView
    public LoadImage3AsyncTask( CallBackImagePath callBackImagePath) {
        this.callBackImagePath = callBackImagePath;
    }

    @Override
    protected String doInBackground(String... params) {
        byte[] data = HttpURLConnHelper.loadByteFromURL(params[0]);
        String path=" ";
        try {
            JSONObject jsonObject=new JSONObject(new String(data));
            JSONObject jsonObject1=jsonObject.optJSONObject("focusImages");
            JSONArray jsonArray=jsonObject1.optJSONArray("list");
            JSONObject jsonObject2=jsonArray.optJSONObject(0);
            path=jsonObject2.optString("pic");
            return path;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(String str) {
        super.onPostExecute(str);
        if (str!=null) {
            callBackImagePath.sendImagePath(str);
        }
    }
}
