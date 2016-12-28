package Base;

import java.util.List;

/**
 * Created by 三 on 2016/10/19.
 */
//听什么，具体的
public class HotRecommendsList {
    private String title;
    private List<HotRecommendsListListen> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<HotRecommendsListListen> getList() {
        return list;
    }

    public void setList(List<HotRecommendsListListen> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "HotRecommendsList{" +
                "title='" + title + '\'' +
                ", list=" + list +
                '}';
    }
}
