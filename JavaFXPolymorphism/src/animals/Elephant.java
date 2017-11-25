package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Elephant extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description="Animal Description";
	public Button sound = new Button("Play");
	
	public Elephant(String name) {
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
		return "Elephants are large mammals of the family Elephantidae and the order Proboscidea. Three species are currently recognized: the African bush elephant (Loxodonta africana), the African forest elephant (L. cyclotis), and the Asian elephant (Elephas maximus). Elephants are scattered throughout sub-Saharan Africa, South Asia, and Southeast Asia.";
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
