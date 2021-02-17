package pl.radys.szkola;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;
import java.util.List;

public class Pair {
    Word w1, w2;
    boolean good=false;

    /**
     * Okreslenie 2 slow.
     * @param w1 slowo 1
     * @param w2 slowo 2
     */
    public Pair(Word w1, Word w2) {
        this.w1 = w1;
        this.w2 = w2;
    }

    /**
     * wyrysowywanie kresek przy laczeniu slow w pary
     * @param renderer umozliwia wyrysowywanie kresek
     */
    public void render(ShapeRenderer renderer){
      if(w1==null || w2==null)return;
      renderer.rectLine(w1.x+w1.width+5,w1.y+w1.height-5,w2.x-5,w2.y+w2.height-5,3);

    }

    /**
     *
     * @param str
     * @return
     */
    public boolean check(List<String> str){
        boolean git=false;
        for (String s : str) {
            if((s.split("=")[0].equals(w1.string) && s.split("=")[1].equals(w2.string)) || (s.split("=")[1].equals(w1.string) && s.split("=")[0].equals(w2.string))){
                git=true;
                break;
            }
        }

        return git;

    }



}
