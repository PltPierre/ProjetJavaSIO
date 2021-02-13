package main;

import dao.DaoDriveExpress;
import ihm.*;

public class Main {

    public static void main(String[] args) {
	LoginPage mp = new LoginPage(DaoDriveExpress.SQLConnection(), 0, 0);
	mp.setUndecorated(true);
	mp.setVisible(true);
    }

}