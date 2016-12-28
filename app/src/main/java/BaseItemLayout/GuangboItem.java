package BaseItemLayout;

/**
 * Created by 三 on 2016/10/21.
 */
public class GuangboItem implements Item {
    private String coverLarge;
    private String name;
    private String programName;
    private int playCount;

    public String getCoverLarge() {
        return coverLarge;
    }

    public void setCoverLarge(String coverLarge) {
        this.coverLarge = coverLarge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    @Override
    public int getType() {
        return 1;
    }
}
