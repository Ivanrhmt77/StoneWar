package GUI;

import javax.swing.JLabel;

public class ComingSoon extends Screen {

    private JLabel comingSoonLabel;
    
    public ComingSoon(ScreenHandler screenHandler) {
        super(screenHandler);
        initialize();
        submitAction(); 
    }

    @Override
    protected void initialize() {
        super.initialize();

        comingSoonLabel = addLabel("Coming Soon...", 144, 304, 813, 160, 120);

        panel.add(backButton);
        panel.add(comingSoonLabel);
    }

    @Override
    public void onShow() {
        backButton.requestFocusInWindow();
    }

}
