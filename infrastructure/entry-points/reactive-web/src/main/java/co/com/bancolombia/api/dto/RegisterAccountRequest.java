package co.com.bancolombia.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAccountRequest {

    private  String name;
    private  String statusId;
}
