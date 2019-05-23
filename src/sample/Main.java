package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {


    private static double trys;

    public static void main(String[] args)
    {

        for(int i = 0; i < 2; i++){
            try {
                i--;
                trys++;
                System.out.println("You got " + (int)trys + " times jebaited");
                openWebpage(new URL("https://www.youtube.com/embed/tEo9sqzX1lQ?autoplay=1"));
                Thread.sleep(1700);
            } catch (MalformedURLException | InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    public static boolean openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }
}
