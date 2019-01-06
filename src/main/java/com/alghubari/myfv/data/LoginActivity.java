package com.alghubari.myfv.data;
import android.support.annotation.NonNull;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alghubari.myfv.MainActivity;
import com.alghubari.myfv.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private static String TAG = "LoginActivity";
    private EditText editTextUserEmail, editTextPassword;
    private Button btnsingn,btnsingup;

   /* private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


*/


    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser user;
    private boolean firstTimeAccess;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        editTextUserEmail = (EditText) findViewById(R.id.et_User_Email);
        editTextPassword = (EditText) findViewById(R.id.et_user_password);
        firstTimeAccess = true;
        initFirebase();
        btnsingn = (Button) findViewById(R.id.btnSignIn);
        btnsingup = (Button) findViewById(R.id.btnSignUp);
        btnsingn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editTextUserEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                singIn(userEmail, password);


            }
        });
        btnsingup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = editTextUserEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                singup(userEmail, password);

            }
        });

    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        // Check if user is signed in (non-null) and update UI accordingly.
        // FirebaseUser currentUser = mAuth.getCurrentUser();
        //  updateUI(currentUser);
    }

    private void initFirebase() {
        //Khoi tao thanh phan de dang nhap, dang ky
        mAuth = FirebaseAuth.getInstance();
        //authUtils = new AuthUtils();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    // User is signed in
                    // FirebaseUser user = user.getUid();
                    // Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());


                    // Log.d(TAG, "onAuthStateChanged:signed_out");
                }

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void singIn(String userEmail, String password) {
        FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(userEmail, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "hla", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();

            }
        });
    }


    public void singup(String userEmail, String password) {
        FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword(userEmail, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (!task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "hla", Toast.LENGTH_SHORT).show();
                } else
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                LoginActivity.this.finish();

            }
        });

    }
}