package com.mart.menu;

import java.awt.Component;

import com.mart.menu.MainForm;
import com.mart.menu.MenuItem;

public interface EventMenu {

    public void mainMenuSelected(MainForm mainForm, int index, MenuItem menuItem);

    public void subMenuSelected(MainForm mainForm, int index, int subMenuIndex, Component menuItem);
}
