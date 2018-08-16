package test.tokopedia.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import test.tokopedia.newsapp.R;
import test.tokopedia.newsapp.data.SourceData;
import test.tokopedia.newsapp.ui.ArticleListActivity.ArticleListActivity;
import test.tokopedia.newsapp.ui.MainActivity.MainActivity;

/**
 * Created by Kharisma AW on 8/13/2018.
 */
public class NewsSourceListAdapter extends RecyclerView.Adapter<NewsSourceListAdapter.ViewHolder> {
    private List<SourceData> mSourceDataList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public NewsSourceListAdapter(List<SourceData> mSourceDataList, Context mContext) {
        this.mSourceDataList = mSourceDataList;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.item_news_source, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final SourceData sourceData = mSourceDataList.get(i);

        viewHolder.mNewsSourceCard.setText(sourceData.getName());
        viewHolder.mNewsSourceCard.setBackgroundColor(mContext.getResources().getColor(R.color.colorPrimaryDark));
        viewHolder.mNewsSourceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, ArticleListActivity.class);
                i.putExtra("source", sourceData.getId());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSourceDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNewsSourceCard;
        public ViewHolder(View itemView) {
            super(itemView);
            mNewsSourceCard = itemView.findViewById(R.id.item_news_source);
        }
    }
}
