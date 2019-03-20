package com.example.zzx.zbar_demo.utils.okhttp;

import com.google.gson.internal.$Gson$Types;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;

/**
 * Created by pengchenghu on 2019/2/28.
 * Author Email: 15651851181@163.com
 * Describe: 回调类封装
 */
public abstract class BaseCallBack<T> {
    public Type mType;

    static Type getSuperclassTypeParameter(Class<?> subclass) {
        Type superclass = subclass.getGenericSuperclass();
        if (superclass instanceof Class) {
            return null;
        }
        ParameterizedType parameterized = (ParameterizedType) superclass;
        return $Gson$Types.canonicalize(parameterized.getActualTypeArguments()[0]);
    }

    public BaseCallBack() {
        mType = getSuperclassTypeParameter(this.getClass());
    }

    /**
     * 成功
     *
     * @param t
     */
    public abstract void onSuccess(T t);

    /**
     * 错误代码
     *
     * @param code
     */
    public abstract void onError(int code);

    /**
     * 失败
     *
     * @param call
     * @param e
     */
    public abstract void onFailure(Call call, IOException e);
}