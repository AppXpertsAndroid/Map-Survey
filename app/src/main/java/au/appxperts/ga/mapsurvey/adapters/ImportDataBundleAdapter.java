package au.appxperts.ga.mapsurvey.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import au.appxperts.ga.mapsurvey.R;
import au.appxperts.ga.mapsurvey.requestresponse.Bundles;
import au.appxperts.ga.mapsurvey.requestresponse.GABundle;

/**
 * Created by xpertsinfosoftmac-3 on 11/05/16.
 */
public class ImportDataBundleAdapter extends RecyclerView.Adapter<GridItems>{


    private Bundles feedItemList;

    public ImportDataBundleAdapter(Context context, Bundles feedItemList) {
        this.feedItemList = feedItemList;
    }

    public Bundles getFeedItemList() {
        return feedItemList;
    }

    @Override
    public GridItems onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, null);

        GridItems viewHolder = new GridItems(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GridItems customViewHolder,final int i) {
        final GABundle feedItem = feedItemList.getBundles().get(i);

        //Download image using picasso library

        if(feedItem.bundleStatus){
            customViewHolder.check.setVisibility(View.VISIBLE);
        }else{
            customViewHolder.check.setVisibility(View.GONE);
        }

        //Setting text view title
        String fileName = feedItem.bundleName.substring(feedItem.bundleName.lastIndexOf('/') + 1);
        if(fileName!=null)
        customViewHolder.textView.setText(fileName);


        customViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

class GridItems extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected ImageView check;
    protected TextView textView;


    public GridItems(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.thumbnail);
        this.check = (ImageView) view.findViewById(R.id.check);
        this.textView = (TextView) view.findViewById(R.id.title);
    }
}
