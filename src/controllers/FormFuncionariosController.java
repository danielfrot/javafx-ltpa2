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
                //System.out.println("Nova tela: "+ newScreen + ", "+ userData);
                funcionario = (Funcionario) userData;
            }
        });
    }
    //@FXML
    //protected void initialize(){}
    
    
    @FXML
    protected void btn_Salvar(ActionEvent event)throws SQLException {
        //try{
            //bd = new CRUD();
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
            System.out.println("PASSOU NA HORA DE SALVAR " + novofuncionario);
            
        //}
    }
    
    @FXML
    protected void btn_Cancelar(ActionEvent event){
        Main.changeScreen("ListFuncionarios", "TESTE");
    }
    
}
