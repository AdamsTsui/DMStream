package com.team.finn.view.home.fragment;

import android.os.Bundle;
import android.widget.Button;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.team.finn.R;
import com.team.finn.base.BaseFragment;
import com.team.finn.presenter.home.impl.HomePresenterImp;
import com.team.finn.presenter.home.interfaces.HomeContract;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版本号：1.0
 * 备注消息：
 **/
public class HomeFragment extends BaseFragment<HomePresenterImp> implements HomeContract.View{
    @BindView(R.id.btn_home)
    Button btnHome;
    SVProgressHUD svProgressHUD;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void onInitView(Bundle bundle) {
      svProgressHUD=new SVProgressHUD(getActivity());

    }
    @Override
    protected void onEvent() {

    }

    @Override
    protected Class getPresenterClazz() {
        return HomeContract.Presenter.class;
    }
    @Override
    protected Class getModelClazz() {
        return HomeContract.Model.class;
    }

    @OnClick(R.id.btn_home)
    public void home()
    {
          mPresenter.columnDetail();

    }
    @Override
    public void showSuccessWithStatus(String msg) {
        svProgressHUD.showSuccessWithStatus(msg);
    }

    @Override
    public void showErrorWithStatus(String msg) {

    }

    @Override
    public void showsInfoWithStatus(String msg) {

    }

    @Override
    public void showWithProgress(String msg) {

    }

    @Override
    public void dismiss() {

    }
}
