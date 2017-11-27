/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logika.HerniPlan;
import utils.Observer;

/**
 *
 * @author Lenovo
 */
public class PanelVychodu implements Observer
{

    private HerniPlan plan;
    ListView<String> list;
    ObservableList<String> data;
    
    private TextArea centralText;
    private TextField zadejPrikazTextArea;

    /**
     *
     * @param plan
     * @param text
     * @param field
     */
    public PanelVychodu(HerniPlan plan, TextArea text,TextField field)
      {
        this.plan = plan;
        plan.registerObserver(this);

        centralText = text;
        zadejPrikazTextArea = field;
        
        init();
      }

    private void init()
      {
=======
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import logika.HerniPlan;
import logika.Prostor;
import utils.ObserverProstor;

/**
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class PanelVychodu implements ObserverProstor {
    
    private HerniPlan plan;
    private ListView<String> list;
    private ObservableList<String> data;
    
    /**
     *
     * @param plan
     */
    public PanelVychodu(HerniPlan plan){
        this.plan = plan;
        plan.zaregistrujPozorovatele(this);
        init();
        
    }

    /**
     *
     */
    @Override
    public void update() {
        List<Prostor> vychody = new ArrayList<>(plan.getAktualniProstor().getVychody());
        data.clear();
        vychody.stream().forEach(i->data.add(i.getNazev()));
    }

    private void init() {
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
        list = new ListView<>();
        data = FXCollections.observableArrayList();
        list.setItems(data);
        list.setPrefWidth(100);
<<<<<<< HEAD
        
        list.setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override
            public void handle(MouseEvent click)
            {
                    String vstupniPrikaz = "jdi "+list.getSelectionModel().getSelectedItem();
                    String odpovedHry = plan.getHra().zpracujPrikaz("jdi "+list.getSelectionModel().getSelectedItem());

                
                    centralText.appendText("\n" + vstupniPrikaz + "\n");
                    centralText.appendText("\n" + odpovedHry + "\n");
                    
                    
                    if (plan.getHra().konecHry()) 
                    {
                    zadejPrikazTextArea.setEditable(false);
                    centralText.appendText(plan.getHra().vratEpilog());
                    }
                    
                    
                    plan.notifyAllObservers();
            }
        });
        update();
      }

=======
        update();
        }
    
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
    /**
     *
     * @return
     */
<<<<<<< HEAD
    public ListView<String> getList()
      {
        return list;
      }

    @Override
    public void update()
      {
        String vychody = plan.getAktualniProstor().seznamVychodu();
        data.clear();
        String[] oddeleneVychody = vychody.split(" ");
        for (int i = 1; i < oddeleneVychody.length; i++) {
            data.add(oddeleneVychody[i]);
        }
      }
=======
    public ListView getList(){
        return list;
    }
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
    
    /**
     * Metoda zaregistruje pozorovatele k hernímu plánu při spuštění nové hry.
     * @param plan
     */
    public void nastaveniHernihoPlanu (HerniPlan plan){
        this.plan = plan;
<<<<<<< HEAD
        plan.registerObserver(this);
        this.update();
    }


=======
        plan.zaregistrujPozorovatele(this);
        this.update();
    }
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
}
