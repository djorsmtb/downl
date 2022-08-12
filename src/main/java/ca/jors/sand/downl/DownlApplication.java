package ca.jors.sand.downl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DownlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DownlApplication.class, args);
	}

	// @Bean
	// public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
	// return http.authorizeExchange().pathMatchers("/actuator/**").permitAll().anyExchange()
	// .authenticated().and().build();
	// }
	// @Bean
	// public Docket api() {
	// 	return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
	// 			.paths(PathSelectors.any()).build();
	// }
}
