package pl.radys.szkola;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SzkolaDwa implements Screen, InputProcessor {
    SpriteBatch batch;

    Texture tlo;
    BitmapFont font;
    GlyphLayout layout;

    String beginmessage;
    boolean began=false;
    GRAmatyka GRAmatyka;


    List<String> A;
    List<String> B;
    List<String> C;
    List<String> D;
    List<String> E;
    ArrayList<Word> wordsA = new ArrayList<>();
    ArrayList<Word> wordsB = new ArrayList<>();
    ArrayList<Word> wordsC = new ArrayList<>();
    ArrayList<Word> wordsD = new ArrayList<>();
    ArrayList<Word> wordsE = new ArrayList<>();
    ShapeRenderer renderer;
    String nameA, nameB, nameC, nameD, nameE;

    /**
     * wypisanie wszystkich zmiennych
     * @param GRAmatyka
     * @param A slowa z 1 kategori
     * @param B slowa z 2 kategori
     * @param C slowa z 3 kategori
     * @param D slowa z 4 kategori
     * @param E slowa z 5 kategori
     * @param nameA tytuł 1 kategori
     * @param nameB tytuł 2 kategori
     * @param nameC tytuł 3 kategori
     * @param nameD tytuł 4 kategori
     * @param nameE tytuł 5 kategori
     * @param beginmessage polecenie
     */
    public SzkolaDwa(GRAmatyka GRAmatyka,List<String> A,List<String> B, List<String> C,List<String> D,List<String> E, String nameA, String nameB, String nameC, String nameD, String nameE, String beginmessage) {
        this.GRAmatyka = GRAmatyka;
        this.beginmessage=beginmessage;
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;
        this.E=E;
        this.nameA=nameA;
        this.nameB=nameB;
        this.nameC=nameC;
        this.nameD=nameD;
        this.nameE=nameE;
    }

    /**
     * sprawdzenie czy zadanie zostalo rozwiazane poprawnie
     * @return informacja o poprawnym rozwiazaniu
     */
        boolean isGood () {
        for (Word word : wordsC) {
            if (word.x > 240 || word.y > 150) return false;
        }
        for (Word word : wordsB) {
            if (word.x < Gdx.graphics.getWidth() - 240 || word.y < Gdx.graphics.getHeight() - 150) return false;
        }
        for (Word word : wordsA) {
            if (word.x > 240 || word.y < Gdx.graphics.getHeight() - 150) return false;
        }
        for (Word word : wordsD) {
            if (word.x < Gdx.graphics.getWidth() - 240 || word.y > 150) return false;
        }
        for (Word word : wordsE) {
            if ((word.x < Gdx.graphics.getWidth() / 2 - 110 || word.x > Gdx.graphics.getWidth() / 2 + 110) || word.y > 150)
                return false;
        }
        return true;
    }

    /**
     * sprawdzenie czy rozwiazanie jest niepoprawne i czy wszystkie slowa sa ulozone
     * @return zle ulozone zadanie lub brak informacji
     */
    boolean failed () {
        int i = 0;
        int j = 0;
        for (Word word : wordsA) {
            if(word==tmp)continue;
            if ((word.x < 240 && word.y < 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) || ((word.x > Gdx.graphics.getWidth() / 2 - 110 && word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150))
                i++;
        }
        for (Word word : wordsB) {
            if(word==tmp)continue;
            if ((word.x < 240 && word.y < 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) || ((word.x > Gdx.graphics.getWidth() / 2 - 110 && word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150))
                i++;
        }
        for (Word word : wordsC) {
            if(word==tmp)continue;
            if ((word.x < 240 && word.y < 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) || ((word.x > Gdx.graphics.getWidth() / 2 - 110 && word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150))
                i++;
        }
        for (Word word : wordsD) {
            if(word==tmp)continue;
            if ((word.x < 240 && word.y < 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) || ((word.x > Gdx.graphics.getWidth() / 2 - 110 && word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150))
                i++;
        }
        for (Word word : wordsE) {
            if(word==tmp)continue;
            if ((word.x < 240 && word.y < 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) || (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) || ((word.x > Gdx.graphics.getWidth() / 2 - 110 && word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150))
                i++;
        }


        if (i == wordsA.size() + wordsB.size() + wordsC.size() + wordsD.size() + wordsE.size()) {

            for (Word word : wordsC) {
                if (word.x < 240 && word.y < 150) j++;
            }
            for (Word word : wordsB) {
                if (word.x > Gdx.graphics.getWidth() - 240 && word.y > Gdx.graphics.getHeight() - 150) j++;
            }
            for (Word word : wordsA) {
                if (word.x < 240 && word.y > Gdx.graphics.getHeight() - 150) j++;
            }
            for (Word word : wordsD) {
                if (word.x > Gdx.graphics.getWidth() - 240 && word.y < 150) j++;
            }
            for (Word word : wordsE) {
                if ((word.x > Gdx.graphics.getWidth() / 2 - 110 || word.x < Gdx.graphics.getWidth() / 2 + 110) && word.y < 150) j++;
            }


        }
        return j != i && (i == wordsA.size() + wordsB.size() + wordsC.size() + wordsD.size() + wordsE.size()) ;
    }



    Word tmp;
    boolean a=false;

    /**
     * wyrysowanie pol na planszy
     * polecenie oraz informacja koncowa o poprawnosci wykonania zadania
     * @param delta odleglosc czasu miedzy klatkami
     */
    @Override
    public void render (float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(tlo,0,0);
        batch.end();
        renderer.setColor(Color.WHITE);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.valueOf("#A8DADC"));
        renderer.rect(0, Gdx.graphics.getHeight()-150,240,150);
        renderer.rect(Gdx.graphics.getWidth()-240, Gdx.graphics.getHeight()-150,240,150);
        renderer.rect(0,0,240,150);
        renderer.rect(Gdx.graphics.getWidth()-240,0,240,150);
        renderer.rect(Gdx.graphics.getWidth()/2-105,0,240,150);
        renderer.setColor(Color.valueOf("#457B9D"));
        renderer.rect(0, Gdx.graphics.getHeight()-50,240,50);
        renderer.rect(Gdx.graphics.getWidth()-240, Gdx.graphics.getHeight()-50,240,50);
        renderer.rect(0,100,240,50);
        renderer.rect(Gdx.graphics.getWidth()-240,100,240,50);
        renderer.rect(Gdx.graphics.getWidth()/2-105,100,240,50);




        if(tmp!=null){
            tmp.x=Gdx.input.getX()-tmp.getWidth()/2;
            tmp.y=Gdx.graphics.getHeight()-Gdx.input.getY()-tmp.getHeight();

        }



        renderer.end();
        batch.begin();
        font=new BitmapFont(Gdx.files.internal("Calibri.fnt"));
        font.setColor(Color.BLACK);
        for (Word word : wordsA) {
            if(tmp==word)continue;
            word.render(font,batch);
        }
        for (Word word : wordsB) {
            if(tmp==word)continue;
            word.render(font,batch);
        }
        for (Word word : wordsC) {
            if(tmp==word)continue;
            word.render(font,batch);
        }
        for (Word word : wordsD) {
            if(tmp==word)continue;
            word.render(font,batch);
        }
        for (Word word : wordsE) {
            if(tmp==word)continue;
            word.render(font,batch);
        }




        if(tmp!=null){
            tmp.render(font,batch);
        }

        font.draw(batch,nameA, 20,Gdx.graphics.getHeight()-20);
        font.draw(batch,nameB, Gdx.graphics.getWidth()-215,Gdx.graphics.getHeight()-20);
        font.draw(batch,nameC, 20,130);
        font.draw(batch,nameD, Gdx.graphics.getWidth()-215,130);
        font.draw(batch,nameE, Gdx.graphics.getWidth()/2-100,130);

        batch.end();
        if(finished && Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){
            GRAmatyka.setScreen(new Menu(GRAmatyka));
        }
        if(isGood()){
            message=("Gratulacje udało ci się ukończyc poziom.");
            finished=true;
            tmp=null;
        }
        else if(failed()){
            message=("Nie udało ci się spróbuj ponownie.");
            finished=true;
            tmp=null;
        }
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        if(finished){
            if(isGood()) {
                renderer.setColor(Color.valueOf("#008148"));
            } else {
                renderer.setColor(Color.valueOf("#E63946"));
            }
            renderer.rect(Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()/2-200,400,400);
        }
        if(!began){
            renderer.rect(Gdx.graphics.getWidth()/2-200,Gdx.graphics.getHeight()/2-200,400,400);
            if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){
                began=true;
            }
        }
        renderer.end();
        batch.begin();
        if(finished || !began)  {
            font.draw(batch, !began?beginmessage:message, Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2+100);
            font.draw(batch, "Nacisnij dowolny przycisk.", Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2-20);
        }
        batch.end();
    }

    /**
     * losowe umiejscowienie slow
     */
    @Override
    public void show() {
        tlo = new Texture("kartka.png");
        batch = new SpriteBatch();
        layout=new GlyphLayout();
        font=new BitmapFont();
        renderer=new ShapeRenderer();
        for (int i = 0; i < A.size(); i++) {
            wordsA.add(new Word(A.get(i), MathUtils.random(0,Gdx.graphics.getWidth()/10)*5+120,MathUtils.random(0,Gdx.graphics.getHeight()/10)*3+150,font, layout,30));
        }
        for (int i = 0; i < B.size(); i++) {
            wordsB.add(new Word(B.get(i), MathUtils.random(0,Gdx.graphics.getWidth()/10)*5+120,MathUtils.random(0,Gdx.graphics.getHeight()/10)*3+150,font, layout,30));
        }
        for (int i = 0; i < C.size(); i++) {
            wordsC.add(new Word(C.get(i), MathUtils.random(0,Gdx.graphics.getWidth()/10)*5+120,MathUtils.random(0,Gdx.graphics.getHeight()/10)*3+150,font, layout,30));
        }
        for (int i = 0; i < D.size(); i++) {
            wordsD.add(new Word(D.get(i), MathUtils.random(0,Gdx.graphics.getWidth()/10)*5+120,MathUtils.random(0,Gdx.graphics.getHeight()/10)*3+150,font, layout,30));
        }
        for (int i = 0; i < E.size(); i++) {
            wordsE.add(new Word(E.get(i), MathUtils.random(0,Gdx.graphics.getWidth()/10)*5+120,MathUtils.random(0,Gdx.graphics.getHeight()/10)*3+150,font, layout,30));
        }
        Gdx.input.setInputProcessor(this);

    }
    boolean finished=false;
    String message="";


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
    public void dispose () {
        batch.dispose();

    }

    @Override
    public boolean keyDown(int keycode) {


        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    /**
     * sluzy do odkladania slow po kliknieciu go
     * @param x wspolrzedna szerokosciowa
     * @param y wspolrzedna wysokosciowa
     * @param pointer wskaźnik
     * @param button przycisk
     * @return
     */
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        for(Word w:wordsA){
            if(w.contains(x,Gdx.graphics.getHeight()-y)){
                tmp=w;
                a=true;
                return false;
            }
        }
        for(Word w:wordsB){
            if(w.contains(x,Gdx.graphics.getHeight()-y)){
                tmp=w;
                a=false;
                return false;
            }
        }
        for(Word w:wordsC){
            if(w.contains(x,Gdx.graphics.getHeight()-y)){
                tmp=w;
                a=true;
                return false;
            }
        }
        for(Word w:wordsD){
            if(w.contains(x,Gdx.graphics.getHeight()-y)){
                tmp=w;
                a=true;
                return false;
            }
        }
        for(Word w:wordsE){
            if(w.contains(x,Gdx.graphics.getHeight()-y)){
                tmp=w;
                a=true;
                return false;
            }
        }
        return false;
    }

    /**
     * puszczenie myszki upuszcza slowo w dane miejsce
     * @param x wspolrzedna x
     * @param y wspolrzedna y
     * @param pointer wskaznik
     * @param button przycisk
     * @return
     */
    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        if(tmp!=null){
            tmp=null;

        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
