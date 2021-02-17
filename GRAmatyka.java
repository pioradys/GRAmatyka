package pl.radys.szkola;

import com.badlogic.gdx.Game;

public class GRAmatyka extends Game {
    /**
     * Ustawienie menu
     */
    @Override
    public void create() {
        setScreen(new Menu(this));
    }
}
