package bilton.iatamy.api_rest_produto_pedido.repository;

import bilton.iatamy.api_rest_produto_pedido.entities.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TreinoRepository extends JpaRepository<Treino, Long> {

    Optional<Treino> findByStatus(String status);
}
