package uenp.cadastroclientes;

public class Endereco {
    private String cep;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    
public Endereco(String cep, String rua, String numero, String cidade, String estado) {
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }    
}
