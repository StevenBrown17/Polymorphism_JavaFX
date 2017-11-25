package animals;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.net.URISyntaxException;

public class Animal {
	
	public String type; 
	public String name, description;
	public Button sound = new Button("Play");
	
	public Animal() {
		type = getClass().getSimpleName();
	}

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
	}//end playSound();


	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public String getDescription() {
		return "Animal Description";
	}


	public Button getSound() {
		return sound;
	}


}//end class
