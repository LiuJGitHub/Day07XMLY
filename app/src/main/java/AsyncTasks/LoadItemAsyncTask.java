package AsyncTasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.liujiang.day07xmly.R;

import CallBack.CallBackBitmap;
import NewWork.HttpURLConnHelper;

/**
 * Created by 三 on 2016/10/18.
 */
public class LoadItemAsyncTask extends AsyncTask<String,Void,Bitmap> {
    private CallBackBitmap mCallBackBitmap=null;

    //是ViewPager中要显示图片的ImageView
    public LoadItemAsyncTask(CallBackBitmap mCallBackBitmap) {
        this.mCallBackBitmap= mCallBackBitmap;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        byte[] data = HttpURLConnHelper.loadByteFromURL(params[0]);
        if (data != null) {
            Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
            return bitmap;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        mCallBackBitmap.sendBItmap(bitmap);
    }
}
