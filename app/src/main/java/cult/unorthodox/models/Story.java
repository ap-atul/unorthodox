package cult.unorthodox.models;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

@SuppressWarnings("ALL")
@Keep
public class Story implements Parcelable {
    private String id;
    private String title;
    private String subtitle;
    private String art;

    public Story() {
    }

    public Story(String id, String title, String subtitle, String art) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.art = art;
    }

    protected Story(Parcel in) {
        id = in.readString();
        title = in.readString();
        subtitle = in.readString();
        art = in.readString();
    }

    public static final Creator<Story> CREATOR = new Creator<Story>() {
        @Override
        public Story createFromParcel(Parcel in) {
            return new Story(in);
        }

        @Override
        public Story[] newArray(int size) {
            return new Story[size];
        }
    };

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

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", art=" + art +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(title);
        parcel.writeString(subtitle);
        parcel.writeString(art);
    }
}
