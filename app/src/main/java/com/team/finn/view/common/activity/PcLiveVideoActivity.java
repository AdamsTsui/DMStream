package com.team.finn.view.common.activity;

import android.net.Uri;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.team.finn.R;
import com.team.finn.base.BaseActivity;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.common.CommonLiveVideoModelLogic;
import com.team.finn.model.logic.common.bean.LiveVideoInfo;
import com.team.finn.model.logic.home.bean.HomeRecommendHotCate;
import com.team.finn.presenter.common.impl.CommonPhoneLiveVideoPresenterImp;
import com.team.finn.presenter.common.interfaces.CommonPhoneLiveVideoContract;

import butterknife.BindView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public class PcLiveVideoActivity extends BaseActivity<CommonLiveVideoModelLogic, CommonPhoneLiveVideoPresenterImp> implements CommonPhoneLiveVideoContract.View, MediaPlayer.OnInfoListener, MediaPlayer.OnBufferingUpdateListener {

    @BindView(R.id.vm_videoview)
    VideoView vmVideoview;
    private HomeRecommendHotCate.RoomListEntity mRoomEntity;
    private LiveVideoInfo videoInfo;
    private String Room_id;

    @Override
    protected int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        Vitamio.isInitialized(this);
        return R.layout.activity_pclive_video;
    }
    @Override
    protected void onInitView(Bundle bundle) {
        Room_id = getIntent().getExtras().getString("Room_id");
        vmVideoview.setKeepScreenOn(true);
        mPresenter.getPresenterPhoneLiveVideoInfo(Room_id);
    }

    @Override
    protected void onEvent() {
        vmVideoview.setOnInfoListener(this);
        vmVideoview.setOnBufferingUpdateListener(this);
    }

    @Override
    protected BaseView getView() {
        return this;
    }

    @Override
    public void getViewPhoneLiveVideoInfo(LiveVideoInfo mLiveVideoInfo) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                videoInfo = mLiveVideoInfo;
                getViewInfo(mLiveVideoInfo);
            }
        });
    }

    private void getViewInfo(LiveVideoInfo mLiveVideoInfo) {
        String url = mLiveVideoInfo.getData().getRtmp_url() + "/" + mLiveVideoInfo.getData().getRtmp_live();
        Uri uri = Uri.parse(url);
        vmVideoview.setVideoURI(uri);
        vmVideoview.setBufferSize(1024 * 1024 * 20);
        vmVideoview.setVideoQuality(MediaPlayer.VIDEOQUALITY_HIGH);
        vmVideoview.requestFocus();
        vmVideoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // optional need Vitamio 4.0
                mediaPlayer.setPlaybackSpeed(1.0f);
            }
        });
    }

    @Override
    public void showErrorWithStatus(String msg) {
        Toast.makeText(this, "请求失败!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBufferingUpdate(MediaPlayer mp, int percent) {

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (vmVideoview != null) {
            vmVideoview.start();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (vmVideoview != null) {
            vmVideoview.pause();
        }
    }

    @Override
    protected void onDestroy() {
        if (vmVideoview != null) {
            //        释放资源
            vmVideoview.stopPlayback();
        }
        super.onDestroy();
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
        switch (what) {
            case MediaPlayer.MEDIA_INFO_BUFFERING_START:
                if (vmVideoview.isPlaying()) {
                    vmVideoview.pause();
                }
                break;
            case MediaPlayer.MEDIA_INFO_BUFFERING_END:
                vmVideoview.start();
                break;
            case MediaPlayer.MEDIA_INFO_DOWNLOAD_RATE_CHANGED:

                break;
        }
        return true;
    }
}
