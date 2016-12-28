package AsyncTasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.liujiang.day07xmly.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import CallBack.CallBackImagePath;
import LogUtils.LogUtil;
import NewWork.HttpURLConnHelper;

/**
 * Created by 三 on 2016/10/19.
 */
public class LoadImage2AsyncTask extends AsyncTask<String ,Void ,String> {
    private CallBackImagePath callBackImagePath;
    //private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    //是ViewPager中要显示图片的ImageView
    public LoadImage2AsyncTask( CallBackImagePath callBackImagePath) {
        this.callBackImagePath = callBackImagePath;
    }

    @Override
    protected String doInBackground(String... params) {
        byte[] data = HttpURLConnHelper.loadByteFromURL(params[0]);
        String path=" ";
        try {
            JSONObject jsonObject=new JSONObject(new String(data));
            JSONArray jsonArray=jsonObject.optJSONArray("list");
            for (int i = 0; i < 1; i++) {
                JSONObject jsonObject1=jsonArray.optJSONObject(i);
                path=jsonObject1.optString("coverPath");
            }
            LogUtil.d("Async","-------------path:"+path);
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
