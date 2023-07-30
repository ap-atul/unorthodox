package cult.unorthodox.ui.read;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import cult.unorthodox.databinding.ActivityReadBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.WindowTools;
import cult.unorthodox.ui.read.adapter.PassageAdapter;

public class ReadActivity extends AppCompatActivity {
    private ActivityReadBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowTools.fullScreen(getWindow().getDecorView());
        binding = ActivityReadBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setUpDummyPassages();
    }

    private void setUpDummyPassages() {
        List<String> passages = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            passages.add("This is sample passage and should be replaced with awesome content");
        }
        binding.rvPassages.setAdapter(new PassageAdapter(new Story(), passages));
    }
}