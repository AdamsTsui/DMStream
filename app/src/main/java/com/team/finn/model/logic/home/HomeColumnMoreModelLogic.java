package com.team.finn.model.logic.home;

import android.content.Context;

import com.team.finn.api.home.HomeApi;
import com.team.finn.model.ParamsMapUtils;
import com.team.finn.model.logic.home.bean.HomeColumnMoreTwoCate;
import com.team.finn.model.logic.home.bean.HomeRecommendHotCate;
import com.team.finn.net.http.HttpUtils;
import com.team.finn.net.transformer.DefaultTransformer;
import com.team.finn.presenter.home.interfaces.HomeColumnMoreListContract;

import java.util.List;

import rx.Observable;

/**
 *  版本号：1.0
 *  备注消息：
 **/
public class HomeColumnMoreModelLogic implements HomeColumnMoreListContract.Model {

    /**
     *  栏目 更多 二级分类列表
     * @param context
     * @param cate_id
     * @return
     */
    @Override
    public Observable<List<HomeColumnMoreTwoCate>> getModelHomeColumnMoreTwoCate(Context context, String cate_id) {
        return HttpUtils.getInstance(context)
                .setLoadDiskCache(true)
                .getRetofitClinet()
                .builder(HomeApi.class)
                .getHomeColumnMoreCate(ParamsMapUtils.getColumnMoreCate(cate_id))
//               进行预处理
                .compose(new DefaultTransformer<List<HomeColumnMoreTwoCate>>());
    }
}
