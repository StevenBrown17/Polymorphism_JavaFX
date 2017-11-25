package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Parrot extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description="Animal Description";
	public Button sound = new Button("Play");
	
	public Parrot(String name) {
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
		return "Parrots, also known as psittacines /ˈsɪtəsaɪnz/,[1][2] are birds of the roughly 393 species in 92 genera that make up the order Psittaciformes, found in most tropical and subtropical regions. The order is subdivided into three superfamilies: the Psittacoidea (\"true\" parrots), the Cacatuoidea (cockatoos), and the Strigopoidea (New Zealand parrots). Parrots have a generally pantropical distribution with several species inhabiting temperate regions in the Southern Hemisphere, as well.";
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