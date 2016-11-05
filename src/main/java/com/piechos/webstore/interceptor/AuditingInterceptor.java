package com.piechos.webstore.interceptor;


import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class AuditingInterceptor extends HandlerInterceptorAdapter {

    Logger logger = Logger.getLogger("auditLogger");
    private String user;
    private String productId;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (request.getRequestURI().endsWith("products/add") && request.getMethod().equals("POST")) {
            user = request.getRemoteUser();
            productId = request.getParameterValues("productId")[0];
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex)
            throws Exception {
        if(request.getRequestURI().endsWith("products/add") && response.getStatus() == 302) {
            logger.info(String.format("Nowy product [%s] dodany przez [%s] dnia [%s]", productId, user, getCurrentTime()));
        }
    }
    private String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyy 'o' hh:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }
}
