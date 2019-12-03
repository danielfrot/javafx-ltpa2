package model;

import java.sql.SQLException;

public class Funcionario {
    
    private Integer idFuncionario;
    private String nome,rg,cpf, nascimento, telefone, sexo, estadoCivil, rua, numCasa,bairro,cidade,matricula,cargo,setor;
    
    public CRUD bd = new CRUD();

    public Funcionario(int idFuncionario, String nome, String rg, String cpf, String nascimento, String telefone, String sexo, String estadoCivil, String rua, String numCasa, String bairro, String cidade, String matricula, String cargo, String setor) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.rua = rua;
        this.numCasa = numCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.matricula = matricula;
        this.cargo = cargo;
        this.setor = setor;
    }
   
    public Funcionario() {
    }
    public Funcionario(String nome, String rg, String cpf, String nascimento, String telefone, String sexo, String estadoCivil, String rua, String numCasa, String bairro, String cidade, String matricula, String cargo, String setor) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.rua = rua;
        this.numCasa = numCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.matricula = matricula;
        this.cargo = cargo;
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", nascimento=" + nascimento + ", telefone=" + telefone + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", rua=" + rua + ", numCasa=" + numCasa + ", bairro=" + bairro + ", cidade=" + cidade + ", matricula=" + matricula + ", cargo=" + cargo + ", setor=" + setor + '}';
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNascimento() {
        return nascimento;
    }
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getNumCasa() {
        return numCasa;
    }
    public void setNumCasa(String numCasa) {
        this.numCasa = numCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getSetor() {
        return setor;
    }
    public void setSetor(String setor) {
        this.setor = setor;
    }
    
    public void save() throws SQLException{
        bd.INSERT(this);
    }
    
    public void update() throws SQLException{
        bd.UPDATE(this);
    }

}