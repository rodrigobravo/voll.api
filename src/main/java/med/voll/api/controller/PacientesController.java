package med.voll.api.controller;

import med.voll.api.controller.paciente.DadosCadastroPaciente;
import med.voll.api.controller.paciente.Paciente;
import med.voll.api.controller.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
