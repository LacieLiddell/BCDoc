package com.example.lacie.bcdoc;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONException;
import org.json.JSONObject;

public class NetworkManager {
    private static final NetworkManager INSTANCE = new NetworkManager();
    private static final OkHttpClient client = new OkHttpClient();
    private static final Executor executor = Executors.newSingleThreadExecutor();

    private NetworkManager(){
    }

    public static NetworkManager getINSTANCE() {
        return INSTANCE;
    }

    public void get(final String url, final OnRequestCompleteListener listener){
        final Request request = new Request.Builder().url(url).build();

        performRequest(request, listener);
    }

    public void performRequest(final Request request, final OnRequestCompleteListener listener){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                final String body = getBody(request);

                listener.onRequestComplete(body);
            }
        });
    }

    private String getBody(final Request request){
        try {
            final Response response = client.newCall(request).execute();
            try (ResponseBody body = response.body()){
                if (response.isSuccessful() && body != null){
                    return body.string();
                }
            }
        }catch (IOException e){
            Log.e("tag", "Fail to perform request", e);
        }
        return null;
    }

    public interface OnRequestCompleteListener {
        void onRequestComplete(final String body);
    }

}
