package NewWork;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Base.DiantaiName;
import Base.EditorRecommendAlbums;
import Base.FenleiItem;
import Base.FindItem;
import Base.FinditemEditorRecommend;
import Base.FinditemHead1;
import Base.FinditemHead2;
import Base.FinditemSpecialColumn;
import Base.HotRecommendsList;
import Base.HotRecommendsListListen;
import Base.SpecialColumn;
import Base.ZhuboList;
import Base.ZhuboTitle;
import BaseItemLayout.BangdanItem1;
import BaseItemLayout.BangdanItem2;
import BaseItemLayout.BangdanItem3;
import BaseItemLayout.FirstKResults;
import BaseItemLayout.GuangboItem;
import BaseItemLayout.GuangboTitle;
import BaseItemLayout.Item;
import LogUtils.LogUtil;

/**
 * Created by 三 on 2016/10/17.
 */
public class JsonHelper {
    public static List<FindItem> findItemJson(String str){
        List<FindItem> ret=new ArrayList<>();
        FindItem findItem=null;
        try {
            JSONObject jsonObject1=new JSONObject(str);
            JSONObject jsonObject2=jsonObject1.optJSONObject("tabs");
            JSONArray jsonArray3=jsonObject2.optJSONArray("list");
            for (int i = 0; i < jsonArray3.length(); i++) {
                findItem=new FindItem();
                JSONObject jsonObject4=jsonArray3.optJSONObject(i);
                findItem.setTitle(jsonObject4.optString("title"));
                ret.add(findItem);
            }

        return ret;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    //FIND_RECOMMEND_ITEM
    public static List<Object>findRecommendItemJson(String str){
        List<Object> list=new ArrayList<>();
        List<FinditemHead1> findlist1=new ArrayList<>();
        List<FinditemHead2> findlist2=new ArrayList<>();
        List<FinditemEditorRecommend> editorlist=new ArrayList<>();//小编推荐
        List<EditorRecommendAlbums> editorlist2=new ArrayList<>();
        List<FinditemSpecialColumn> speciallist=new ArrayList<>();
        List<SpecialColumn> speciallist2=new ArrayList<>();
        FinditemHead1 finditemHead1=null;
        FinditemHead2 finditemHead2=null;
        FinditemEditorRecommend finditemEditorRecommend=null;
        EditorRecommendAlbums editorRecommendAlbums=null;
        FinditemSpecialColumn specialColumn=null;
        SpecialColumn specialColumn1=null;

        try {
            JSONObject jsonObject1=new JSONObject(str);
            //FinditemHead2
            JSONObject jsonObject2=jsonObject1.optJSONObject("discoveryColumns");
            JSONArray jsonArray3=jsonObject2.optJSONArray("list");
            for (int i = 0; i < jsonArray3.length(); i++) {
                JSONObject jsonObject4=jsonArray3.optJSONObject(i);
                finditemHead2=new FinditemHead2();
                finditemHead2.setTitle(jsonObject4.optString("title"));
                finditemHead2.setCoverPath(jsonObject4.optString("coverPath"));
                findlist2.add(finditemHead2);
            }

            list.add(findlist2);

            //FinditemEditorRecommend
            JSONObject jsonObject4=jsonObject1.optJSONObject("editorRecommendAlbums");
            finditemEditorRecommend=new FinditemEditorRecommend();
            finditemEditorRecommend.setTitle(jsonObject4.optString("title"));
            JSONArray jsonArray5=jsonObject4.optJSONArray("list");
            /**
             *EditorRecommendAlbums {
             String intro;nickname;albumCoverUrl290;title;
             int tracks;//集数 int playsCounts;//下载量
             * */
            for (int i = 0; i < jsonArray5.length(); i++) {
                JSONObject jsonObject6=jsonArray5.optJSONObject(i);
                editorRecommendAlbums=new EditorRecommendAlbums();
                editorRecommendAlbums.setIntro(jsonObject6.optString("intro"));
                editorRecommendAlbums.setNickname(jsonObject6.optString("nickname"));
                editorRecommendAlbums.setAlbumCoverUrl290(jsonObject6.optString("coverLarge"));
                editorRecommendAlbums.setTitle(jsonObject6.optString("title"));
                editorRecommendAlbums.setTracks(jsonObject6.optInt("tracks"));
                editorRecommendAlbums.setPlaysCounts(jsonObject6.optInt("playsCounts"));
                editorlist2.add(editorRecommendAlbums);
            }
            finditemEditorRecommend.setList(editorlist2);
            //editorlist.add(finditemEditorRecommend);

            list.add(finditemEditorRecommend);
            //FinditemHead1
            JSONObject jsonObject7=jsonObject1.optJSONObject("focusImages");
            JSONArray jsonArray8=jsonObject7.optJSONArray("list");
            for (int i = 0; i < jsonArray8.length(); i++) {
                JSONObject jsonObject9=jsonArray8.optJSONObject(i);
                finditemHead1=new FinditemHead1();
                finditemHead1.setPic(jsonObject9.optString("pic"));
                finditemHead1.setUrl(jsonObject9.optString("url"));
                findlist1.add(finditemHead1);
            }

            list.add(findlist1);

            //SpecialColumn
            JSONObject jsonObject10=jsonObject1.optJSONObject("specialColumn");
            specialColumn=new FinditemSpecialColumn();
            specialColumn.setTitle(jsonObject10.optString("title"));
            /**
             * SpecialColumn {
             String title; subtitle; footnote; coverPath;
             * */
            JSONArray jsonArray11=jsonObject10.optJSONArray("list");
            for (int i = 0; i < jsonArray11.length(); i++) {
                JSONObject jsonObject12=jsonArray11.optJSONObject(i);
                specialColumn1=new SpecialColumn();
                specialColumn1.setTitle(jsonObject12.optString("title"));
                specialColumn1.setSubtitle(jsonObject12.optString("subtitle"));
                specialColumn1.setFootnote(jsonObject12.optString("footnote"));
                specialColumn1.setCoverPath(jsonObject12.optString("coverPath"));
                speciallist2.add(specialColumn1);
                LogUtil.d("flag","-----------list"+speciallist2.size());
            }
            specialColumn.setList(speciallist2);

            list.add(specialColumn);
            LogUtil.d("flag","-----------list"+list.size());
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //头布局轮播视图
    public static List<FinditemHead1>findListViewHead1Json(String str){
        List<FinditemHead1> findlist1=new ArrayList<>();
        FinditemHead1 finditemHead1=null;
        try {
            JSONObject jsonObject1=new JSONObject(str);
            JSONObject jsonObject7=jsonObject1.optJSONObject("focusImages");
            JSONArray jsonArray8=jsonObject7.optJSONArray("list");
            for (int i = 0; i < jsonArray8.length(); i++) {
                JSONObject jsonObject9=jsonArray8.optJSONObject(i);
                finditemHead1=new FinditemHead1();
                finditemHead1.setPic(jsonObject9.optString("pic"));
                finditemHead1.setUrl(jsonObject9.optString("url"));
                findlist1.add(finditemHead1);
            }
            return findlist1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //头布局第二部分
    public static List<FinditemHead2> finditemHead2ListJson(String str){
        //FinditemHead2
        List<FinditemHead2> findlist2=new ArrayList<>();
        FinditemHead2 finditemHead2=null;
        JSONObject jsonObject1= null;
        try {
            jsonObject1 = new JSONObject(str);
            JSONObject jsonObject2=jsonObject1.optJSONObject("discoveryColumns");
            JSONArray jsonArray3=jsonObject2.optJSONArray("list");
            for (int i = 0; i < jsonArray3.length(); i++) {
                JSONObject jsonObject4=jsonArray3.optJSONObject(i);
                finditemHead2=new FinditemHead2();
                finditemHead2.setTitle(jsonObject4.optString("title"));
                finditemHead2.setCoverPath(jsonObject4.optString("coverPath"));
                findlist2.add(finditemHead2);
            }
            return findlist2;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //解析小编推荐
    public static List<HotRecommendsList> finditemEditorRecommendJson(String str) {

        List<HotRecommendsList> list2=new ArrayList<>();
        List<HotRecommendsListListen> list3=null;
        //HotRecommends hotRecommends=null;
        HotRecommendsList hotRecommendsList=null;
        HotRecommendsListListen hotRecommendsListListen=null;
        JSONObject jsonObject1= null;
        try {
            jsonObject1 = new JSONObject(str);
            //FinditemEditorRecommend
            JSONObject jsonObject4=jsonObject1.optJSONObject("editorRecommendAlbums");
            hotRecommendsList=new HotRecommendsList();
            hotRecommendsList.setTitle(jsonObject4.optString("title"));
            JSONArray jsonArray5=jsonObject4.optJSONArray("list");
            list3=new ArrayList<>();
            for (int i = 0; i < jsonArray5.length(); i++) {
                JSONObject jsonObject6=jsonArray5.optJSONObject(i);
                hotRecommendsListListen=new HotRecommendsListListen();
                hotRecommendsListListen.setIntro(jsonObject6.optString("intro"));
                hotRecommendsListListen.setTrackTitle(jsonObject6.optString("title"));
                hotRecommendsListListen.setAlbumCoverUrl290(jsonObject6.optString("albumCoverUrl290"));
                list3.add(hotRecommendsListListen);
            }
            hotRecommendsList.setList(list3);
            list2.add(hotRecommendsList);
            return  list2;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //听……………………
    public static List<HotRecommendsList> hotRecommendsJson(String str){
        //List<HotRecommends> list =new ArrayList<>();
        List<HotRecommendsList> list2=new ArrayList<>();
        List<HotRecommendsListListen> list3=null;
        //HotRecommends hotRecommends=null;
        HotRecommendsList hotRecommendsList=null;
        HotRecommendsListListen hotRecommendsListListen=null;
        JSONObject jsonObject1= null;
        try {
            jsonObject1 = new JSONObject(str);
            JSONObject jsonObject2=jsonObject1.optJSONObject("hotRecommends");

            JSONArray jsonArray3=jsonObject2.optJSONArray("list");

            for (int i = 0; i < jsonArray3.length(); i++) {
                JSONObject jsonObject4=jsonArray3.optJSONObject(i);
                hotRecommendsList=new HotRecommendsList();
                //听健康有bug
                if (jsonObject4.optString("title").equals("听健康")){
                    continue;
                }
                hotRecommendsList.setTitle(jsonObject4.optString("title"));
                JSONArray jsonArray5=jsonObject4.optJSONArray("list");
                list3=new ArrayList<>();
                for (int i1 = 0; i1 < jsonArray5.length(); i1++) {
                    JSONObject jsonObject6=jsonArray5.optJSONObject(i1);
                    hotRecommendsListListen=new HotRecommendsListListen();
                    hotRecommendsListListen.setIntro(jsonObject6.optString("intro"));
                    hotRecommendsListListen.setAlbumCoverUrl290(jsonObject6.optString("albumCoverUrl290"));
                    hotRecommendsListListen.setTrackTitle(jsonObject6.optString("trackTitle"));
                    list3.add(hotRecommendsListListen);

                }
                //LogUtil.d("JSON","------------jsonArray5---"+ jsonArray5.length());
                hotRecommendsList.setList(list3);
                //LogUtil.d("JSON","------------jsonArray5-++--"+hotRecommendsList.toString());
                list2.add(hotRecommendsList);
                //LogUtil.d("JSON","------------jsonArray5 -list2----"+ list2.size());
            }
            //hotRecommends.setList(list2);
            //list.add(hotRecommends);
            return list2;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //分类中的item
    public static List<FenleiItem> FenleiItemJson(String str){
        List<FenleiItem> list=new ArrayList<>();
        FenleiItem fenleiItem=null;
        JSONObject jsonObject1= null;
        try {
            jsonObject1 = new JSONObject(str);
            JSONArray jsonArray2=jsonObject1.optJSONArray("list");
            for (int i = 0; i < jsonArray2.length(); i++) {
                if (i>0){
                    JSONObject jsonObject3=jsonArray2.getJSONObject(i);
                    fenleiItem=new FenleiItem();
                    fenleiItem.setTitle(jsonObject3.optString("title"));
                    fenleiItem.setCoverPath(jsonObject3.optString("coverPath"));
                    list.add(fenleiItem);
                }
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    //榜单中的item BangdanItem2
    public static List<BangdanItem2> bangdanItemJson(String str){
        List<BangdanItem2> list=new ArrayList<>();
        //List<BangdanItem3> list1=null;
        List<FirstKResults> list2=null;
        BangdanItem1 bangdanItem1=null;
        BangdanItem2 bangdanItem2=null;
        FirstKResults firstKResults=null;
        try {
            JSONObject jsonObject=new JSONObject(str);
            JSONArray jsonArray1=jsonObject.optJSONArray("datas");
            for (int i = 0; i < jsonArray1.length(); i++) {
                JSONObject jsonObject2=jsonArray1.optJSONObject(i);
                bangdanItem1=new BangdanItem1();
                bangdanItem1.setTitle(jsonObject2.optString("title"));
                JSONArray jsonArray3=jsonObject2.optJSONArray("list");
                for (int i1 = 0; i1 < jsonArray3.length(); i1++) {
                    JSONObject jsonObject4=jsonArray3.optJSONObject(i1);
                    bangdanItem2=new BangdanItem2();
                    bangdanItem2.setBangdanItem1(bangdanItem1);
                    bangdanItem2.setTitle(jsonObject4.optString("title"));
                    bangdanItem2.setCoverPath(jsonObject4.optString("coverPath"));
                    JSONArray jsonArray5=jsonObject4.optJSONArray("firstKResults");
                    list2=new ArrayList<>();
                    for (int i2 = 0; i2 < jsonArray5.length(); i2++) {
                        JSONObject jsonObject6=jsonArray5.optJSONObject(i2);
                        firstKResults=new FirstKResults();
                        firstKResults.setTitle(jsonObject6.optString("title"));
                        list2.add(firstKResults);
                    }
                    bangdanItem2.setList(list2);
                    list.add(bangdanItem2);
                }

            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    //解析主播item
    public static List<ZhuboTitle> zhuboItemJson(String str){
        List<ZhuboTitle> list=new ArrayList<>();
        List<ZhuboList> list2=null;
        ZhuboTitle zhuboTitle=null;
        ZhuboList zhuboList=null;
        try {
            JSONObject jsonObject=new JSONObject(str);
            JSONArray jsonArray=jsonObject.optJSONArray("list");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1=jsonArray.optJSONObject(i);
                zhuboTitle =new ZhuboTitle();
                zhuboTitle.setTitle(jsonObject1.optString("title"));
                JSONArray jsonArray1=jsonObject1.optJSONArray("list");
                list2=new ArrayList<>();
                for (int i1 = 0; i1 < jsonArray1.length(); i1++) {
                    JSONObject jsonObject2=jsonArray1.optJSONObject(i1);//!!!!!!!!!! i1
                    zhuboList=new ZhuboList();
                    zhuboList.setNickname(jsonObject2.optString("nickname"));
                    zhuboList.setSmallLogo(jsonObject2.optString("smallLogo"));
                    list2.add(zhuboList);
                }
                zhuboTitle.setList(list2);
                list.add(zhuboTitle);
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //电台Nameitem
    public static List<DiantaiName> daintaiNameJson(String str) {
        List<DiantaiName> list=new ArrayList<>();
        DiantaiName diantaiName=null;
        try {
            JSONObject jsonObject1=new JSONObject(str);
            JSONObject jsonObject2=jsonObject1.optJSONObject("data");
            JSONArray jsonArray=jsonObject2.optJSONArray("categories");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject3=jsonArray.optJSONObject(i);
                diantaiName =new DiantaiName();
                diantaiName.setName(jsonObject3.optString("name"));
                list.add(diantaiName);
            }
        return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    //解析广播
    public static List<Item> guangboJson(String str) {
        List<Item> list=new ArrayList<>();
        List<GuangboTitle> list1=null;
        List<GuangboItem> list2=null;
        GuangboTitle guangboTitle=null;
        GuangboItem guangboItem=null;
        BangdanItem3 bangdanItem3=null;//没有内容的一个类。
        try {
            JSONObject jsonObject=new JSONObject(str);
            JSONObject jsonObject1=jsonObject.optJSONObject("data");
            JSONArray jsonArray=jsonObject1.optJSONArray("localRadios");
            guangboTitle=new GuangboTitle();
            list.add(guangboTitle);
            LogUtil.d("JSON","-1----------------list--"+list);
            //list2=new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject2=jsonArray.optJSONObject(i);
                guangboItem=new GuangboItem();
                guangboItem.setName(jsonObject2.optString("name"));
                guangboItem.setCoverLarge(jsonObject2.optString("coverLarge"));
                guangboItem.setProgramName(jsonObject2.optString("programName"));
                guangboItem.setPlayCount(jsonObject2.optInt("playCount"));
                //list2.add(guangboItem);
                list.add(guangboItem);
                LogUtil.d("JSON","-2----------------list--"+list);
            }
            JSONArray jsonArray1=jsonObject1.optJSONArray("topRadios");
            bangdanItem3=new BangdanItem3();
            list.add(bangdanItem3);
            LogUtil.d("JSON","-3----------------list--"+list);
            for (int i = 0; i < 3; i++) {
                JSONObject jsonObject3=jsonArray1.optJSONObject(i);
                guangboItem=new GuangboItem();
                guangboItem.setName(jsonObject3.optString("name"));
                guangboItem.setCoverLarge(jsonObject3.optString("coverLarge"));
                guangboItem.setProgramName(jsonObject3.optString("programName"));
                guangboItem.setPlayCount(jsonObject3.optInt("playCount"));
                list.add(guangboItem);
                LogUtil.d("JSON","-4----------------list--"+list);
            }
            LogUtil.d("JSON","-5----------------list--"+list.size());
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
