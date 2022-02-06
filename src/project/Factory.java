
package project;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import javax.swing.JOptionPane;


public class Factory extends Agent{
    double product1_price;
    double product2_price;
    double product3_price;
    
    double Customer1_balance;
    double Customer2_balance;
    double Customer3_balance;
    
    double product1_quantity;
    double product2_quantity;
    double product3_quantity;
    int counter=0;
    int num1;
    int num;
    int num2;
    public Factory() 
    {
        product1_price = 100;
        product1_quantity = 50;
        
        product2_price = 200;
        product2_quantity = 30;
        
        product3_price = 50 ; 
        product3_quantity = 100;
        
        Customer1_balance = 1000;
        Customer2_balance = 1000;
        Customer3_balance = 1000;
    }
    
    public void setdata()
    {
        
        String s1 = JOptionPane.showInputDialog("Enter the number of product");
         num1 = Integer.parseInt(s1);
        
        String s = JOptionPane.showInputDialog("Enter the quantity of the product");
         num = Integer.parseInt(s);

        
        
    }
    
    @Override
    protected void setup() {
        
        
        addBehaviour(new CyclicBehaviour() {
            @Override
            
            public void action() {
                
                ACLMessage obj = receive();
                if (obj!=null)
                {
                    if (obj.getPerformative()==ACLMessage.PROPOSE) {
                        
                        String var = JOptionPane.showInputDialog(obj.getContent()+"\nEnter\n 1 to accept\n "
                                + "2 to reject");
                        int m = Integer.parseInt(var);
                        switch(m)
                        {
                            case (1) : 
                                    ACLMessage obj6 = new ACLMessage();
                                    obj6.addReceiver(new AID(obj.getSender().getLocalName(),false));
                                    obj6.setContent("Accept");
                                    obj6.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                    send(obj6);
// JOptionPane.showMessageDialog(null,"Accept");
                                break;
                            case (2) :
                                ACLMessage obj7 = new ACLMessage();
                                    obj7.addReceiver(new AID(obj.getSender().getLocalName(),false));
                                    obj7.setContent(" Rejected!!\n"
                                                                   +"There is an offer!!!\n"
                                                                   + "Product 1 is " + (product1_price - (product1_price*.05)) 
                                                                   + "\nProduct 2 is " + (product2_price-(product2_price*.05))
                                                                   + "\nProduct 3 is " + (product3_price-(product3_price*.05)));
                                    obj7.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                    send(obj7);
                                /*JOptionPane.showMessageDialog(null, " Rejected!!\n"
                                                                   +"There is an offer!!!\n"
                                                                   + "Product 1 is " + (product1_price-5) 
                                                                   + "\nProduct 2 is " + (product2_price-5)
                                                                   + "\nProduct 3 is " + (product3_price-5));
                        */
                                    break;
                        }
                         
                    }
                    else
                {
                    
                
                    setdata();
                  
                    //// CSTOMER 1/////////////////////////
                    if(obj.getSender().getLocalName().equals("Customer_1"))
                    {
                      
                        
                        switch (num1)
                        {
                            ///// PRODUCT 1 ///////////////
                            case (1) :
                                if(num<=product1_quantity)
                                {
                                    if(Customer1_balance>=(product1_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer1_balance );
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                        
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product1_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                
                                case (2) :
                                    /////// PRODUCT 2 //////////////////////////
                                if(num<=product2_quantity)
                                {
                                    if(Customer1_balance>=(product2_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product2_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                
                                case (3) :
                                    ///////////// PRODUCT 3 ////////////////
                                if(num<=product3_quantity)
                                {
                                    if(Customer1_balance>=(product3_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        Customer1_balance = Customer1_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer1_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_1", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product3_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                
                                default: 
                                    JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        //////////////// CUSTOMER 2 /////////////////////
                    } else if(obj.getSender().getLocalName().equals("Customer_2"))
                    {
                     //   String s = obj.getContent();
                     //   JOptionPane.showMessageDialog(null, s);
                        
                        switch (num1)
                        {
                            /////////////// PRODUCT 1 ////////////////////
                            case (1) :
                                if(num<=product1_quantity)
                                {
                                    if(Customer2_balance>=(product1_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product1_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                 ////////////// PRODUCT 2 ///////////////////////
                                case (2) :
                                if(num<=product2_quantity)
                                {
                                    if(Customer2_balance>=(product2_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product2_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                    ///// PRODUCT 3 ///////////////////////////
                                case (3) :
                                if(num<=product3_quantity)
                                {
                                    if(Customer2_balance>=(product3_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        Customer2_balance = Customer2_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer2_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_2", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product3_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                
                                default: 
                                    JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    } 
                        /////////////// CUSTOMER 3 ///////////////////////
                    else if(obj.getSender().getLocalName().equals("Customer_3"))
                    {
                     //   String s = obj.getContent();
                     //   JOptionPane.showMessageDialog(null, s);
                        
                        switch (num1)
                        {
                            //////////// PRODUCT 1 //////////////////
                            case (1) :
                                if(num<=product1_quantity)
                                {
                                    if(Customer3_balance>=(product1_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product1_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product1_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product1_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                ///////////// PRODUCUT 2 //////////////////
                                case (2) :
                                if(num<=product2_quantity)
                                {
                                    if(Customer3_balance>=(product2_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product2_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product2_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product2_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                ///////////////// PRODUCT 3 ////////////////////
                                case (3) :
                                if(num<=product3_quantity)
                                {
                                    if(Customer3_balance>=(product3_price*num) )
                                    {
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else if( counter<2)
                                    {
                                        counter++;
                                        obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        Customer3_balance = Customer3_balance - (product3_price*num);
                                        obj.setContent("Approved\n"
                                                + "The salary of products is " + (product3_price*num) 
                                                + "\n The balance is " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                        
                                        send(obj);
                                    }
                                    else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"Your balance isn't enough"
                                                + "Your balance is : " + Customer3_balance);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                }
                                else 
                                    {
                                         obj = new ACLMessage();
                                        obj.addReceiver(new AID("Customer_3", false));
                                        
                                        obj.setContent("Refused\n"
                                                +"The quantity isn't enough\n"
                                                + "The quantity is " + product3_quantity);
                                        obj.setPerformative(ACLMessage.REFUSE);
                                        send(obj);
                                    }
                                break;
                                
                                default: 
                                    JOptionPane.showMessageDialog(null, "ERROR");
                        }
                    }
                                                 
                }
                }
            }
        });
        }

        
        }
