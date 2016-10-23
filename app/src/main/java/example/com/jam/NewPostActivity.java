package example.com.jam;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewPostActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private String mUserId;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Button submitButton = (Button) findViewById(R.id.submitPostButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
                EditText bodyEditText = (EditText) findViewById(R.id.bodyEditText);

                String title = titleEditText.getText().toString();
                String body = bodyEditText.getText().toString();

                if(!title.matches("") && !body.matches("")){
                    Post post = new Post(title, body, mUserId = mFirebaseUser.getUid());
                    mDatabase.child("posts").push().setValue(post);

                    Toast.makeText(getApplicationContext(), "Post Submitted", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                } else{
                    Snackbar.make(v, "Both fields are required", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }

}
