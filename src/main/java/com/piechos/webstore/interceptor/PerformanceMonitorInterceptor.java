package com.piechos.webstore.interceptor;

import org.apache.log4j.Logger;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PerformanceMonitorInterceptor implements HandlerInterceptor {

    ThreadLocal<StopWatch> stopWatchLocal = new ThreadLocal<StopWatch>();
    Logger logger = Logger.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        StopWatch stopWatch = new StopWatch(o.toString());
        stopWatch.start(o.toString());
        stopWatchLocal.set(stopWatch);
        logger.info("Przetwarzanie żądania do ścieżki: " + getURLPath(httpServletRequest));
        logger.info("Przetwarzanie żądanie rozpoczęto o: " + getCurrentTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        logger.info("Przetwarzanie żądania zakończono o: " + getCurrentTime());
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                                Exception e) throws Exception {
        StopWatch stopWatch = stopWatchLocal.get();
        stopWatch.stop();
        logger.info("Łączny czas przetwarzania żądania: " + stopWatch.getTotalTimeMillis() + " ms");
        stopWatchLocal.set(null);
        logger.info("===================================================");
    }

    private String getURLPath(HttpServletRequest request) {
        String currentPath = request.getRequestURI();
        String queryString = request.getQueryString();
        queryString = queryString == null ? "" : "?" + queryString;
        return currentPath + queryString;
    }

    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
