package cult.unorthodox.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import java.util.Arrays;

import cult.unorthodox.R;
import cult.unorthodox.databinding.ActivityMainBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.HeartbeatTool;
import cult.unorthodox.ui.home.adapter.StoryAdapter;

public class MainActivity extends AppCompatActivity implements StoryAdapter.StoryClickedListener {
    private ActivityMainBinding binding;
    private HeartbeatTool heartbeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        heartbeat = new HeartbeatTool(MainActivity.this);
        setContentView(binding.getRoot());

        addDummyData();
    }

    private void addDummyData() {
        Story a = new Story();
        a.setTitle("This is red");
        a.setSubtitle("like this is some kind of story");
        a.setArt(R.drawable.article);

        Story b = new Story();
        b.setTitle("This is blue");
        b.setSubtitle("like this is some kind of story");
        b.setArt(R.drawable.article_2);

        binding.rvStory.setAdapter(new StoryAdapter(Arrays.asList(a, b), heartbeat, this));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.rvStory);
    }

    @Override
    public void onStoryClicked(Story story) {
        // Unused
    }
}