package com.example.markgeneratordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.markgeneratordemo.databinding.ActivityMainBinding;
import com.example.markgeneratordemo.models.StudentInfoModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //initialization
        databaseReference = FirebaseDatabase.getInstance().getReference("students_info");

        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveStudentInfo();
                startActivity(new Intent(MainActivity.this, ResultActivity.class));
                finish();
            }
        });
    }

    private void saveStudentInfo() {
        String name = binding.etStdName.getText().toString().trim();
        String id = binding.etSId.getText().toString().trim();
        if (name.isEmpty() || id.isEmpty()) {
            Toast.makeText(this, "Fill up every field properly", Toast.LENGTH_SHORT).show();
            return;
        }

        String key = databaseReference.push().getKey();
        StudentInfoModel model = new StudentInfoModel(Integer.parseInt(id), name);
        assert key != null;
        databaseReference.child(key).setValue(model);
        Toast.makeText(this, "Successfully added ", Toast.LENGTH_SHORT).show();
    }
}