package app.chat.com.chatappcareerpath;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by sultankhan on 4/13/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
