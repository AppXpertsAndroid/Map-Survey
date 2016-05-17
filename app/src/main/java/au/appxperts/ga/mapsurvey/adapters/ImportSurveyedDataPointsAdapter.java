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

/**
 * Created by PC on 17-May-16.
 */
public class ImportSurveyedDataPointsAdapter extends RecyclerView.Adapter<GridItems>{


    private List<String> feedItemList;

    public ImportSurveyedDataPointsAdapter(Context context, List<String> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public GridItems onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_item, null);

        GridItems viewHolder = new GridItems(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GridItems customViewHolder, int i) {
        String feedItem = feedItemList.get(i);

        //Download image using picasso library


        //Setting text view title
        customViewHolder.textView.setText(feedItem);
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }




}


