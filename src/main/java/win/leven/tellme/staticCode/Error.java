package win.leven.tellme.staticCode;

/**
 * 错误码
 * Created by Leven on 2017/5/22.
 */
public enum Error {
    CODE_1(1, "网络错误,请稍后再试"),
    CODE_2(2, "参数错误"),
    ;

    private Error(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    private int errorCode;

    private String msg;

    public int getErrorCode() {
        return errorCode;
    }

    public String getMsg() {
        return msg;
    }

}
