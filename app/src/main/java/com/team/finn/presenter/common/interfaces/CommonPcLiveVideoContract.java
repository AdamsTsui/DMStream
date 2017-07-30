package com.team.finn.presenter.common.interfaces;


import android.content.Context;

import com.team.finn.base.BaseModel;
import com.team.finn.base.BasePresenter;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.common.bean.TempLiveVideoInfo;

import okhttp3.Request;

/**
 *  作者：finn
 *  版本号：1.0
 *  备注消息：
 **/
public interface CommonPcLiveVideoContract {

      interface View extends BaseView {
           void getViewPcLiveVideoInfo(TempLiveVideoInfo mLiveVideoInfo);
      }
    interface  Model extends BaseModel{
        Request getModelPcLiveVideoInfo(Context context, String room_id);
    }
    abstract class Presenter extends BasePresenter<View,Model> {
              public abstract  void getPresenterPcLiveVideoInfo(String room_id);
      }

}
