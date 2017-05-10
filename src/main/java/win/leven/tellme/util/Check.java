package win.leven.tellme.util;

import win.leven.tellme.exception.InvalidParamException;

/**
 * Created by leven on 2017/4/14.
 */
public class Check {

    public static void orThrow(boolean b, String msg) {
        if (!b)
            throw new InvalidParamException(msg);
    }
}
