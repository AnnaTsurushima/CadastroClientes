package uenp.cadastroclientes;

public class Cliente {
    private Integer codigo;
    private String nome;
    private Endereco endereco;
    private String telefone;
    private static Integer codigoClientes = 0;
    
    public Cliente(String nome, Endereco endereco, String telefone) {
        this.codigo = codigoClientes;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigoClientes++;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

}
