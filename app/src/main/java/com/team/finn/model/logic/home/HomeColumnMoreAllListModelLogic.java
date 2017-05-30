package com.team.finn.model.logic.home;

import android.content.Context;

import com.team.finn.api.home.HomeApi;
import com.team.finn.model.ParamsMapUtils;
import com.team.finn.model.logic.home.bean.HomeColumnMoreAllList;
import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;
import com.team.finn.net.http.HttpUtils;
import com.team.finn.net.transformer.DefaultTransformer;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreAllListContract;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreListContract;

import java.util.List;

import rx.Observable;

/**
 *  版本号：1.0
 *  备注消息：
 **/
public class HomeColumnMoreAllListModelLogic implements HomeColumnMoreAllListContract.Model {

    /**
     *  全部直播列表
     * @param context
     * @param cate_id
     * @return
     */
    @Override
    public Observable<List<HomeColumnMoreAllList>> getModelHomeColumnMoreAllList(Context context, String cate_id,int offset,int limit) {
        return HttpUtils.getInstance(context)
                .setLoadDiskCache(true)
                .getRetofitClinet()
                .builder(HomeApi.class)
                .getHomeColumnMoreAllList(cate_id,ParamsMapUtils.getHomeFaceScoreColumn(offset,limit))
//               进行预处理
                .compose(new DefaultTransformer<List<HomeColumnMoreAllList>>());
    }
}
