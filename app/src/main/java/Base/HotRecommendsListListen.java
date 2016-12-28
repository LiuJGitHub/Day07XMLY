package Base;

/**
 * Created by 三 on 2016/10/19.
 */
public class HotRecommendsListListen {
    private String intro;
    private String trackTitle;
    private String albumCoverUrl290;

    @Override
    public String toString() {
        return "HotRecommendsListListen{" +
                "intro='" + intro + '\'' +
                ", trackTitle='" + trackTitle + '\'' +
                ", albumCoverUrl290='" + albumCoverUrl290 + '\'' +
                '}';
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTrackTitle() {
        return trackTitle;
    }

    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }

    public String getAlbumCoverUrl290() {
        return albumCoverUrl290;
    }

    public void setAlbumCoverUrl290(String albumCoverUrl290) {
        this.albumCoverUrl290 = albumCoverUrl290;
    }
}
