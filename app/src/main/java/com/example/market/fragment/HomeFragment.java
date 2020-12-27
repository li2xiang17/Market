package com.example.market.fragment;

import android.graphics.Color;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.market.R;
import com.example.market.adapter.BrandAdapter;
import com.example.market.adapter.CategoryAdapter;
import com.example.market.adapter.FirstAdapter;
import com.example.market.adapter.HotGoodsAdapter;
import com.example.market.adapter.NewGoodsAdapter;
import com.example.market.adapter.SecondAdapter;
import com.example.market.adapter.SpecialAdapter;
import com.example.market.adapter.SpecialimgAdapter;
import com.example.market.adapter.TextAdapter;
import com.example.market.adapter.TextsAdapter;
import com.example.market.adapter.TextssAdapter;
import com.example.market.adapter.ThirdAdapter;
import com.example.market.bean.HomeBean;
import com.example.market.contract.HomeContract;
import com.example.market.presenter.HomePresenterImp;
import com.example.mylibrary.base.BaseFragment;
import com.example.mylibrary.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterImp> implements HomeContract.iHomeView, BaseView {

    private RecyclerView mRecycler;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerBeans;
    private SecondAdapter secondAdapter;
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    private ThirdAdapter thirdAdapter;
    private FirstAdapter firstAdapter;
    private DelegateAdapter delegateAdapter;
    private TextAdapter textAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private BrandAdapter brandAdapter;
    private TextsAdapter textsAdapter;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private NewGoodsAdapter newGoodsAdapter;
    private TextssAdapter textssAdapter;
    private HotGoodsAdapter hotGoodsAdapter;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private SpecialAdapter specialAdapter;
    private SpecialimgAdapter specialimgAdapter;
    private ArrayList<HomeBean.DataBean.TopicListBean> toplist;
    private CategoryAdapter categoryAdapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initView(View view) {
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler);
        presenter.attachView(this);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getActivity());
        mRecycler.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycler.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0,10);
        firstlayout();
        secondlayout();
        thirdlayout();
        textlinerlayout();
        brandlayout();
        textslinerlayout();
        newGoodslayout();
        textssAdapter();
        hotGoodslayout();
        specialAdapter();
        specialimgAdapter();
        categoryAdapter();
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        delegateAdapter.addAdapter(firstAdapter);
        delegateAdapter.addAdapter(secondAdapter);
        delegateAdapter.addAdapter(thirdAdapter);
        delegateAdapter.addAdapter(textAdapter);
        delegateAdapter.addAdapter(brandAdapter);
        delegateAdapter.addAdapter(textsAdapter);
        delegateAdapter.addAdapter(newGoodsAdapter);
        delegateAdapter.addAdapter(textssAdapter);
        delegateAdapter.addAdapter(hotGoodsAdapter);
        delegateAdapter.addAdapter(specialAdapter);
        delegateAdapter.addAdapter(specialimgAdapter);
        delegateAdapter.addAdapter(categoryAdapter);
        mRecycler.setAdapter(delegateAdapter);
    }

    private void categoryAdapter() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(7);
        categoryListBeans = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getActivity(),categoryListBeans,linearLayoutHelper);
    }

    private void specialimgAdapter() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.DKGRAY);
        singleLayoutHelper.setMargin(0,100,0,100);
        //公共属性
        singleLayoutHelper.setItemCount(1);
        toplist = new ArrayList<>();
        specialimgAdapter = new SpecialimgAdapter(getActivity(),toplist,singleLayoutHelper);

    }

    private void specialAdapter() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        specialAdapter = new SpecialAdapter(getActivity(),linearLayoutHelper);
    }

    private void textssAdapter() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textssAdapter = new TextssAdapter(getActivity(),linearLayoutHelper);
    }

    private void hotGoodslayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(3);
        hotGoodsListBeans = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(getActivity(),hotGoodsListBeans,linearLayoutHelper);
    }

    private void newGoodslayout() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        newGoodsListBeans = new ArrayList<>();
        newGoodsAdapter = new NewGoodsAdapter(getActivity(),newGoodsListBeans,gridLayoutHelper);
    }

    private void textslinerlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textsAdapter = new TextsAdapter(getActivity(),linearLayoutHelper);
    }

    private void brandlayout() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setItemCount(4);
        brandListBeans = new ArrayList<>();
        brandAdapter = new BrandAdapter(getActivity(),brandListBeans,gridLayoutHelper);
    }


    private void textlinerlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);
        textAdapter = new TextAdapter(getActivity(),linearLayoutHelper);
    }

    private void thirdlayout() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // 创建对象

        // 公共属性
        columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        columnLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        columnLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        channelBeans = new ArrayList<>();
        thirdAdapter = new ThirdAdapter(getActivity(), columnLayoutHelper, channelBeans);
    }

    private void secondlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        bannerBeans = new ArrayList<>();
        secondAdapter = new SecondAdapter(getActivity(), linearLayoutHelper, bannerBeans);
    }

    private void firstlayout() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离
        firstAdapter = new FirstAdapter(getActivity(), linearLayoutHelper);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomePresenterImp getPresenter() {
        return new HomePresenterImp();
    }

    @Override
    public void onHomeSuccess(HomeBean.DataBean data) {
        List<HomeBean.DataBean.BannerBean> banner = data.getBanner();
        bannerBeans.addAll(banner);
        secondAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.ChannelBean> channel = data.getChannel();
        channelBeans.addAll(channel);
        thirdAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.BrandListBean> brandList = data.getBrandList();
        brandListBeans.addAll(brandList);
        brandAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = data.getNewGoodsList();
        newGoodsListBeans.addAll(newGoodsList);
        newGoodsAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList = data.getHotGoodsList();
        hotGoodsListBeans.addAll(hotGoodsList);
        hotGoodsAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.TopicListBean> topicList = data.getTopicList();
        toplist.addAll(topicList);
        specialimgAdapter.notifyDataSetChanged();

        List<HomeBean.DataBean.CategoryListBean> categoryList = data.getCategoryList();
        categoryListBeans.addAll(categoryList);
        categoryAdapter.notifyDataSetChanged();

        delegateAdapter.notifyDataSetChanged();

    }


    @Override
    public void onHomeFail(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}