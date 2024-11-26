package bilton.iatamy.api_rest_produto_pedido.service;

import bilton.iatamy.api_rest_produto_pedido.entities.DTO.AlterarStatusTreinoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.DTO.AlterarTreinoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.Treino;
import bilton.iatamy.api_rest_produto_pedido.repository.TreinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    private TreinoRepository treinoRepository;
    public TreinoService(TreinoRepository treinoRepository) {
        this.treinoRepository = treinoRepository;
    }

    public Treino adicionarTreino(Treino treino) {
        Treino t = new Treino();
        t.setExercicios(treino.getExercicios());
        t.setNumeroSeries(treino.getNumeroSeries());
        t.setRepeticoes(treino.getRepeticoes());
        t.setDescanso(treino.getDescanso());
        t.setStatus(treino.getStatus());
        return treinoRepository.save(t);
    }

    public AlterarTreinoDTO alterarTreino(Long codigo, AlterarTreinoDTO alterarTreinoDTO) throws Exception {
        Optional<Treino> t = treinoRepository.findById(codigo);

        if(Optional.ofNullable(t).isPresent()) {
            t.get().setExercicios(alterarTreinoDTO.getExercicios());
            t.get().setNumeroSeries(alterarTreinoDTO.getNumeroSeries());
            t.get().setRepeticoes(alterarTreinoDTO.getRepeticoes());
            t.get().setDescanso(alterarTreinoDTO.getDescanso());
            t.get().setStatus(alterarTreinoDTO.getStatus());


            treinoRepository.save(t.get());

            return alterarTreinoDTO;
        }

        throw new Exception("Treino não existe!");
    }


    public AlterarStatusTreinoDTO atualizarStatusTreino(Long id, AlterarStatusTreinoDTO alterarStatusTreinoDTO) throws Exception {
        Optional<Treino> t = treinoRepository.findById(id);
        if(Optional.ofNullable(t).isPresent()) {
            t.get().setStatus(alterarStatusTreinoDTO.getStatus());

            treinoRepository.save(t.get());
            return alterarStatusTreinoDTO;
        }
        throw new Exception("Treino não existe!");

    }

    public void removerTreinoPorId(Long id){
        treinoRepository.deleteById(id);
    }



    public Optional<Treino> buscarTreinoPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<Treino> buscarTreino() {
        List<Treino> t = treinoRepository.findAll();
        return t;
    }



    public Optional<Treino> buscarTreinoPorStatus(String status) {
           Optional<Treino> t = treinoRepository.findByStatus(status);
           return t;
    }

}


