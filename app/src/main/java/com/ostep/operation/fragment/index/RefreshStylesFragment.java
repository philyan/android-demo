package com.ostep.operation.fragment.index;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.ostep.operation.R;
import com.ostep.operation.activity.style.BezierCircleStyleActivity;
import com.ostep.operation.activity.style.BezierRadarStyleActivity;
import com.ostep.operation.activity.style.ClassicsStyleActivity;
import com.ostep.operation.activity.style.DeliveryStyleActivity;
import com.ostep.operation.activity.style.DropBoxStyleActivity;
import com.ostep.operation.activity.style.FlyRefreshStyleActivity;
import com.ostep.operation.activity.style.FunGameBattleCityStyleActivity;
import com.ostep.operation.activity.style.FunGameHitBlockStyleActivity;
import com.ostep.operation.activity.style.MaterialStyleActivity;
import com.ostep.operation.activity.style.PhoenixStyleActivity;
import com.ostep.operation.activity.style.StoreHouseStyleActivity;
import com.ostep.operation.activity.style.TaurusStyleActivity;
import com.ostep.operation.activity.style.WaterDropStyleActivity;
import com.ostep.operation.activity.style.WaveSwipeStyleActivity;
import com.ostep.operation.adapter.BaseRecyclerAdapter;
import com.ostep.operation.adapter.SmartViewHolder;
import com.ostep.operation.util.StatusBarUtil;
import com.scwang.smartrefresh.header.BezierCircleHeader;
import com.scwang.smartrefresh.header.DeliveryHeader;
import com.scwang.smartrefresh.header.DropBoxHeader;
import com.scwang.smartrefresh.header.FunGameHitBlockHeader;
import com.scwang.smartrefresh.header.PhoenixHeader;
import com.scwang.smartrefresh.header.TaurusHeader;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;

import java.util.Arrays;

import static android.R.layout.simple_list_item_2;
import static android.support.v7.widget.DividerItemDecoration.VERTICAL;
import static com.ostep.operation.R.id.recyclerView;

/**
 * 风格展示
 * A simple {@link Fragment} subclass.
 */
public class RefreshStylesFragment extends Fragment implements AdapterView.OnItemClickListener {

    private enum Item {
        Hidden(R.string.title_activity_style_delivery,DeliveryStyleActivity.class),
        Delivery(R.string.title_activity_style_delivery,DeliveryStyleActivity.class),
        DropBox(R.string.title_activity_style_drop_box, DropBoxStyleActivity.class),
        WaveSwipe(R.string.title_activity_style_wave_swipe, WaveSwipeStyleActivity.class),
        FlyRefresh(R.string.title_activity_style_fly_refresh, FlyRefreshStyleActivity.class),
        WaterDrop(R.string.title_activity_style_water_drop, WaterDropStyleActivity.class),
        Material(R.string.title_activity_style_material, MaterialStyleActivity.class),
        Phoenix(R.string.title_activity_style_phoenix, PhoenixStyleActivity.class),
        Taurus(R.string.title_activity_style_taurus, TaurusStyleActivity.class),
        Bezier(R.string.title_activity_style_bezier, BezierRadarStyleActivity.class),
        Circle(R.string.title_activity_style_circle, BezierCircleStyleActivity.class),
        FunGameHitBlock(R.string.title_activity_style_hit_block, FunGameHitBlockStyleActivity.class),
        FunGameBattleCity(R.string.title_activity_style_battle_city, FunGameBattleCityStyleActivity.class),
        StoreHouse(R.string.title_activity_style_storehouse, StoreHouseStyleActivity.class),
        Classics(R.string.title_activity_style_classics, ClassicsStyleActivity.class),
        ;
        public int nameId;
        public Class<?> clazz;
        Item(@StringRes int nameId, Class<?> clazz) {
            this.nameId = nameId;
            this.clazz = clazz;
        }

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_refresh_styles, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);
        StatusBarUtil.setPaddingSmart(getContext(), root.findViewById(R.id.toolbar));

        View view = root.findViewById(recyclerView);
        if (view instanceof RecyclerView) {
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), VERTICAL));
            recyclerView.setAdapter(new BaseRecyclerAdapter<Item>(Arrays.asList(Item.values()), simple_list_item_2,this) {
                @NonNull
                @Override
                public SmartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                    SmartViewHolder holder = super.onCreateViewHolder(parent, viewType);
                    if (viewType == 0) {
                        holder.itemView.setVisibility(View.GONE);
                        holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0,0));
                    }
                    return holder;
                }

                @Override
                public int getViewTypeCount() {
                    return 2;
                }

                @Override
                public int getItemViewType(int position) {
                    return position == 0 ? 0 : 1;
                }

                @Override
                protected void onBindViewHolder(SmartViewHolder holder, Item model, int position) {
                    holder.text(android.R.id.text1, model.name());
                    holder.text(android.R.id.text2, model.nameId);
                    holder.textColorId(android.R.id.text2, R.color.colorTextAssistant);
                }
            });
        }


        RefreshLayout refreshLayout = root.findViewById(R.id.refreshLayout);
        if (refreshLayout != null) {
            refreshLayout.setOnMultiPurposeListener(new SimpleMultiPurposeListener() {
                @Override
                public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                    refreshLayout.finishRefresh(3000);
                }
                @Override
                public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                    refreshLayout.finishLoadMore(2000);
                }
                @Override
                public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
                    if (newState == RefreshState.None) {
                        if (oldState == RefreshState.LoadFinish) {
                            RefreshFooter refreshFooter = refreshLayout.getRefreshFooter();
                            if (refreshFooter instanceof RefreshFooterWrapper) {
                                View footerView = refreshFooter.getView();
                                if (footerView instanceof TaurusHeader) {
                                    refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DropBoxHeader(getContext())));
                                } else if (footerView instanceof DropBoxHeader) {
                                    refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new DeliveryHeader(getContext())));
                                } else if (footerView instanceof DeliveryHeader) {
                                    refreshLayout.setRefreshFooter(new RefreshFooterWrapper(new BezierCircleHeader(getContext())));
                                } else {
                                    refreshLayout.setRefreshFooter(new BallPulseFooter(getContext()));
                                }
                            }
                        } else if (oldState == RefreshState.RefreshFinish) {
                            RefreshHeader refreshHeader = refreshLayout.getRefreshHeader();
                            if (refreshHeader instanceof RefreshHeaderWrapper) {
                                refreshLayout.setRefreshHeader(new PhoenixHeader(getContext()));
                            } else if (refreshHeader instanceof PhoenixHeader) {
                                refreshLayout.setRefreshHeader(new DropBoxHeader(getContext()));
                            } else if (refreshHeader instanceof DropBoxHeader) {
                                refreshLayout.setRefreshHeader(new FunGameHitBlockHeader(getContext()));
                            } else if (refreshHeader instanceof FunGameHitBlockHeader) {
                                refreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
                            } else {
                                refreshLayout.setRefreshHeader(new RefreshHeaderWrapper(new BallPulseFooter(getContext())));
                            }
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getContext(), Item.values()[position].clazz));
    }
}
