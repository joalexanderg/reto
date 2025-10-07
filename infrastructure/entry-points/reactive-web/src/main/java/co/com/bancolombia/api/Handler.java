package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.RegisterAccountRequest;
import co.com.bancolombia.model.exceptions.BusinessException;
import co.com.bancolombia.model.exceptions.message.BusinessErrorMessage;
import co.com.bancolombia.usecase.registeraccountt.RegisterAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static co.com.bancolombia.model.exceptions.message.BusinessErrorMessage.INVALID_REQUEST;

@Component
@RequiredArgsConstructor
public class Handler {
//private  final UseCase useCase;
//private  final UseCase2 useCase2;
    private final RegisterAccountUseCase  registerAccounttUseCase;

    public Mono<ServerResponse> register(ServerRequest serverRequest) {
        // useCase.logic();
        return serverRequest.bodyToMono(RegisterAccountRequest.class)
                //.switchIfEmpty(Mono.error(new BusinessException(INVALID_REQUEST))) de esta forma simepre ejecuta
                .switchIfEmpty(Mono.error(()-> new BusinessException(INVALID_REQUEST)))
                .flatMap(accountDto -> registerAccounttUseCase.register(accountDto.getName(), accountDto.getStatusId()))
                .flatMap(account -> ServerResponse.ok().bodyValue(account));
        /*Aunque esta opción captura los errores lo ideal es centralizarlos en un clase y aca solo negocio*/
                //.onErrorResume(BusinessException.class, error -> ServerResponse.badRequest().bodyValue(error.getErrorMessage()));
    }

    public Mono<ServerResponse> listenGETOtherUseCase(ServerRequest serverRequest) {
        // useCase2.logic();
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> listenPOSTUseCase(ServerRequest serverRequest) {
        // useCase.logic();
        return ServerResponse.ok().bodyValue("");
    }
}
