package pl.radys.szkola;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

import java.util.Arrays;
import java.util.List;

public class Menu implements Screen {

    BitmapFont bitmapFont;
    SpriteBatch ba;
    GRAmatyka GRAmatyka;
    Texture tlo;

    Stage stage;

    public Menu(GRAmatyka GRAmatyka) {
        this.GRAmatyka = GRAmatyka;
    }

    /**
     * Ta metoda sluzy do wypisania wszystkich przyciskow i ustawienia poziomow.
     */
    @Override
    public void show() {
        tlo = new Texture("tlo.png");
        bitmapFont=new BitmapFont(Gdx.files.internal("Calibri.fnt"));
        ba=new SpriteBatch();
        stage=new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin=new Skin(Gdx.files.internal("skin/neon-ui.json"));

        TextButton button=new TextButton("Poziom 1", skin);
        button.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                List<String> A= Arrays.asList(new String[]{"kiełek", "nieś","leśnik","brzezina","wierzba"});
                List<String> B= Arrays.asList(new String[]{"pleść","ścienny","cierpieć","przedwiośnie","łebek"});
                List<String> good= Arrays.asList(new String[]{"kiełek=łebek","nieś=pleść","leśnik=ścienny","brzezina=przedwiośnie","wierzba=cierpieć"});

               GRAmatyka.setScreen(new Szkola(GRAmatyka,A,B,good,"Połącz w pary wyrazy, \nw których samogłoska e\njest tego samego pochodzenia:"));
                super.clicked(event, x, y);
            }
        });
        button.setBounds(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-25,200,100);


        TextButton button2=new TextButton("Poziom 2",skin);
        button2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                List<String> A= Arrays.asList(new String[]{"mydełko", "cierń","pasterz","kwiatek","szew"});
                List<String> B= Arrays.asList(new String[]{"pierwszy","brzytewka", "sen","ojciec","ser"});
                List<String> good= Arrays.asList(new String[]{"mydełko=brzytewka","cierń=pierwszy","pasterz=ser","kwiatek=sen","szew=ojciec"});

                GRAmatyka.setScreen(new Szkola(GRAmatyka,A,B,good,"Połącz w pary wyrazy, w których samogłoska e \njest tego samego pochodzenia:"));
                super.clicked(event, x, y);
            }
        });
        button2.setBounds(Gdx.graphics.getWidth()/2+75,Gdx.graphics.getHeight()/2-25,200,100);

        TextButton button3=new TextButton("Poziom 3",skin);
        button3.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                List<String> A= Arrays.asList(new String[]{"żeński", "wieźć"});
                List<String> B= Arrays.asList(new String[]{"miejski","wierny"});
                List<String> C= Arrays.asList(new String[]{"pierścień", "śmierć"});
                List<String> D= Arrays.asList(new String[]{"mech", "brew"});
                List<String> E= Arrays.asList(new String[]{"dzień", "ojciec"});
                GRAmatyka.setScreen(new SzkolaDwa(GRAmatyka,A,B,C,D,E,"Samogłoski e","Samogłoski jać (ě)","Wokalizacji sonantu miękkiego (ŕ̥)","Wokalizacja jeru tylnego(Ъ)","Wokalizacja jeru przedniego(Ь)","Wskaż wyrazy,\nw których polska samogłoska e pochodzi z:"));
                super.clicked(event, x, y);
            }
        });
        button3.setBounds(Gdx.graphics.getWidth()/2-250,Gdx.graphics.getHeight()/2-150,200,100);


        TextButton button4=new TextButton("Poziom 4",skin);
        button4.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

                List<String> A= Arrays.asList(new String[]{"wiosło"});
                List<String> B= Arrays.asList(new String[]{"włos"});
                List<String> C= Arrays.asList(new String[]{"mowa"});
                List<String> D= Arrays.asList(new String[]{"żołna"});
                List<String> E= Arrays.asList(new String[]{"robić"});
                GRAmatyka.setScreen(new SzkolaDwa(GRAmatyka,A,B,C,D,E,"Z psł. *e (przegłos)","Z psł. *o w wyniku metatezy TorT","Z psł. sonantu l twardego","Z psł. sonantu l miękkiego","Z psł. *o w wyniku metatezy orT","Sklasyfikuj podane wyrazy\nze względu na pochodzenie samogłoski o:"));
                super.clicked(event, x, y);
            }
        });
        button4.setBounds(Gdx.graphics.getWidth()/2+75,Gdx.graphics.getHeight()/2-150,200,100);

        stage.addActor(button);
        stage.addActor(button2);
        stage.addActor(button3);
        stage.addActor(button4);

    }

    /**
     * rozrysowanie planszy gry
     * @param v
     */
    @Override
    public void render(float v) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        ba.begin();
        ba.draw(tlo,0,0);
        bitmapFont=new BitmapFont(Gdx.files.internal("Cal.fnt"));
        bitmapFont.setColor(Color.BLACK);
        bitmapFont.draw(ba,"GRAmatyka", Gdx.graphics.getWidth()/2-60,400);
        ba.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
