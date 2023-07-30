package cult.unorthodox.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

import cult.unorthodox.C;
import cult.unorthodox.R;
import cult.unorthodox.databinding.ActivityMainBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.HeartbeatTool;
import cult.unorthodox.tools.WindowTools;
import cult.unorthodox.ui.home.adapter.StoryAdapter;
import cult.unorthodox.ui.read.ReadActivity;

public class MainActivity extends AppCompatActivity implements StoryAdapter.StoryClickedListener {
    private ActivityMainBinding binding;
    private HeartbeatTool heartbeat;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowTools.fullScreen(getWindow().getDecorView());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        heartbeat = new HeartbeatTool(MainActivity.this);
        db = FirebaseFirestore.getInstance();
        setContentView(binding.getRoot());
        loadData();
    }

    private void loadData() {
        db.collection(C.COLLECTIONS_STORIES).get()
                .addOnSuccessListener(snapshots -> handleStories(snapshots.toObjects(Story.class)))
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show());
    }

    private void handleStories(List<Story> stories) {
        binding.rvStory.setAdapter(new StoryAdapter(stories, heartbeat, this));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.rvStory);
    }

    @Override
    public void onStoryClicked(Story story) {
        startActivity(new Intent(MainActivity.this, ReadActivity.class).putExtra(C.KEY_STORY_ID, story));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}