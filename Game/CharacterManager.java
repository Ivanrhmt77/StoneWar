package Game;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class CharacterManager {
    
    private List<Character> characters = new ArrayList<>();

    public CharacterManager() {
        initializeCharacters();
    }

    private void initializeCharacters() {
        characters.add(new Character("Archer", 120, 80, 15, 25, 10, 30, 20, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Knight", 200, 50, 20, 15, 5, 25, 15, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Mage", 100, 120, 10, 35, 20, 40, 25, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Healer", 150, 100, 5, 15, 30, 50, 30, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Rogue", 140, 90, 25, 20, 10, 35, 20, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Paladin", 180, 70, 20, 20, 15, 40, 20, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Warrior", 220, 60, 30, 10, 5, 25, 15, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Berserker", 170, 40, 40, 25, 0, 60, 25, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Druid", 130, 110, 15, 15, 25, 40, 30, loadImage("Assets/Image/Ghost.jpg")));
        characters.add(new Character("Assassin", 100, 90, 35, 30, 5, 25, 15, loadImage("Assets/Image/Ghost.jpg")));
    }

    public Character getCharacterByName(String name) {
        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }

    private Image loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        return icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    }

}
