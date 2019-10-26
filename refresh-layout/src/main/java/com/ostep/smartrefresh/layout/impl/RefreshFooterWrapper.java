package com.ostep.smartrefresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.ostep.smartrefresh.layout.internal.InternalAbstract;
import com.ostep.smartrefresh.layout.api.RefreshFooter;

/**
 * 刷新底部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter/*, InvocationHandler */{

    public RefreshFooterWrapper(View wrapper) {
        super(wrapper);
    }

//    @Override
//    public boolean setNoMoreData(boolean noMoreData) {
//        return mWrappedInternal instanceof RefreshFooter && ((RefreshFooter) mWrappedInternal).setNoMoreData(noMoreData);
//    }

}
