package BaseItemLayout;

import java.util.List;

/**
 * Created by 三 on 2016/10/21.
 */
public class GuangboTitle implements Item {

    private String time;
    private List<GuangboItem> list;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<GuangboItem> getList() {
        return list;
    }

    public void setList(List<GuangboItem> list) {
        this.list = list;
    }

    @Override
    public int getType() {
        return 0;
    }
}
