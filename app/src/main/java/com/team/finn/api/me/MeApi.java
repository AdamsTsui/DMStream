package com.team.finn.api.me;

import com.team.finn.model.logic.me.bean.PersonInfoBean;
import com.team.finn.model.logic.video.bean.VideoHotColumn;
import com.team.finn.net.response.HttpResponse;

import java.util.List;
import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

import static com.team.finn.api.NetWorkApi.getPersonInfo;
import static com.team.finn.api.NetWorkApi.getVideoHotColumn;

/**
 * Created by Administrator on 2017/3/17 0017.
 */

public interface MeApi {
    /**
     * 推荐---最热
     *
     * @return
     */
    @GET(getPersonInfo)
    Observable<HttpResponse<PersonInfoBean>> getPersonInfos(@QueryMap Map<String, String> params) ;
}
