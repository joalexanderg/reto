package co.com.bancolombia.model.exceptions;

import co.com.bancolombia.model.exceptions.message.TechnicalErrorMessage;
import lombok.Getter;

@Getter
public class TechbicalExeption extends RuntimeException{

    private final TechnicalErrorMessage errorMessage;

    public TechbicalExeption(Throwable cause, TechnicalErrorMessage errorMessage) {
        super(errorMessage.getMessage(), cause);
        this.errorMessage = errorMessage;
    }
}
