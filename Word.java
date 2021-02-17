package pl.radys.szkola;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Word extends Rectangle {
    String string;

    /**
     * deklaracja slow jako klasy i jej cech
     * @param string
     * @param x miejsce slowa we wspolrzednej x
     * @param y miejsce slowa we wspolrzednej y
     * @param font czcionka
     * @param layout szerokosc slowa
     * @param height wysokosc
     */
    public Word(String string, float x, float y, BitmapFont font, GlyphLayout layout, float height) {
        super(x, y, 70, height);
        layout.setText(font,string);
        this.width=layout.width;
        this.string = string;
    }

    /**
     *wyrysowywanie slow
     * @param font czcionka slowa
     * @param batch
     */
    public void render(BitmapFont font, SpriteBatch batch){
        font.draw(batch,string,x,y+height);
    }
    public void renderBounds(ShapeRenderer renderer){
        renderer.rect(x,y,width,height);
    }

}
