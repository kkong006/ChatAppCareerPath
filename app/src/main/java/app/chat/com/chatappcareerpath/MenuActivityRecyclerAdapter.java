package app.chat.com.chatappcareerpath;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sultankhan on 4/27/16.
 */
public class MenuActivityRecyclerAdapter extends RecyclerView.Adapter<MenuActivityRecyclerAdapter.MyViewHolder>{

    LayoutInflater inflater;
    Context context;
    List<MenuActivityRecyclerInfo> data = Collections.emptyList();


    public MenuActivityRecyclerAdapter(MenuActivity context, ArrayList<MenuActivityRecyclerInfo> data){
        this.data = data;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void addRow(MenuActivityRecyclerInfo row) {
        data.add(row);
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public MenuActivityRecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate( R.layout.row_menu_activity, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, new MyViewHolder.MyViewHolderClicks() {
            @Override
            public void rowClick(View caller, int position) {
                Toast.makeText(context, "Row Number Clicked" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void nameClick(View caller, int position) {
                Toast.makeText(context, "Name Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        return myViewHolder;

    }

    // Set row data
    @Override
    public void onBindViewHolder(MenuActivityRecyclerAdapter.MyViewHolder holder, int position) {
        holder.fullname.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // This is the row object
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public MyViewHolderClicks mListener;
        TextView fullname;

        public MyViewHolder(View itemView, MyViewHolderClicks listener) {
            super(itemView);
            mListener = listener;
            fullname = (TextView) itemView.findViewById(R.id.fullname);

            itemView.setOnClickListener(this);
            fullname.setOnClickListener(this);


        }

        @Override
        public void onClick(View view) {

            switch (view.getId()){
                case R.id.fullname:
                    mListener.nameClick(view, getAdapterPosition());
                    break;
                default:
                    mListener.rowClick(view, getAdapterPosition());
            }

        }

        public interface MyViewHolderClicks{
            void rowClick(View caller, int position);
            void nameClick(View caller, int position);
        }
    }

}
