package ar.com.clazz.token.rest;

import javax.validation.Valid;

import org.keycloak.adapters.rotation.AdapterTokenVerifier;
import org.keycloak.common.VerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ar.com.clazz.token.rest.dto.JWTRequest;
import ar.com.clazz.token.security.CustomKeycloakSpringBootConfigResolver;
import lombok.RequiredArgsConstructor;
/**
 * @author Cesar Vargas
 *
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/token")
public class JWTController {

	@Autowired
	private CustomKeycloakSpringBootConfigResolver resolver;
	
    @GetMapping("/{id}")
    public Boolean verifyToken(@PathVariable String id) {
    	try {
			AdapterTokenVerifier.verifyToken(id, resolver.getKeycloakDeployment());
			return true;
		} catch (VerificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
    
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public Boolean verifyToken(@Valid @RequestBody JWTRequest jwtRequest) {
    	try {
			AdapterTokenVerifier.verifyToken(jwtRequest.getToken(), resolver.getKeycloakDeployment());
			return true;
		} catch (VerificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
    }
}