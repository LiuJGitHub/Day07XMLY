package AsyncTasks;

import android.os.AsyncTask;

import java.util.List;

import Base.FinditemEditorRecommend;
import CallBack.CallBackEditor;
import NewWork.HttpURLConnHelper;
import NewWork.JsonHelper;

/**
 * Created by 三 on 2016/10/19.
 */
//public class FinditemEditorRecommendAsyncTask extends AsyncTask<String,Void,List<FinditemEditorRecommend>> {
//    private List<FinditemEditorRecommend> list=null;
//    private CallBackEditor clCallBackEditor;
//
//    public FinditemEditorRecommendAsyncTask(List<FinditemEditorRecommend> list, CallBackEditor clCallBackEditor) {
//        this.list = list;
//        this.clCallBackEditor = clCallBackEditor;
//    }
//
////    @Override
////    protected List<FinditemEditorRecommend> doInBackground(String... params) {
////        byte[]data= HttpURLConnHelper.loadByteFromURL(params[0]);
////        if (data!=null){
////            list= JsonHelper.finditemEditorRecommendJson(new String(data));
////            return list;
////        }
////        return null;
////    }
//
//    @Override
//    protected void onPostExecute(List<FinditemEditorRecommend> finditemEditorRecommends) {
//        super.onPostExecute(finditemEditorRecommends);
//        clCallBackEditor.sendEditor(finditemEditorRecommends);
//    }
//}
