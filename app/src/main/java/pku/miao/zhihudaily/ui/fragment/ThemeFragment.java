package pku.miao.zhihudaily.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pku.miao.zhihudaily.R;
import pku.miao.zhihudaily.bean.LatestNews;
import pku.miao.zhihudaily.bean.Theme;
import pku.miao.zhihudaily.contract.ThemeContract;
import pku.miao.zhihudaily.ui.activity.DetailActivity;
import pku.miao.zhihudaily.ui.adapter.RecommendAdapter;
import pku.miao.zhihudaily.ui.adapter.ThemeAdapter;
import pku.miao.zhihudaily.ui.view.DividerItemDecoration;

/**
 * Created by vector on 16/4/13.
 */
public class ThemeFragment extends Fragment implements ThemeContract.View, SwipeRefreshLayout.OnRefreshListener, ThemeAdapter.OnStoryItemClick{

    private ThemeContract.Presenter mPresenter;
    public static final String ARGUMENT_TASK_ID = "TASK_ID";

    RecyclerView hot_rcv;
    SwipeRefreshLayout swp;

    Context context;

    private ThemeAdapter themeAdapter;



    public static ThemeFragment newInstance(String taskId){
        Bundle arguments = new Bundle();
        arguments.putString(ARGUMENT_TASK_ID, taskId);
        ThemeFragment fragment = new ThemeFragment();
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_theme, container, false);
        context = getActivity();

        setHasOptionsMenu(true);
        initView(root);

        return root;
    }


    void initView(View root){
        // Set up floating action button
        FloatingActionButton fab =
                (FloatingActionButton) getActivity().findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        hot_rcv = (RecyclerView) root.findViewById(R.id.id_hot_rcv);

        hot_rcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        hot_rcv.setHasFixedSize(true);
        int spacingInPixels = 8;
        hot_rcv.addItemDecoration(new DividerItemDecoration(spacingInPixels));

        themeAdapter = new ThemeAdapter(context, null);
        themeAdapter.setOnStoryItemClick(this);
        hot_rcv.setAdapter(themeAdapter);

        hot_rcv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        swp = (SwipeRefreshLayout) root.findViewById(R.id.id_swp);

        swp.setOnRefreshListener(this);


    }


    @Override
    public void onResume(){
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(ThemeContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onRefresh() {
        mPresenter.start();
    }

    @Override
    public void showStory(Theme theme) {
        swp.setRefreshing(false);
        themeAdapter.refresh(theme);
    }

    @Override
    public void onStoryItemClick(int position, int id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("newsID", themeAdapter.theme.stories.get(position-1).getId());
        startActivity(intent);
    }
}
