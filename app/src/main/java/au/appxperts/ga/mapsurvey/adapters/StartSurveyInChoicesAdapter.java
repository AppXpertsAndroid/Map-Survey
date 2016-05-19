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

/**
 * Created by PC on 17-May-16.
 */
public class StartSurveyInChoicesAdapter extends RecyclerView.Adapter<ListItems>{


    private List<String> feedItemList;

    public StartSurveyInChoicesAdapter(Context context, List<String> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public ListItems onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_chkboxes, null);

        ListItems viewHolder = new ListItems(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListItems customViewHolder, int i) {
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

