package BaseItemLayout;

import java.util.List;

/**
 * Created by 三 on 2016/10/19.
 */
public class BangdanItem2 implements Item {
    private String coverPath;
    private String title;
    //firstKResults
    private List<FirstKResults> list;
    private BangdanItem1 mBangdanItem1;

    public BangdanItem1 getBangdanItem1() {
        return mBangdanItem1;
    }

    public void setBangdanItem1(BangdanItem1 bangdanItem1) {
        mBangdanItem1 = bangdanItem1;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<FirstKResults> getList() {
        return list;
    }

    public void setList(List<FirstKResults> list) {
        this.list = list;
    }

    @Override
    public int getType() {
        return 1;
    }
}
