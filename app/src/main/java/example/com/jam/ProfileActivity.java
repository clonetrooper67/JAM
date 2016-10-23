package example.com.jam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by taz98 on 10/23/2016.
 */

public class ProfileActivity extends AppCompatActivity {
    User user = new User();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);
        TextView firstName = (TextView) findViewById(R.id.profile_first_name);
        TextView lastName = (TextView) findViewById(R.id.profile_last_name);
        TextView description = (TextView) findViewById(R.id.profile_description);
        TextView userEmail = (TextView) findViewById(R.id.profile_email);

        String fName = user.getfName();
        String lName = user.getlName();
        String desc = user.getDesc();
        String email = user.getContact();

        firstName.setText(fName);
        lastName.setText(lName);
        description.setText(desc);
        userEmail.setText(email);

    }
}
