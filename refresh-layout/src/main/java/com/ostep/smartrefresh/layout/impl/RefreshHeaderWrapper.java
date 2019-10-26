package com.ostep.smartrefresh.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.ostep.smartrefresh.layout.internal.InternalAbstract;
import com.ostep.smartrefresh.layout.api.RefreshHeader;

/**
 * 刷新头部包装
 * Created by scwang on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends InternalAbstract implements RefreshHeader/*, InvocationHandler*/ {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}
