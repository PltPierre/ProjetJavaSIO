package main;

import dao.DaoDriveExpress;
import ihm.*;

public class Main {

    public static void main(String[] args) {
	MainPage mp = new MainPage(DaoDriveExpress.SQLConnection(),0,0);
	mp.setUndecorated(true);
	mp.setVisible(true);
    }

}