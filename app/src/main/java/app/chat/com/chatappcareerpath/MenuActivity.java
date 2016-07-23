package app.chat.com.chatappcareerpath;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

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
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));
        data.add(new MenuActivityRecyclerInfo("John Doe"));


        //inflate recyclerview object
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        //set adapter
        adapter = new MenuActivityRecyclerAdapter(this, data);

        recyclerView.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

        recyclerView.setAdapter(adapter);
    }
}
