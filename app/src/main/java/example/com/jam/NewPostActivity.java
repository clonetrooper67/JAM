package example.com.jam;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

public class NewPostActivity extends AppCompatActivity {

    private boolean hasImage = false;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;
    private Bitmap imageFile;

    private DatabaseReference mDatabase;
    private String mUserId;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseUser mFirebaseUser;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        Button submitButton = (Button) findViewById(R.id.submitPostButton);
        Button cameraButton = (Button) findViewById(R.id.imageButton);

        cameraButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dispatchTakePictureIntent();

            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText titleEditText = (EditText) findViewById(R.id.titleEditText);
                EditText bodyEditText = (EditText) findViewById(R.id.bodyEditText);

                String title = titleEditText.getText().toString();
                String body = bodyEditText.getText().toString();

                if(!title.matches("") && !body.matches("")){
                    if(hasImage){
                        StorageReference storageRef = storage.getReferenceFromUrl("gs://junior-achievement-mobil-ad088.appspot.com/");
                        StorageReference imageRef = storageRef.child("postImages/" + mFirebaseUser.getUid() + ".jpg");
                        storageRef = storageRef.child("postImages" + "/" + mFirebaseUser.getUid());

                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        imageFile.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                        byte[] data = baos.toByteArray();

                        UploadTask uploadTask = storageRef.putBytes(data);
                        uploadTask.addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                // Handle unsuccessful uploads
                            }
                        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, and download URL.
                                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            }
                        });

                        Post post = new Post(title, body, mUserId = mFirebaseUser.getEmail(), "postImages" + "/" + mFirebaseUser.getUid());
                        mDatabase.child("posts").push().setValue(post);
                    }else {
                        Post post = new Post(title, body, mUserId = mFirebaseUser.getEmail());
                        mDatabase.child("posts").push().setValue(post);
                    }

                    Toast.makeText(getApplicationContext(), "Post Submitted", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                } else{
                    Snackbar.make(v, "Both fields are required", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        imageView = (ImageView) findViewById(R.id.postImageView);
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageFile = imageBitmap;
            imageView.setImageBitmap(imageBitmap);
            hasImage = true;
        }
    }

}
