package com.team.finn.view.home.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.team.finn.model.logic.home.bean.HomeCateList;
import com.team.finn.view.home.fragment.OtherFragment;
import com.team.finn.view.home.fragment.recommend.RecommendFragment;

import java.util.List;

/**
 *  版本号：1.0
 *  备注消息：
 **/
public class HomeAllListAdapter extends FragmentStatePagerAdapter {

    private  List<HomeCateList> mHomeCateLists;
    private  String[] mTiltle;
    private FragmentManager mFragmentManager;

    public HomeAllListAdapter(FragmentManager fm, List<HomeCateList> homeCateLists,String[] title)
    {
        super(fm);
        this.mFragmentManager=fm;
        this.mHomeCateLists=homeCateLists;
        this.mTiltle=title;
    }
    @Override
    public int getCount() {
        return mTiltle.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTiltle[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            return RecommendFragment.getInstance();
        }
        OtherFragment otherHomeFragment= OtherFragment.getInstance(mHomeCateLists.get(position-1));
        return otherHomeFragment;
    }
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(((Fragment) object).getView()); // 移出viewpager两边之外的page布局
//    }
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Fragment fragment = getItem(position);
//        if (!fragment.isAdded()) { // 如果fragment还没有added
//            FragmentTransaction ft = mFragmentManager.beginTransaction();
//            ft.add(fragment, fragment.getClass().getSimpleName());
//            ft.commit();
//            mFragmentManager.executePendingTransactions();//同步的方式添加Fragment
//        }
//        if (fragment.getView().getParent() == null) {
//            container.addView(fragment.getView()); // 为viewpager增加布局
//        }
//        return fragment;
//    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
////        if (position <= getCount()) {
////            FragmentManager manager = ((Fragment) object).getFragmentManager();
////            FragmentTransaction trans = manager.beginTransaction();
////            trans.remove((Fragment) object);
////            trans.commit();
////        }
//    }

}
