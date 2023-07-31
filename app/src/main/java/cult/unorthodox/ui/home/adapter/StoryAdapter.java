package cult.unorthodox.ui.home.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import cult.unorthodox.databinding.ItemStoryBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.HeartbeatTool;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {
    private final List<Story> stories;
    private final StoryAdapter.StoryClickedListener listener;

    public StoryAdapter(List<Story> stories, StoryAdapter.StoryClickedListener listener) {
        this.stories = stories;
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
        Picasso.get().load(story.getArt()).into(holder.binding.art);
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

            binding.root.setOnClickListener(view -> {
                HeartbeatTool tool = new HeartbeatTool(view.getContext());
                tool.start(view, () -> {
                    Log.d("DEBUG", "finished clicked on " + getBindingAdapterPosition());
                    listener.onStoryClicked(stories.get(getBindingAdapterPosition()));
                });
            });
        }
    }
}
