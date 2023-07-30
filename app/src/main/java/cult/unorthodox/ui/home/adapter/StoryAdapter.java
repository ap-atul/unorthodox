package cult.unorthodox.ui.home.adapter;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cult.unorthodox.R;
import cult.unorthodox.databinding.ItemStoryBinding;
import cult.unorthodox.models.Story;
import cult.unorthodox.tools.VibratorTools;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.MyViewHolder> {
    private final List<Story> stories;
    private final StoryAdapter.StoryClickedListener listener;
    private final Vibrator vibrator;

    public StoryAdapter(List<Story> stories, Vibrator vibrator, StoryAdapter.StoryClickedListener listener) {
        this.stories = stories;
        this.vibrator = vibrator;
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
            Animation beat = AnimationUtils.loadAnimation(binding.getRoot().getContext(), R.anim.heart_beat);
            beat.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    VibratorTools.vibrateHeartBeatPattern(vibrator);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    listener.onStoryClicked(stories.get(getBindingAdapterPosition()));
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                    // Unused
                }
            });
            binding.root.setOnClickListener(v -> v.startAnimation(beat));
        }
    }
}
