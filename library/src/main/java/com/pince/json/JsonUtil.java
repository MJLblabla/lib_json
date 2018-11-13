package com.pince.json;

import android.text.TextUtils;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by athoucai on 2017/5/12.
 */
public class JsonUtil {

    private static JsonUtilWrapper jsonUtilWrapper = new JsonUtilWrapper();

    private JsonUtil() {
    }

    public static void setJsonProcessor(IJsonProcessor jsonProcessor) {
        jsonUtilWrapper.setJsonProcessor(jsonProcessor);
    }

    public static <M> M fromJson(String jsonStr, Class<M> modelClazz) {
        if (!TextUtils.isEmpty(jsonStr)) {
            return jsonUtilWrapper.fromJson(jsonStr, modelClazz);
        } else {
            return null;
        }
    }

    public static <M> M fromJson(String jsonStr, Type type) {
        if (!TextUtils.isEmpty(jsonStr)) {
            return jsonUtilWrapper.fromJson(jsonStr, type);
        } else {
            return null;
        }
    }

    public static <M> String toJson(M model) {
        return jsonUtilWrapper.toJson(model);
    }

    public static <M> String toJson(List<M> models) {
        return jsonUtilWrapper.toJson(models);
    }
}