package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import start.Main;
import helper.Database;
import model.CRUD;

public class LoginController implements Initializable {
    @FXML
    private Label status;
    @FXML
    private TextField textCpf;
    @FXML
    private TextField textSenha;
    CRUD crud = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        crud = new CRUD();
        if(Database.getInstance().isConnected()){
            status.setText("Conectado!!");  
        }else{
            status.setText("Sem conexão com Banco de Dados!!");
        }
    }  
    public void login(ActionEvent event){
        try{
            if(crud.login(textCpf.getText().trim(),textSenha.getText().trim()) ){
                status.setText("Usuario Logado");
            Main.changeScreen("ListFuncionarios");
            }else{
            textCpf.clear();
            textSenha.clear();
            textCpf.requestFocus();
            status.setText("CPF ou Senha invalidos, tente novamente!");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void Exit(ActionEvent event) {
        try{
            System.exit(0);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}