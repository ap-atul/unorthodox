package cult.unorthodox.tools;

import android.os.VibrationEffect;
import android.os.Vibrator;

public class VibratorTools {
    private static final long[] HEART_BEAT_TIMINGS = new long[] { 0, 200, 200, 200 };
    private static final int[] HEART_BEAT_AMPLITUDES = new int[] { 0, 255, 0, 255 };
    private VibratorTools() {throw new IllegalStateException("Tools class"); }
    public static void vibrateHeartBeatPattern(Vibrator vibrator) {
        vibrator.vibrate(VibrationEffect.createWaveform(
                HEART_BEAT_TIMINGS,
                HEART_BEAT_AMPLITUDES,
                -1
        ));
    }
}
