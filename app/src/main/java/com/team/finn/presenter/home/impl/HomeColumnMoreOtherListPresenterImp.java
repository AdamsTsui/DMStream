package com.team.finn.presenter.home.impl;

import com.team.finn.model.logic.home.bean.HomeColumnMoreAllList;
import com.team.finn.model.logic.home.bean.HomeColumnMoreOtherList;
import com.team.finn.net.callback.RxSubscriber;
import com.team.finn.net.exception.ResponeThrowable;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreOtherListContract;

import java.util.List;

/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeColumnMoreOtherListPresenterImp extends HomeColumnMoreOtherListContract.Presenter {
    @Override
    public void getPresenterColumnMoreOtherList(String cate_id, int offset, int limint) {
        addSubscribe(mModel.getModelHomeColumnMoreOtherList(mContext, cate_id, offset, limint).subscribe(new RxSubscriber<List<HomeColumnMoreOtherList>>() {
            @Override
            public void onSuccess(List<HomeColumnMoreOtherList> mHomeColumnMoreOtherList) {
                mView.getViewHomeColumnOtherList(mHomeColumnMoreOtherList);
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                mView.showErrorWithStatus(ex.message);
            }
        }));

    }

    @Override
    public void getPresenterColumnMoreOtherListLoadMore(String cate_id, int offset, int limit) {
        addSubscribe(mModel.getModelHomeColumnMoreOtherList(mContext, cate_id, offset, limit).subscribe(new RxSubscriber<List<HomeColumnMoreOtherList>>() {
            @Override
            public void onSuccess(List<HomeColumnMoreOtherList> mHomeColumnMoreAllList) {
                mView.getViewHomeColumnOtherListLoadMore(mHomeColumnMoreAllList);
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                mView.showErrorWithStatus(ex.message);
            }
        }));
    }
}
