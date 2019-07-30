//package com.otto.sdk.ui.activities.payment;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.otto.sdk.IConfig;
//import com.otto.sdk.OttoCashSdk;
//import com.otto.sdk.R;
//import com.otto.sdk.model.api.request.PaymentValidateRequest;
//import com.otto.sdk.model.api.response.PaymentValidateResponse;
//import com.otto.sdk.model.dao.PaymentDao;
//import com.poovam.pinedittextfield.LinePinField;
//
//import app.beelabs.com.codebase.base.BaseActivity;
//import app.beelabs.com.codebase.base.BaseDao;
//import app.beelabs.com.codebase.base.response.BaseResponse;
//import app.beelabs.com.codebase.support.util.CacheUtil;
//import retrofit2.Response;
//
//public class PinActivity extends BaseActivity {
//
//    LinePinField lineField;
//    private PaymentValidateRequest model;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pin);
//
//        initComponent();
//        addTextWatcher(lineField);
//    }
//
//    private void initComponent() {
//        lineField = findViewById(R.id.lineField);
//    }
//
//    private void onCallApiSetPin(final String pin) {
//        final PaymentDao dao = new PaymentDao(this);
//
//        model = new PaymentValidateRequest(String.valueOf(CacheUtil.getPreferenceString(
//                IConfig.SESSION_PHONE, PinActivity.this)));
//        model.setPin(lineField.getText().toString());
//
//        showApiProgressDialog(OttoCashSdk.getAppComponent(), new PaymentDao(this) {
//            @Override
//            public void call() {
//                dao.onPaymentValidate(model, PinActivity.this, BaseDao.getInstance(PinActivity.this,
//                        IConfig.KEY_API_PAYMENT_VALIDATE).callback);
//            }
//        });
//    }
//
//    @Override
//    protected void onApiResponseCallback(BaseResponse br, int responseCode, Response response) {
//        super.onApiResponseCallback(br, responseCode, response);
//        if (response.isSuccessful()) {
//            if (responseCode == IConfig.KEY_API_PAYMENT_VALIDATE) {
//                PaymentValidateResponse data = (PaymentValidateResponse) br;
//                if (data.getMeta().getCode() == 200) {
//
//                    int emoney = CacheUtil.getPreferenceInteger(IConfig.SESSION_EMONEY_BALANCE, PinActivity.this);
//                    int total = CacheUtil.getPreferenceInteger(IConfig.SESSION_TOTAL, PinActivity.this);
//
//                    int emoneyBalance = emoney - total;
//                    CacheUtil.putPreferenceInteger(IConfig.SESSION_EMONEY_BALANCE, emoneyBalance, PinActivity.this);
//
//                    Intent intent = new Intent(PinActivity.this, CheckOutSuccessActivity.class);
//                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                    startActivity(intent);
//                    finish();
//                } else {
//                    Toast.makeText(this, data.getMeta().getCode() + ":" + data.getMeta().getMessage(),
//                            Toast.LENGTH_LONG).show();
//                }
//            }
//        }
//    }
//
//
//    public void addTextWatcher(EditText input) {
//        input.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                if (charSequence.toString().length() == 6) {
//                    onCallApiSetPin(charSequence.toString());
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//
//        });
//    }
//}