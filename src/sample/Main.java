package sample;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {


    private static double trys = 0;
    static JFrame frame;

    public static void main(String[] args)  {

        frame = new JFrame("An usefull App");

        frame.setSize(200, 200);
        frame.addNotify();
        Dimension d = new Dimension();
        d.setSize(200, 200);
        Dimension x = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(((int)x.getWidth() / 2)  - 200, ((int)x.getHeight() / 2) - 200, 200, 200);

        frame.setMinimumSize(d);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        JTextField txt = new JTextField();
        txt.setBounds(100, 100, 50, 50);
        new Thread() {
            int counter = 10;
            public void run() {
                while(counter >= 0) {
                    txt.setText("" +  (counter--));
                    try{
                        Thread.sleep(1000);
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        frame.add(txt);
        frame.pack();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        frame.dispose();
        for(int i = 0; i < 2; i++){
            try {
                i--;
                trys++;

                //Opens You got Jebaited
                openWebpage(new URL("https://www.youtube.com/embed/tEo9sqzX1lQ?autoplay=1"));
                //Random delay from 1.7-6.7 seconds between Jebaited
                long delay = (int)(Math.random() * 5000 )+1700;
                System.out.println("You got " + (int)trys + " times jebaited: " + delay + "ms");
                Thread.sleep(delay);

            } catch (MalformedURLException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void openWebpage(URI uri) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(uri);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
