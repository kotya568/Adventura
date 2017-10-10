package logika;

/**
 * Instance třídy věc představují jednotlivé předměty.
 * 
 * Tato třída je součástí jednoduché textové hry.
 *
 *@author     Jekaterina Krivenchuk
 * @version    pro školní rok 2016/2017
 */
public class Vec
{
    private String nazev;

    /***************************************************************************
     * Konstuktor třídy
     */
    public Vec(String nazev)
    {
        this.nazev = nazev;
    }

    /**
     * Metoda vrací název věci
     */ 
    public String getNazev() {
        return nazev;
    }
}
