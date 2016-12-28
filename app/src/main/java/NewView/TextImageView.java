package NewView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.liujiang.day07xmly.R;

/**
 * Created by 三 on 2016/10/18.
 */
public class TextImageView extends ImageView {
    public TextImageView(Context context) {
        this(context,null);
    }

    public TextImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TextImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint=new Paint();
        textPaint=new TextPaint();
        paint.setAntiAlias(true);
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(20);
        //bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }
    private Paint paint=null;
    private TextPaint textPaint=null;
    private Bitmap bitmap=null;
    private String str=" ";
    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        invalidate();
    }
    public  void setStr(String str){
        this.str=str;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawBitmap(bitmap,0,0,paint);
        canvas.drawText(str,getWidth()/2-textPaint.measureText(str)/2,getHeight()-12.0f*getPaddingBottom(),textPaint);
    }
}
