package view;


import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.Bookmark;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * Dialog to edit details of a person.
 * 
 * @author Marco Jakob
 */
public class CreateBookmarkController {
	
	public final static String CREATE_BOOKMARK_URI = "http://localhost:8080/davidcalle9430/bookmarks/";
    @FXML
    private TextField URIField;
    @FXML
    private TextArea descriptionField;

    private Stage dialogStage;
    private Bookmark bookmark;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setPerson(Bookmark bookm) {
        this.bookmark = bookm;
        URIField.setText(bookm.getUri());
        descriptionField.setText(bookm.getDescription());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
        	Bookmark newBookmark = new Bookmark();
            newBookmark.setUri(URIField.getText());
            newBookmark.setDescription(descriptionField.getText());
            okClicked = true;
            bookmark = newBookmark;
            dialogStage.close();
            RestTemplate restTemplate = new RestTemplate();
            URI response = restTemplate.postForLocation(CREATE_BOOKMARK_URI, bookmark);
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
       return true;
    }
}