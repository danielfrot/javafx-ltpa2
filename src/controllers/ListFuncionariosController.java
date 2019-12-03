package controllers;

import start.Main;
import helper.Database;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CRUD;
import model.Funcionario;

public class ListFuncionariosController implements Initializable {
    @FXML
    private TableView<Funcionario> tabela;
    @FXML
    private TableColumn<Funcionario, String> nome;
    @FXML
    private TableColumn<Funcionario, String> rg;
    @FXML
    private TableColumn<Funcionario, String> cpf;
    @FXML
    private TableColumn<Funcionario, String> nascimento;
    @FXML
    private TableColumn<Funcionario, String> telefone;
    @FXML
    private TableColumn<Funcionario, String> sexo;
    @FXML
    private TableColumn<Funcionario, String> estadoCivil;
    @FXML
    private TableColumn<Funcionario, String> rua;
    @FXML
    private TableColumn<Funcionario, String> numCasa;
    @FXML
    private TableColumn<Funcionario, String> bairro;
    @FXML
    private TableColumn<Funcionario, String> cidade;
    @FXML
    private TableColumn<Funcionario, String> matricula;
    @FXML
    private TableColumn<Funcionario, String> cargo;
    @FXML
    private TableColumn<Funcionario, String> setor;
    //buttons
    Connection connection = null;
    CRUD crud = null;
    ObservableList<Funcionario> funcionarios = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("ENTROU NO INITIALIZE RETORNANDO PRA TELA 1");
        Main.addOnChangedScreenListeners(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("ListFuncionarios"))
                    carregarTabela();
                //System.out.println("Nova tela: "+ newScreen + ", "+ userData);
                //funcionario = (Funcionario) userData;
            };
        });
        carregarTabela();
    }
    
    public void fillList() throws SQLException {
        funcionarios = crud.SELCT();
    }
    @FXML
    public void btn_Novo(ActionEvent event){
        System.out.println("btn_Novo");
        Main.changeScreen("FormFuncionarios");
    }
    @FXML
    public void btn_Editar(ActionEvent event){
        System.out.println("btn_Editar");
        int index = tabela.getSelectionModel().getSelectedIndex();
        Funcionario funcionario = tabela.getSelectionModel().getSelectedItem();
        Main.changeScreen("FormFuncionarios", funcionario); // passando o funcionario selecionado como parâmetro pra nova tela
    }
    
    @FXML
    public void btn_Excluir(ActionEvent event) throws SQLException {
        int index = tabela.getSelectionModel().getSelectedIndex();
        Funcionario funcionario = tabela.getSelectionModel().getSelectedItem();
        int idFuncionario = funcionario.getIdFuncionario();
        crud.DELET(idFuncionario);
        funcionarios.remove(index);
        tabela.notify();
    }
    @FXML
    public void btn_Sair(ActionEvent event){
        System.exit(0);
    }

    private void carregarTabela() {
        funcionarios = FXCollections.observableArrayList();
        crud = new CRUD();
        try {
            fillList();
            connection = Database.getInstance().getConnection();
            nome.setCellValueFactory(
                    new PropertyValueFactory<>("nome"));
            rg.setCellValueFactory(
                    new PropertyValueFactory<>("rg"));
            cpf.setCellValueFactory(
                    new PropertyValueFactory<>("cpf"));
            nascimento.setCellValueFactory(
                    new PropertyValueFactory<>("nascimento"));
            telefone.setCellValueFactory(
                    new PropertyValueFactory<>("telefone"));
            sexo.setCellValueFactory(
                    new PropertyValueFactory<>("sexo"));
            estadoCivil.setCellValueFactory(
                    new PropertyValueFactory<>("estadoCivil"));
            rua.setCellValueFactory(
                    new PropertyValueFactory<>("rua"));
            numCasa.setCellValueFactory(
                    new PropertyValueFactory<>("numCasa"));
            bairro.setCellValueFactory(
                    new PropertyValueFactory<>("bairro"));
            cidade.setCellValueFactory(
                    new PropertyValueFactory<>("cidade"));
            matricula.setCellValueFactory(
                    new PropertyValueFactory<>("matricula"));
            cargo.setCellValueFactory(
                    new PropertyValueFactory<>("cargo"));
            setor.setCellValueFactory(
                    new PropertyValueFactory<>("setor"));
            tabela.setItems(funcionarios);
        } catch (SQLException ex) {
            Logger.getLogger(ListFuncionariosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}