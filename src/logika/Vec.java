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
    private Image obr; 
    private String adresa;

    /***************************************************************************
     * Konstuktor třídy
     * @param nazev
     */
    public Vec(String nazev)
    {
        this.nazev = nazev;
    }

    /**
     * Metoda vrací název věci
     * @return 
     */ 
    public String getNazev() {
        return nazev;
    }
}
