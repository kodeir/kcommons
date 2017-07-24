package com.kodeir.kcommons.swing;

import java.awt.*;

public class KSwingCommons {

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy){
        return setConstraintsHorizontal(weightx, gridx, gridy, 1);
    }

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy, int gridwidth){
        return setConstraintsHorizontal(weightx, gridx, gridy, gridwidth, 1);
    }

    public static GridBagConstraints setConstraintsHorizontal(double weightx, int gridx, int gridy, int gridwidth, int gridheight){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = weightx;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.ipady = 5;
        return constraints;
    }

    public static void setSize(Component component, int width, int height){
        component.setMinimumSize(new Dimension(width,height));
        component.setMaximumSize(new Dimension(width,height));
        component.setPreferredSize(new Dimension(width,height));
    }

}
