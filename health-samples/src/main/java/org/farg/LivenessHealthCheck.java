package org.farg;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import jakarta.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped  
public class LivenessHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        
        return HealthCheckResponse.named("Health check aplicação")
                .up()
                .withData("storage", "OK")
                .withData("serviço local", "OK")
                .build();


    }
}
