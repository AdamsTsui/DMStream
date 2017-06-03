package com.team.finn.presenter.me.impl;

import com.team.finn.presenter.me.interfaces.MeContract;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class MePresenterImpl extends MeContract.Presenter{
    @Override
    public void Login() {
        mView.showLoginPopWindow();
    }
}
