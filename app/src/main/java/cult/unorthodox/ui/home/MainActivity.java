package cult.unorthodox.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.List;

import cult.unorthodox.C;
import cult.unorthodox.R;
import cult.unorthodox.databinding.ActivityMainBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.WindowTools;
import cult.unorthodox.ui.home.adapter.StoryAdapter;
import cult.unorthodox.ui.read.ReadActivity;
import cult.unorthodox.ui.settings.SettingsDialog;

public class MainActivity extends AppCompatActivity implements StoryAdapter.StoryClickedListener {
    private ActivityMainBinding binding;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowTools.fullScreen(getWindow().getDecorView());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.settings.setOnClickListener(v -> launchDialog());
        db = FirebaseFirestore.getInstance();
        setContentView(binding.getRoot());
        loadData();
    }

    private void launchDialog() {
        SettingsDialog dialog = new SettingsDialog(MainActivity.this);
        dialog.show();
    }

    private void loadData() {
        db.collection(C.COLLECTIONS_STORIES)
                .orderBy("timestamp", Query.Direction.DESCENDING)
                .get()
                .addOnSuccessListener(snapshots -> handleStories(snapshots.toObjects(Story.class)))
                .addOnFailureListener(e -> Toast.makeText(MainActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show());
    }

    private void handleStories(List<Story> stories) {
        binding.rvStory.setAdapter(new StoryAdapter(stories, this));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(binding.rvStory);
    }

    @Override
    public void onStoryClicked(Story story) {
        Log.d("DEBUG", story.toString());
        startActivity(new Intent(MainActivity.this, ReadActivity.class).putExtra(C.KEY_STORY_ID, story));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}