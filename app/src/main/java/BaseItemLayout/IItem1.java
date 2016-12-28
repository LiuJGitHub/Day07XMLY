package BaseItemLayout;

/**
 * Created by 三 on 2016/10/11.
 */
public class IItem1 implements Item {
    private String info1;
    private String info2;

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getInfo2() {
        return info2;
    }

    public void setInfo2(String info2) {
        this.info2 = info2;
    }

    @Override
    public int getType() {
        return 1;
    }
}
