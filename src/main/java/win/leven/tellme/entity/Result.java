package win.leven.tellme.entity;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.alibaba.fastjson.JSON;
import win.leven.tellme.staticCode.Error;

import java.util.Date;
import java.util.Map;

public class Result {
    public static final int STATUS_SECCESS = 1;

    public static final int STATUS_FAILED = 0;

    private int status;

    private int errorCode;

    private String msg;

    private Map<String, Object> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Result(int status, int errorCode, String msg, Map<String, Object> data) {
        this.status = status;
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    public static Result success(Map<String, Object> data) {
        return new Result(STATUS_SECCESS, 0, null, data);
    }

    public static Result failed(Error error, Map<String, Object> data) {
        return new Result(STATUS_FAILED, error.getErrorCode(), error.getMsg(), data);
    }

    public static Result failed(Error error) {
        return new Result(STATUS_FAILED, error.getErrorCode(), error.getMsg(), null);
    }

    public static Result failed(Error error, String msg) {
        return new Result(STATUS_FAILED, error.getErrorCode(), msg, null);
    }
}
