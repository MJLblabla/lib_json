package com.pince.jsonadapter.gson;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.pince.json.IJsonProcessor;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author athoucai
 * @date 2018/9/13
 */
public class GsonProcessor implements IJsonProcessor {
    private Gson mGson;

    public GsonProcessor() {
        mGson = new Gson();
    }

    public GsonProcessor(@NonNull Gson mGson) {
        this.mGson = mGson;
    }

    @Override
    public <M> M fromJson(String jsonStr, Class<M> modelClazz) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        M model = null;
        try {
            model = mGson.fromJson(jsonStr, modelClazz);
        } catch (JsonParseException e) {
            Log.w("GsonProcessor", e);
        }
        return model;
    }

    @Override
    public <M> M fromJson(String jsonStr, Type type) {
        if (TextUtils.isEmpty(jsonStr)) {
            return null;
        }
        M model = null;
        try {
            model = mGson.fromJson(jsonStr, type);
        } catch (JsonParseException e) {
            Log.w("GsonProcessor", e);
        }
        return model;
    }

    @Override
    public <M> String toJson(M model) {
        return mGson.toJson(model);
    }

    @Override
    public <M> String toJson(Collection<M> models) {
        return mGson.toJson(models);
    }
}
