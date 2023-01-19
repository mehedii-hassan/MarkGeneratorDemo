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
    private DatabaseReference databaseReferenceBan;
    private DatabaseReference databaseReferencePhy;
    private DatabaseReference databaseReferenceMath;
    private DatabaseReference databaseReferenceEng;
    private ActivityShowResultBinding binding;
    private List<StudentInfoModel> listStudentInfo;
    private List<ResultModel> listBangla;
    private List<ResultModel> listPhysics;
    private List<ResultModel> listMath;
    private List<ResultModel> listEnglish;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        listStudentInfo = new ArrayList<>();
        listBangla = new ArrayList<>();
        listPhysics = new ArrayList<>();
        listMath = new ArrayList<>();
        listEnglish = new ArrayList<>();


        //initialization-------
        databaseReferenceS_info = FirebaseDatabase.getInstance().getReference("students_info");
        databaseReferenceBan = FirebaseDatabase.getInstance().getReference("bangla");
        databaseReferencePhy = FirebaseDatabase.getInstance().getReference("physics");
        databaseReferenceMath = FirebaseDatabase.getInstance().getReference("math");
        databaseReferenceEng = FirebaseDatabase.getInstance().getReference("english");


        //adapter------------
        StudentResultsAdapter adapter = new StudentResultsAdapter();
        binding.rvId.setLayoutManager(new LinearLayoutManager(this));
        binding.rvId.setAdapter(adapter);

        databaseReferenceS_info.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShowResultActivity.this.listStudentInfo.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    StudentInfoModel model = items.getValue(StudentInfoModel.class);
                    ShowResultActivity.this.listStudentInfo.add(model);
                }
                adapter.submitNewStudentInfoList(listStudentInfo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(binding.getRoot().getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReferenceBan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShowResultActivity.this.listBangla.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    ResultModel resultModel = items.getValue(ResultModel.class);
                    ShowResultActivity.this.listBangla.add(resultModel);
                }
                adapter.submitNewListBangla(listBangla);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(binding.getRoot().getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReferencePhy.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShowResultActivity.this.listPhysics.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    ResultModel resultModel = items.getValue(ResultModel.class);
                    ShowResultActivity.this.listPhysics.add(resultModel);
                }
                adapter.submitNewListPhysics(listPhysics);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(binding.getRoot().getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReferenceMath.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                 ShowResultActivity.this.listMath.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    ResultModel model = items.getValue(ResultModel.class);
                    ShowResultActivity.this.listMath.add(model);
                }
                adapter.submitNewListMath(listMath);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(binding.getRoot().getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
            }
        });
        databaseReferenceMath.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShowResultActivity.this.listMath.clear();
                for (DataSnapshot items : snapshot.getChildren()) {
                    ResultModel model = items.getValue(ResultModel.class);
                    ShowResultActivity.this.listEnglish.add(model);
                }
                adapter.submitNewListEnglish(listEnglish);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(binding.getRoot().getContext(), "something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

}