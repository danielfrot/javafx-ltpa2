package controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import model.Funcionario;
import start.Main;
import javafx.scene.control.TextField;
import model.CRUD;
        
public class FormFuncionariosController implements Initializable{
    
    private Funcionario funcionario;
    public Funcionario novofuncionario;
    @FXML
    private TextField txt_nome;
    @FXML
    private TextField txt_rg;
    @FXML
    private TextField txt_cpf;
    @FXML
    private TextField txt_nascimento;
    @FXML
    private TextField txt_telefone;
    @FXML
    private TextField txt_sexo;
    @FXML
    private TextField txt_estado_civil;
    @FXML
    private TextField txt_rua;
    @FXML
    private TextField txt_numero_casa;
    @FXML
    private TextField txt_bairro;
    @FXML
    private TextField txt_cidade;
    @FXML
    private TextField txt_matricula;
    @FXML
    private TextField txt_cargo;
    @FXML
    private TextField txt_setor;
    
    CRUD bd;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTROU NO INITIALIZE");
        Main.addOnChangedScreenListeners(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("FormFuncionarios"))
                    if (userData != null){
                        funcionario = (Funcionario) userData;
                        txt_nome.setText(funcionario.getNome());
                        txt_rg.setText(funcionario.getRg());
                        txt_cpf.setText(funcionario.getCpf());
                        txt_nascimento.setText(funcionario.getNascimento());
                        txt_telefone.setText(funcionario.getTelefone());
                        txt_sexo.setText(funcionario.getSexo());
                        txt_estado_civil.setText(funcionario.getEstadoCivil());
                        txt_rua.setText(funcionario.getRua());
                        txt_numero_casa.setText(funcionario.getNumCasa());
                        txt_bairro.setText(funcionario.getBairro());
                        txt_cidade.setText(funcionario.getCidade());
                        txt_matricula.setText(funcionario.getMatricula());
                        txt_cargo.setText(funcionario.getCargo());
                        txt_setor.setText(funcionario.getSetor());
                    }else{
                        funcionario = null;
                        txt_nome.setText("");
                        txt_rg.setText("");
                        txt_cpf.setText("");
                        txt_nascimento.setText("");
                        txt_telefone.setText("");
                        txt_sexo.setText("");
                        txt_estado_civil.setText("");
                        txt_rua.setText("");
                        txt_numero_casa.setText("");
                        txt_bairro.setText("");
                        txt_cidade.setText("");
                        txt_matricula.setText("");
                        txt_cargo.setText("");
                        txt_setor.setText("");
                    }
                    //System.out.println("Nova tela: "+ newScreen + ", "+ userData);     
            }
        });
    }
    //@FXML
    //protected void initialize(){}
    
    
    @FXML
    protected void btn_Salvar(ActionEvent event)throws SQLException {
        //try{
            //bd = new CRUD();
            
            if(this.funcionario == null){
                novofuncionario = new Funcionario();
                novofuncionario.setNome(txt_nome.getText());
                novofuncionario.setRg(txt_rg.getText());
                novofuncionario.setCpf(txt_cpf.getText());
                novofuncionario.setNascimento(txt_nascimento.getText());
                novofuncionario.setTelefone(txt_telefone.getText());
                novofuncionario.setSexo(txt_sexo.getText());
                novofuncionario.setEstadoCivil(txt_estado_civil.getText());
                novofuncionario.setRua(txt_rua.getText());
                novofuncionario.setNumCasa(txt_numero_casa.getText());
                novofuncionario.setBairro(txt_bairro.getText());
                novofuncionario.setCidade(txt_cidade.getText());
                novofuncionario.setMatricula(txt_matricula.getText());
                novofuncionario.setCargo(txt_cargo.getText());
                novofuncionario.setSetor(txt_setor.getText());
                //novofuncionario.save();
                //bd.INSERT(novofuncionario);
                //Main.changeScreen("ListFuncionarios", novofuncionario);
            //}catch(SQLException ex){
                CRUD c = new CRUD();
                c.INSERT(novofuncionario);    
                }
            if(this.funcionario != null){
                funcionario.setNome(txt_nome.getText());
                funcionario.setRg(txt_rg.getText());
                funcionario.setCpf(txt_cpf.getText());
                funcionario.setNascimento(txt_nascimento.getText());
                funcionario.setTelefone(txt_telefone.getText());
                funcionario.setSexo(txt_sexo.getText());
                funcionario.setEstadoCivil(txt_estado_civil.getText());
                funcionario.setRua(txt_rua.getText());
                funcionario.setNumCasa(txt_numero_casa.getText());
                funcionario.setBairro(txt_bairro.getText());
                funcionario.setCidade(txt_cidade.getText());
                funcionario.setMatricula(txt_matricula.getText());
                funcionario.setCargo(txt_cargo.getText());
                funcionario.setSetor(txt_setor.getText());
                CRUD c = new CRUD();
                c.UPDATE(funcionario);  
            }
            
            System.out.println("PASSOU NA HORA DE SALVAR " + novofuncionario);
            
        //}
    }
    
    @FXML
    protected void btn_Cancelar(ActionEvent event){
        Main.changeScreen("ListFuncionarios", "TESTE");
    }
    
}
