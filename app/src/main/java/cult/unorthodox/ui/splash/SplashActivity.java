package cult.unorthodox.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import cult.unorthodox.R;
import cult.unorthodox.databinding.ActivitySplashBinding;
import cult.unorthodox.tools.WindowTools;
import cult.unorthodox.ui.home.MainActivity;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowTools.fullScreen(getWindow().getDecorView());
        ActivitySplashBinding binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Animation spinZoom = AnimationUtils.loadAnimation(this, R.anim.spin_zoom);
        spinZoom.setAnimationListener(new AnimationAdapter());
        binding.logo.setAnimation(spinZoom);
    }

    private class AnimationAdapter implements Animation.AnimationListener {
        private void launchMainActivity() {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }

        @Override
        public void onAnimationStart(Animation animation) {
            // Unused
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            launchMainActivity();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // Unused
        }
    }
}