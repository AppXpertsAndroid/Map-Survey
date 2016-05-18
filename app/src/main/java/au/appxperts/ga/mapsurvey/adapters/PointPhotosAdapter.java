package au.appxperts.ga.mapsurvey.adapters;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import au.appxperts.ga.mapsurvey.R;

/**
 * Created by PC on 18-May-16.
 */
public class PointPhotosAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> feedItemList;
    public PointPhotosAdapter(Context context, List<String> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_item_grid, null);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ViewHolder myViewHolder = (ViewHolder)holder;


    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageViewmain;
        ImageView imageView_opt_selctn;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewmain = (ImageView) itemView.findViewById(R.id.imageViewmain);
            imageView_opt_selctn = (ImageView) itemView.findViewById(R.id.imageView_opt_selctn);
        }
    }

}
