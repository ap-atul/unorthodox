package cult.unorthodox.ui.read;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

import cult.unorthodox.C;
import cult.unorthodox.R;
import cult.unorthodox.databinding.ActivityReadBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.models.StoryDetails;
import cult.unorthodox.tools.WindowTools;
import cult.unorthodox.ui.read.adapter.PassageAdapter;

public class ReadActivity extends AppCompatActivity {
    private List<String> passages;
    private PassageAdapter adapter;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Story story;
        ActivityReadBinding binding;
        super.onCreate(savedInstanceState);
        WindowTools.fullScreen(getWindow().getDecorView());
        binding = ActivityReadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = FirebaseFirestore.getInstance();
        story = getIntent().getParcelableExtra(C.KEY_STORY_ID);

        passages = new ArrayList<>();
        adapter = new PassageAdapter(story, passages);
        binding.rvPassages.setAdapter(adapter);
        loadStoryDetails(story.getId());
    }

    private void loadStoryDetails(String id) {
        db.collection(C.COLLECTIONS_PASSAGES)
                .document(id)
                .get()
                .addOnSuccessListener(documentSnapshot -> handleStoryDetails(documentSnapshot.toObject(StoryDetails.class)))
                .addOnFailureListener(e -> Toast.makeText(ReadActivity.this, R.string.server_error, Toast.LENGTH_SHORT).show());
    }

    private void handleStoryDetails(StoryDetails details) {
        if (details == null) return;
        passages.addAll(details.getPassages());
        adapter.notifyItemRangeInserted(1, passages.size());
    }
}