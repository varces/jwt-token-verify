package ar.com.clazz.token.security;

import org.keycloak.adapters.KeycloakConfigResolver;
import org.keycloak.adapters.KeycloakDeployment;
import org.keycloak.adapters.KeycloakDeploymentBuilder;
import org.keycloak.adapters.OIDCHttpFacade;
import org.keycloak.representations.adapters.config.AdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomKeycloakSpringBootConfigResolver implements KeycloakConfigResolver {

	private KeycloakDeployment keycloakDeployment;
	
    private AdapterConfig adapterConfig;
	
	public  KeycloakDeployment getKeycloakDeployment() {
		return this.keycloakDeployment;
	}


    @Override
    public KeycloakDeployment resolve(OIDCHttpFacade.Request request) {
        if (keycloakDeployment != null) {
            return keycloakDeployment;
        }

        keycloakDeployment = KeycloakDeploymentBuilder.build(adapterConfig);

        return keycloakDeployment;
    }

    @Autowired
    void setAdapterConfig(AdapterConfig adapterConfig) {
        this.adapterConfig = adapterConfig;
    }
}
