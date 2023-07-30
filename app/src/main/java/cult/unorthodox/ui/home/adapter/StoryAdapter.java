package cult.unorthodox.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cult.unorthodox.databinding.ItemStoryBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.HeartbeatTool;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {
    private final List<Story> stories;
    private final StoryAdapter.StoryClickedListener listener;
    private final HeartbeatTool heartbeat;

    public StoryAdapter(List<Story> stories, HeartbeatTool heartbeat, StoryAdapter.StoryClickedListener listener) {
        this.stories = stories;
        this.heartbeat = heartbeat;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemStoryBinding binding = ItemStoryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.MyViewHolder holder, int position) {
        Story story = stories.get(position);
        holder.binding.holyTitle.setText(story.getTitle());
        holder.binding.holySubTitle.setText(story.getSubtitle());
        holder.binding.art.setImageResource(story.getArt());
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    public interface StoryClickedListener {
        void onStoryClicked(Story story);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ItemStoryBinding binding;
        public MyViewHolder(@NonNull ItemStoryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            heartbeat.setListener(() -> listener.onStoryClicked(stories.get(getBindingAdapterPosition())));
            binding.root.setOnClickListener(heartbeat::start);
        }
    }
}
