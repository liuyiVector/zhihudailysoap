package pku.miao.zhihudaily.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.Comment;
import pku.miao.zhihudaily.bean.Comments1;

/**
 * Created by vector on 16/5/3.
 */
public class CommentsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    Comments1 comments;

    public CommentsAdapter(Context context, Comments1 comments){
        this.context = context;
        this.comments = comments;
        if(comments!=null)
            comments.aggregrate();
    }

    public void refresh( Comments1 comments){
        this.comments = comments;
        comments.aggregrate();


        Log.v("liuyi", comments.all_comments.size()+"--------");
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Comment comment = comments.all_comments.get(position);

        Date date = new Date(comment.time*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ((CommentViewHolder)holder).time_tv.setText(sdf.format(date));
        ((CommentViewHolder)holder).comment_tv.setText(comment.content);
        ((CommentViewHolder)holder).like_count_tv.setText(comment.likes+"");
        ((CommentViewHolder)holder).name_tv.setText(comment.author);
        ((CommentViewHolder)holder).avatar_sdv.setImageURI(Uri.parse(comment.avatar));
    }

    @Override
    public int getItemCount() {
        return comments == null ? 0 : comments.all_comments.size();
    }


    static class CommentViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView avatar_sdv;
        TextView name_tv;
        TextView like_count_tv;
        TextView comment_tv;
        TextView time_tv;
        public CommentViewHolder(View itemView) {
            super(itemView);
            avatar_sdv = (SimpleDraweeView) itemView.findViewById(R.id.avatar_sdv);
            name_tv = (TextView) itemView.findViewById(R.id.name_tv);
            like_count_tv = (TextView) itemView.findViewById(R.id.like_count_tv);
            comment_tv = (TextView) itemView.findViewById(R.id.comment_tv);
            time_tv = (TextView) itemView.findViewById(R.id.time_tv);
        }
    }
}
