package com.peculiar.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyButton extends JButton {
  public MyButton(String name) {
    super(name);
    setBorderPainted(false);
    setBorder(BorderFactory.createEtchedBorder());
    setMargin(new Insets(0, 10, 0, 10));
    setFont(new Font("Arial", Font.PLAIN, 23));
    setFont(new java.awt.Font("Roboto", 1, 12));
    setForeground(new Color(255, 255, 255));
    setBackground(new Color(12, 12, 12));
  }
}