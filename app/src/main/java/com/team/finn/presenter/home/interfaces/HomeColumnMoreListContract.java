package com.team.finn.presenter.home.interfaces;

import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.home.bean.HomeCarousel;
import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;

import java.util.List;

import rx.Observable;

/**
 *  作者：finn
 *  版本号：1.0
 *  备注消息：
 **/
public interface HomeColumnMoreListContract {
    interface View extends BaseView {
        void getViewHomeColumnMoreTwoCate(List<HomeColumnMoreTwoCate> mHomeColumnMoreTwoCate);

    }
    interface  Model extends BaseModel {

        Observable<List<HomeColumnMoreTwoCate>> getModelHomeColumnMoreTwoCate(Context context,String cate_id);
    }
    abstract class Presenter extends BasePresenter<View,Model> {
        /**
         *  获取栏目 更多 二级分类
         */
      public abstract void getPresenterHomeColumnMoreTwoCate(String cate_id);
    }
}
