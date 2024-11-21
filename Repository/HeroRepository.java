package Repository;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import Game.Hero;

public class HeroRepository {
    
    private List<Hero> heroes = new ArrayList<>();

    public HeroRepository() {
        initialize();
    }

    public Hero getHeroByName(String name) {
        for (Hero character : heroes) {
            if (character.getName().equalsIgnoreCase(name))
                return character;
        }
        return null;
    }

    public Hero getHeroById(int id) {
        if (id >= 0 && id < heroes.size())
            return heroes.get(id);

        return null;
    }
    
    private void initialize() {
        heroes.add(new Hero("Ado", 120, 100, 15, 35, 20, 30, 25, loadImage("Assets/Image/Ado.png")));
        heroes.add(new Hero("Crypto King", 200, 80, 18, 40, 25, 25, 20, loadImage("Assets/Image/CryptoKing.png")));
        heroes.add(new Hero("Flower", 100, 120, 12, 45, 30, 35, 25, loadImage("Assets/Image/Flower.jpg")));
        heroes.add(new Hero("Ghost", 140, 90, 20, 50, 35, 25, 20, loadImage("Assets/Image/Ghost.png")));
        heroes.add(new Hero("Gojo", 180, 100, 22, 45, 30, 40, 25, loadImage("Assets/Image/Gojo.png")));
        heroes.add(new Hero("Hengker", 220, 70, 15, 35, 25, 30, 20, loadImage("Assets/Image/Hengker.png")));
        heroes.add(new Hero("Patrick", 170, 60, 25, 55, 40, 35, 30, loadImage("Assets/Image/Patrick.png")));
        heroes.add(new Hero("Red Ranger", 130, 110, 16, 40, 25, 45, 30, loadImage("Assets/Image/RedRanger.png")));
        heroes.add(new Hero("Skull", 100, 90, 20, 60, 40, 25, 25, loadImage("Assets/Image/Skull.png")));
    }

    private ImageIcon loadImage(String path) {
        ImageIcon icon = new ImageIcon(path);
        Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
