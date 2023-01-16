package com.example.markgeneratordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.markgeneratordemo.databinding.ActivityResultBinding;
import com.example.markgeneratordemo.models.ResultModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ResultActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private DatabaseReference databaseReferenceBan;
    private DatabaseReference databaseReferenceEng;
    private DatabaseReference databaseReferencePhy;
    private DatabaseReference databaseReferenceMath;
    private ActivityResultBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference("results");
        databaseReferenceBan = FirebaseDatabase.getInstance().getReference("bangla");
        databaseReferenceEng = FirebaseDatabase.getInstance().getReference("english");
        databaseReferencePhy = FirebaseDatabase.getInstance().getReference("physics");
        databaseReferenceMath = FirebaseDatabase.getInstance().getReference("math");
        binding.btnSaveRA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        binding.btnShowResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ResultActivity.this, ShowResultActivity.class));
            }
        });
    }

    private void saveData() {
        String subject = binding.etSubjectName.getText().toString().toLowerCase().trim();
        String mark = binding.etMark.getText().toString().trim();
        String outOf = binding.etOutOf.getText().toString().trim();

        if (subject.isEmpty() || mark.isEmpty() || outOf.isEmpty()) {
            Toast.makeText(this, "Fill up all the field properly", Toast.LENGTH_SHORT).show();
            return;
        }
        String key = databaseReference.push().getKey();
        ResultModel model = new ResultModel(subject, Integer.parseInt(mark), Integer.parseInt(outOf));

        switch (subject) {
            case "bangla":
                assert key != null;
                databaseReferenceBan.child(key).setValue(model);
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();

                break;
            case "english":
                assert key != null;
                databaseReferenceEng.child(key).setValue(model);
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();

                break;
            case "physics":
                assert key != null;
                databaseReferencePhy.child(key).setValue(model);
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();

                break;
            case "math":
                assert key != null;
                databaseReferenceMath.child(key).setValue(model);
                Toast.makeText(this, "Successfully added", Toast.LENGTH_SHORT).show();

                break;
        }

    }
}