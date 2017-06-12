package com.team.finn.presenter.video.interfaces;


import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.video.bean.VideoStramInfo;

import okhttp3.Request;

/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public interface VideoPhoneVideoInfoContract {

    interface View extends BaseView {
        void getViewPhoneLiveVideoInfo(VideoStramInfo mLiveVideoInfo);
    }

    interface Model extends BaseModel {
        Request getModelPhoneLiveVideoInfo(Context context, String room_id);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getPresenterPhoneLiveVideoInfo(String room_id);
    }

}
