package com.otto.sdk.presenter.dao;

import com.otto.sdk.model.api.Api;
import com.otto.sdk.model.api.request.LoginRequest;
import com.otto.sdk.model.api.request.RegisterRequest;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import retrofit2.Callback;

public class AuthDao extends BaseDao {
    public AuthDao(Object obj) {
        super(obj);
    }

    public void onRegister(RegisterRequest model, BaseActivity ac, Callback callback) {
        Api.onRegister(model, ac, callback);
    }

    public void onLogin(LoginRequest model, BaseActivity ac, Callback callback) {
        Api.onLogin(model, ac, callback);
    }
}
