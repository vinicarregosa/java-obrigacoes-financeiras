import Exceptions.OperacaoJaPaga;
import Exceptions.PagamentoInsuficienteException;
import Exceptions.ValorInvalidoException;

public class Main {

    public static void main(String[] args) {

        Empresa openai = new Empresa("4325945945-22", "OPENAI");
        Obrigacao obrigacao1 = new Obrigacao(openai, 110.0,
                "GPT PLUS");

        try {
            obrigacao1.pagar(80.0);
            System.out.println("Valor pago com sucesso.");
        } catch (PagamentoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Operação finalizada.");

        Empresa ibm = new Empresa("23898838219-22", "IBM");
        Obrigacao obrigacao2 = new Obrigacao(ibm, 100.0, "Curso Ciber");

        try {
            obrigacao2.pagar(-20.0);
            System.out.println("Valor pago com sucesso.");

        } catch (ValorInvalidoException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Operação finalizada.");


        Obrigacao obrigacao3 = new Obrigacao(openai, 200.0, "GPT-5.6-SOL");

        try {
            obrigacao3.pagar(200.0);
            System.out.println("Valor pago com sucesso.");

        } catch (PagamentoInsuficienteException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Operação finalizada.");

        try {
            obrigacao3.pagar(200.0);
            System.out.println("Valor pago com sucesso.");

        } catch (OperacaoJaPaga e) {
            System.out.println(e.getMessage());
        }


    }
}
