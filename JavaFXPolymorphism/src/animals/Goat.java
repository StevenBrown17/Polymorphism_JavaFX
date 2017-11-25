package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Goat extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description="Animal Description";
	public Button sound = new Button("Play");
	
	public Goat(String name) {
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
		return "The domestic goat (Capra aegagrus hircus) is a subspecies of goat domesticated from the wild goat of southwest Asia and Eastern Europe. The goat is a member of the family Bovidae and is closely related to the sheep as both are in the goat-antelope subfamily Caprinae. There are over 300 distinct breeds of goat.";
	}//end getDescription

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
