package cult.unorthodox.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cult.unorthodox.R;

public class HeartbeatTool {
    private final Vibrator vibrator;
    private final MediaPlayer player;
    private final Animation animation;
    private OnHeartBeatFinished listener;

    public HeartbeatTool(Context context) {
        vibrator = context.getSystemService(Vibrator.class);
        player = MediaPlayer.create(context, R.raw.heart_beat);
        animation = AnimationUtils.loadAnimation(context, R.anim.heart_beat);
        animation.setAnimationListener(new AnimationAdapter());
    }

    public void setListener(OnHeartBeatFinished listener) {
        this.listener = listener;
    }

    public void start(View v) {
        v.startAnimation(animation);
    }

    public interface OnHeartBeatFinished {
        void done();
    }

    private class AnimationAdapter implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            VibratorTools.vibrateHeartBeatPattern(vibrator);
            player.start();
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (listener != null) listener.done();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // Unused
        }
    }
}
