package com.example.markgeneratordemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.markgeneratordemo.adapters.StudentResultsAdapter;
import com.example.markgeneratordemo.databinding.ActivityShowResultBinding;
import com.example.markgeneratordemo.models.ResultModel;
import com.example.markgeneratordemo.models.StudentInfoModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowResultActivity extends AppCompatActivity {

    private DatabaseReference databaseReferenceS_info;
    private ActivityShowResultBinding binding;
    private List<StudentInfoModel> studentInfoModelList;
    private List<ResultModel> resultModelList;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        studentInfoModelList = new ArrayList<>();
        resultModelList = new ArrayList<>();


        //initialization-------
        databaseReferenceS_info = FirebaseDatabase.getInstance().getReference("students_info");


        //adapter------------


        databaseReferenceS_info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //ShowResultActivity.this.studentInfoModelList.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    StudentInfoModel model = items.getValue(StudentInfoModel.class);
                    ShowResultActivity.this.studentInfoModelList.add(model);
                }
                StudentResultsAdapter adapter = new StudentResultsAdapter(studentInfoModelList);
                binding.rvId.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
                binding.rvId.setAdapter(adapter);

                Log.e("TAG", "" + ShowResultActivity.this.studentInfoModelList.size());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        Log.e("TAG", "sList " + studentInfoModelList.size());




    }

}