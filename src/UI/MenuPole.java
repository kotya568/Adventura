/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

/**
 *
 * @author krij02
 */
public class MenuPole extends MenuBar{
   public MenuPole(){
         init();
 }

    
    private void init() {
        Menu menuSoubor = new Menu("Adventura");
        
        MenuItem itemNovaHra = new MenuItem("Nova hra");
        ///MenuItem itemNovaHra = new MenuItem(new Image("Nova hra", new ImageView(Main.class.getRsourceAsStream("/zdroje/ikona.png"))));
        itemNovaHra.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        MenuItem itemKonec = new MenuItem("Konec");
        
        menuSoubor.getItems().addAll(itemNovaHra, itemKonec);
        this.getMenus().addAll(menuSoubor);
        itemKonec.setOnAction(new EventHandler<ActionEvent>(){
        
        
        }
                
                
                
                
                ;
                
    }
    
   
   
   
   
   
   
   
   
   
   
   
}
   

