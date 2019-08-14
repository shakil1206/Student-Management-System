
package stumanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class AllStudentController implements Initializable {

    @FXML
    private TableView<Student> StudentTable;
    @FXML
    private TableColumn<Student, String> NameCol;
    @FXML
    private TableColumn<Student, String> emailCol;
    @FXML
    private TableColumn<Student, String> departmentCol;
    @FXML
    private TableColumn<Student, String> addressCol;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {


     AddStudentLayoutController.stdList.clear();
        try {
           
            
            StudentTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
             
            File file = new File("Student.txt");
            if(!file.exists())file.createNewFile();
            
            
            Scanner input = new Scanner(file);
            
                     
            while(input.hasNext())
            {
               String str = input.nextLine();
               String[] parts = str.split("  ");
               
               Student student = new Student(parts[0], parts[1], parts[2],  parts[3]);
               
               AddStudentLayoutController.stdList.add(student);
               
            }

            
            
            NameCol.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
            emailCol.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
            departmentCol.setCellValueFactory(new PropertyValueFactory<Student, String>("department"));
            addressCol.setCellValueFactory(new PropertyValueFactory<Student, String>("address"));
            
                                                       
            StudentTable.setItems(AddStudentLayoutController.stdList);
            
            
        } catch (IOException ex) {
            Logger.getLogger(AllStudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        
    }    

    @FXML
    private void DeleteButtonAction(ActionEvent event) throws IOException {
        
        ObservableList<Student> SelectedStudent = FXCollections.observableArrayList();
        SelectedStudent = StudentTable.getSelectionModel().getSelectedItems();
        
        AddStudentLayoutController.stdList.removeAll(SelectedStudent);
        
        File file = new File("Student.txt");
        if(!file.exists())file.createNewFile();
        
        FileWriter writer = new FileWriter(file);
        
        String str="";
        
        for(Student s: AddStudentLayoutController.stdList)
        {
           str+= s.getName()+"  "+s.getEmail()+"  "+s.getDepartment()+"  "+s.getAddress()+"  ";
        }
        
       writer.write(str);
       
       writer.close();
       
    }
    
}
