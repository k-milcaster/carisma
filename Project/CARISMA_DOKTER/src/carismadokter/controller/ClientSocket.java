package carismadokter.controller;
import carismainterface.server.*;
import carismadokter.boundaries.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author K-MiL Caster
 */
public class ClientSocket {
    public dokterform dokterform;
    private String host = "localhost";
    private int port = 2015;
    public Login login;
    private UserService userService;
//    public Employees employee;
//    public Customers customer;
//    public Offices office;
//    public Orders order;
//    public Payments payment;
//    public ProductLine productLine;
//    public Products products;
    public ClientSocket() throws RemoteException, NotBoundException{
        this.Connect();
    }
    public void Connect(){
        try {
            Registry registry = null;
            try {
                registry = LocateRegistry.getRegistry(host, port);
            } catch (RemoteException ex) {
                Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
            }            
            userService = (UserService) registry.lookup("userRequest");
            
//            EmployeesServices employeeServer = (EmployeesServices) registry.lookup("employeeServer");
//            OfficesServices officeServer = (OfficesServices) registry.lookup("officeServer");
//            OrderdetailsPKServices orderDetailsPKServer = (OrderdetailsPKServices) registry.lookup("orderDetailsPKServer");
//            OrderdetailsServices orderDetailServer = (OrderdetailsServices) registry.lookup("orderDetailServer");
//            OrdersServices ordersServer = (OrdersServices) registry.lookup("ordersServer");
//            PaymentsPKServices paymentsPKServer = (PaymentsPKServices) registry.lookup("paymentsPKServer");
//            PaymentsServices paymentServer = (PaymentsServices) registry.lookup("paymentServer");
//            ProductlinesServices productLinesServer = (ProductlinesServices) registry.lookup("productLinesServer");
//            ProductsServices productsServer = (ProductsServices) registry.lookup("productServer");
//            customer = new Customers(customerServer, host, port, user, pass);
//            employee = new Employees(employeeServer, host, port, user, pass);
//            order = new Orders(ordersServer, orderDetailServer, productsServer, host, port, user, pass);
//            productLine = new ProductLine(productLinesServer, host, port, user, pass);
//            office = new Offices(officeServer, host, port, user, pass);
//            products = new Products(productsServer, host, port, user, pass);
//            opening.connectButton.setEnabled(false);
//            opening.hostField.setEnabled(false);
//            opening.portField.setEnabled(false);
//            opening.passField.setEnabled(false);
//            opening.officesButton.setEnabled(true);
//            opening.customersButton.setEnabled(true);
//            opening.employeesButton.setEnabled(true);
//            opening.pLButton.setEnabled(true);
//            opening.productsButton.setEnabled(true);
//            opening.ordersButton.setEnabled(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public UserService getUserService(){
        return this.userService;
    }
}
