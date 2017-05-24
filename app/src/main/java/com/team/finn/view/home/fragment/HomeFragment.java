package com.team.finn.view.home.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.team.finn.R;
import com.team.finn.base.BaseFragment;
import com.team.finn.base.BaseView;
import com.team.finn.model.logic.home.HomeCateModelLogic;
import com.team.finn.presenter.home.impl.HomeCatePresenterImp;
import com.team.finn.presenter.home.interfaces.HomeCateContract;
import com.team.finn.ui.pagestatemanager.PageManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeFragment extends BaseFragment<HomeCateModelLogic, HomeCatePresenterImp> implements HomeCateContract
        .View {
    @BindView(R.id.btn_home)
    Button btnHome;
    SVProgressHUD svProgressHUD;
    @BindView(R.id.img_search)
    ImageView imgSearch;
    @BindView(R.id.img_scanner)
    ImageView imgScanner;
    @BindView(R.id.img_history)
    ImageView imgHistory;
    @BindView(R.id.img_message)
    ImageView imgMessage;
    Handler handler = new Handler();
    private PageManager pageStateManager;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView(Bundle bundle) {
        svProgressHUD = new SVProgressHUD(getActivity());

    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected BaseView getViewImp() {
        return this;
    }

    @OnClick(R.id.btn_home)
    public void home() {
//        正常数据
//     mPresenter.getHomeCate("3e760da75be261a588c74c4830632360");
//        错误数据
//        mPresenter.getHomeCate("3e760da75be261a588c74c483063236");


//        初始化pageStateManager
        pageStateManager = PageManager.init(this, true, () -> Toast.makeText(getActivity().getApplicationContext(),
                "点击重试了...", Toast
                .LENGTH_LONG).show());
        handler.postDelayed(() -> {
//            修改state值来查看不同状态
            int state = 2;
            switch (state) {
                case 0:
                    pageStateManager.showError();
                    break;
                case 1:
                    pageStateManager.showEmpty();
                    break;
                case 2:
                    pageStateManager.showContent();
            }

        }, 2000);
    }
    @OnClick(R.id.img_message)
    public void message() {

    }
    @OnClick(R.id.img_history)
    public void history() {

    }
    @OnClick(R.id.img_scanner)
    public void scanner() {

    }
    @OnClick(R.id.img_search)
    public void search() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
