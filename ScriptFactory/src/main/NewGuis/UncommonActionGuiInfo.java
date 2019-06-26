package main.NewGuis;

import main.Actions.Action;

import java.util.ArrayList;
import java.util.function.Consumer;

public class UncommonActionGuiInfo extends NewStatementGUI {
    public UncommonActionGuiInfo(ArrayList<Action> actionList, Consumer<Integer> updateTextField)
    {
        String[] actionTypes = new String[]{"Comment", "Run subscript"};
        NewStatementGUI.Descriptions[] setDescs = {
                new Descriptions("Enter any text to be your comment."),
                new Descriptions("Enter the name of the subscript (cAsE sEnSiTiVe)")
        };
        initGui("Add new uncommon action", actionList, updateTextField, actionTypes, setDescs);
    }
}
