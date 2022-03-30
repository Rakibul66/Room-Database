package com.eso.taskroomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eso.taskroomdatabase.db.Student;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;
    private Context context;

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        holder.mTvName.setText(student.getName());
        holder.mTvEmail.setText(student.getEmail());
        holder.mTvCountry.setText(student.getCountry());
        holder.mTvTime.setText(student.getRegisteredTime());
    }

    @Override
    public int getItemCount() {
        if (studentList == null) return 0;
        return studentList.size();
    }

    public void setData(List<Student> students){
        this.studentList = students;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTime,mTvName,mTvEmail,mTvCountry;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tvName);
            mTvEmail = itemView.findViewById(R.id.tvEmail);
            mTvCountry = itemView.findViewById(R.id.tvCountry);
            mTvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
