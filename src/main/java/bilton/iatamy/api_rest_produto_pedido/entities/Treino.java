package bilton.iatamy.api_rest_produto_pedido.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exercicios;
    private String numeroSeries;
    private String repeticoes;
    private String descanso;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExercicios() {
        return exercicios;
    }

    public void setExercicios(String exercicios) {
        this.exercicios = exercicios;
    }

    public String getNumeroSeries() {
        return numeroSeries;
    }

    public void setNumeroSeries(String numeroSeries) {
        this.numeroSeries = numeroSeries;
    }

    public String getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(String repeticoes) {
        this.repeticoes = repeticoes;
    }

    public String getDescanso() {
        return descanso;
    }

    public void setDescanso(String descanso) {
        this.descanso = descanso;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
