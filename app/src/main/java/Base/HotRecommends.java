package Base;

import java.util.List;

/**
 * Created by 三 on 2016/10/19.
 */
//热门推荐  听…………
public class HotRecommends {
    private String title;
    private List<HotRecommendsList> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HotRecommendsList> getList() {
        return list;
    }

    public void setList(List<HotRecommendsList> list) {
        this.list = list;
    }
}
