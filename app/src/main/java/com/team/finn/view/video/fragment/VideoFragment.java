package com.team.finn.view.video.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.flyco.tablayout.SlidingTabLayout;
import com.team.finn.R;
import com.team.finn.base.BaseFragment;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.video.bean.VideoCateList;
import com.team.finn.model.logic.video.VideoCateListLogic;
import com.team.finn.presenter.video.impl.VideoCateListPresenterImpl;
import com.team.finn.presenter.video.interfaces.VideoAllCateListContract;
import com.team.finn.view.video.adapter.VideoAllListAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public class VideoFragment extends BaseFragment<VideoCateListLogic, VideoCateListPresenterImpl> implements VideoAllCateListContract.View {

    SVProgressHUD svProgressHUD;
    @BindView(R.id.live_sliding_tab)
    SlidingTabLayout liveSlidingTab;
    @BindView(R.id.live_viewpager)
    ViewPager liveViewpager;
    private String[] mTitles;
    private VideoAllListAdapter mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_live;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        svProgressHUD = new SVProgressHUD(getActivity());
        mPresenter.getPresenterVideoCatelist();
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @Override
    protected void lazyFetchData() {
        mPresenter.getPresenterVideoCatelist();
    }


    @Override
    public void getViewVideoAllCate(List<VideoCateList> cateLists) {
        /**
         *  默认数据
         */
        mTitles = new String[cateLists.size() + 1];
        mTitles[0] = "推荐";
//        mFragments.add(RecommendHomeFragment.getInstance());
        for (int i = 0; i < cateLists.size(); i++) {
            mTitles[i + 1] = cateLists.get(i).getCate1_name();
//            Bundle bundle=new Bundle();
//             bundle.putSerializable("homecatelist",cateLists.get(i));
//            mFragments.add(OtherHomeFragment.getInstance(bundle));
        }
//        不摧毁Fragment
        liveViewpager.setOffscreenPageLimit(mTitles.length);
        mAdapter = new VideoAllListAdapter(getChildFragmentManager(), cateLists, mTitles);
        liveViewpager.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        liveSlidingTab.setViewPager(liveViewpager, mTitles);
    }

    @Override
    public void showErrorWithStatus(String msg) {
        svProgressHUD.showErrorWithStatus(msg);
    }

}
