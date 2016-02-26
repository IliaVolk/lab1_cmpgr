package input;

import GUI.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorMixEnableItemListener implements ItemListener {
    private JCheckBox checkBox;
    private InputManager inputManager;
    public ColorMixEnableItemListener(JCheckBox checkBox, InputManager inputManager){
        this.checkBox = checkBox;
        this.inputManager = inputManager;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
            for(ColorMixRadioButton button : inputManager.getFormHandler().getColorMixButtons()){
                button.setEnabled(checkBox.isSelected());
            }
        inputManager.getContext().setColorMixDisabled(!checkBox.isSelected());
    }
}
