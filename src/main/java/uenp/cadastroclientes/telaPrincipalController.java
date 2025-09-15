package uenp.cadastroclientes;

import java.io.IOException;
import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class telaPrincipalController {
    
    
    @FXML
    private TextField nome;
    
    @FXML
    private TextField cep;
    
    @FXML
    private TextField rua;
    
    @FXML
    private TextField cidade;
    
    @FXML
    private TextField telefone;
    
    @FXML
    private TextField numero;
    
    @FXML
    private TextField estado;
    
    private ArrayList<Cliente> listaClientes;
    
    @FXML 
    private TableView<Cliente> tabelaClientes;
    
    @FXML
    private TableColumn<Cliente, Integer> colunaCodigo;

    @FXML
    private TableColumn<Cliente, String> colunaNome;
    
    @FXML
    private TableColumn<Cliente, String> colunaCidade;
    
    @FXML
    private TableColumn<Cliente, String> colunaEstado;
    
    @FXML
    private TableColumn<Cliente, String> colunaTelefone;
    
    @FXML
    public void buscar(){
        Buscador buscador = new Buscador();
        Endereco endereco;
        
        try{
        endereco = buscador.buscar(cep.getText());
        }
        catch(IOException ioe) {
             Alert alerta = new Alert(AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("" + ioe);
            alerta.show();
            return;
            
        }
        catch(IllegalArgumentException iae) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setHeaderText(null);
            alerta.setContentText("Formato inválido:" + iae);
            alerta.show();
            return;
            
        }
        
        rua.setText(endereco.getRua());
        cidade.setText(endereco.getCidade());
        estado.setText(endereco.getEstado());
        
    }
    
    @FXML
    public void limpar() {
        nome.clear();
        cep.clear();
        rua.clear();
        numero.clear();
        cidade.clear();
        telefone.clear();
        estado.clear();
    }
    
    @FXML
    public void gravar () {
        Endereco endereco = new Endereco(cep.getText().strip(), rua.getText().strip(), numero.getText().strip(), cidade.getText().strip(), estado.getText().strip());
         Cliente cliente = new Cliente(nome.getText().strip(), endereco, telefone.getText().strip());
         
         listaClientes.add(cliente);
         
         tabelaClientes.setItems(FXCollections.observableArrayList(listaClientes));
    }
    
    @FXML
    public void initialize() {
        listaClientes = new ArrayList();
        
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colunaCidade.setCellValueFactory(cid -> {
                return new SimpleStringProperty(
                    cid.getValue().getEndereco().getCidade()
                    );
                }
            );
    
    
        colunaEstado.setCellValueFactory(cid -> {
                return new SimpleStringProperty(
                    cid.getValue().getEndereco().getEstado()
                    );
                }
            );
    }
}



