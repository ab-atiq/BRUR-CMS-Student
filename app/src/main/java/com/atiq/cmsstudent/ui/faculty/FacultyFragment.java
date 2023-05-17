package com.atiq.cmsstudent.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.atiq.cmsstudent.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {
    private RecyclerView cseDepartment, eeeDepartment, physicsDepartment;
    private LinearLayout cseNoData, eeeNoData, physicsNoData;
    private List<TeacherData> cseList, eeeList, physicsList;
    private TeacherAdapter adapter;
    private DatabaseReference databaseReference, dbRef;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        cseDepartment = view.findViewById(R.id.cseDepartment);
        eeeDepartment = view.findViewById(R.id.eeeDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);

        cseNoData = view.findViewById(R.id.cseNoData);
        eeeNoData = view.findViewById(R.id.eeeNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teachers");

        cseDepartment();
        eeeDepartment();
        physicsDepartment();

        return view;
    }

    private void physicsDepartment() {
        dbRef = databaseReference.child("Physics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                physicsList = new ArrayList<>();
                if(!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }else{
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dSnapshot:snapshot.getChildren()){
                        TeacherData data = dSnapshot.getValue(TeacherData.class);
                        physicsList.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(physicsList, getContext());
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void eeeDepartment() {
        dbRef = databaseReference.child("EEE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eeeList = new ArrayList<>();
                if(!snapshot.exists()){
                    eeeNoData.setVisibility(View.VISIBLE);
                    eeeDepartment.setVisibility(View.GONE);
                }else{
                    eeeNoData.setVisibility(View.GONE);
                    eeeDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dSnapshot:snapshot.getChildren()){
                        TeacherData data = dSnapshot.getValue(TeacherData.class);
                        eeeList.add(data);
                    }
                    eeeDepartment.setHasFixedSize(true);
                    eeeDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(eeeList, getContext());
                    eeeDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cseDepartment() {
        dbRef = databaseReference.child("CSE");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                cseList = new ArrayList<>();
                if(!snapshot.exists()){
                    cseNoData.setVisibility(View.VISIBLE);
                    cseDepartment.setVisibility(View.GONE);
                }else{
                    cseNoData.setVisibility(View.GONE);
                    cseDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot dSnapshot:snapshot.getChildren()){
                        TeacherData data = dSnapshot.getValue(TeacherData.class);
                        cseList.add(data);
                    }
                    cseDepartment.setHasFixedSize(true);
                    cseDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(cseList, getContext());
                    cseDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}