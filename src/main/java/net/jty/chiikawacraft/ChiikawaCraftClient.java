package net.jty.chiikawacraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.entity.client.chiikawa.ChiikawaModel;
import net.jty.chiikawacraft.entity.client.chiikawa.ChiikawaRenderer;
import net.jty.chiikawacraft.entity.client.hachiware.HachiwareModel;
import net.jty.chiikawacraft.entity.client.hachiware.HachiwareRenderer;
import net.jty.chiikawacraft.entity.client.usagi.UsagiModel;
import net.jty.chiikawacraft.entity.client.usagi.UsagiRenderer;
import net.jty.chiikawacraft.entity.client.yoroi.YoroiModel;
import net.jty.chiikawacraft.entity.client.yoroi.YoroiRenderer;
import net.jty.chiikawacraft.screen.ModScreenHandlers;
import net.jty.chiikawacraft.screen.custom.HealerScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

/**
 * AI Generated Documentation
 * ChiikawaCraftClient is the main client-side initializer for the ChiikawaCraft mod.
 * This class is responsible for registering entity models, renderers, and client-side screens.
 * It implements the ClientModInitializer to ensure proper setup during the client initialization phase.
 */
public class ChiikawaCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ChiikawaModel.CHIIKAWA, ChiikawaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHIIKAWA, ChiikawaRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(HachiwareModel.HACHIWARE, HachiwareModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.HACHIWARE, HachiwareRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(UsagiModel.USAGI, UsagiModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.USAGI, UsagiRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(YoroiModel.YOROI, YoroiModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.YOROI, YoroiRenderer::new);

        HandledScreens.register(ModScreenHandlers.HEALER_SCREEN_HANDLER, HealerScreen::new);


    }
}
