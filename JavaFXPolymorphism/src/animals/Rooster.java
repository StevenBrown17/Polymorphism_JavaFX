package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Rooster extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description="Animal Description";
	public Button sound = new Button("Play");
	
	public Rooster(String name) {
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
		return "A rooster, also known as a cockerel or cock, is a male gallinaceous bird, usually a male chicken (Gallus gallus). Mature male chickens less than one year old are called cockerels. The term \"rooster\" originates in the United States, and the term is widely used throughout North America, as well as Australia and New Zealand. The older terms \"cock\" or \"cockerel\", the latter denoting a young cock, are used in the United Kingdom and Ireland.";
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