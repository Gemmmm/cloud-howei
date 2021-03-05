package com.howei.filter;

import com.howei.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.ArrayList;

/**
 * @author DELL
 * @date 2020-12-28 15:58
 */
@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("come in myLogGateWayFiltere:::" + exchange);

        String token = exchange.getRequest().getQueryParams().getFirst("token");
        System.out.println(token);
        URI uri = exchange.getRequest().getURI();
        System.out.println("uri:"+uri);
        String path = uri.getPath();
        if(path.startsWith("/auth")||path.startsWith("/hw/v2/api-docs")){
            return chain.filter(exchange);
        }
        if (token == null) {
            log.info("token为空");
            exchange.getResponse().getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }


        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
