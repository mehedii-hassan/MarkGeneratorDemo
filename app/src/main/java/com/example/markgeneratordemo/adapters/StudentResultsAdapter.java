package com.example.markgeneratordemo.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.markgeneratordemo.databinding.RowDesignTableLayoutBinding;
import com.example.markgeneratordemo.models.StudentInfoModel;

import java.util.List;


public class StudentResultsAdapter extends RecyclerView.Adapter<StudentResultsAdapter.ResultViewHolder> {

    private List<StudentInfoModel> studentInfoModelList;

    public StudentResultsAdapter(List<StudentInfoModel> studentInfoModelList) {
        this.studentInfoModelList = studentInfoModelList;
    }

    @NonNull
    @Override
    public ResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowDesignTableLayoutBinding binding = RowDesignTableLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ResultViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ResultViewHolder holder, int position) {
        //Log.e("TAG","adapter "+studentInfoModelList.size());
        Log.e("TAG", "adapter " + studentInfoModelList.get(1).getName());
        String name = studentInfoModelList.get(position).getName();
        holder.binding.tvName.setText(name);
        holder.binding.tvId.setText(String.valueOf(studentInfoModelList.get(position).getId()));

    }

    @Override
    public int getItemCount() {
        return studentInfoModelList.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {
        private RowDesignTableLayoutBinding binding;

        public ResultViewHolder(RowDesignTableLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
