package bilton.iatamy.api_rest_produto_pedido.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {


    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(
                new Info()
                        .title("Gerenciamento de treinos")
                        .description("API de Gerenciamento de treinos")
                        .version("1.0.0")
        );
    }
}