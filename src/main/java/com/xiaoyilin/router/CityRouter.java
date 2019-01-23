package com.xiaoyilin.router;

import com.xiaoyilin.handle.CityHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 请求路由处理类
 */
@Configuration
public class CityRouter {

    @Bean
    public RouterFunction<ServerResponse> routerCity(CityHandle cityHandle) {
        return RouterFunctions.route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), cityHandle::helloCity);

    }


}
