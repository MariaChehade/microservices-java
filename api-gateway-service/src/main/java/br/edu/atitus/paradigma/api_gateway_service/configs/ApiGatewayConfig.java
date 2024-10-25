package br.edu.atitus.paradigma.api_gateway_service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	RouteLocator getRotes(RouteLocatorBuilder builder) {
		return builder.routes()
			.route(rota -> rota
					.path("/get")
					.filters(f -> f
							.addRequestHeader("Usuario", "Fulano")
							.addRequestParameter("Parametro", "ValorParametro")
							.addRequestHeader("Servidor", "MeuServer"))
					.uri("http://httpbin.org"))
			
			
			.route(rota -> rota
					.path("/cambio-service/**")
					.filters(f -> f
							.addRequestHeader("Usuario", "Maria Chehade")
							.addRequestParameter("Parametro", "ValorParametro")
							.addRequestHeader("Servidor", "MeuServer"))
					.uri("lb://cambio-service"))
			
			
			.route(rota -> rota
					.path("/produto-service/**")
					.filters(f -> f
							.addRequestHeader("Usuario", "Maria Chehade")
							.addRequestParameter("Parametro", "ValorParametro")
							.addRequestHeader("Servidor", "MeuServer"))
					.uri("lb://produto-service"))
			
			
			.route(rota -> rota
					.path("/saudacao-service/**")
					.filters(f -> f
							.addRequestHeader("Usuario", "Maria Chehade")
							.addRequestParameter("Parametro", "ValorParametro")
							.addRequestHeader("Servidor", "MeuServer"))
					.uri("lb://saudacao-service"))
			.build();
		
		}
	

}