package LogUtils;

import android.util.Log;

/**
 * Created by 三 on 2016/10/17.
 */
public class LogUtil {
    public static boolean isDebug=true;

    public static void i(String tag,String msg){
        if (isDebug){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if (isDebug){
            Log.d(tag,msg);
        }
    }
}
