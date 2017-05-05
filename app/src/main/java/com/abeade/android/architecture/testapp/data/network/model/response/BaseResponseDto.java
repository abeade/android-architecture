package com.abeade.android.architecture.testapp.data.network.model.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponseDto<T> {
    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
