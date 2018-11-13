package com.pince.json;

import java.lang.reflect.Type;
import java.util.Collection;

/**
 * json解析接口
 *
 * @author athoucai
 * @date 2018/9/13
 */
public interface IJsonProcessor {
    /**
     * string -> javabean
     *
     * @param jsonStr
     * @param modelClazz
     * @param <M>
     * @return
     */
    <M> M fromJson(String jsonStr, Class<M> modelClazz);

    /**
     * string -> javabean
     *
     * @param jsonStr
     * @param type
     * @param <M>
     * @return
     */
    <M> M fromJson(String jsonStr, Type type);

    /**
     * javabean -> string<br>
     * 适用于解析普通javabean
     *
     * @param model
     * @param <M>
     * @return
     */
    <M> String toJson(M model);

    /**
     * javabean -> string<br>
     * 适用于解析列表结构
     *
     * @param models
     * @param <M>
     * @return
     */
    <M> String toJson(Collection<M> models);
}
