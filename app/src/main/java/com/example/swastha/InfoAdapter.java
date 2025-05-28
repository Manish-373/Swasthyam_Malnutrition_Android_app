package com.example.swastha;import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {
    private List<InfoItem> infoList;

    public InfoAdapter(List<InfoItem> infoList) {
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InfoItem item = infoList.get(position);
        holder.titleTextView.setText(item.getTitle());

        // Enable bold text and clickable links
        holder.descriptionTextView.setText(Html.fromHtml(item.getDescription(), Html.FROM_HTML_MODE_COMPACT));
        holder.descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance()); // Enable clicking

        // Toggle visibility
        boolean isExpanded = item.isExpanded();
        holder.descriptionTextView.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        // Click to Expand/Collapse
        holder.titleTextView.setOnClickListener(v -> {
            item.setExpanded(!item.isExpanded());
            notifyItemChanged(position);
        });
    }



    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public void updateList(List<InfoItem> newList) {
        infoList = newList;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }
    }
}
