package com.team.finn.presenter.home.interfaces;


import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.home.HomeCate;

import java.util.List;

import rx.Observable;

import static com.team.finn.api.NetWorkApi.getHomeCate;

/**
 *  版本号：1.0
 *  备注消息：
 **/
public interface HomeCateContract {
    interface View extends BaseView {

    }
    interface  Model extends BaseModel {
        Observable<List<HomeCate>> getHomeCate(Context context,String identification);
    }

    abstract class Presenter extends BasePresenter<View,Model> {
        public abstract void  getHomeCate(String identification);
    }
}