package logika;

import javafx.scene.image.Image;

/**
 * Instance třídy věc představují jednotlivé předměty.
 * 
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class Vec
{
    private String nazev;
    private boolean zbran;    //dá se věc použít jako zbraň?
    private boolean prenosna;    //dá se věc přenášet?
<<<<<<< HEAD
    private String adresa;
    private String obrazek;
=======
    private Image obr; 
    private String adresa;
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5

    /***************************************************************************
     * Konstuktor třídy
     * @param nazev
<<<<<<< HEAD
     * @param obrazek
=======
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
     */
    public Vec(String nazev,String obrazek)
    {
        this.nazev = nazev;
        this.obrazek = obrazek;
    }

    /**
     * Metoda vrací název věci
     * @return 
     */ 
    public String getNazev() {
        return nazev;
    }

    /**
     *
     * @return
     */
    public String getObrazek() {
        return obrazek;
    }
    
    
}
