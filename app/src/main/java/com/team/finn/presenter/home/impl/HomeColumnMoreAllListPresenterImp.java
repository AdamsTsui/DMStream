package com.team.finn.presenter.home.impl;

import com.team.finn.model.logic.home.bean.HomeColumnMoreAllList;
import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;
import com.team.finn.net.callback.RxSubscriber;
import com.team.finn.net.exception.ResponeThrowable;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreAllListContract;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreListContract;

import java.util.List;

/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeColumnMoreAllListPresenterImp extends HomeColumnMoreAllListContract.Presenter {
    @Override
    public void getPresenterColumnMoreAllList(String cate_id, int offset, int limint) {
        addSubscribe(mModel.getModelHomeColumnMoreAllList(mContext, cate_id, offset, limint).subscribe(new RxSubscriber<List<HomeColumnMoreAllList>>() {
            @Override
            public void onSuccess(List<HomeColumnMoreAllList> mHomeColumnMoreAllList) {
                mView.getViewHomeColumnAllList(mHomeColumnMoreAllList);
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                mView.showErrorWithStatus(ex.message);
            }
        }));

    }

    @Override
    public void getPresenterColumnMoreAllListLoadMore(String cate_id, int offset, int limit) {
        addSubscribe(mModel.getModelHomeColumnMoreAllList(mContext, cate_id, offset, limit).subscribe(new RxSubscriber<List<HomeColumnMoreAllList>>() {
            @Override
            public void onSuccess(List<HomeColumnMoreAllList> mHomeColumnMoreAllList) {
                mView.getViewHomeColumnAllListLoadMore(mHomeColumnMoreAllList);
            }

            @Override
            protected void onError(ResponeThrowable ex) {
                mView.showErrorWithStatus(ex.message);
            }
        }));
    }
}
