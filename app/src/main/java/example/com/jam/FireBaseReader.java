package example.com.jam;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by taz98 on 10/22/2016.
 */

public class FireBaseReader {
    void init(String UUID){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://junior-achievement-mobil-ad088.appspot.com");
        imagesRef = storageRef.child("images");

        StorageReference userProfRef = storageRef.child("images/" + UUID + "profile.jpg");
    }
    public void getImage(String UUID){


    }
}
