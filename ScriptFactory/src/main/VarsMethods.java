package main;

import main.Actions.Action;
import main.Actions.Logic.Endif;
import main.Actions.Logic.If;
import main.Actions.Logic.InverseIf;
import org.parabot.core.ui.Logger;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class VarsMethods {
    public static int tickSpeed = 1200;
    public String currentAction = "";
    public final static String CACHED_LOC = "ScriptFactory cache.txt";

    public static void log(String str)
    {
        Logger.addMessage(str, false);
        System.out.println(str);
    }

    public static void loadscript(ArrayList<Action> actions, File selectedFile) {
        actions.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(selectedFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                switch (line.split(" ")[0])
                {
                    case "If":
                        actions.add(new If(line));
                        break;
                    case "InverseIf":
                        actions.add(new InverseIf(line));
                        break;
                    case "Endif":
                        actions.add(new Endif(line));
                        break;
                    default:
                        actions.add(new Action(line));
                }
            }
            log("File loaded successfully");
        } catch (FileNotFoundException ignored) {
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void savescript(ArrayList<Action> actions, File selectedFile) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(selectedFile);

            for (Action a : actions)
            {
                writer.println(a.toString());
            }
            writer.close();
            log("File saved successfully");
        } catch (FileNotFoundException ignored) {
        }
    }

    public static JPanel centralizeComponent(Component component)
    {
        JPanel centralizer = new JPanel();
        centralizer.setLayout(new FlowLayout(FlowLayout.CENTER));
        centralizer.add(component);

        return centralizer;
    }
}
