/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;

class observable{
    String state;
    ArrayList <observer>list=new ArrayList();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
    
       public void addObserver(observer o) {
        this.list.add(o);
       }
       
       public void deleteObserver(observer o) {
         this.list.remove(o);
       }
    
    public void notifyObservers(){
        for(int i=0;i<list.size();i++){
            list.get(i).update(getState());
        }
    }
    
}

 interface observer{
    public void update(String state);
 }
 class obsersve1 implements observer {
    String state;
    @Override
    public void update(String state) {
        this.state=state;
        System.out.println("observer 1 >> "+getState());
    }
     public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
     }
     
 }
class obsersve2 implements observer {
 String state;
    @Override
    public void update(String state) {
        this.state=state;
        System.out.println("observer 2 >> "+getState());
    }
     public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
     
 }


public class ObserverPattern {

    public static void main(String[] args) {
        
      observable o=new observable();
      
      observer A=new obsersve1();
      o.addObserver(A);
      observer B=new obsersve2();
      o.addObserver(B);
      
      o.setState("khaled");
      
    }
    
}
