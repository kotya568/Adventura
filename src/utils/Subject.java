/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 * @author     Jekaterina Krivenchuk
 * @version    ZS 2017
 */
public interface Subject {
    
    /**
     *
     * @param observer
     */
    void registerObserver (Observer observer);
    
    /**
     *
     * @param observer
     */
    void deleteObserver (Observer observer);
    
    /**
<<<<<<< HEAD
     *Upozorni všechny pozorovatele
=======
     *
>>>>>>> 48f6d711570cbdf19daa560979a04daf86a7b8f5
     */
    void notifyAllObservers ();
    
}
