package BaseItemLayout;

/**
 * Created by 三 on 2016/10/11.
 */
public class IItem2 implements Item {
    private String info1;
    private String info2;
    private String info3;

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

    public String getInfo3() {
        return info3;
    }

    public void setInfo3(String info3) {
        this.info3 = info3;
    }

    @Override
    public int getType() {
        return 2;
    }
}
