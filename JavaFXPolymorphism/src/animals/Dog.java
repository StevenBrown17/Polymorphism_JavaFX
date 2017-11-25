package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Dog extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description;
	public Button sound = new Button("Play");
	
	public Dog(String name) {
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
		return "The domestic dog (Canis lupus familiaris or Canis familiaris) is a member of genus Canis (canines) that forms part of the wolf-like canids, and is the most widely abundant carnivore. The dog and the extant gray wolf are sister taxa, with modern wolves not closely related to the wolves that were first domesticated, which implies that the direct ancestor of the dog is extinct.";
		
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
