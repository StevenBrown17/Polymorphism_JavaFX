package application;

import java.io.*;
import java.net.*;
import java.util.*;
import animals.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class MainController implements Initializable{
	
	@FXML public TextField txtName;
	@FXML public ComboBox<Animals> cbAnimal;
	@FXML public Button btnAdd;
	
	@FXML public TableView<Animal> tblAnimal;
	@FXML public TableColumn<Animal, Button> colSound = new TableColumn<Animal, Button>("Sound");
	@FXML public TableColumn<Animal, String> colName = new TableColumn<Animal, String>("Name"), 
											 colType = new TableColumn<Animal, String>("Name"), 
											 colDescription = new TableColumn<Animal, String>("Name");
	
	public ObservableList<Animal> animalList = FXCollections.observableArrayList();
	
	public List<String> nameList = new ArrayList<String>();
	
	
	
	/**
	 * Method runs on startup.
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		//prefill data
		animalList.add(new Cow("Belle"));
		animalList.add(new Dolphin("Willie"));
		animalList.add(new Cat("Max"));
		
		//lets columns know what getter to look for
		colType.setCellValueFactory(new PropertyValueFactory<Animal, String>("type"));
		colName.setCellValueFactory(new PropertyValueFactory<Animal, String>("name"));
		colDescription.setCellValueFactory(new PropertyValueFactory<Animal, String>("description"));
		colSound.setCellValueFactory(new PropertyValueFactory<Animal, Button>("sound"));
		
		//used to adjust the cell height to fit the animal description in
		colDescription.setCellFactory(param -> {
	        return new TableCell<Animal, String>() {
	            @Override
	            protected void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);

	                if (item == null || empty) {
	                    setText(null);
	                    setStyle("");
	                } else {
	                    Text text = new Text(item);
	                    text.setStyle("-fx-padding: 5px 30px 5px 5px;"
	                            + "-fx-text-alignment:justify;");
	                    text.wrappingWidthProperty().bind(getTableColumn().widthProperty().subtract(35));
	                    //System.out.println(text.getLayoutBounds().getHeight()+10);//117
	                    //setPrefHeight(text.getLayoutBounds().getHeight()+10); -----> This is not working somehow
	                    setPrefHeight(117);
	                    setGraphic(text);
	                }
	            }
	        };
	    });

		
		cbAnimal.getItems().setAll(Animals.values());//populate combobox
		cbAnimal.setValue(Animals.Cat);//set combobox to Cat
		
		readNames();
		tblAnimal.setItems(animalList);
	}//end initialize
		
	/**
	 * onClick will capture the text in the Name text field. If no name is inserted, a random name will be assigned.
	 * The switch statement determines which animal is selected. A new animal is added to the list, and the table is repopulated.
	 */
	public void onClick() {
		
		String name="";
		Random r = new Random();//used to randomly select a name
		
		if(!txtName.getText().trim().isEmpty())
			name = txtName.getText();
		else
			name = nameList.get(r.nextInt(nameList.size()));
		switch(cbAnimal.getValue()){
		
		case Cat: animalList.add(new Cat(name));
			break;
		case Cow: animalList.add(new Cow(name));
			break;
		case Dog: animalList.add(new Dog(name));
			break;
		case Dolphin: animalList.add(new Dolphin(name));
			break;
		case Elephant: animalList.add(new Elephant(name));
			break;
		case Goat: animalList.add(new Goat(name));
			break;
		case Horse: animalList.add(new Horse(name));
			break;
		case Lion: animalList.add(new Lion(name));
			break;
		case Parrot: animalList.add(new Parrot(name));
			break;
		case Rooster: animalList.add(new Rooster(name));
			break;
		case Whale: animalList.add(new Whale(name));
			break;		
		
		}//end switch
		
		tblAnimal.setItems(animalList);		
		
	}//end onClick
	
	
	/**
	 * This method reads in a file full of names into a list. If the user does not enter a name for an animal,
	 * a random name will be assigned
	 */
	public void readNames(){
		
		BufferedReader reader;
		
		try {
			String path = getClass().getResource("/files/names.txt").toURI().toString();
			path = path.replace("file:/", "");
			reader = new BufferedReader(new FileReader(path));
	
			String line = reader.readLine();
	
			while( line != null ) {
			    nameList.add(line);
			    line = reader.readLine();
			}
			
		} catch (URISyntaxException | IOException e) {
			System.out.println("Error reading name file");
			e.printStackTrace();
		}
		
		
	}//end read names
	
	
	/**
	 * Values for ComboBox
	 * @author Steve
	 *
	 */
	enum Animals{
		Cat,
		Cow,
		Dog,
		Dolphin,
		Elephant,
		Goat,
		Horse,
		Lion,
		Parrot,
		Rooster,
		Whale
	}//end enum

}//end class