package win.leven.tellme.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import win.leven.tellme.entity.Result;
import win.leven.tellme.staticCode.Error;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Leven on 2017/5/22.
 */
@ControllerAdvice
public class ExceptionHandler {
    private Logger log = LoggerFactory.getLogger(ExceptionHandler.class);

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public Result handleError(HttpServletRequest req, Exception exception) {
        return Result.failed(Error.CODE_1);
    }
}
