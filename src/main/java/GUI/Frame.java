package GUI;

import input.*;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLJPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Frame extends JFrame {
    private InputManager inputManager = new InputManager();
    private JPanel rightPanel = new JPanel();
    private GLJPanel mainPanel;

    public Dimension getDimention(){
        return getSize();
    }
    private Frame(){
        super("Laboratory work №1 by Ilia Volk");
        Util.setFrame(this);
        PointHandler pointHandler = new PointHandler();
        inputManager.setGlEventListener(new GLEventListenerImpl(inputManager.getContext()));
        inputManager.getGlEventListener().addPaintable(pointHandler);
        inputManager.setGlobalMouseListener(new GlobalMouseListener(
                inputManager.getGlEventListener(), inputManager.getContext(), this,
                pointHandler
                ));


        addMouseListener(inputManager.getGlobalMouseListener());
        addMouseMotionListener(inputManager.getGlobalMouseListener());
        GLProfile glProfile = GLProfile.getDefault();
        GLCapabilities capabilities = new GLCapabilities(glProfile);
        mainPanel = new GLJPanel(capabilities);
        mainPanel.addGLEventListener(inputManager.getGlEventListener());


        setSize(960, 640);
        add(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


        createForms();
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
            new Frame();
        });

    }


    void createForms(){
        inputManager.getFormHandler().createForms();
        mainPanel.setLayout(new BorderLayout());
        //mainPanel.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        rightPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.setMinimumSize(new Dimension(100, 300));
        rightPanel.setMaximumSize(new Dimension(100, 300));
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        //color chooser
        JButton colorChooserButton = new JButton("Choose a color");
        final Frame frame = this;
        //color shower
        final JPanel colorShower = new JPanel();
        //colorShower.setLayout(new BoxLayout(colorShower, BoxLayout.Y_AXIS));
        colorShower.setAlignmentX(Component.LEFT_ALIGNMENT);
        colorShower.setForeground(inputManager.getContext().getColor());
        colorShower.setBackground(inputManager.getContext().getColor());
        colorShower.setOpaque(true);
        //color shower ends
        colorChooserButton.addActionListener(e -> {
            Color c = JColorChooser.showDialog(frame,
                    "Choose color", null);
            if(c != null){
                inputManager.getContext().setColor(c);
                colorShower.setForeground(c);
                colorShower.setBackground(c);
                repaint();
            }
        });
        colorChooserButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        colorShower.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(colorShower);
        rightPanel.add(colorChooserButton);

        inputManager.getContext().setColor(Color.BLACK);
        ////////////
        //bk changing color button
        JButton bkChangingButton = new JButton();
        bkChangingButton.setText("Choose bk color");
        bkChangingButton.addActionListener(e ->{
            Color c = JColorChooser.showDialog(frame,
                    "Choose background color", null);
            if(c != null){
                inputManager.getGlEventListener().setBkColor(c);
                repaint();
            }

        });
        bkChangingButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(bkChangingButton);

        //bk ends
        ////////

        //clear button
        JButton clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.addActionListener(e ->{
            inputManager.getGlEventListener().clearPaintable();
            repaint();
        });
        clearButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(clearButton);

        //clear button ends
        ////////
        //ColorMixTypeSelection
        //checkbox
        JCheckBox colorMixEnableCheckbox = new JCheckBox();
        colorMixEnableCheckbox.addItemListener(new
                ColorMixEnableItemListener(colorMixEnableCheckbox, inputManager));
        colorMixEnableCheckbox.addItemListener(e -> repaint());
        colorMixEnableCheckbox.setText("Enable color mix");
        colorMixEnableCheckbox.setSelected(true);
        colorMixEnableCheckbox.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(colorMixEnableCheckbox);
        //checkbox ends


        JLabel colorMixTypeTitle = new JLabel("Color mix type");
        colorMixTypeTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(colorMixTypeTitle);
        JPanel colorMixTypeButtonPanel = new JPanel();

        //JPanel colorMixTypeButtonPanel1 = new JPanel();
        //JPanel colorMixTypeButtonPanel2 = new JPanel();
        int i = 0;
        for (ColorMixRadioButton button : inputManager.getFormHandler().getColorMixButtons()){
            button.addActionListener(e -> repaint());
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            rightPanel.add(button);
            //if (i < 3) colorMixTypeButtonPanel1.add(button);
            //else colorMixTypeButtonPanel2.add(button);
            //i++;
        }
        /*colorMixTypeButtonPanel.add(colorMixTypeButtonPanel1);
        colorMixTypeButtonPanel.add(colorMixTypeButtonPanel2);
        rightPanel.add(colorMixTypeButtonPanel);*/
        //rightPanel.add(colorMixTypeButtonPanel1);
        //rightPanel.add(colorMixTypeButtonPanel2);
        //////////////////////


        //Shape selection
        JLabel shapeTitle = new JLabel("Shapes");
        shapeTitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        rightPanel.add(shapeTitle);
        //JPanel shapeButtonPanel = new JPanel();
        for (ShapeRadioButton button : inputManager.getFormHandler().getShapeButtons()){
            //shapeButtonPanel.add(button);
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            rightPanel.add(button);
        }
        inputManager.getFormHandler().getShapeButtons().get(0).setSelected(true);
        //rightPanel.add(shapeButtonPanel);
        //////////////


        mainPanel.add(rightPanel, BorderLayout.EAST);
    }
}
