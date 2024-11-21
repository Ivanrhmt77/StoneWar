package Repository;

import GameSystem.SoundSystem;
import java.util.HashMap;
import java.util.Map;

public class SoundRepository {

    private Map<String, SoundSystem> soundMap = new HashMap<>();

    public SoundRepository() {
        initialize();
    }

    public void initialize() {
        soundMap.put("titleScreen", new SoundSystem("/Assets/Audio/titleScreenBG.wav"));
        soundMap.put("battleScreen", new SoundSystem("/Assets/Audio/battleScreenBG.wav"));
        soundMap.put("victory", new SoundSystem("/Assets/Audio/VictorySFX.wav"));
        soundMap.put("defeat", new SoundSystem("/Assets/Audio/DefeatSFX.wav"));
    }
    
    public SoundSystem getSound(String soundName) {
        return soundMap.get(soundName);
    }
}
