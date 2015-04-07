package carismaserver.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import carismaserver.boundaries.Main;
import carismaserver.entity.UserEntity;

/**
 *
 * @author K-MiL Caster
 */
public class ServerSocket {

    private final int port = 2015;
    public Main ui;
    private Registry server = null;

    public ServerSocket(Main ui) {
        this.ui = ui;
    }

    public void Start() throws UnknownHostException {
        ui.portLabel.setText("" + port);
        ui.iPLabel.setText("" + InetAddress.getLocalHost());
        try {
            server = LocateRegistry.createRegistry(port);

            UserEntity user = new UserEntity(ui);
//            EmployeesServerService employee = new EmployeesServerService(ui);
//            OfficesServerService office = new OfficesServerService(ui);
//            OrderdetailsPKServerService orderDetailsPK = new OrderdetailsPKServerService(ui);
//            OrderdetailsServerService orderDetail = new OrderdetailsServerService(ui);
//            OrdersServerService orders = new OrdersServerService(ui);
//            PaymentsPKServerService paymentsPK = new PaymentsPKServerService(ui);
//            PaymentsServerService payment = new PaymentsServerService(ui);
//            ProductsServerService product = new ProductsServerService(ui);
//            ProductlinesServerService productLines = new ProductlinesServerService(ui);

            server.rebind("userRequest", user);
//            server.rebind("employeeServer", employee);
//            server.rebind("officeServer", office);
//            server.rebind("orderDetailsPKServer", orderDetailsPK);
//            server.rebind("orderDetailServer", orderDetail);
//            server.rebind("ordersServer", orders);
//            server.rebind("paymentsPKServer", paymentsPK);
//            server.rebind("paymentServer", payment);
//            server.rebind("productServer", product);
//            server.rebind("productLinesServer", productLines);

            ui.act.append("Server Started \n");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close() throws RemoteException, NotBoundException {
        server.unbind("customerServer");
//        server.unbind("employeeServer");
//        server.unbind("officeServer");
//        server.unbind("orderDetailsPKServer");
//        server.unbind("orderDetailServer");
//        server.unbind("ordersServer");
//        server.unbind("paymentsPKServer");
//        server.unbind("paymentServer");
//        server.unbind("productServer");
//        server.unbind("productLinesServer");
        ui.act.append("Server Stopped \n");
    }
}
