package au.appxperts.ga.mapsurvey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;

/**
 * Created by PC on 17-May-16.
 */
public class PackageDataPointsAdapter extends RecyclerView.Adapter<ListItemsPDP>{


    private List<String> feedItemList;

    public PackageDataPointsAdapter(Context context, List<String> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public ListItemsPDP onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pdp, null);

        ListItemsPDP viewHolder = new ListItemsPDP(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemsPDP customViewHolder, int i) {
        String feedItem = feedItemList.get(i);

        //Download image using picasso library


        //Setting text view title
        customViewHolder.textView.setText(feedItem);
        customViewHolder.secondTextView.setText("Date"+"");
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }




}

class ListItemsPDP extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;
    protected TextView secondTextView;

    public ListItemsPDP(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        this.textView = (TextView) view.findViewById(R.id.title);
        this.secondTextView = (TextView)view.findViewById(R.id.date);
    }
}
