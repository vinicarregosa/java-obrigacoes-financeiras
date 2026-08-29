

public class Empresa {

    private String cnpj;
    private String razaoSocial;

    public Empresa (String cnpj, String razaoSocial){
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;

        if (this.cnpj == null || this.razaoSocial == null || this.cnpj.isBlank() || this.razaoSocial.isBlank()){
            throw new IllegalArgumentException("Cnpj ou Razão Social inválidos.");
        }

    }
}
