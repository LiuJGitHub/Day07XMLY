package AsyncTasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.liujiang.day07xmly.R;
import NewWork.HttpURLConnHelper;
import NewWork.ImageCacheHelper;

/**
 * Created by 三 on 2016/9/21.
 */
public class LoadImageAsyncTask extends AsyncTask<String ,Void ,Bitmap> {
    private ImageView mImageView;
    //private ImageCacheHelper mImageCacheHelper=new ImageCacheHelper();
    //是ViewPager中要显示图片的ImageView
    public LoadImageAsyncTask(ImageView imageView) {
        this.mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        byte[] data = HttpURLConnHelper.loadByteFromURL(params[0]);
        //ImageCacheHelper.loadImage(params[0],mImageView);

        if (data != null) {
            Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
            return bitmap;
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap!=null){
            mImageView.setImageBitmap(bitmap);
        }else{
            mImageView.setImageResource(R.drawable.image_default_202);
        }
    }
}
