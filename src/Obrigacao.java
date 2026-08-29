import Exceptions.OperacaoJaPaga;
import Exceptions.PagamentoInsuficienteException;
import Exceptions.ValorInvalidoException;

public class Obrigacao {

    private Empresa empresa;
    private String descricao;
    private double valor;
    private StatusObrigacao status;

    public Obrigacao (Empresa empresa, double valor, String descricao){


        this.empresa = empresa;
        this.valor = valor;
        this.status = StatusObrigacao.PENDENTE;
        this.descricao = descricao;

        if (this.valor <= 0){
            throw new ValorInvalidoException("Valor inválido.");
        }
        if (this.descricao == null || this.descricao.isBlank() || this.empresa == null){
            throw new IllegalArgumentException("Descrição inválida ou Empresa não Informada.");
        }


    }
    public void pagar(double valor){

        if (valor <= 0) {
            throw new ValorInvalidoException("Valor inválido");
        }

        if(status == StatusObrigacao.PAGA) {
            throw new OperacaoJaPaga("A operação já foi paga.");
        }

        if (valor < this.valor) {
            throw new PagamentoInsuficienteException("Pagamento insuficiente.");
        }

        status = StatusObrigacao.PAGA;

    }

}

