package pku.miao.zhihudaily.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.Story;
import pku.miao.zhihudaily.bean.TopStory;

/**
 * Created by vector on 16/4/13.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LatestNews latestNews;
    Context context;


    private final int VIEW_TYPE_ONE = 0;
    private final int VIEW_TYPE_TWO = 1;


    public RecommendAdapter(Context context, LatestNews latestNews){
        this.context = context;
        this.latestNews = latestNews;
    }



    public void refresh(LatestNews latestNews){
        this.latestNews = latestNews;
    }


    @Override
    public int getItemViewType(int position){
        if(position == VIEW_TYPE_ONE)
            return VIEW_TYPE_ONE;
        return VIEW_TYPE_TWO;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ONE){
            return new TopStoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_top_story, parent, false));
        }else{
            return new StoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.v("miao", "position" + position);
        if(position != 0){
            Story story = latestNews.getStories().get(position-1);
            Log.v("miao", story.getTitle());
            ((StoryViewHolder) holder).story_title_tv.setText(story.getTitle());
        }else{
            List<TopStory> topStories = latestNews.getTopStories();
        }
    }

    @Override
    public int getItemCount() {
        return latestNews.getStories().size() + 1;
    }



    static class StoryViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;
        public ImageView story_imv;
        public TextView story_title_tv;


        public StoryViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.story_imv = (ImageView) itemView.findViewById(R.id.story_image_imv);
            this.story_title_tv = (TextView) itemView.findViewById(R.id.story_title_tv);
        }
    }


    static class TopStoryViewHolder extends RecyclerView.ViewHolder{

        ViewPager top_story_vp;

        public TopStoryViewHolder(View itemView) {
            super(itemView);
            top_story_vp = (ViewPager) itemView.findViewById(R.id.top_story_vp);
        }
    }

}
