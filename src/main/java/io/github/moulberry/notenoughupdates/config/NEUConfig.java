package io.github.moulberry.notenoughupdates.config;

import com.google.gson.annotations.Expose;
import io.github.moulberry.notenoughupdates.NotEnoughUpdates;
import io.github.moulberry.notenoughupdates.config.special.Hidden;
import io.github.moulberry.notenoughupdates.config.special.HiddenProfileSpecific;
import io.github.moulberry.notenoughupdates.core.GuiScreenElementWrapper;
import io.github.moulberry.notenoughupdates.core.config.Config;
import io.github.moulberry.notenoughupdates.core.config.Position;
import io.github.moulberry.notenoughupdates.core.config.annotations.*;
import io.github.moulberry.notenoughupdates.core.config.gui.GuiPositionEditor;
import io.github.moulberry.notenoughupdates.miscgui.GuiEnchantColour;
import io.github.moulberry.notenoughupdates.miscgui.GuiInvButtonEditor;
import io.github.moulberry.notenoughupdates.miscgui.NEUOverlayPlacements;
import io.github.moulberry.notenoughupdates.config.settings.*;
import io.github.moulberry.notenoughupdates.overlays.*;
import io.github.moulberry.notenoughupdates.util.SBInfo;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

public class NEUConfig extends Config {

    private void editOverlay(String activeConfig, TextOverlay overlay, Position position) {
        Vector2f size = overlay.getDummySize();
        int width = (int)size.x;
        int height = (int)size.y;
        Minecraft.getMinecraft().displayGuiScreen(new GuiPositionEditor(position, width, height, () -> {
            overlay.renderDummy();
            OverlayManager.dontRenderOverlay = overlay.getClass();
        }, () -> {
        }, () -> NotEnoughUpdates.INSTANCE.openGui = new GuiScreenElementWrapper(
                new NEUConfigEditor(NotEnoughUpdates.INSTANCE.config, activeConfig))
        ));
    }

    @Override
    public void executeRunnable(int runnableId) {
        String activeConfigCategory = null;
        if(Minecraft.getMinecraft().currentScreen instanceof GuiScreenElementWrapper) {
            GuiScreenElementWrapper wrapper = (GuiScreenElementWrapper) Minecraft.getMinecraft().currentScreen;
            if(wrapper.element instanceof NEUConfigEditor) {
                activeConfigCategory = ((NEUConfigEditor)wrapper.element).getSelectedCategoryName();
            }
        }
        final String activeConfigCategoryF = activeConfigCategory;

        switch (runnableId) {
            case 0:
                ClientCommandHandler.instance.executeCommand(Minecraft.getMinecraft().thePlayer, "/neumap");
                return;
            case 1:
                editOverlay(activeConfigCategory, OverlayManager.miningOverlay, mining.overlayPosition);
                return;
            case 2:
                Minecraft.getMinecraft().displayGuiScreen(new GuiPositionEditor(
                        NotEnoughUpdates.INSTANCE.config.mining.drillFuelBarPosition,
                        NotEnoughUpdates.INSTANCE.config.mining.drillFuelBarWidth, 12, () -> {
                }, () -> {
                }, () -> NotEnoughUpdates.INSTANCE.openGui = new GuiScreenElementWrapper(
                        new NEUConfigEditor(NotEnoughUpdates.INSTANCE.config, activeConfigCategoryF))
                ));
                return;
            case 3:
                editOverlay(activeConfigCategory, OverlayManager.farmingOverlay, skillOverlays.farmingPosition);
                return;
            case 4:
                editOverlay(activeConfigCategory, OverlayManager.petInfoOverlay, petOverlay.petInfoPosition);
                return;
            case 5:
                editOverlay(activeConfigCategory, OverlayManager.timersOverlay, miscOverlays.todoPosition);
                return;
            case 6:
                NotEnoughUpdates.INSTANCE.openGui = new NEUOverlayPlacements();
                return;
            case 7:
                NotEnoughUpdates.INSTANCE.openGui = new GuiInvButtonEditor();
                return;
            case 8:
                NotEnoughUpdates.INSTANCE.openGui = new GuiEnchantColour();
                return;

        }
    }

