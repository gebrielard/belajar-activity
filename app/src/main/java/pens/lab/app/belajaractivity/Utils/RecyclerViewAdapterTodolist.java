package pens.lab.app.belajaractivity.Utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import pens.lab.app.belajaractivity.R;
import pens.lab.app.belajaractivity.data.model.Task;

public class RecyclerViewAdapterTodolist extends RecyclerView.Adapter<RecyclerViewAdapterTodolist.MyViewHolder> {
    private static ArrayList<Task> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tvNumber;
        public TextView tvTitle;
        public TextView tvDescription;
        public MyViewHolder(View view) {
            super(view);
            this.tvNumber = view.findViewById(R.id.tvTodolistNumber);
            this.tvTitle = view.findViewById(R.id.tvTodolistTitle);
            this.tvDescription = view.findViewById(R.id.tvTodolistDescription);
        }
    }

    public RecyclerViewAdapterTodolist(ArrayList<Task> myDataset) {
        mDataset = myDataset;
    }

    public void addTask(Task newTask) {
        mDataset.add(newTask);
        notifyItemChanged(getItemCount() - 1);
    }

    @Override
    public RecyclerViewAdapterTodolist.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tvNumber.setText(String.valueOf(position+1));
        holder.tvTitle.setText(mDataset.get(position).getTitle());
        holder.tvDescription.setText(mDataset.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}
