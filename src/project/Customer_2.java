
package project;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;


public class Customer_2 extends Agent{
             @Override
             protected void setup() {
                 
              String s = JOptionPane.showInputDialog("Enter the number of orders");
              int x = Integer.parseInt(s);
                 for (int i = 0; i < x; i++) {
                     
                 
                    ACLMessage obj = new ACLMessage();
                    obj.addReceiver(new AID("Factory", false));
                    obj.setContent("Customer_2 ");
                    obj.setPerformative(ACLMessage.REQUEST);
                    send(obj);
                 }
                    addBehaviour(new CyclicBehaviour() {
                @Override
                public void action() {
                    ACLMessage obj1 = receive();
                    if(obj1!=null){
                    if(obj1.getPerformative()==ACLMessage.REJECT_PROPOSAL)
                        {
                            String var= JOptionPane.showInputDialog(obj1.getContent() +
                                                              "\n Enter"
                                                            + "\n 1 to accept"
                                                            + "\n 2 to reject");
                            switch (Integer.parseInt(var))
                            {
                                case (1) : 
                                    JOptionPane.showMessageDialog(null, "Accept");
                                    break;
                                case (2) :
                                    JOptionPane.showMessageDialog(null, "Reject");
                                    break;
                            }
                        }else
                        {
                            String s = obj1.getContent();
                            JOptionPane.showMessageDialog(null, s);
                    
                        }
                    }
                }
            });
                      ACLMessage obj2 = new ACLMessage();
            obj2.addReceiver(new AID("Factory", false));
            obj2.setContent("Can I buy 10 of any product by salary of 8 ? ");
            obj2.setPerformative(ACLMessage.PROPOSE);
            send(obj2);
             }
}

