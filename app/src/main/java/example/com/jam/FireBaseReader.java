package example.com.jam;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

/**
 * Created by taz98 on 10/22/2016.
 */

// The FireBaseReader class provides the ability to store, upload, and retrieve image files.
public class FireBaseReader {

    public void getProfileImage(String UUID) throws IOException{
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://junior-achievement-mobil-ad088.appspot.com/");
        StorageReference imageRef = storageRef.child("images/" + UUID + "/profile.jpg");

        String path = imageRef.getPath();

        File localFile = File.createTempFile("images", "jpg");

        imageRef.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                // Local temp file has been created
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });

    }

}
