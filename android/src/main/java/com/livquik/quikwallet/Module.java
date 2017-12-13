package com.livquik.quikwallet;

import android.content.Context;
import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.livquik.qwnw.QWNetworkSDKInit;
import com.livquik.qwnw.QWSDKLibInit;
import com.livquik.qwnw.core.QWConstants;
import com.livquik.qwnw.model.QWParams;

import java.util.HashMap;
import java.util.Map;

public class Module extends ReactContextBaseJavaModule {

    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";

    public Module(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "qwsdk";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }

    @ReactMethod
    public void init(String mobile, String partnerId, String signature, String env) {
        QWParams qwParams = new QWParams();
        qwParams.setMobile(mobile);
        qwParams.setEnv(env);
        qwParams.setPartnerid(partnerId);
        qwParams.setSignature(signature);
        QWNetworkSDKInit.init(getReactApplicationContext(), qwParams, QWConstants.QUIK_PAY);
    }
}