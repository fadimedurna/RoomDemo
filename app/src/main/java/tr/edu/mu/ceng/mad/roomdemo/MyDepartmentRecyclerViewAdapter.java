package tr.edu.mu.ceng.mad.roomdemo;

import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/*
 * TODO: Replace the implementation with code for your data type.
 */
public class MyDepartmentRecyclerViewAdapter extends
        RecyclerView.Adapter<MyDepartmentRecyclerViewAdapter.ViewHolder> {

    private final List<Department> mValues;
    private DepartmentFragment.DepartmentListener mListener;

    public MyDepartmentRecyclerViewAdapter(List<Department> items,
                                           DepartmentFragment.DepartmentListener listener) {
        mValues = (List<Department>) items;
        mListener = listener;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_department, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(mValues.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    mListener.onDepartmentSelected(holder.mItem);
                }
            }
        });

        if (position %2 == 1)
            holder.mNameView.setBackgroundColor(Color.GREEN);
        else
            holder.mNameView.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView; //container(LinearLAayout)
        public final TextView mNameView;
        public Department mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}