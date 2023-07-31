package cult.unorthodox.tools;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import cult.unorthodox.R;

public class HeartbeatTool {
    private final VibratorTool vibratorTools;
    private final MediaPlayerTool playerTool;
    private final Animation animation;
    private OnHeartBeatFinished listener;

    public HeartbeatTool(Context context) {
        vibratorTools = VibratorTool.getInstance(context);
        playerTool = MediaPlayerTool.getInstance(context);
        animation = AnimationUtils.loadAnimation(context, R.anim.heart_beat);
        animation.setAnimationListener(new AnimationAdapter());
    }

    public void start(View v, OnHeartBeatFinished listener) {
        this.listener = listener;
        v.startAnimation(animation);
    }

    public interface OnHeartBeatFinished {
        void done();
    }

    private class AnimationAdapter implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            vibratorTools.vibrateHeartBeatPattern();
            playerTool.play();
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
