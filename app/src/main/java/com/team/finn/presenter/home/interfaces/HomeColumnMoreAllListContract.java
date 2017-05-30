package com.team.finn.presenter.home.interfaces;

import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.home.bean.HomeColumnMoreAllList;
import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;

import java.util.List;

import rx.Observable;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public interface HomeColumnMoreAllListContract {
    interface View extends BaseView {
        void getViewHomeColumnAllList(List<HomeColumnMoreAllList> mHomeColumnMoreAllList);
        void getViewHomeColumnAllListLoadMore(List<HomeColumnMoreAllList> mHomeColumnMoreAllList);
    }

    interface Model extends BaseModel {

        Observable<List<HomeColumnMoreAllList>> getModelHomeColumnMoreAllList(Context context, String cate_id, int offset, int limit);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        /**
         * 获取全部列表
         */
        public abstract void getPresenterColumnMoreAllList(String cate_id, int offset, int limit);
        /**
         *  加载更多
         */
        public abstract  void getPresenterColumnMoreAllListLoadMore(String cate_id,int offset,int limit);

    }
}
