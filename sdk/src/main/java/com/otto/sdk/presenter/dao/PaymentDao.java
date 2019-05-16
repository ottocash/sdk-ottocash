package com.otto.sdk.presenter.dao;

import com.otto.sdk.model.api.Api;
import com.otto.sdk.model.api.request.PaymentValidateRequest;
import com.otto.sdk.model.api.request.ReviewCheckOutRequest;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
import retrofit2.Callback;

public class PaymentDao extends BaseDao {
    public PaymentDao(Object obj) {
        super(obj);
    }

    public void onReviewCheckOut(ReviewCheckOutRequest model, BaseActivity ac, Callback callback) {
        Api.onReviewCheckOut(model, ac, callback);
    }

    public void onPaymentValidate(PaymentValidateRequest model, BaseActivity ac, Callback callback) {
        Api.onPaymentValidate(model, ac, callback);
    }
}
