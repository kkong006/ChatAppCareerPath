package app.chat.com.chatappcareerpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MenuActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MenuActivityRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<MenuActivityRecyclerInfo> data = new ArrayList<>();
        data.add(new MenuActivityRecyclerInfo("Bob"));
        data.add(new MenuActivityRecyclerInfo("Sandra"));
        data.add(new MenuActivityRecyclerInfo("Bobby"));
        data.add(new MenuActivityRecyclerInfo("LALALA"));


        // Inflate Recycler View Object
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // Create Adapter
        adapter = new MenuActivityRecyclerAdapter(this, data);

        // Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

        // Set Adapter
        recyclerView.setAdapter(adapter);

    }
}
