package app.chat.com.chatappcareerpath;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Login extends AppCompatActivity {

    EditText passwordEditText;
    EditText usernameEditText;
    Button signUpButton;
    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Link Java Variable with XML Object
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        loginButton = (Button) findViewById(R.id.loginButton);
        signUpButton = (Button) findViewById(R.id.signUpButton);

        // When Login Button is clicked, do this
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Firebase ref = new Firebase("https://chatlistandroidlec.firebaseio.com/");
                ref.authWithPassword(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new Firebase.AuthResultHandler() {
                    @Override
                    public void onAuthenticated(AuthData authData) {
                        Toast.makeText(Login.this, "User ID: " + authData.getUid() + ", Provider: " + authData.getProvider(), Toast.LENGTH_SHORT).show();

                        Firebase users = new Firebase("https://chatlistandroidlec.firebaseio.com/users");
                        users.child(authData.getUid()).setValue("blah");

                        Firebase userData = new Firebase("https://chatlistandroidlec.firebaseio.com/users/" + authData.getUid());
                        userData.child("fullname").setValue("Corey Morey");
                        userData.child("phone number").setValue("911");
                        userData.child("gender").setValue("anything");

                        Intent intent = new Intent( getApplicationContext(), MenuActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAuthenticationError(FirebaseError firebaseError) {
                        Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        Log.e("Login Error", firebaseError.toString());
                    }
                });

            }
        });

        // When SignUp Button is Clicked, do this
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class );
                startActivity(intent);
            }
        });



    }
}
