package animals;

import java.net.URISyntaxException;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Cow extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description;
	public Button sound = new Button("Play");
	
	public Cow(String name) {
		this.name = name;
		this.sound.setOnAction(e -> playSound());
	}

	@Override
	public void playSound() {
		
		Media sound = null;
		try {
			sound = new Media(getClass().getResource("/sounds/"+type.toLowerCase()+".wav").toURI().toString());
			
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();
			
			
		} catch (URISyntaxException e) {
			System.out.println("Could not play media.");
			e.printStackTrace();
		}
	}//end playSound()

	@Override
	public String getDescription() {
		return "Cows are the most common type of large domesticated ungulates. They are a prominent modern member of the subfamily Bovinae, are the most widespread species of the genus Bos, and are most commonly classified collectively as Bos taurus. Cattle are raised as livestock for meat";
		
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Button getSound() {
		return sound;
	}

}//end class