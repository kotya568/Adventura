/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import logika.HerniPlan;
import main.Main;
import utils.ObserverProstor;

/**
 *
 * @author linx
 */
public class OknoProstor implements ObserverProstor {
    
    private TextArea popisMistnosti;
    private HerniPlan plan;
    private Circle bod;
    private AnchorPane obrazekPane;
    private HBox obal;
    
    /**
     *
     * @param plan
     */
    public OknoProstor(HerniPlan plan){
        this.plan = plan;
       /* init();*/
    }
    
    /**
     *
     */
    public void update() {
         popisMistnosti.setText(plan.getAktualniProstor().dlouhyPopis());
         AnchorPane.setTopAnchor(bod, plan.getAktualniProstor().getY());
         AnchorPane.setLeftAnchor(bod, plan.getAktualniProstor().getX());
                         
    }
    /*
    private void init() {
        obrazekPane = new AnchorPane();
        ImageView obrazek = new ImageView(new Image(Main.class.getResourceAsStream("../zdroje/mapa.png"), 400, 250, false, false));
        bod = new Circle(5,Paint.valueOf("green"));
        obrazekPane.getChildren().addAll(obrazek, bod);
        
        popisMistnosti = new TextArea();
        popisMistnosti.setEditable(false);
        popisMistnosti.setPrefWidth(400);
        
        obal = new HBox();
        obal.getChildren().addAll(popisMistnosti, obrazekPane);
        update(); 
        
    }
    
    public HBox getPanel(){
        return obal;
    } 
    
         /**
     * Metoda zaregistruje pozorovatele k hernímu plánu při spuštění nové hry.
     * 
     * @param plan
     */

    /**
     *
     * @param plan
     */

    public void nastaveniHernihoPlanu (HerniPlan plan){
        this.plan = plan;
        this.update();
    }


   
    
    
    
}
