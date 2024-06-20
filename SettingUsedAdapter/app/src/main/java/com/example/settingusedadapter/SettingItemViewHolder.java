package com.example.settingusedadapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SettingItemViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public SettingItemViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textView);
    }
}
