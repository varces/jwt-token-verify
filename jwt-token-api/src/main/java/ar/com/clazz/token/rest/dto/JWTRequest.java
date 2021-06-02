package ar.com.clazz.token.rest.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
/**
 * @author Cesar Vargas
 *
 */
@Data
public class JWTRequest {

    @ApiModelProperty
    @NotBlank
    private String token;

}
