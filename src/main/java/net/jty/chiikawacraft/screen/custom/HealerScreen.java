package net.jty.chiikawacraft.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.jty.chiikawacraft.ChiikawaCraft;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * AI Generated Documentation
 * Study only, Not Implemented in final game
 * HealerScreen is a graphical user interface (GUI) class responsible for rendering
 * the client-side interface of the Healer Screen in the ChiikawaCraft mod. It extends
 * the HandledScreen class and ties to the HealerScreenHandler for managing interactions
 * with the related inventory and block entity.
 *
 * This class handles:
 * - Rendering the background texture of the Healer GUI.
 * - Displaying tooltips for items when hovered over.
 *
 * Key Features:
 * - Utilizes a custom GUI texture for rendering the background.
 * - Properly positions the GUI relative to the screen.
 * - Draws tooltips dynamically based on the player's interactions.
 *
 * Methods:
 * - Constructor: Initializes the HealerScreen with a HealerScreenHandler, player inventory, and screen title.
 * - drawBackground: Renders the static background texture for the Healer GUI.
 * - render: Manages rendering of the screen, including background, tooltips, and dynamic components.
 */
public class HealerScreen extends HandledScreen<HealerScreenHandler> {
    public static final Identifier GUI_TEXTURE =
            Identifier.of(ChiikawaCraft.MOD_ID, "textures/gui/healer/healer_gui.png");

    public HealerScreen(HealerScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);
    }
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}