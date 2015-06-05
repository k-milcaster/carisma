package carismaadministrator.controller;

import java.io.File;
import carismaadministrator.boundary.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.UIManager;

/**
 *
 * @author K-MiL Caster
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
        if (new File("D:/carismaconfig").exists()) {
            Scanner s = null;
            try {
                s = new Scanner(new File("D:/carismaconfig"));
            } catch (FileNotFoundException ex) {

            }
            ArrayList<String> list = new ArrayList<String>();
            while (s.hasNext()) {
                list.add(s.next());
            }
            s.close();
            return list.size() == 2;
        } else {
            return false;
        }

    }
}
