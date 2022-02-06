
package project;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Project {
    
    public static void main(String[] args) {
        String s;
        int num;    
        jade.core.Runtime r = jade.core.Runtime.instance();
        Profile p = new ProfileImpl("localhost", 10000, "Factory");
        ContainerController main1 = r.createMainContainer(p);
        try {
            AgentController rma = main1.createNewAgent("rma", "jade.tools.rma.rma", null);
            rma.start();

            s = JOptionPane.showInputDialog("Enter the customer which you want to use!!"
                    + "\n 1- Customer_1"
                    + "\n 2- Customer_2"
                    + "\n 3- Customer_3");
            num = Integer.parseInt(s);
            



            switch(num)
            {
                case (1) : 
                    AgentController Customer_1 = main1.createNewAgent("Customer_1", "project.Customer_1", null);
                    AgentController Factory = main1.createNewAgent("Factory", "project.Factory", null);

                    Customer_1.start();
                        
                    Factory.start();
                    break;
                    
                case (2) : 
            
                    AgentController Customer_2 = main1.createNewAgent("Customer_2", "project.Customer_2", null);
                    AgentController Factory1 = main1.createNewAgent("Factory", "project.Factory", null);

                    Customer_2.start();
                    
                    Factory1.start();
                    break;
                    
                case (3) : 
            AgentController Customer_3 = main1.createNewAgent("Customer_3", "project.Customer_3", null);
                     
            AgentController Factory2 = main1.createNewAgent("Factory", "project.Factory", null);

                    Customer_3.start();
                    
                    Factory2.start();
                    break;    
                
                
                default:
                    JOptionPane.showMessageDialog(null, "Invalid number");
            }
                    
        } catch (StaleProxyException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
