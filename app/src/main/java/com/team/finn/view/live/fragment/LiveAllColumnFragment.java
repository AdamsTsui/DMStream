package com.team.finn.view.live.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.team.finn.R;
import com.team.finn.base.BaseFragment;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.live.LiveAllListModelLogic;
import com.team.finn.model.logic.live.bean.LiveAllList;
import com.team.finn.presenter.live.impl.LiveAllListPresenterImp;
import com.team.finn.presenter.live.interfaces.LiveAllListContract;
import com.team.finn.ui.refreshview.XRefreshView;
import com.team.finn.view.live.adapter.LiveAllListAdapter;

import java.util.List;

import butterknife.BindView;
/**
 *  作者：finn
 *  版本号：1.0
 *  备注消息：
 **/
public class LiveAllColumnFragment extends BaseFragment<LiveAllListModelLogic, LiveAllListPresenterImp> implements LiveAllListContract.View {

    /**
     *  分页加载
     */
//    起始位置
    private  int offset = 0;
    //    每页加载数量
    private  int limit = 20;
    @BindView(R.id.rtefresh_content)
    XRefreshView rtefreshContent;
    @BindView(R.id.livealllist_content_recyclerview)
    RecyclerView livealllistContentRecyclerview;
    private LiveAllListAdapter mLiveAllListAdapter;

    public static LiveAllColumnFragment getInstance() {
        LiveAllColumnFragment rf = new LiveAllColumnFragment();
        return rf;
    }

    @Override
    protected int getLayoutId() {

        return R.layout.fragment_live_allcolumn;
    }

    @Override
    protected void onInitView(Bundle bundle) {

        setXrefeshViewConfig();
        livealllistContentRecyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        mLiveAllListAdapter=new LiveAllListAdapter(getActivity());
        livealllistContentRecyclerview.setAdapter(mLiveAllListAdapter);
        rtefreshContent.setXRefreshViewListener(new XRefreshView.SimpleXRefreshListener() {
            @Override
            public void onRefresh() {
//                延迟500毫秒, 原因 用户体验好 !!!
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refresh();
                    }
                }, 500);
            }
            @Override
            public void onLoadMore(boolean isSilence) {
                offset+=limit;
                loadMore(offset, limit);
            }
        });
    }
    @Override
    protected void onEvent() {

    }
    private void loadMore(int offset, int limit) {
        mPresenter.getPresenterListAllListLoadMore(offset,limit);
    }
    /**
     * 刷新网络数据
     */
    private void refresh() {
//       重新开始计算
        offset=0;
        mPresenter.getPresenterListAllList(0, 20);
    }
    /**
     * 配置XRefreshView
     */
    protected void setXrefeshViewConfig() {
        rtefreshContent.setPinnedTime(2000);
        rtefreshContent.setPullLoadEnable(true);
        rtefreshContent.setPullRefreshEnable(true);
        rtefreshContent.setMoveForHorizontal(true);
        rtefreshContent.setPinnedContent(true);
//        滚动到底部 自动加载数据
        rtefreshContent.setSilenceLoadMore();

    }
    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    protected void lazyFetchData() {
        refresh();
    }
    @Override
    public void getViewLiveAllListColumn(List<LiveAllList> mLiveAllList) {
        if (rtefreshContent != null) {
            rtefreshContent.stopRefresh();
        }
        mLiveAllListAdapter.getLiveAllList(mLiveAllList);
    }
    @Override
    public void getViewLiveAllListLoadMore(List<LiveAllList> mLiveAllList) {
        if (rtefreshContent != null) {
             rtefreshContent.stopLoadMore();
        }
        mLiveAllListAdapter.getLiveAllListLoadMore(mLiveAllList);
    }
    @Override
    public void showErrorWithStatus(String msg) {
        if (rtefreshContent != null) {
            rtefreshContent.stopRefresh(false);
            rtefreshContent.stopLoadMore(false);
        }
    }
}
