/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import logika.Batoh;
import logika.HerniPlan;
import utils.ObserverBatoh;

/**
 *
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public class OknoBatoh implements ObserverBatoh {
    
    private VBox obal;
    private FlowPane batohPane, prostorPane;
    private HerniPlan plan;
    private Batoh batoh;
    
    /**
     *
     * @param batoh
     * @param plan
     */
    public OknoBatoh (Batoh batoh, HerniPlan plan){
        this.batoh = batoh;
        this.plan = plan;
        /*batoh.zaregistrujPozorovatele(this);
        plan.zaregistrujPozorovatele(this);
        init();*/
    }
/*
    @Override
    public void update() {
        batohPane.getChildren().clear();
        batoh.getVeci().forEach(i->{
            batohPane.getChildren().add(new ImageView(i.getObr()));
        });
        
        prostorPane.getChildren().clear();
        plan.getAktualniProstor().getVeci().forEach(i->{
            prostorPane.getChildren().add(new ImageView(i.getObr()));
        });
    }
*/
    private void init() {
        obal = new VBox();
        obal.setPrefWidth(200);
        batohPane = new FlowPane();
        prostorPane = new FlowPane();        
        obal.getChildren().addAll(new Label("Věci v prostoru: "), prostorPane, new Label("Věci v batohu: "), batohPane);
        this.update();     
    }
    
    /**
     *
     * @return
     */
    public VBox getObal(){
        return obal;
    }

    /**
     *
     */
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
