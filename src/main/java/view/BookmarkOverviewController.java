package view;

import java.awt.print.Book;

import org.hsqldb.error.Error;
import org.springframework.web.client.RestTemplate;

import com.example.Bookmark;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;

public class BookmarkOverviewController {
	public final static String DELETE_BOOKMARK_URI = "http://localhost:8080/davidcalle9430/bookmarks/";
	
	@FXML
	private TableView<Bookmark> bookmarkTable;
	@FXML
	private TableColumn<Bookmark, String> URIColumn;
	@FXML
	private TableColumn<Bookmark, String> descriptionColumn;

	@FXML
	private Label URILabel;
	@FXML
	private Label descriptionLabel;
	@FXML
	private Label idLabel;
	// Reference to the main application.
	private MainApp mainApp;

	
	private ObservableList<Bookmark> bookmarks = FXCollections.observableArrayList();
	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public BookmarkOverviewController() {
		UpdateBookmarks();
	}
	public void UpdateBookmarks(){
		RestTemplate restTemplate = new RestTemplate();
		Bookmark[] restBookmarks = (Bookmark[]) restTemplate.getForObject("http://localhost:8080/davidcalle9430/bookmarks/", Bookmark[].class);
		bookmarks.setAll(restBookmarks);
	}
	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
	    descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		URIColumn.setCellValueFactory(cellData -> cellData.getValue().URIProperty());
		bookmarkTable.setItems(bookmarks);
		bookmarkTable.getSelectionModel().selectedItemProperty().addListener(
				  (observable, oldValue, newValue) -> showPersonDetails(newValue));
	}
	private void showPersonDetails(Bookmark bookmark) {
	    if (bookmark != null) {
	        idLabel.setText(bookmark.getId().toString());
	        descriptionLabel.setText(bookmark.getDescription());
	        URILabel.setText(bookmark.getUri());
	    } else {
	    	idLabel.setText("");
	        descriptionLabel.setText("");
	        URILabel.setText("");
	    }
	}
	
	public void handleDeletePerson(){
		Bookmark selectedBookmark = bookmarkTable.getSelectionModel().getSelectedItem();
		if(selectedBookmark != null){
			RestTemplate restTemplate = new RestTemplate();
			String URI = DELETE_BOOKMARK_URI + selectedBookmark.getId();
			System.out.println(URI);
			restTemplate.delete(URI);
			UpdateBookmarks();	
		}else{
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(null);
			alert.setTitle("Not selected");
			alert.setHeaderText("No bookmark selected");
			alert.setContentText("Please select a bookmark in the table");
			alert.show();
		}
	}
	
	@FXML
	public void handleNewBookMark() {
		System.out.println("Oprime el botón");
	    Bookmark newBookmark  = new Bookmark();
	    boolean okClicked = mainApp.showPersonEditDialog(newBookmark);
	    if (okClicked) {
	        UpdateBookmarks();
	    }
	}
	/**
	 * Is called by the main application to give a reference back to itself.
	 * 
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
}