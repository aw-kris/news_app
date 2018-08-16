package test.tokopedia.newsapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import test.tokopedia.newsapp.R;
import test.tokopedia.newsapp.data.ArticleData;
import test.tokopedia.newsapp.ui.WebviewActivity.WebViewActivity;

/**
 * Created by Kharisma AW on 8/15/2018.
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {
    private List<ArticleData> mArticleDataList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ArticleListAdapter(List<ArticleData> mArticleDataList, Context mContext) {
        this.mArticleDataList = mArticleDataList;
        this.mContext = mContext;
        this.mLayoutInflater = LayoutInflater.from(mContext);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = mLayoutInflater.inflate(R.layout.item_article, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleListAdapter.ViewHolder viewHolder, int i) {
        final ArticleData articleData = mArticleDataList.get(i);

//        int[] androidColors = mContext.getResources().getIntArray(R.array.colorArray);
//        int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];

        Picasso.get().load(articleData.getUrlToImage()).into(viewHolder.article_img);
        viewHolder.article_title.setText(articleData.getTitle());
        viewHolder.article_source.setText(articleData.getSource().getName());
        viewHolder.article_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, WebViewActivity.class);
                i.putExtra("url", articleData.getUrl().replace("https", "http"));
//                i.putExtra("url", "http://www.google.com");
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArticleDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout article_container;
        ImageView article_img;
        TextView article_title, article_source;
        public ViewHolder(View itemView) {
            super(itemView);
            article_container = itemView.findViewById(R.id.item_article_container);
            article_img = itemView.findViewById(R.id.article_img);
            article_title = itemView.findViewById(R.id.article_title);
            article_source = itemView.findViewById(R.id.article_source);
        }
    }
}
