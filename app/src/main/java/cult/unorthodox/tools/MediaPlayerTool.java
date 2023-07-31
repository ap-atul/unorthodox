package cult.unorthodox.tools;

import android.content.Context;
import android.media.MediaPlayer;

import cult.unorthodox.R;

public class MediaPlayerTool {
    private final MediaPlayer player;
    private static MediaPlayerTool instance = null;

    public MediaPlayerTool(Context context) {
        player = MediaPlayer.create(context, R.raw.heart_beat);
    }

    public static MediaPlayerTool getInstance(Context context) {
        if (instance == null) {
            instance = new MediaPlayerTool(context);
        }
        return instance;
    }

    public void play() {
        player.start();
    }
}
