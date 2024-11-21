package Repository;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Hero;

public class HeroRepository {
    
    private List<Hero> heroes = new ArrayList<>();

    public HeroRepository() {
        initializeCharacters();
    }

    private void initializeCharacters() {
        heroes.add(new Hero("Archer", 120, 80, 15, 25, 10, 30, 20, loadImage("Assets/Image/Flower.jpg")));
        heroes.add(new Hero("Knight", 200, 50, 20, 15, 5, 25, 15, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Mage", 100, 120, 10, 35, 20, 40, 25, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Rogue", 140, 90, 25, 20, 10, 35, 20, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Paladin", 180, 70, 20, 20, 15, 40, 20, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Warrior", 220, 60, 30, 10, 5, 25, 15, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Berserker", 170, 40, 40, 25, 0, 60, 25, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Druid", 130, 110, 15, 15, 25, 40, 30, loadImage("Assets/Image/Skull.png")));
        heroes.add(new Hero("Assassin", 100, 90, 35, 30, 5, 25, 15, loadImage("Assets/Image/Flower.jpg")));
    }

    public Hero getHeroByName(String name) {
        for (Hero character : heroes) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }
        return null;
    }

    public Hero getHeroById(int id) {
        if (id >= 0 && id < heroes.size()) {
            return heroes.get(id);
        }
        return null;
    }
    

    private ImageIcon loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
