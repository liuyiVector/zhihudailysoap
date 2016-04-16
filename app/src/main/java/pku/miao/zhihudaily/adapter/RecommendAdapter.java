package pku.miao.zhihudaily.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
import pku.miao.zhihudaily.bean.TopStory;

/**
 * Created by vector on 16/4/13.
 */
public class RecommendAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LatestNews latestNews;
    Context context;
    View[] topViews;

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
            return new TopStoryViewHolder(LayoutInflater.from(context).inflate(R.layout.top_story, parent, false), parent);
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
            ((StoryViewHolder)holder).story_imv.setImageURI(Uri.parse(story.getImages().get(0)));
        }else{
            List<TopStory> topStories = latestNews.getTopStories();
            setGallery(context, ((TopStoryViewHolder)holder).top_story_vp, ((TopStoryViewHolder)holder).viewGroup, ((TopStoryViewHolder)holder).parent);
        }
    }

    @Override
    public int getItemCount() {
        return latestNews.getStories().size() + 1;
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

        ViewPager top_story_vp;
        ViewGroup viewGroup;
        ViewGroup parent;

        public TopStoryViewHolder(View itemView, ViewGroup parent) {
            super(itemView);
            top_story_vp = (ViewPager) itemView.findViewById(R.id.top_story_vp);
            viewGroup = (ViewGroup) itemView.findViewById(R.id.viewGroup);
            this.parent = parent;
        }
    }


    void setGallery(final Context context, ViewPager top_story_vp, ViewGroup viewGroup, ViewGroup parent){
        int len = latestNews.getTopStories().size();
        topViews = new View[len];
        for(int i = 0; i < len; i++){
            View item = LayoutInflater.from(context).inflate(R.layout.item_top_story, parent, false);
            SimpleDraweeView image = (SimpleDraweeView) item.findViewById(R.id.story_image_imv);
            TextView story_title_tv = (TextView) item.findViewById(R.id.story_title_tv);
            image.setImageURI(Uri.parse(latestNews.getTopStories().get(i).getImage()));
            //增加一个蒙版的效果
            image.setColorFilter(Color.GRAY, PorterDuff.Mode.MULTIPLY);
            //灰白色
//            ColorMatrix matrix = new ColorMatrix();
//            matrix.setSaturation(0);
//
//            ColorMatrixColorFilter filter = new ColorMatrixColorFilter(matrix);
//            image.setColorFilter(filter);
            story_title_tv.setText(latestNews.getTopStories().get(i).getTitle());
            topViews[i] = item;
        }

        final ImageView[] tips = new ImageView[len];
        viewGroup.removeAllViews();
        for(int i=0; i<len; i++){
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(5,5));
            tips[i] = imageView;
            if(i == 0){
                tips[i].setBackgroundResource(R.drawable.circle_select);
            }else{
                tips[i].setBackgroundResource(R.drawable.circle_unselect);
            }

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            layoutParams.leftMargin = 5;
            layoutParams.rightMargin = 5;
            viewGroup.addView(imageView, layoutParams);
        }

        top_story_vp.setAdapter(new MyAdapter());
        top_story_vp.setCurrentItem(0);
        top_story_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                for(int i=0; i< tips.length; i++){
                    if(i == position){
                        tips[i].setImageDrawable(context.getResources().getDrawable(R.drawable.circle_select));
                    }else{
                        tips[i].setImageDrawable(context.getResources().getDrawable(R.drawable.circle_unselect));
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return topViews.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            ((ViewPager)container).removeView(topViews[position % topViews.length]);

        }

        /**
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
         */
        @Override
        public Object instantiateItem(View container, int position) {
            ((ViewPager)container).addView(topViews[position % topViews.length], 0);
            return topViews[position % topViews.length];
        }



    }

}
