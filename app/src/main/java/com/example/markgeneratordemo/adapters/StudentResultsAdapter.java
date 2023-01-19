package com.example.markgeneratordemo.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.markgeneratordemo.databinding.RowDesignTableLayoutBinding;
import com.example.markgeneratordemo.models.ResultModel;
import com.example.markgeneratordemo.models.StudentInfoModel;

import java.util.ArrayList;
import java.util.List;


public class StudentResultsAdapter extends RecyclerView.Adapter<StudentResultsAdapter.ResultViewHolder> {

    private List<StudentInfoModel> listStudentInfo;
    private List<ResultModel> listBangla;
    private List<ResultModel> listPhysics;
    private List<ResultModel> listEnglish;
    private List<ResultModel> listMath;

    public StudentResultsAdapter() {
        listStudentInfo = new ArrayList<>();
        listBangla = new ArrayList<>();
        listPhysics = new ArrayList<>();
        listMath = new ArrayList<>();
        listEnglish = new ArrayList<>();
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

        String name = listStudentInfo.get(position).getName();
        holder.binding.tvName.setText(name);
        holder.binding.tvId.setText(String.valueOf(listStudentInfo.get(position).getId()));
        //holder.binding.tvBan.setText(String.valueOf(listBangla.get(position).getMark()));
       /* holder.binding.tvBan.setText(String.valueOf(listBangla.get(position).getMark()));
        holder.binding.tvPhy.setText(String.valueOf(listPhysics.get(position).getMark()));
        holder.binding.tvEng.setText(String.valueOf(listEnglish.get(position).getMark()));
        holder.binding.tvMath.setText(String.valueOf(listMath.get(position).getMark()));*/

    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitNewStudentInfoList(List<StudentInfoModel> studentInfoModelList) {
        this.listStudentInfo = studentInfoModelList;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitNewListBangla(List<ResultModel> listBangla) {
        this.listBangla = listBangla;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitNewListPhysics(List<ResultModel> listPhysics) {
        this.listPhysics = listPhysics;
        notifyDataSetChanged();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void submitNewListMath(List<ResultModel> listMath) {
        this.listMath = listMath;
        notifyDataSetChanged();
    }
 @SuppressLint("NotifyDataSetChanged")
    public void submitNewListEnglish(List<ResultModel> listEnglish) {
        this.listEnglish = listEnglish;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listStudentInfo.size();
    }

    class ResultViewHolder extends RecyclerView.ViewHolder {
        private RowDesignTableLayoutBinding binding;

        public ResultViewHolder(RowDesignTableLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
