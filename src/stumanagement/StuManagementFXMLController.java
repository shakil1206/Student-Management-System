
package stumanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class StuManagementFXMLController implements Initializable {

    @FXML
    private VBox MainContent;
    
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("AddStudentLayout.fxml"));
            
            MainContent.getChildren().setAll(pane);
            
        } catch (IOException ex) {
            Logger.getLogger(StuManagementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void AddStudentAction(ActionEvent event) throws IOException {
        
      Parent pane = FXMLLoader.load(getClass().getResource("AddStudentLayout.fxml"));
            
      MainContent.getChildren().setAll(pane);
        
    }

    @FXML
    private void AllStudentAction(ActionEvent event) throws IOException {
        
        Parent pane = FXMLLoader.load(getClass().getResource("AllStudent.fxml"));
        MainContent.getChildren().setAll(pane);
        
    }
    
}
