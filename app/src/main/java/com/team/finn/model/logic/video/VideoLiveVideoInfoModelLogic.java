package com.team.finn.model.logic.video;

import android.content.Context;

import com.team.finn.api.NetWorkApi;
import com.team.finn.presenter.video.interfaces.VideoPhoneVideoInfoContract;
import com.team.finn.utils.MD5Util;

import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * 作者：finn
 * 版本号：1.0
 * 备注消息：
 **/
public class VideoLiveVideoInfoModelLogic implements VideoPhoneVideoInfoContract.Model {

    @Override
    public Request getModelPhoneLiveVideoInfo(Context context, String room_id) {

        /**
         * 房间加密处理
         */
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("vid", room_id);
        RequestBody formBody = builder.build();
        int time = (int) (System.currentTimeMillis() / 1000);
        String str = "lapi/live/thirdPart/getPlay/" + room_id + "?aid=android1&rate=0&time=" + time + "9TUk5fjjUjg9qIMH3sdnh";
        String auth = MD5Util.getToMd5Low32(str);
//        L.e("地址为:"+NetWorkApi.baseUrl + NetWorkApi.getLiveVideo + room_id+"?"+tempParams.toString());
        Request requestPost = new Request.Builder()
                .url(NetWorkApi.baseVideoUrl + NetWorkApi.getVideoPlay + "?client_sys=android")
                .post(formBody)
                .addHeader("User-Device", "MTk1OWZjM2ItNTZkYy00NmMwLTgwM2MtNjRmYmU1YjU4YzA0fHYyLjUuMA==")
                .addHeader("User-Agent", "android/2.5.0 (android 6.0.1; ; OPPO+R9s)")
                .addHeader("aid", "android1")
                .addHeader("auth", auth)
                .addHeader("time", time + "")
                .build();
        return requestPost;
    }
}
