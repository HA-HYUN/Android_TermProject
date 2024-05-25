package org.androidtown.termproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SubtaskAdapter extends RecyclerView.Adapter<SubtaskAdapter.SubtaskViewHolder> {

    private List<String> subtasks;

    public SubtaskAdapter() {
        subtasks = new ArrayList<>();
    }

    @NonNull
    @Override
    public SubtaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subtask_item, parent, false);
        return new SubtaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubtaskViewHolder holder, int position) {
        String subtask = subtasks.get(position);
        holder.bind(subtask);
    }

    @Override
    public int getItemCount() {
        return subtasks.size();
    }

    // Subtask 추가
    public void addSubtask(String subtask) {
        subtasks.add(subtask);
        notifyItemInserted(subtasks.size() - 1);
    }

    // Subtask 삭제
    public void deleteSubtask() {
        if (subtasks.size() > 0) {
            subtasks.remove(subtasks.size() - 1);
            notifyItemRemoved(subtasks.size());
        }
    }

    static class SubtaskViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewSubtaskDetail;

        public SubtaskViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSubtaskDetail = itemView.findViewById(R.id.text_view_subtask_detail);
        }

        public void bind(String subtask) {
            textViewSubtaskDetail.setText(subtask);
        }
    }
}

