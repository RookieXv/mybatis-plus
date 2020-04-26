package com.example.mybatisplus.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(description="统一Restful返回对象")
public class CommonResult<T> {

    @ApiModelProperty(value="请求状态：0成功，1提示失败，2打印堆栈")
    private int code;

    @ApiModelProperty(value="错误信息")
    private String errorMsg;

    @ApiModelProperty(value="堆栈异常信息")
    private String stackException;

    @ApiModelProperty(value="请求返回数据")
    private T result;

    public static<T> CommonResult<T> buildError(String errorMsg){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(1);
        commonResult.setErrorMsg(errorMsg);
        return commonResult;
    }

    public static<T> CommonResult<T> buildException(String stackException){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(2);
        commonResult.setStackException(stackException);
        return commonResult;
    }

    public static<T> CommonResult buildSuccess(T result){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(0);
        commonResult.setResult(result);
        return commonResult;
    }

    public static<T> CommonResult buildSuccess(String msg,T result){
        CommonResult commonResult = new CommonResult();
        commonResult.setCode(0);
        commonResult.setErrorMsg(msg);
        commonResult.setResult(result);
        return commonResult;
    }
}
