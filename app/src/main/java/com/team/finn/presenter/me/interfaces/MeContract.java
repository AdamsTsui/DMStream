package com.team.finn.presenter.me.interfaces;

import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.me.bean.PersonInfoBean;
import com.team.finn.presenter.video.interfaces.VideoAllCateListContract;
import com.team.finn.presenter.video.interfaces.VideoOtherCateContract;

import rx.Observable;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public interface MeContract {
    interface View extends BaseView{
        void getViewPersonInfo(PersonInfoBean personInfoBean);
        void showLoginPopWindow();

    }
    interface Model extends BaseModel{
        Observable<PersonInfoBean> getModelPersonInfo(Context context ,String userName, String passWord);
    }

    abstract class Presenter extends BasePresenter<View,Model>{
        public abstract  void Login();
    }
}
