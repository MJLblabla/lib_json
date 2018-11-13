package com.pince.jsonadapter.fastjson;

import com.alibaba.fastjson.JSON;
import com.pince.json.IJsonProcessor;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * @author athoucai
 * @date 2018/11/13
 */
public class FastjsonProcessor implements IJsonProcessor {

    public FastjsonProcessor() {
    }

    @Override
    public <M> M fromJson(String jsonStr, Class<M> modelClazz) {
        return JSON.parseObject(jsonStr, modelClazz);
    }

    @Override
    public <M> M fromJson(String jsonStr, Type type) {
        return JSON.parseObject(jsonStr, type);
    }

    @Override
    public <M> String toJson(M model) {
        return JSON.toJSONString(model);
    }

    @Override
    public <M> String toJson(Collection<M> models) {
        return JSON.toJSONString(models);
    }
}
