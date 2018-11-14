package com.sajjad.recycleritemsearchclick;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> employeeList;

    EmployeeAdapter(Context context, List<String> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.employee_item, viewGroup,false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        EmployeeHolder employeeHolder = (EmployeeHolder) viewHolder;
        employeeHolder.employeeName.setText(employeeList.get(i));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeHolder extends RecyclerView.ViewHolder {

        Button update;
        TextView employeeName;

        EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            update = itemView.findViewById(R.id.employee_update);
            employeeName = itemView.findViewById(R.id.employee_name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, employeeList.get(getAdapterPosition()), Toast.LENGTH_LONG).show();
                }
            });

            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "update" + getAdapterPosition(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}