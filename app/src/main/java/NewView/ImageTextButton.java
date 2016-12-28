package NewView;

/**
 * Created by 三 on 2016/10/18.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

public class ImageTextButton extends LinearLayout {
    private ImageView iv;
    private TextView tv;

    public ImageTextButton(Context context) {
        this(context,null);
    }

    public ImageTextButton(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public ImageTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.image_text_buttton, this,
                true);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);
    }

    public ImageView getIv() {
        return iv;
    }
    public void setIv(ImageView iv) {
        this.iv = iv;
        invalidate();
    }

    public void setDefaultImageResource(int resId) {
        iv.setImageResource(resId);
    }

    public void setDefaultTextViewText(String text) {
        tv.setText(text);
    }

    /**
     * @param resId
     */
    public void setImageResource(int resId) {
        iv.setImageResource(resId);
    }


    /**
     * @param text
     */
    public void setTextViewText(String text) {
        tv.setText(text);
    }

    /**
     * @param color
     */
    public void setTextColor(int color) {
        tv.setTextColor(color);
    }

}