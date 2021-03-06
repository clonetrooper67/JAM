package example.com.jam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// The LogInActivity class controls the activity_log_in view. When a user clicks the
// Account button from the navigation header bar, the user is taken to a log in screen.
// From this screen, a user can log in or sign up. If a user is already logged in, they
// are not asked to log in again. Instead, they are offered to edit profile or to sign up
// a different account.
public class LogInActivity extends AppCompatActivity {

    protected EditText emailEditText;
    protected EditText passwordEditText;
    protected Button logInButton;
    protected TextView signUpTextView;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFireBaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Initialize FirebaseAuth
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFireBaseUser = mFirebaseAuth.getCurrentUser();

        signUpTextView = (TextView) findViewById(R.id.signUpText);
        emailEditText = (EditText) findViewById(R.id.emailField);
        passwordEditText = (EditText) findViewById(R.id.passwordField);
        logInButton = (Button) findViewById(R.id.loginButton);

        updateLogInState();

        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mFireBaseUser != null) {
                    Intent intent = new Intent(getApplicationContext(), ProfileEditActivity.class);
                    startActivity(intent);
                } else {

                    String email = emailEditText.getText().toString();
                    String password = passwordEditText.getText().toString();

                    email = email.trim();
                    password = password.trim();

                    if (email.isEmpty() || password.isEmpty()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LogInActivity.this);
                        builder.setMessage(R.string.login_error_message)
                                .setTitle(R.string.login_error_title)
                                .setPositiveButton(android.R.string.ok, null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    } else {
                        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                        } else {
                                            AlertDialog.Builder builder = new AlertDialog.Builder(LogInActivity.this);
                                            builder.setMessage(task.getException().getMessage())
                                                    .setTitle(R.string.login_error_title)
                                                    .setPositiveButton(android.R.string.ok, null);
                                            AlertDialog dialog = builder.create();
                                            dialog.show();
                                        }
                                    }
                                });
                    }
                }
            }

        });
        updateLogInState();

    }

    protected void updateLogInState() {
        if (mFireBaseUser != null) {
            emailEditText.setVisibility(View.GONE);
            passwordEditText.setVisibility(View.GONE);
            logInButton.setText("Edit Profile");
            signUpTextView.setVisibility(View.GONE);
        } else {
            emailEditText.setVisibility(View.VISIBLE);
            passwordEditText.setVisibility(View.VISIBLE);
            logInButton.setText("Login");
            signUpTextView.setVisibility(View.VISIBLE);

        }
    }
}
