package animals;

import java.net.URISyntaxException;

import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Cat extends Animal{
	
	String type = getClass().getSimpleName();
	public String name, description;//="The domestic cat is a small, typically furry, carnivorous mammal. They are often called house cats when kept as indoor pets or simply cats when there is no need to distinguish them from other felids and felines. ";;
	public Button sound = new Button("Play");;
	
	public Cat(String name) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//end playSound()
	
	@Override
	public String getDescription() {
		return "The domestic cat is a small, typically furry, carnivorous mammal. They are often called house cats when kept as indoor pets or simply cats when there is no need to distinguish them from other felids and felines. ";
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


