package bilton.iatamy.api_rest_produto_pedido.controller;

import bilton.iatamy.api_rest_produto_pedido.entities.DTO.AlterarStatusTreinoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.DTO.AlterarTreinoDTO;
import bilton.iatamy.api_rest_produto_pedido.entities.Treino;
import bilton.iatamy.api_rest_produto_pedido.service.TreinoService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treino")
public class TreinoController {

    private TreinoService treinoService;

    public TreinoController(TreinoService treinoService) {
        this.treinoService = treinoService;
    }

    @PostMapping("/adicionar")
    public ResponseEntity<?> adicionarTreino(@RequestBody Treino treino) {
        try {
            Treino t = treinoService.adicionarTreino(treino);
            return ResponseEntity.ok().body(t);
        } catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }


    }

    @GetMapping("/buscar/{codigo}")
    public ResponseEntity<?> buscarTreinoPorCodigo(@PathVariable Long codigo) {
        try {
            Optional<Treino> t = treinoService.buscarTreinoPorId(codigo);
            return ResponseEntity.ok().body(t);

        } catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }

    }


    @GetMapping("/buscar")
    public ResponseEntity<?> buscarTreino() {
        try {
            List<Treino> t = treinoService.buscarTreino();
            return ResponseEntity.ok().body(t);
        } catch (Exception ex) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
    }

    @PutMapping("/alterar/{codigo}")
    public ResponseEntity<?> atualizarTreino(@PathVariable Long codigo, @RequestBody AlterarTreinoDTO treinoDTO) {
        try {

            AlterarTreinoDTO treinoAtualizado = treinoService.alterarTreino(codigo, treinoDTO);


            return ResponseEntity.ok(treinoAtualizado);
        } catch (Exception ex) {

            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }


    }

    @PatchMapping("/alterarstatus/{codigo}")
    public ResponseEntity<?> alterarStatus(@PathVariable Long codigo, @RequestBody AlterarStatusTreinoDTO alterarStatusTreinoDTO){
        try{
            AlterarStatusTreinoDTO treinoDTO = treinoService.atualizarStatusTreino(codigo, alterarStatusTreinoDTO);
            return ResponseEntity.ok().body(treinoDTO);

        } catch (Exception e) {
            return new ResponseEntity("Erro de consulta", HttpStatusCode.valueOf(504));
        }
    }

    @DeleteMapping("/excluir/{codigo}")
    public ResponseEntity<?> excluirTreino(@PathVariable Long codigo){
        try {
            treinoService.removerTreinoPorId(codigo);
            return ResponseEntity.ok("Excluído com Sucesso");
        }catch(Exception ex) {
            return new ResponseEntity("Erro de Consulta", HttpStatusCode.valueOf(504));
        }
    }






}
