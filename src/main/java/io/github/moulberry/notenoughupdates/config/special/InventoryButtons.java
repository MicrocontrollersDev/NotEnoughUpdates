package io.github.moulberry.notenoughupdates.config.special;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class InventoryButtons {
    public static List<InventoryButton> createDefaultInventoryButtons() {
        List<InventoryButton> buttons = new ArrayList<>();
        //Below crafting
        buttons.add(new InventoryButton(87, 63, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21, 63, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21*2, 63, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21*3, 63, null, true, false, false, 0, ""));

        //Above crafting
        buttons.add(new InventoryButton(87, 5, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21, 5, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21*2, 5, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+21*3, 5, null, true, false, false, 0, ""));

        //Crafting square
        buttons.add(new InventoryButton(87, 25, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+18, 25, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87, 25+18, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(87+18, 25+18, null, true, false, false, 0, ""));

        //Crafting result
        buttons.add(new InventoryButton(143, 35, null, true, false, false, 0, ""));

        //Player menu area
        buttons.add(new InventoryButton(60, 8, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(60, 60, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(26, 8, null, true, false, false, 0, ""));
        buttons.add(new InventoryButton(26, 60, null, true, false, false, 0, ""));

        //Right side
        for(int i=0; i<8; i++) {
            int y = 2+20*i;
            if(y < 80) {
                buttons.add(new InventoryButton(2, 2+20*i, null, false, true, false, 0, ""));
            } else {
                buttons.add(new InventoryButton(2, 2+20*i-166, null, false, true, true, 0, ""));
            }
        }

        //Top side
        for(int i=0; i<8; i++) {
            buttons.add(new InventoryButton(4+21*i, -19, null, false, false, false, 0, ""));
        }

        //Left side
        for(int i=0; i<8; i++) {
            int y = 2+20*i;
            if(y < 80) {
                buttons.add(new InventoryButton(-19, 2+20*i, null, false, false, false, 0, ""));
            } else {
                buttons.add(new InventoryButton(-19, 2+20*i-166, null, false, false, true, 0, ""));
            }
        }

        //Bottom side
        for(int i=0; i<8; i++) {
            buttons.add(new InventoryButton(4+21*i, 2, null, false, false, true, 0, ""));
        }
        return buttons;
    }

    public static class InventoryButton {
        @Expose
        public int x;
        @Expose public int y;
        @Expose public boolean playerInvOnly;

        @Expose public boolean anchorRight;
        @Expose public boolean anchorBottom;

        @Expose public int backgroundIndex;
        @Expose public String command;
        @Expose public String icon;

        public boolean isActive() {
            return command.trim().length() > 0;
        }

        public InventoryButton(int x, int y, String icon, boolean playerInvOnly, boolean anchorRight, boolean anchorBottom, int backgroundIndex, String command) {
            this.x = x;
            this.y = y;
            this.icon = icon;
            this.playerInvOnly = playerInvOnly;
            this.anchorRight = anchorRight;
            this.anchorBottom = anchorBottom;
            this.backgroundIndex = backgroundIndex;
            this.command = command;
        }
    }
}
