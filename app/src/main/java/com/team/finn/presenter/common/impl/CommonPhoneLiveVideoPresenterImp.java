package com.team.finn.presenter.common.impl;


import com.google.gson.Gson;
import com.team.finn.model.logic.common.bean.LiveVideoInfo;
import com.team.finn.presenter.common.interfaces.CommonPhoneLiveVideoContract;
import com.team.finn.utils.L;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public class CommonPhoneLiveVideoPresenterImp extends CommonPhoneLiveVideoContract.Presenter {
    @Override
    public void getPresenterPhoneLiveVideoInfo(String room_id) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        client.newCall(mModel.getModelPhoneLiveVideoInfo(mContext, room_id)).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                mView.showErrorWithStatus(e.getMessage());
            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                try {
                    JSONObject jsonObject = new JSONObject(response.body().string());
                    if (jsonObject.getString("error").equals("0")) {
                        Gson gson = new Gson();
                        LiveVideoInfo mLiveVideoInfo = gson.fromJson(response.body().string(), LiveVideoInfo.class);
                        mView.getViewPhoneLiveVideoInfo(mLiveVideoInfo);
                    } else {
                        mView.showErrorWithStatus("获取数据失败!");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
