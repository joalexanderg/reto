package co.com.bancolombia.api.exceptions;
//Permite centralizar el manejo de errores
import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.TechnicalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Order (-2) // Prioridad
@Slf4j
@Component //Para que lo pueda inyectar
public class ExceptionHandler extends AbstractErrorWebExceptionHandler {
    public ExceptionHandler(ErrorAttributes errorAttributes, WebProperties resources, ApplicationContext applicationContext, ServerCodecConfigurer serverCodecConfigurer) {
        super(errorAttributes, resources.getResources(), applicationContext);
        this.setMessageWriters(serverCodecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
    }

    private Mono<ServerResponse> renderErrorResponse(ServerRequest request){
      return   Mono.error(getError(request))
                .onErrorResume(BusinessException.class, error ->{
                    log.warn("BussinessException", error);
                    return ServerResponse.badRequest().bodyValue(Map.of("code", error.getErrorMessage().getCode()));
                })
                .onErrorResume(TechnicalException.class, error ->{
                    log.error("TechnicalException", error);
                    return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).bodyValue(Map.of("code", error.getErrorMessage().getCode()));
                })
                .onErrorResume(error -> {
                    log.error("Internal server error", error);
                    return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
                })
              .cast(ServerResponse.class);
    }
}
