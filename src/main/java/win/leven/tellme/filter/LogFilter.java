package win.leven.tellme.filter;

import org.slf4j.MDC;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by leven on 2017/4/13.
 */

@WebFilter(filterName = "logFilter", urlPatterns = "/*")
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Long traceId = LocalDateTime.now().toInstant(ZoneOffset.UTC).getEpochSecond();
        MDC.put("traceId", String.valueOf(traceId));
        MDC.put("ip",servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        MDC.clear();
    }
}
