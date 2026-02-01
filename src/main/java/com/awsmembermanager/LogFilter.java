package com.awsmembermanager;

import static jakarta.servlet.RequestDispatcher.ERROR_METHOD;
import static jakarta.servlet.RequestDispatcher.ERROR_REQUEST_URI;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        filterChain.doFilter(request, response);

        String url = request.getRequestURL().toString();
        String method = request.getMethod();

        if (request.getDispatcherType() == DispatcherType.ERROR) {
            // try to get original request url
            Object attr = request.getAttribute(ERROR_REQUEST_URI);
            if (attr instanceof String) {
                url = (String) attr;
            }

            // try to get original method
            attr = request.getAttribute(ERROR_METHOD);
            if (attr instanceof String) {
                method = (String) attr;
            }
        }

        log.info("[REQUEST - RESPONSE]: {} {} - {}", method, url, response.getStatus());
    }

    @Override
    protected boolean shouldNotFilterErrorDispatch() {
        return false;
    }
}
