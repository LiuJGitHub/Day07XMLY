package CallBack;

import java.util.List;

import Base.HotRecommends;
import Base.HotRecommendsList;

/**
 * Created by 三 on 2016/10/19.
 */
public interface CallBackHotRecommends {
    void sendListHotRecommends(List<HotRecommendsList> list);
}
