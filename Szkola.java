package pl.radys.szkola;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Szkola implements Screen, InputProcessor {
	SpriteBatch batch;
	Texture tlo;
	BitmapFont font;
	GlyphLayout layout;
	GRAmatyka GRAmatyka;
	String beginmessage;
	boolean began=false;

	List<String> A;
	List<String> B;
	List<String> good;
	ArrayList<Word> wordsA = new ArrayList<>();
	ArrayList<Word> wordsB = new ArrayList<>();
	ArrayList<Pair> pairs=new ArrayList<>();

	ShapeRenderer renderer;

	/**
	 * Zadeklarowanie wszystkich obiektow
	 * @param GRAmatyka zmienna uzyta do wyswietlenia pola z wynikiem
	 * @param A pierwsza grupa slow
	 * @param B druga grupa slow
	 * @param good sprawdzenie poprawnego polaczenia
	 * @param beginmessage polecenie
	 */
	public Szkola(GRAmatyka GRAmatyka,List<String> A,List<String> B,List<String> good, String beginmessage) {
		this.GRAmatyka = GRAmatyka;
		this.A=A;
		this.B=B;
		this.good=good;
		this.beginmessage=beginmessage;
	}

/**
 * Sprawdzenie polaczenia par
 */
	public boolean isGood(){
		if(pairs.size()<good.size())return false;
		for (Pair pair : pairs) {
			if(!pair.check(good))return false;
		}
		return true;
	}
	Word tmp;
	boolean a=false;

	/**
	 * wypisanie slow
	 * pole wyswietlane po wykonaniu zadania
	 * @param delta czas miedzy kolejnymi klatkami
	 */
	@Override
	public void render (float delta) {
		font=new BitmapFont(Gdx.files.internal("Calibri.fnt"));

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(tlo,0,0);
		for (Word word : wordsA) {
			word.render(font,batch);
		}
		for (Word word : wordsB) {
			word.render(font,batch);
		}
		batch.end();
		renderer.setColor(Color.valueOf("#457B9D"));
		renderer.begin(ShapeRenderer.ShapeType.Filled);
		for (Pair pair : pairs) {
			pair.render(renderer);

		}

		if(tmp!=null){
			renderer.rectLine(tmp.x+tmp.width+5,tmp.y+tmp.height-5,Gdx.input.getX(),Gdx.graphics.getHeight()-Gdx.input.getY(),3);
		}

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

		if(finished){
			if(Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)){
				GRAmatyka.setScreen(new Menu(GRAmatyka));
			}
		}

		if(isGood()){
			message=("Gratulacje! Udało ci się ukończyć poziom.");
			finished=true;
		}
		else if(pairs.size()==A.size()){
			message=("Nie udało ci się, spróbuj ponownie.");
		 	finished=true;
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
	 * odpowiednie umieszczenie slow aby nie nachodzily na siebie i byly ustawione w parach
	 */
	@Override
	public void show() {
		tlo = new Texture("tablica.png");
		batch = new SpriteBatch();
		layout=new GlyphLayout();
		font=new BitmapFont();

		renderer=new ShapeRenderer();

		for (int i = 0; i < A.size(); i++) {
			wordsA.add(new Word(A.get(i),200,400-i*40,font, layout,30));
		}
		for (int i = 0; i < B.size(); i++) {
			wordsB.add(new Word(B.get(i),400,400-i*40,font, layout,30));
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
	 * mozliwosc rozpoczecia rysowania linii w momencie wcisniecia myszki
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
		return false;
	}

	/**
	 * skonczenie rysowania linii w momencie puszcenia przycisku
	 * @param x wspolrzedna szerokosciowa
	 * @param y wspolrzedna wysokosciowa
	 * @param pointer wskaźnik
	 * @param button przycisk
	 * @return
	 */
	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		if(tmp!=null){
		if(a){
			for(Word w:wordsB){
				if(w.contains(x,Gdx.graphics.getHeight()-y)){
					pairs.add(new Pair(tmp,w));
				}
			}
		}else{
			for(Word w:wordsA){
				if(w.contains(x,Gdx.graphics.getHeight()-y)){
					pairs.add(new Pair(tmp,w));
				}
			}
		}

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
