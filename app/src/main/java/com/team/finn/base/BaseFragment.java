package com.team.finn.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.finn.model.ContractProxy;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *  版本号：1.0
 *  备注消息：
 **/
public abstract class BaseFragment<M extends  BaseModel,P extends BasePresenter> extends Fragment {
    protected Unbinder unbinder;
    protected View rootView;
    protected Context mContext = null;//context

    //    定义Presenter
    protected  P mPresenter;

    //    获取布局资源文件
    protected  abstract  int getLayoutId();

//    初始化数据

    protected  abstract void onInitView(Bundle bundle);

//    初始化事件Event

    protected  abstract  void onEvent();

    //   获取抽取View对象
    protected   abstract BaseView getViewImp();
    //    获得抽取接口Model对象
    protected   Class getModelClazz()  {
        return (Class<M>)ContractProxy.getModelClazz(getClass(), 0);
    }
    //    获得抽取接口Presenter对象
    protected    Class getPresenterClazz()  {
        return (Class<P>)ContractProxy.getPresnterClazz(getClass(), 1);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayoutId() != 0) {
            rootView = inflater.inflate(getLayoutId(), null);
        } else {
            rootView = super.onCreateView(inflater, container, savedInstanceState);
        }
        unbinder= ButterKnife.bind(this, rootView);
        bindMVP();
        onInitView(savedInstanceState);
        onEvent();
        return rootView;
    }
    /**
     *  获取presenter 实例
     */
    private  void bindMVP()
    {
        if(getPresenterClazz()!=null)
        {
            mPresenter=getPresenterImpl();
            mPresenter.mContext=getActivity();
            bindVM();
        }
    }
    private <T> T getPresenterImpl()
    {
        return ContractProxy.getInstance().presenter(getPresenterClazz());
    }
    @Override
    public void onStart() {
        if(mPresenter==null)
        {
            bindMVP();
        }
        super.onStart();
    }
    private  void bindVM()
    {
        if(mPresenter!=null&&!mPresenter.isViewBind()&&getModelClazz()!=null&&getViewImp()!=null)
        {
            ContractProxy.getInstance().bindModel(getModelClazz(),mPresenter);
            ContractProxy.getInstance().bindView(getViewImp(),mPresenter);
            mPresenter.mContext=getActivity();
        }
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(mPresenter==null)
        {
            bindMVP();
        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
        if(mPresenter!=null)
        {
            ContractProxy.getInstance().unbindView(getViewImp(),mPresenter);
            ContractProxy.getInstance().unbindModel(getModelClazz(),mPresenter);
        }
    }

}
