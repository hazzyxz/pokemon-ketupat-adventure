package data;

import main.GamePanel;
import main.KeyHandler;
import screens.*;

import java.io.*;

public class SaveLoad {

    GamePanel gp;;
    KeyHandler keyH;

    public SaveLoad(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
    }

    public void save(String pathName) {
        try {
            FileOutputStream fileOut = new FileOutputStream(pathName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            DataStorage ds = new DataStorage();
            ds.player = gp.player;
            ds.currentScreen = gp.currentScreen.getCityName();

            out.writeObject(ds);
            out.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String pathName) {
        try {
            FileInputStream fileIn = new FileInputStream(pathName);
            ObjectInputStream in = new ObjectInputStream(fileIn);

            DataStorage ds = (DataStorage) in.readObject();
            gp.player = ds.player;

            // LOAD SCREEN BASED ON cityName
            switch (ds.currentScreen) {
                case "Pallet Town": gp.currentScreen = new PalletTown(gp, keyH); break;
                case "Viridian City": gp.currentScreen = new ViridianCity(gp, keyH); break;
                case "Pewter City": gp.currentScreen = new PewterCity(gp, keyH); break;
                case "Cerulean City": gp.currentScreen = new CeruleanCity(gp, keyH); break;
                case "Lavender Town": gp.currentScreen = new LavenderTown(gp, keyH); break;
                case "Vermillion City": gp.currentScreen = new VermillionCity(gp, keyH); break;
                case "Saffron City": gp.currentScreen = new SaffronCity(gp, keyH); break;
                case "Celadon City": gp.currentScreen = new CeladonCity(gp, keyH); break;
                case "Fuchsia City": gp.currentScreen = new FuchsiaCity(gp, keyH); break;
                case "Cinnabar Island": gp.currentScreen = new CinnabarIsland(gp, keyH); break;
            }


            in.close();


        } catch (FileNotFoundException e) {
            System.out.println("Load File Not Found!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Load Class Not Found!");
        }
    }
}
