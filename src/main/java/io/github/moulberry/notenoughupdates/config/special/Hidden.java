package io.github.moulberry.notenoughupdates.config.special;

import com.google.common.collect.Lists;
import com.google.gson.annotations.Expose;
import io.github.moulberry.notenoughupdates.config.NEUConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hidden {
    @Expose
    public HashMap<String, HiddenProfileSpecific> profileSpecific = new HashMap<>();
    @Expose public List<InventoryButtons.InventoryButton> inventoryButtons = InventoryButtons.createDefaultInventoryButtons();

    @Expose public boolean enableItemEditing = false;
    @Expose public boolean cacheRenderedItempane = true;
    @Expose public boolean autoupdate = true;
    @Expose public String overlaySearchBar = "";
    @Expose public String overlayQuickCommand = "";
    @Expose public boolean dev = false;
    @Expose public boolean loadedModBefore = false;
    @Expose public String selectedCape = null;
    @Expose public int compareMode = 0;
    @Expose public int sortMode = 0;
    @Expose public ArrayList<Boolean> compareAscending = Lists.newArrayList(true, true, true);
    @Expose public ArrayList<String> favourites = new ArrayList<>();
    @Expose public ArrayList<String> previousAuctionSearches = new ArrayList<>();
    @Expose public ArrayList<String> eventFavourites = new ArrayList<>();
    @Expose public ArrayList<String> quickCommands = createDefaultQuickCommands();
    @Expose public ArrayList<String> enchantColours = Lists.newArrayList(
            "[a-zA-Z\\- ]+:\u003e:9:6:0",
            "[a-zA-Z\\- ]+:\u003e:6:c:0",
            "[a-zA-Z\\- ]+:\u003e:5:5:0",
            "Experience:\u003e:3:5:0",
            "Life Steal:\u003e:3:5:0",
            "Scavenger:\u003e:3:5:0",
            "Looting:\u003e:3:5:0");
    @Expose public String repoURL = "https://github.com/Moulberry/NotEnoughUpdates-REPO/archive/master.zip";
    @Expose public String repoCommitsURL = "https://api.github.com/repos/Moulberry/NotEnoughUpdates-REPO/commits/master";

    private static ArrayList<String> createDefaultQuickCommands() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("/warp home:Warp Home:eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzljODg4MWU0MjkxNWE5ZDI5YmI2MWExNmZiMjZkMDU5OTEzMjA0ZDI2NWRmNWI0MzliM2Q3OTJhY2Q1NiJ9fX0=");
        arr.add("/warp hub:Warp Hub:eyJ0aW1lc3RhbXAiOjE1NTkyMTU0MTY5MDksInByb2ZpbGVJZCI6IjQxZDNhYmMyZDc0OTQwMGM5MDkwZDU0MzRkMDM4MzFiIiwicHJvZmlsZU5hbWUiOiJNZWdha2xvb24iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2Q3Y2M2Njg3NDIzZDA1NzBkNTU2YWM1M2UwNjc2Y2I1NjNiYmRkOTcxN2NkODI2OWJkZWJlZDZmNmQ0ZTdiZjgifX19");
        arr.add("/warp dungeon_hub:Dungeon Hub:eyJ0aW1lc3RhbXAiOjE1Nzg0MDk0MTMxNjksInByb2ZpbGVJZCI6IjQxZDNhYmMyZDc0OTQwMGM5MDkwZDU0MzRkMDM4MzFiIiwicHJvZmlsZU5hbWUiOiJNZWdha2xvb24iLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzliNTY4OTViOTY1OTg5NmFkNjQ3ZjU4NTk5MjM4YWY1MzJkNDZkYjljMWIwMzg5YjhiYmViNzA5OTlkYWIzM2QiLCJtZXRhZGF0YSI6eyJtb2RlbCI6InNsaW0ifX19fQ==");
        arr.add("/craft:Crafting Table:CRAFTING_TABLE");
        arr.add("/storage:Storage:CHEST");
        arr.add("/wardrobe:Wardrobe:LEATHER_CHESTPLATE");
        arr.add("/pets:Pets:BONE");
        arr.add("neuah:NEU Auction House:GOLD_BLOCK");
        arr.add("/bz:Bazaar:GOLD_BARDING");
        return arr;
    }
}
