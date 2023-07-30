package cult.unorthodox.models;


@SuppressWarnings("ALL")
public class Story {
    private String id;
    private String title;
    private String subtitle;
    private int art;

    public Story() {
    }

    public Story(String id, String title, String subtitle, int art) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.art = art;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getArt() {
        return art;
    }

    public void setArt(int art) {
        this.art = art;
    }
}
