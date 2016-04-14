package pku.miao.zhihudaily.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import pku.miao.zhihudaily.R;

/**
 * Created by vector on 16/4/13.
 */
public class TopImageFragment extends Fragment {

    ImageView top_story_imv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_story, container, false);

        initView(root);

        return root;
    }


    void initView(View view){
        top_story_imv = (ImageView) view.findViewById(R.id.top_story_imv);
    }
}
