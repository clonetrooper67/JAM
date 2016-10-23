package example.com.jam;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by taz98 on 10/22/2016.
 */

public class FireBaseReader {
    void init(String UUID){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://junior-achievement-mobil-ad088.appspot.com/");
        storageRef = storage.getReferenceFromUrl("gs://<your-bucket-name>");
        StorageReference imagesRef = storageRef.child("images");
        StorageReference spaceRef = storageRef.child("images/space.jpg");
        String fileName = "profile.jpg";
        spaceRef = imagesRef.child(fileName);

        String path = spaceRef.getPath();

        String name = spaceRef.getName();

        imagesRef = spaceRef.getParent();

    }
    public void getImage(String UUID){

    }
}
