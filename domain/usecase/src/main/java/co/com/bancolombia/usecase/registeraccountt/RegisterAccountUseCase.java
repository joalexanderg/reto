package co.com.bancolombia.usecase.registeraccountt;

import co.com.bancolombia.model.account.Account;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RequiredArgsConstructor
public class RegisterAccountUseCase {

   /* public Mono<Account> register(String name, String statusId){

        return legalValidation(name)
                .flatMap(legal -> disponibilityValidation())
                .flatMap(disponibility ->getStatus(name))
                .map(status -> Account.newAccount(0, name, status))// Cuando no es asincrono se usa map
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);
    }*/
    //Usando paralelizacion
  /*  public Mono<Account> register(String name, String statusId){

        return  Mono.zip(legalValidation(name), disponibilityValidation())
                .flatMap(disponibility ->getStatus(name))
                .map(status -> Account.newAccount(0, name, status))// Cuando no es asincrono se usa map
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);
    }*/
//Primero obtener el status y luego si validacion y disponibilidad  usaar propiedad asociativa
    public Mono<Account> register(String name, String statusId){
        return getStatus(name)
                .flatMap(
                       status -> Mono.zip(legalValidation(name), disponibilityValidation())
                               .map(legal -> Account.newAccount(0, name, status))
                )
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);
      /*  return  Mono.zip(legalValidation(name), disponibilityValidation())
                .flatMap(disponibility ->getStatus(name))
                .map(status -> Account.newAccount(0, name, status))// Cuando no es asincrono se usa map
                .flatMap(this::finalValidation)
                .flatMap(this::saveAccount);*/
    }
// No envolver llamados sincronos. Si no hay asicronismo no modelarlo
    private Mono<Account> generateAccount(String name, String status){
        return Mono.just(Account.newAccount(0, name, status));
    }

    private Mono<String> legalValidation(String accountName){
        return Mono.just(accountName).delayElement(Duration.ofSeconds(2));
    }
    private Mono<Integer> disponibilityValidation(){
        return Mono.just(9).delayElement(Duration.ofSeconds(2));
    }
    private Mono<String> getStatus(String accountName){
        return Mono.just("OK");
    }
    private Mono<Account> finalValidation(Account account){
        return Mono.just(account);
    }
    private Mono<Account> saveAccount(Account account){
        return Mono.just(account);
    }
}
