package au.appxperts.ga.mapsurvey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

import au.appxperts.ga.mapsurvey.R;

/**
 * Created by PC on 17-May-16.
 */
public class SuccessfulPackageOperationAdapter extends RecyclerView.Adapter<ListItemsPDPSuccess>{


    private List<String> feedItemList;

    public SuccessfulPackageOperationAdapter(Context context, List<String> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public ListItemsPDPSuccess onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_pdpsuccess, null);

        ListItemsPDPSuccess viewHolder = new ListItemsPDPSuccess(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItemsPDPSuccess customViewHolder, int i) {
        String feedItem = feedItemList.get(i);

        //Download image using picasso library


        //Setting text view title
        customViewHolder.textView.setText(feedItem);
        customViewHolder.date.setText("Date"+"");
        customViewHolder.time.setText("Time"+"");
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }




}

class ListItemsPDPSuccess extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;
    protected TextView date;
    protected TextView time;

    public ListItemsPDPSuccess(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        this.textView = (TextView) view.findViewById(R.id.title);
        this.date = (TextView)view.findViewById(R.id.date);
        this.time = (TextView)view.findViewById(R.id.time);
    }
}
