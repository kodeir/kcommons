package com.kodeir.kcommons.swing;

import java.awt.*;

public class KSwingCommons {

    public static GridBagConstraints setConstraintsHorizontal(int gridx, int gridy){
        return setConstraintsHorizontal(gridx, gridy, 0.5 , 0.5);
    }

    public static GridBagConstraints setConstraintsHorizontal(int gridx, int gridy, double weightx, double weighty){
        return setConstraintsHorizontal(gridx, gridy, weightx , weighty, 1, 1);
    }

    /**
     *
     * Creates GridBagConstraints with HORIZONTAl fill
     *
     * @param gridx row
     * @param gridy column
     * @param weightx space among columns
     * @param weighty space among rows
     *
     *                From https://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html:
     *                Generally weights are specified with 0.0 and 1.0 as the extremes:
     *                 the numbers in between are used as necessary.
     *                Larger numbers indicate that the component's row or column should get more space.
     *                For each column, the weight is related to the highest weightx specified for a component within that column,
     *                 with each multicolumn component's weight being split somehow between the columns the component is in.
     *                Similarly, each row's weight is related to the highest weighty specified for a component within that row.
     *                Extra space tends to go toward the rightmost column and bottom row.
     *
     * @param gridwidth number of columns
     * @param gridheight number of rows
     * @return
     */
    public static GridBagConstraints setConstraintsHorizontal(int gridx, int gridy, double weightx, double weighty, int gridwidth, int gridheight){
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.weightx = weightx;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.gridwidth = gridwidth;
        constraints.gridheight = gridheight;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.ipadx = 5;
        constraints.ipady = 5;
        return constraints;
    }

    /**
     * Set size for AWT Component using three methods as it recommended in manuals
     * @param component
     * @param width
     * @param height
     */
    public static void setSize(Component component, int width, int height){
        component.setMinimumSize(new Dimension(width,height));
        component.setMaximumSize(new Dimension(width,height));
        component.setPreferredSize(new Dimension(width,height));
    }

}
