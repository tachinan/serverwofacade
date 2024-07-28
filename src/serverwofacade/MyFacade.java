/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverwofacade;

/**
 *
 * @author user
 */
public class MyFacade {
    private static MyFacade myFacadeObj = null;
    private MyFacade(){}
    public static MyFacade getMyFacadeObject(){
        if (myFacadeObj == null){
            myFacadeObj = new MyFacade();
        }
        return myFacadeObj;
    }
    
    public void startServer() {
        ScheduleServer obj = new ScheduleServer();
        obj.startBooting();
        obj.readSystemConfigFile();
        obj.init();
        obj.initializeContext();
        obj.initializeListeners();
        obj.createSystemObjects();
        System.out.println("Start working......");
    }

    public void stopServer() {
        ScheduleServer obj = new ScheduleServer();
        System.out.println("After work done.........");
        obj.releaseProcesses();
        obj.destory();
        obj.destroySystemObjects();
        obj.destoryListeners();
        obj.destoryContext();
        obj.shutdown();
    }
}
