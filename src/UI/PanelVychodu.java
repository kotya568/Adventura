/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

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
        list = new ListView<>();
        data = FXCollections.observableArrayList();
        list.setItems(data);
        list.setPrefWidth(100);
        update();
        }
    
    /**
     *
     * @return
     */
    public ListView getList(){
        return list;
    }
    
    /**
     * Metoda zaregistruje pozorovatele k hernímu plánu při spuštění nové hry.
     * @param plan
     */
    public void nastaveniHernihoPlanu (HerniPlan plan){
        this.plan = plan;
        plan.zaregistrujPozorovatele(this);
        this.update();
    }
}
