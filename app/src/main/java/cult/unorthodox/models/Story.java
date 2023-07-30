package cult.unorthodox.models;

import java.util.List;

public class Story {
    private String title;
    private String subtitle;
    private int art;
    private List<String> passages;
    private String references;

    public Story() {}
    public Story(String title, String subtitle, int art, List<String> passages, String references) {
        this.title = title;
        this.subtitle = subtitle;
        this.art = art;
        this.passages = passages;
        this.references = references;
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

    public List<String> getPassages() {
        return passages;
    }

    public void setPassages(List<String> passages) {
        this.passages = passages;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
