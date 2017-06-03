package com.team.finn.model.logic.me;

import android.content.Context;

import com.team.finn.api.home.HomeApi;
import com.team.finn.api.me.MeApi;
import com.team.finn.model.ParamsMapUtils;
import com.team.finn.model.logic.home.bean.HomeCarousel;
import com.team.finn.model.logic.me.bean.PersonInfoBean;
import com.team.finn.net.http.HttpUtils;
import com.team.finn.net.transformer.DefaultTransformer;
import com.team.finn.presenter.me.interfaces.MeContract;

import java.util.List;

import rx.Observable;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public class MeModelLogic implements MeContract.Model {
    @Override
    public Observable<PersonInfoBean> getModelPersonInfo(Context context, String userName, String passWord) {
        return HttpUtils.getInstance(context)
                .setLoadDiskCache(false)
                .getRetofitClinet()
                .builder(MeApi.class)
                .getPersonInfos(ParamsMapUtils.getPersonInfo(userName,passWord))
//               进行预处理
                .compose(new DefaultTransformer<PersonInfoBean>());
    }
}
