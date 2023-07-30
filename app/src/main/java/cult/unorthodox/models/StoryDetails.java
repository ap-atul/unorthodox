package cult.unorthodox.models;

import androidx.annotation.Keep;

import java.util.List;

@SuppressWarnings("ALL")
@Keep
public class StoryDetails {
    private String id;
    private List<String> passages;
    private List<String> references;

    public StoryDetails() {
    }

    public StoryDetails(String id, List<String> passages, List<String> references) {
        this.id = id;
        this.passages = passages;
        this.references = references;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getPassages() {
        return passages;
    }

    public void setPassages(List<String> passages) {
        this.passages = passages;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "StoryDetails{" +
                "id='" + id + '\'' +
                ", passages=" + passages +
                ", references=" + references +
                '}';
    }
}
