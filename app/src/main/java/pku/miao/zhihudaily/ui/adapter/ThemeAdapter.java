package pku.miao.zhihudaily.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.Story;
import pku.miao.zhihudaily.bean.Theme;
import pku.miao.zhihudaily.bean.TopStory;

/**
 * Created by vector on 16/4/13.
 */
public class ThemeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public interface OnStoryItemClick {
        void onStoryItemClick(int position, int id);
    }

    public Theme theme;
    Context context;
    View[] topViews;

    OnStoryItemClick onStoryItemClick;

    private final int VIEW_TYPE_ONE = 0;
    private final int VIEW_TYPE_TWO = 1;


    public ThemeAdapter(Context context, Theme theme){
        this.context = context;
        this.theme = theme;
    }


    public void setOnStoryItemClick(OnStoryItemClick onStoryItemClick){
        this.onStoryItemClick = onStoryItemClick;
    }

    public void refresh(Theme theme){
        this.theme = theme;
        notifyDataSetChanged();
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
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.v("miao", "position" + position);
        if(position != 0){
            final Story story = theme.stories.get(position-1);
            Log.v("miao", story.getTitle());
            ((StoryViewHolder) holder).story_title_tv.setText(story.getTitle());
            if(story.getImages()!=null & story.getImages().size() > 0) {
                ((StoryViewHolder) holder).story_imv.setImageURI(Uri.parse(story.getImages().get(0)));
            }
            ((StoryViewHolder) holder).cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStoryItemClick.onStoryItemClick(position, story.getId());
                }
            });
        }else{
            ((TopStoryViewHolder) holder).image.setImageURI(Uri.parse(theme.background));
            ((TopStoryViewHolder) holder).story_title_tv.setText(theme.description);
        }
    }

    @Override
    public int getItemCount() {
        return theme == null ? 0 : theme.stories.size() + 1;
    }



    static class StoryViewHolder extends RecyclerView.ViewHolder{

        public CardView cardView;
        public SimpleDraweeView story_imv;
        public TextView story_title_tv;


        public StoryViewHolder(View itemView) {
            super(itemView);
            this.cardView = (CardView) itemView.findViewById(R.id.cardView);
            this.story_imv = (SimpleDraweeView) itemView.findViewById(R.id.story_image_imv);
            this.story_title_tv = (TextView) itemView.findViewById(R.id.story_title_tv);
        }
    }


    static class TopStoryViewHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView image;
        TextView story_title_tv;

        public TopStoryViewHolder(View itemView) {
            super(itemView);
            image = (SimpleDraweeView) itemView.findViewById(R.id.story_image_imv);
            story_title_tv = (TextView) itemView.findViewById(R.id.story_title_tv);
            image.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
        }
    }
}
