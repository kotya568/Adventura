package logika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Observer;
import utils.Subject;

/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author     Jekaterina Krivenchuk
 * @version    pro školní rok 2016/2017
 */
public class HerniPlan implements Subject {
    
    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    
    
    private final List<Observer> listObserveru = new ArrayList<Observer>();
    
    private Batoh batoh;
    private int pokus; //číslo pokusu
    private Map<String, Prostor> mapa;
    protected State state = State.Zacatek;
    protected boolean princeznaJeZiva = true;
    protected boolean dostalJed = false;

    
    /**
     *  Konstruktor, který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví vezeni.
     */
    public HerniPlan() {
        batoh = new Batoh();
        pokus = 0;
        mapa = new HashMap<>();
        zalozProstoryHry();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví vezeni.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor kralovsky_dvur = new Prostor("kralovsky_dvur", "Hezky zamek a kralovna", 110, 40);
        mapa.put("kralovsky_dvur", kralovsky_dvur);
        Prostor vezeni = new Prostor("vezeni", "Strasne a mokre vezeni , ktere dohleda straznik", 15 ,74);
        mapa.put("vezeni", vezeni);
        Prostor les = new Prostor("les","Les, ve kterem bydli carodejnce",60,10);
        mapa.put("les", les);
        Prostor dum = new Prostor("dum","Tvuj rodny domov zachyceny bilymi chodcsi",97,40);  
        mapa.put("dum", dum);  
        Prostor jeskyne = new Prostor("jeskyne","Tady sidli matka ",55,5);
        mapa.put("jeskyne", jeskyne);

        viteznyProstor = dum;

        // přiřazují se průchody mezi prostory (sousedící prostory)
        les.setVychod(jeskyne);
        les.setVychod(kralovsky_dvur);
        kralovsky_dvur.setVychod(les);
        jeskyne.setVychod(les);
        jeskyne.setVychod(dum);

        //věci, které lze vložit do batohu        
        jeskyne.vlozVec(new Vec("dort"));

        aktualniProstor = vezeni;  // hra začíná ve vezeni     
    }

    /**
     * Metoda vraci odkaz na instanci prostoru podle nazvu
     */
    public Prostor getProstor(String name){
        return mapa.get(name);
    }

    /**
     * Metoda rozhodne, jestli hrac muze jit domu
     */
    public boolean muzeJitDomu(){
        return getBatoh().obsahujeVec("mec");
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     */

    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
        notifyAllObservers();
    }

    /**
     *  Metoda vrací počet zbývajících pokusů při odpovídání na otázku
     */
    public int getPokus(){
        return pokus;
    }

    /**
     *  Metoda snižuje (resp. zvyšuje) počet pokusů (pokusy začíají na nule)
     */
    public void spatnaOdpoved(){
        pokus++;
    }

    /**
     *  Metoda vrací vítězný prostor.
     */
    public Prostor getViteznyProstor() {
        return viteznyProstor;
    }

    /**
     *  Metoda vrací odkaz na instanci batohu.
     */
    public Batoh getBatoh() {
        return batoh;
    }

    @Override
    public void registerObserver(Observer observer) {
    listObserveru.add(observer);
          
    }

    @Override
    public void deleteObserver(Observer observer) {
       listObserveru.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer listObserveruItem : listObserveru){
         listObserveruItem.update();
        }
    }

}
