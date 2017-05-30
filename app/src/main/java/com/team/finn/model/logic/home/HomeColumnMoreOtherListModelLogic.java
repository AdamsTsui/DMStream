package com.team.finn.model.logic.home;

import android.content.Context;

import com.team.finn.api.home.HomeApi;
import com.team.finn.model.ParamsMapUtils;
import com.team.finn.model.logic.home.bean.HomeColumnMoreAllList;
import com.team.finn.model.logic.home.bean.HomeColumnMoreOtherList;
import com.team.finn.net.http.HttpUtils;
import com.team.finn.net.transformer.DefaultTransformer;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreOtherListContract;

import java.util.List;

import rx.Observable;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeColumnMoreOtherListModelLogic implements HomeColumnMoreOtherListContract.Model {

    /**
     * 全部直播列表
     *
     * @param context
     * @param cate_id
     * @return
     */
    @Override
    public Observable<List<HomeColumnMoreOtherList>> getModelHomeColumnMoreOtherList(Context context, String cate_id, int offset, int limit) {
        return HttpUtils.getInstance(context)
                .setLoadDiskCache(true)
                .getRetofitClinet()
                .builder(HomeApi.class)
                .getHomeColumnMoreOtherList(ParamsMapUtils.getHomeColumnMoreOtherList(cate_id, offset, limit))
//               进行预处理
                .compose(new DefaultTransformer<List<HomeColumnMoreOtherList>>());
    }
}
