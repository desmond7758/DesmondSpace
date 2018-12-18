package com.dsm.springbootdemo.servlet;

import ch.qos.logback.core.util.TimeUtil;
import org.springframework.stereotype.Component;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/api/dsm", asyncSupported = true)
public class TestServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 异步
        AsyncContext asyncContext = req.startAsync();
        // 开启异步 runnable
        asyncContext.start(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("异步开始啦");
        });
        // 这行不加 页面会一直转圈 不返回
        asyncContext.complete();

        resp.getWriter().write("Hello Word");
    }
}