    @Expose
    @Category(
            name = "Misc",
            desc = "Miscellaneous options which don't fit into any other category"
    )
    public Misc misc = new Misc();

    @Expose
    @Category(
            name = "Notifications",
            desc = "Notifications"
    )
    public Notifications notifications = new Notifications();

    @Expose
    @Category(
            name = "Item List",
            desc = "Item List"
    )
    public Itemlist itemlist = new Itemlist();

    @Expose
    @Category(
            name = "Toolbar",
            desc = "Toolbar"
    )
    public Toolbar toolbar = new Toolbar();

    @Expose
    @Category(
            name = "Inventory Buttons",
            desc = "Inventory Buttons"
    )
    public InventoryButtons inventoryButtons = new InventoryButtons();


    @Expose
    @Category(
            name = "Slot Locking",
            desc = "Slot Locking"
    )
    public SlotLocking slotLocking = new SlotLocking();

    @Expose
    @Category(
            name = "Tooltip Tweaks",
            desc = "Tooltip Tweaks"
    )
    public TooltipTweaks tooltipTweaks = new TooltipTweaks();

    @Expose
    @Category(
            name = "Item Overlays",
            desc = "Item Overlays"
    )
    public ItemOverlays itemOverlays = new ItemOverlays();

    @Expose
    @Category(
            name = "Skill Overlays",
            desc = "Skill Overlays"
    )
    public SkillOverlays skillOverlays = new SkillOverlays();

    @Expose
    @Category(
            name = "Misc Overlays",
            desc = "Misc Overlays"
    )
    public MiscOverlays miscOverlays = new MiscOverlays();

    @Expose
    @Category(
            name = "Storage GUI",
            desc = "Storage GUI"
    )
    public StorageGUI storageGUI = new StorageGUI();

    @Expose
    @Category(
            name = "Dungeons",
            desc = "Dungeons"
    )
    public Dungeons dungeons = new Dungeons();


    @Expose
    @Category(
            name = "Enchanting GUI/Solvers",
            desc = "Enchanting GUI/Solvers"
    )
    public Enchanting enchantingSolvers = new Enchanting();

    @Expose
    @Category(
            name = "Mining",
            desc = "Mining"
    )
    public Mining mining = new Mining();


    @Expose
    @Category(
            name = "Fishing",
            desc = "Fishing"
    )
    public Fishing fishing = new Fishing();

    @Expose
    @Category(
            name = "NEU Auction House",
            desc = "NEU Auction House"
    )
    public NeuAuctionHouse neuAuctionHouse = new NeuAuctionHouse();

    @Expose
    @Category(
            name = "Improved SB Menus",
            desc = "Improved SB Menus"
    )
    public ImprovedSBMenu improvedSBMenu = new ImprovedSBMenu();

    @Expose
    @Category(
            name = "Calendar",
            desc = "Calendar"
    )
    public Calendar calendar = new Calendar();

    @Expose
    @Category(
            name = "Trade Menu",
            desc = "Trade Menu"
    )
    public TradeMenu tradeMenu = new TradeMenu();

    @Expose
    @Category(
            name = "Pet Overlay",
            desc = "Pet Overlay"
    )
    public PetOverlay petOverlay = new PetOverlay();

    @Expose
    @Category(
            name = "AH Search GUI",
            desc = "AH Search GUI"
    )
    public AuctionHouseSearch auctionHouseSearch = new AuctionHouseSearch();

    @Expose
    @Category(
            name = "Accessory Bag Overlay",
            desc = "Accessory Bag Overlay"
    )
    public AccessoryBag accessoryBag = new AccessoryBag();

    @Expose
    @Category(
            name = "Api Key",
            desc = "Api Key"
    )
    public ApiKey apiKey = new ApiKey();

    @Expose
    public Hidden hidden = new Hidden();

    @Expose
    public DungeonMapConfig dungeonMap = new DungeonMapConfig();


    public HiddenProfileSpecific getProfileSpecific() {
        if(SBInfo.getInstance().currentProfile == null) {
            return null;
        }
        return hidden.profileSpecific.computeIfAbsent(SBInfo.getInstance().currentProfile, k-> new HiddenProfileSpecific());
    }



}
