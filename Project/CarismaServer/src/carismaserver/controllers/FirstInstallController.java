package carismaserver.controllers;

import carismaserver.boundaries.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.UIManager;

/**
 *
 * @author kepoterz
 */
public class FirstInstallController {
    
    public static void main(String[] args) throws NotBoundException, RemoteException, IOException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Look & Feel exception");
        }
        if (fileCheck()) {
            new Login().setVisible(true);
        } else {
            new FirstInstall().setVisible(true);
        }
    }
    
    private static boolean fileCheck() {
        if (new File("D:/carismaserverconfig").exists()) {
            Scanner s = null;
            try {
                s = new Scanner(new File("D:/carismaserverconfig"));
            } catch (FileNotFoundException ex) {

            }
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.next());
            }
            s.close();
            return list.size() >= 5;
        } else {
            return false;
        }

    }
}
