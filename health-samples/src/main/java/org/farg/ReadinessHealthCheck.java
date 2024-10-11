package org.farg;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class ReadinessHealthCheck implements HealthCheck {

    static int countDb = 0;
    @Override
    public HealthCheckResponse call() {
        
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Conexão com base de dados health check");

        try{
            countDb++;
            if(countDb % 2 == 0){
                responseBuilder.up();
            } else {
                throw new Exception("Conexão perdida");
            }
            
        }catch(Exception e){
            responseBuilder.down().withData("erro",e.getMessage());
        }

        return responseBuilder.build();

    }
}
