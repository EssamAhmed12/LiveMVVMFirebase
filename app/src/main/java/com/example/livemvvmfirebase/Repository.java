package com.example.livemvvmfirebase;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import javax.annotation.Nullable;

public class Repository {

    private MainModel model = new MainModel();
    private static Repository instance;

    public static Repository getInstance(){
        if (instance==null){
            instance= new Repository();
        }
        return instance;
    }

    public MutableLiveData<MainModel> getData(){
        final MutableLiveData<MainModel> data = new MutableLiveData<>();
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference ref = db.collection("users").document("Profile1");

        ref.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
              model.setFirstName(documentSnapshot.getString("firstName"));
              model.setLastName(documentSnapshot.getString("lastName"));
              model.setEmail(documentSnapshot.getString("email"));
              data.setValue(model);
            }
        });
        return data;
    }
}
