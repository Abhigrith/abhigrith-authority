package com.example.abhigrith_authority.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.abhigrith_authority.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class LoginActivity extends AppCompatActivity {

    private final static String AUTHORITY_COLLECTION_PATH = "official_authority_info";
    private final static String AUTHORITY_ID = "authorityId";
    private final static String AUTHORITY_PASSWORD = "authorityPassword";
    private final static String TAG = "Login";

    private ActivityLoginBinding binding;
    private FirebaseFirestore firestore;
    private CollectionReference authorityDocReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firestore = FirebaseFirestore.getInstance();
        authorityDocReference = firestore.collection(AUTHORITY_COLLECTION_PATH);

        binding.btnLoginSignin.setOnClickListener(v -> {
            String authorisedId = binding.etLoginAuthorisedId.getText().toString().trim();
            String password = binding.etLoginPassword.getText().toString().trim();

            boolean checkWhetherAllFieldsAreFilled = checkWhetherAllFieldsAreFilledAndCorrect(authorisedId, password);
            if (!checkWhetherAllFieldsAreFilled) {
                return;
            }

            getAuthorityLoggedIn(authorisedId, password);
        });
    }

    private boolean checkWhetherAllFieldsAreFilledAndCorrect(String authorisedId, String password) {
        if (authorisedId == null || authorisedId.isEmpty() || authorisedId.trim().isEmpty()) {
            Snackbar.make(binding.getRoot(), "The authorised-ID provided by you is empty or blank", Snackbar.LENGTH_LONG).show();
            return false;
        } else if (password == null || password.isEmpty() || password.trim().isEmpty()) {
            Snackbar.make(binding.getRoot(), "The password provided by you is empty or blank", Snackbar.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    private void getAuthorityLoggedIn(String authorisedId, String authorityPassword) {
        Query query = authorityDocReference.whereEqualTo(AUTHORITY_ID, authorisedId);

        query.get().addOnCompleteListener(this, new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    if(task.getResult() != null) {
                        for (QueryDocumentSnapshot document : task.getResult()) {

                            Log.d(TAG, document.getId() + " => " + document.getData());
                            String authorisedAuthorityId = (String) document.getData().get(AUTHORITY_ID);
                            String authorisedAuthorityPassword = (String) document.getData().get(AUTHORITY_PASSWORD);

                            if (!authorityPassword.equals(authorisedAuthorityPassword)) {
                                Snackbar.make(binding.getRoot(), "You have entered the wrong password", Snackbar.LENGTH_LONG).show();
                                return;
                            }

                            if (authorisedId.equals(authorisedAuthorityId) && authorityPassword.equals(authorisedAuthorityPassword)) {
                                Toast.makeText(getApplicationContext(), "Getting you logged in inside the app", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
                                return;
                            }
                        }

                        Snackbar.make(binding.getRoot(), "You have entered wrong authorityID.\nThe authorityID entered by you is not valid", Snackbar.LENGTH_LONG).show();
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                    Snackbar.make(binding.getRoot(), task.getException().getMessage(), Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}