package app.chat.com.chatappcareerpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    EditText passwordEditText;
    EditText emailEditText;
    EditText fullnameEditText;
    Button signUpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        emailEditText = (EditText) findViewById(R.id.emailEditText);
        fullnameEditText = (EditText) findViewById(R.id.fullnameEditText);
        signUpButton = (Button) findViewById(R.id.signUpButton);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Firebase ref = new Firebase("https://chatlistandroidlec.firebaseio.com/");
                ref.createUser(emailEditText.getText().toString(), passwordEditText.getText().toString() , new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        Toast.makeText(SignUpActivity.this, "Account Successfuly Created", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Toast.makeText(SignUpActivity.this, "Account Creation Failed", Toast.LENGTH_SHORT).show();
                        Log.e("Account Creation Error",firebaseError.toString());
                    }
                });

            }
        });
    }
}
