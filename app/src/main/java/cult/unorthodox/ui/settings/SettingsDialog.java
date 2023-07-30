package cult.unorthodox.ui.settings;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import cult.unorthodox.databinding.DialogInvitationBinding;

public class SettingsDialog extends Dialog {
    public SettingsDialog(@NonNull Context context) {
        super(context);
        DialogInvitationBinding binding = DialogInvitationBinding.inflate(LayoutInflater.from(context));
        setContentView(binding.getRoot());
    }
}
