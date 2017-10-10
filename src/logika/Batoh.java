package logika;

import java.util.Map;
import java.util.HashMap;

/*******************************************************************************
 * Třída Batoh - popisuje kabelku.
 * 
 *  Tato třída je součástí jednoduché textové hry.
 * "Batoh" reprezentuje "úložný prostor" pro sebrané věci (příkazem seber). 
 *  Věci jsou přenositelné. Jsou vkládány do batohu a kdykoli si pomocí příkazu
 * 'batoh' můžeme zjistit její obsah (vypíše se řetězec znaků). Lze je z batohu
 *  odebrat, resp. je "vymazat" příkazem vyhod.
 *  
 * @author     Jekaterina Krivenchuk
 * @version    pro školní rok 2016/2017
 */
public class Batoh implements ISeznamVeci
{
    private Map<String, Vec> veci; //klíč a k němu přiřazená hodnota

    /***************************************************************************
     * Konstruktor třídy
     */
    public Batoh()
    {
        veci = new HashMap<>(); //vytvořená nová mapa, do které se vkládají předměty
    }

    /**
     * Metoda k vypsání obsahu kabelky.
     */
    public String toString(){
        if(veci.size() == 0) { //počet prvků uložených v mapě je nula
            return "Batoh je prazdny.";
        }
        String result = "";
        for(String s : veci.keySet()) { //procházení mapy; vrací množinu obsahující klíče - předměty, které jsou v kabelce
            result += s+ ", ";
        }
        return result;
    }

    /**
     * Metoda rozhodne, zda v kabelce věc je.
     */
    public boolean obsahujeVec(String nazev) {
        return veci.containsKey(nazev); //pokud je klíč obsažen v mapě, vrací true
    }

    /**
     * Metoda vloží věc do kabelky.
     */
    public Vec vlozVec(Vec vec) {
        veci.put(vec.getNazev(),vec); //vloží klíč a hodnotu do mapy
        if(veci.containsKey(vec.getNazev())) return vec;
        return null;
    }

    /**
     * Metoda odebere věc z kabelky.
     */
    public Vec odeberVec(String nazev) {
        return veci.remove(nazev); //v mapě se zrusí odpovídající klíč s hodnotou
    }

    /**
     * Metoda odebere věc z kabelky.
     */
    public Vec odeberVec(Vec vec) {
        return null;
    }

    /**
     * Metoda vrátí "nic", byla-li věc snězena
     */
    public Vec snezVec(Vec vec) {
        return null;
    }

    /**
     * Metoda vrátí "nic", byla-li věc odebrána z kabelky.
     */
    public Vec odebranaVec(Vec vec) {
        return null;
    }

}
