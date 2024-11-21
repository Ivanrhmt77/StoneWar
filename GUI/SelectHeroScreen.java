package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Game.Hero;
import Game.Player;
import GameSystem.BattleSystem;
import Repository.HeroRepository;

public class SelectHeroScreen extends Screen {

    private JLabel selectInfoLabel;
    private JLabel myHeroLabel;
    private JLabel opponentHeroLabel;
    private JButton[] buttons = new JButton[9];
    private JButton startButton;

    private HeroRepository heroRepository = new HeroRepository();
    private Hero myHero;
    private Hero opponentHero;
    
    private int selectTurn;

    public SelectHeroScreen(ScreenHandler screenHandler, Player player) {
        super(screenHandler);

        super.player = player;

        initialize();
        submitAction();
    }

    @Override
    protected void initialize() {
        super.initialize();

        selectInfoLabel = addLabel("Select Your Hero", 330, 150, 1000, 70, 64);
        myHeroLabel = addLabel("Your Hero : ", 777, 30, 300, 30, 24);
        opponentHeroLabel = addLabel("Opponent's Hero : ", 777, 80, 300, 30, 24);

        startButton = addButton("Start", 500, 256, 100);
        startButton.setEnabled(false);

        panel.add(selectInfoLabel);
        panel.add(myHeroLabel);
        panel.add(opponentHeroLabel);

        panel.add(startButton);
        panel.add(backButton);

        int y = 368;

        for(int i = 0, n = 0; i < 3; i++) {
            int x = 100;

            for(int j = 0; j < 3; j++) {
                buttons[n] = addButton(heroRepository.getHeroById(n).getName(), x, y, 250);
                panel.add(buttons[n++]);
                x+= 325;
            }
            y += 125;
        }
    }

    @Override
    protected void submitAction() {
        super.submitAction();

        for(int i = 0; i < buttons.length; i++) {
            int index = i;

            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(selectTurn == 1) {
                        myHero = heroRepository.getHeroById(index);
                        buttons[index].setEnabled(false);
                    } else {
                        opponentHero = heroRepository.getHeroById(index);
                        for (JButton jButton : buttons) {
                            jButton.setEnabled(false);
                        }
                    }

                    selectTurn++;
                    updateUI();
                }
            });
        }

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenHandler.addScreen("battle", new BattleScreen(screenHandler, player, new BattleSystem(myHero, opponentHero)));
                screenHandler.switchScreen("battle");
            }
        });
    }

    @Override
    protected void onShow() {
        selectTurn = 1;
    }

    private void updateUI() {
        myHeroLabel.setText(myHero == null ? "Your Hero : " : "Your Hero : " + myHero.getName());
        opponentHeroLabel.setText(opponentHero == null ? "Opponent's Hero : " : "Opponent's Hero : " + opponentHero.getName());

        startButton.setEnabled(myHero != null && opponentHero != null);

        if(selectTurn == 2) {
            selectInfoLabel.setText("Select Your Opponent's Hero");
            selectInfoLabel.setBounds(180, 150, 1000, 70);
        } else {
            selectInfoLabel.setText("Start the Battle");
            selectInfoLabel.setBounds(360, 150, 1000, 70);
        }
    }
    
}
