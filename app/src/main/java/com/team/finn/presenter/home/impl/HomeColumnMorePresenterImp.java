package com.team.finn.presenter.home.impl;

import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;
import com.team.finn.net.callback.RxSubscriber;
import com.team.finn.net.exception.ResponeThrowable;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreListContract;

import java.util.List;

/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeColumnMorePresenterImp extends HomeColumnMoreListContract.Presenter {
    @Override
    public void getPresenterHomeColumnMoreTwoCate(String cate_id) {
        addSubscribe(mModel.getModelHomeColumnMoreTwoCate(mContext, cate_id).subscribe(new RxSubscriber<List<HomeColumnMoreTwoCate>>() {
            @Override
            public void onSuccess(List<HomeColumnMoreTwoCate> mHomeColumnMoreTwoCate) {
                mView.getViewHomeColumnMoreTwoCate(mHomeColumnMoreTwoCate);
            }
            @Override
            protected void onError(ResponeThrowable ex) {
                mView.showErrorWithStatus(ex.message);
            }
        }));

    }
}
