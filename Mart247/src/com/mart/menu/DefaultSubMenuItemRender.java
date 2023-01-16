package com.mart.menu;

import java.awt.Component;

import com.mart.menu.Menu;
import com.mart.menu.ModelSubMenu;
import com.mart.menu.SubMenuItem;
import com.mart.menu.SubMenuItemRender;

public class DefaultSubMenuItemRender implements SubMenuItemRender {

    @Override
    public Component getSubMenuItemreder(Menu menu, ModelSubMenu data) {
        SubMenuItem item = new SubMenuItem(data.getName());
        if (data.getIcon() != null) {
            item.setIcon(data.getIcon());
        }
        return item;
    }
}
