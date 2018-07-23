package com.dennis.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.dennis.latte_core.delegates.LatteDelegate;
import com.dennis.latte_core.net.RestClient;
import com.dennis.latte_core.net.callback.IError;
import com.dennis.latte_core.net.callback.IFailure;
import com.dennis.latte_core.net.callback.ISuccess;

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://www.qq.com")
                .loader(getContext())
//                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
//                        Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String Msg) {

                    }
                })
                .build()
                .get();
    }
}
