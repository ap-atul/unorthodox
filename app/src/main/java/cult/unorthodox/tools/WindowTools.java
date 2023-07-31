package cult.unorthodox.tools;

import android.view.View;

public class WindowTools {
    private WindowTools() {
        throw new IllegalStateException("Utility class");
    }

    public static void fullScreen(View decorView) {
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }
}
