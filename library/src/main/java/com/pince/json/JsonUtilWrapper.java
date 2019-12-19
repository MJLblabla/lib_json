package com.pince.json;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author athoucai
 * @date 2018/9/13
 */
class JsonUtilWrapper implements IJsonProcessor {

    private IJsonProcessor realJsonProcessor;

    JsonUtilWrapper() {
        setJsonProcessor(newProcessorInstance());
    }

    private IJsonProcessor newProcessorInstance() {
        try {
            Class cls = Class.forName("com.pince.jsonadapter.gson.GsonProcessor");
            return (IJsonProcessor) cls.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }

        try {
            Class cls = Class.forName("com.pince.jsonadapter.fastjson.FastjsonProcessor");
            return (IJsonProcessor) cls.newInstance();
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e) {
        } catch (InstantiationException e) {
        }
        throw new RuntimeException("not found jsonProcessor");
    }

    public void setJsonProcessor(@NonNull IJsonProcessor jsonProcessor) {
        realJsonProcessor = jsonProcessor;
    }

    @Override
    public <M> M fromJson(String jsonStr, Class<M> modelClazz) {
        if (!TextUtils.isEmpty(jsonStr)) {
            return realJsonProcessor.fromJson(jsonStr, modelClazz);
        } else {
            return null;
        }
    }

    @Override
    public <M> M fromJson(String jsonStr, Type type) {
        if (!TextUtils.isEmpty(jsonStr)) {
            return realJsonProcessor.fromJson(jsonStr, type);
        } else {
            return null;
        }
    }

    @Override
    public <M> String toJson(M model) {
        return realJsonProcessor.toJson(model);
    }

    @Override
    public <M> String toJson(Collection<M> models) {
        return realJsonProcessor.toJson(models);
    }
}