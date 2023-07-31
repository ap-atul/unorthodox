package cult.unorthodox.tools;

import android.content.Context;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class VibratorTool {
    private static final long[] HEART_BEAT_TIMINGS = new long[]{0, 0, 0, 0, 200};
    private static final int[] HEART_BEAT_AMPLITUDES = new int[]{0, 0, 0, 0, 255};
    private final Vibrator vibrator;
    private static VibratorTool instance = null;

    public VibratorTool(Context context) {
        vibrator = context.getSystemService(Vibrator.class);
    }

    public static VibratorTool getInstance(Context context) {
        if (instance == null) {
            instance = new VibratorTool(context);
        }
        return instance;
    }

    public void vibrateHeartBeatPattern() {
        vibrator.vibrate(VibrationEffect.createWaveform(
                HEART_BEAT_TIMINGS,
                HEART_BEAT_AMPLITUDES,
                -1
        ));
    }
}
