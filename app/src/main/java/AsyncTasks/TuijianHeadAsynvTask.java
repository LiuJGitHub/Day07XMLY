package AsyncTasks;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by 三 on 2016/10/18.
 */
//推荐的头布局的异步
public class TuijianHeadAsynvTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView mImageView;

    public TuijianHeadAsynvTask(ImageView imageView) {
        mImageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

    }
}
