package start;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Funcionario;

public class Main extends Application {
    private static Stage stage;
    private static Scene login;
    private static Scene FormFuncionarios;
    private static Scene ListFuncionarios;
    private static boolean maximized = true;
    @Override
    public void start(Stage window) throws Exception {

        
        stage = window;
        window.setTitle("Controle de Funcionarios");
        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        login = new Scene(fxmlLogin);
        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("../views/ListFuncionarios.fxml"));
        ListFuncionarios = new Scene(fxmlMenu);
        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("../views/FormFuncionarios.fxml"));
        FormFuncionarios = new Scene(fxmlCadastro);
        window.setScene(login);
        window.show();      
    }
    public static void changeScreen(String scr){
        switch(scr){
            case "login":
                stage.setScene(login);
                break;
            case "ListFuncionarios":
                stage.setScene(ListFuncionarios);
                stage.setMaximized(maximized);
                break;
            case "FormFuncionarios":
                stage.setScene(FormFuncionarios);
                stage.setMaximized(maximized);
                break;
        }
    }
    
     public static void changeScreen(String scr, Object userData){
        switch(scr){
            case "login":
                stage.setScene(login);
                break;
            case "ListFuncionarios":
                stage.setScene(ListFuncionarios);
                stage.setMaximized(true);
                notifyAllListeners("ListFuncionarios", userData);
                break;
            case "FormFuncionarios":
                stage.setScene(FormFuncionarios);
                stage.setMaximized(true);
                notifyAllListeners("FormFuncionarios", userData);
                break;
        }
    }
    
    public static void main(String[] args) {
        launch(args);  
    }
    // --------------- OBSERVER -------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
    
    public static interface OnChangeScreen{
        void onScreenChanged(String newScreen, Object userData); // evento para notificar todo mundo
    }
    
    public static void addOnChangedScreenListeners(OnChangeScreen newListener){ // metodo para adicionar os listners
        listeners.add(newListener);
    }
    
    private static void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l: listeners)
            l.onScreenChanged(newScreen, userData);
    }
}