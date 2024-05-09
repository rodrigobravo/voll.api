package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico cadastro) {
        this.ativo = true;
        this.nome = cadastro.nome();
        this.crm = cadastro.crm();
        this.email = cadastro.email();
        this.telefone = cadastro.telefone();
        this.especialidade = cadastro.especialidade();
        this.endereco = new Endereco(cadastro.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico cadastro) {
        if(cadastro.nome() != null){
            this.nome = cadastro.nome();
        }
        if(cadastro.telefone() != null){
            this.telefone = cadastro.telefone();
        }
        if(cadastro.endereco() != null){
            this.endereco.atualizarInformacao(cadastro.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
