package cult.unorthodox.models;

import java.util.List;

@SuppressWarnings("ALL")
public class StoryDetails extends Story {
    private List<String> passages;
    private String references;

    public StoryDetails() {
    }

    public StoryDetails(List<String> passages, String references) {
        this.passages = passages;
        this.references = references;
    }

    public StoryDetails(String id, String title, String subtitle, int art, List<String> passages, String references) {
        super(id, title, subtitle, art);
        this.passages = passages;
        this.references = references;
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
