package logika;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.Observer;
import utils.Subject;
<<<<<<< HEAD
=======
import utils.ObserverBatoh;
import utils.ObserverProstor;
import utils.SubjektBatoh;
import utils.SubjektProstor;
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
/**
 *  Trida HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
<<<<<<< HEAD
public class HerniPlan implements Subject{
=======
public class HerniPlan implements Subject,SubjektProstor, SubjektBatoh {
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
    
    private Prostor aktualniProstor;
    private Prostor viteznyProstor;
    private Hra hra;
    
    
    private final List<Observer> listObserveru = new ArrayList<Observer>();
    
    private Batoh batoh;
    private int pokus; //číslo pokusu
    private Map<String, Prostor> mapa;

    /**
     *
     */
    protected State state = State.Zacatek;

    /**
     *
     */
    protected boolean kralovnaJeZiva = true;

    /**
     *
     */
    protected boolean dostalJed = false;
   
    private List <ObserverProstor> pozorovateleProstoru;
    private List <ObserverBatoh> pozorovateleBatohu;

    
    /**
     *  Konstruktor, který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví vezeni.
     * @param hra
     */
    public HerniPlan(Hra hra) {
        batoh = new Batoh();
        pokus = 0;
        mapa = new HashMap<>();
        this.hra = hra;
        zalozProstoryHry();
    }

    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví vezeni.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor kralovsky_dvur = new Prostor("kralovsky_dvur", "Hezky zamek a kralovna", 120 ,200);
        mapa.put("kralovsky_dvur", kralovsky_dvur);
<<<<<<< HEAD
        Prostor vezeni = new Prostor("vezeni", "Strasne a mokre vezeni, ktere dohlida straznik", 220 ,300);
=======
        Prostor vezeni = new Prostor("vezeni", "Strasne a mokre vezeni, ktere dohlida straznik", 15 ,74);
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
        mapa.put("vezeni", vezeni);
        Prostor les = new Prostor("les","Les, ve kterem bydli carodejnce",300 ,200);
        mapa.put("les", les);
<<<<<<< HEAD
        Prostor dum = new Prostor("dum","Tvuj rodny domov, ktery je zachycen bilymi chodci",450 ,50);  
=======
        Prostor dum = new Prostor("dum","Tvuj rodny domov, ktery je zachycen bilymi chodci",97,40);  
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
        mapa.put("dum", dum);  
        Prostor jeskyne = new Prostor("jeskyne","Tady sidli matka ",450 ,200);
        mapa.put("jeskyne", jeskyne);

        viteznyProstor = dum;

        // přiřazují se průchody mezi prostory (sousedící prostory)
        vezeni.setVychod(les);
        les.setVychod(jeskyne);
        les.setVychod(kralovsky_dvur);
        kralovsky_dvur.setVychod(les);
        jeskyne.setVychod(les);
        jeskyne.setVychod(dum);

        //věci, které lze vložit do batohu        
        jeskyne.vlozVec(new Vec("dort","dort.jpg"));

        aktualniProstor = vezeni;  // hra začíná ve vezeni     
    }

    /**
     * Metoda vraci odkaz na instanci prostoru podle nazvu
     * @param name
     * @return 
     */
    public Prostor getProstor(String name){
        return mapa.get(name);
    }

    /**
     * Metoda rozhodne, jestli hrac muze jit domu
     * @return 
     */
    public boolean muzeJitDomu(){
        return getBatoh().obsahujeVec("mec");
    }

    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     * @return 
     */
    
    

    public Hra getHra() {
        return hra;
    }

    /**
     *
     * @return
     */
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }

    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     * @param prostor
     */
    public void setAktualniProstor(Prostor prostor) {
        aktualniProstor = prostor;
        notifyAllObservers();
    }

    /**
     *  Metoda vrací počet zbývajících pokusů při odpovídání na otázku
     * @return 
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
     * @return 
     */
    public Prostor getViteznyProstor() {
        return viteznyProstor;
    }

    /**
     *  Metoda vrací odkaz na instanci batohu.
     * @return 
     */
    public Batoh getBatoh() {
        return batoh;
    }

    /**
     *
     * @param observer
     */
    @Override
    public void registerObserver(Observer observer) {
    listObserveru.add(observer);
          
    }

    /**
     *
     * @param observer
     */
    @Override
    public void deleteObserver(Observer observer) {
       listObserveru.remove(observer);
    }

    /**
     *
     */
    @Override
    public void notifyAllObservers() {
        for (Observer listObserveruItem : listObserveru){
         listObserveruItem.update();
        }
    }

    
    /**
     * Metoda zaregistruje pozorovatele prostoru.
     * @param observer
     */
    @Override
    public void zaregistrujPozorovatele(ObserverProstor observer) {
        pozorovateleProstoru.add(observer);
    }
    
    /**
     * Metoda odregistruje pozorovatele prostoru.
     * @param observer
     */
    @Override
    public void odregistrujPozorovatele(ObserverProstor observer) {
       pozorovateleProstoru.remove(observer);
    }
    
    /**
     * Metoda upozorní .
     */
    @Override
    public void upozorniPozorovatele() {
        for(ObserverProstor pozorovatel:pozorovateleProstoru){
            pozorovatel.update();
        }
        for(ObserverBatoh pozorovatel: pozorovateleBatohu){
            pozorovatel.update();
        }
    }
    
    /**
     * Metoda zaregistruje  batohu.
     * @param observer
     */
     @Override
    public void zaregistrujPozorovatele(ObserverBatoh observer) {
        pozorovateleBatohu.add(observer);
    }
    
    /**
     * Metoda odregistruje  batohu.
     * @param observer
     */
    @Override
    public void odregistrujPozorovatele(ObserverBatoh observer) {
        pozorovateleBatohu.remove(observer);
    }

}
