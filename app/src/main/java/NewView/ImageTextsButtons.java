package NewView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.liujiang.day07xmly.R;

/**
 * Created by 三 on 2016/10/18.
 * 图片，文字，文字
 */

public class ImageTextsButtons extends LinearLayout {
    private ImageView iv;
    private TextView tv1,tv2;


    public ImageTextsButtons(Context context) {
        this(context,null);
    }

    public ImageTextsButtons(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public ImageTextsButtons(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.image_text_btns, this,
                true);
        iv = (ImageView) findViewById(R.id.iv);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
    }
    //图片
    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
        invalidate();
    }

    //文字
    public void setDefaultImageResource(int resId) {
        iv.setImageResource(resId);
        invalidate();
    }

    public void setDefaultText1ViewText(String text) {
        tv1.setText(text);
        invalidate();
    }
    public void setDefaultText2ViewText(String text) {
        tv2.setText(text);
        invalidate();
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
    public void setTextView1Text(String text) {
        tv1.setText(text);
    }
    public void setTextView2Text(String text) {
        tv2.setText(text);
    }

    /**
     * @param color
     */
    public void setTextColor(int color) {
        tv1.setTextColor(color);
    }
}
