package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Dolphin extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description="Animal Description";
	public Button sound = new Button("Play");
	
	public Dolphin(String name) {
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
		return "Dolphins are a widely distributed and diverse group of aquatic mammals. They are an informal grouping within the order Cetacea, excluding whales and porpoises, so to zoologists the grouping is paraphyletic. The dolphins comprise the extant families Delphinidae (the oceanic dolphins), Platanistidae (the Indian river dolphins), Iniidae (the new world river dolphins), and Pontoporiidae (the brackish dolphins), and the extinct Lipotidae (baiji or Chinese river dolphin).";
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