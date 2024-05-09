package med.voll.api.controller;

import med.voll.api.controller.paciente.DadosCadastroPaciente;
import med.voll.api.controller.paciente.Paciente;
import med.voll.api.controller.paciente.PacienteRepository;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.paciente.DadosListagemPaciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public String cadastrar(@RequestBody DadosCadastroPaciente cadastroPaciente){

        repository.save(new Paciente(cadastroPaciente));
        System.out.println(cadastroPaciente);
        return "Oi fudido, "+ cadastroPaciente.nome();

    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(sort={"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
        //return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
}
