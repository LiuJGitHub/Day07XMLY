package BaseItemLayout;

/**
 * Created by 三 on 2016/10/19.
 */
public class BangdanItem1 implements Item{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int getType() {
        return 0;
    }
}
