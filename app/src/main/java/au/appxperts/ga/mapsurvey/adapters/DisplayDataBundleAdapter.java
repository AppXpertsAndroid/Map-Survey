package au.appxperts.ga.mapsurvey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.requestresponse.Bundles;
import au.appxperts.ga.mapsurvey.requestresponse.GABundle;

/**
 * Created by PC on 16-May-16.
 */
public class DisplayDataBundleAdapter extends RecyclerView.Adapter<ListItems>{


    private Bundles feedItemList;

    public DisplayDataBundleAdapter(Context context, Bundles feedItemList) {
        this.feedItemList = feedItemList;
    }

    public Bundles getFeedItemList() {
        return feedItemList;
    }

    @Override
    public ListItems onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, null);

        ListItems viewHolder = new ListItems(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItems customViewHolder,final int i) {
        final GABundle feedItem = feedItemList.getBundles().get(i);

        //Download image using picasso library
        if(feedItem.bundleStatus){
            customViewHolder.chkbox.setChecked(true);
        }else{
            customViewHolder.chkbox.setChecked(false);
        }


        //Setting text view title
        String fileName = feedItem.bundleName.substring(feedItem.bundleName.lastIndexOf('/') + 1);
        if(fileName!=null)
            customViewHolder.textView.setText(fileName);

        customViewHolder.chkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(feedItem.bundleStatus){
                    feedItemList.getBundles().get(i).bundleStatus = false;
                }else{
                    feedItemList.getBundles().get(i).bundleStatus = true;
                }
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.getBundles().size() : 0);
    }




}

class ListItems extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView textView;
    protected CheckBox chkbox;

    public ListItems(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        this.textView = (TextView) view.findViewById(R.id.title);
        this.chkbox = (CheckBox)view.findViewById(R.id.chkbox);
    }
}
