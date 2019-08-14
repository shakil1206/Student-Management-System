
package stumanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class AddStudentLayoutController implements Initializable {

    @FXML
    private TextField namef;
    @FXML
    private TextField emailf;
    @FXML
    private TextField departmentf;
    @FXML
    private TextArea addressf;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    

    
    static ObservableList<Student> stdList = FXCollections.observableArrayList();
    
    
    
    @FXML
    private void SaveButtonAction(ActionEvent event) throws IOException {
        
        String name = namef.getText();
        String email = emailf.getText();
        String department = departmentf.getText();
        String address = addressf.getText();
        
        if(name.equals(""))return;
        if(email.equals(""))return;
        if(department.equals(""))return;
        if(address.equals(""))return;
        
        Student student = new Student(name, email, department, address);
        
        
        File file= new File("Student.txt");
        if(!file.exists())file.createNewFile();
        
        FileWriter writer = new FileWriter(file, true);
        
        writer.write(name+"  "+email+"  "+department+"  "+address+"  \n");
        writer.close();
        
        
        
        namef.clear();
        emailf.clear();
        departmentf.clear();
        addressf.clear();
        
        
    }

    @FXML
    private void ResetButtonAction(ActionEvent event) {
        
        namef.clear();
        emailf.clear();
        departmentf.clear();
        addressf.clear();
        
    }
    
}
