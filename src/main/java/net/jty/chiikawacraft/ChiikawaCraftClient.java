package net.jty.chiikawacraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jty.chiikawacraft.entity.ModEntities;
import net.jty.chiikawacraft.entity.client.ChiikawaModel;
import net.jty.chiikawacraft.entity.client.ChiikawaRenderer;

public class ChiikawaCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(ChiikawaModel.CHIIKAWA, ChiikawaModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.CHIIKAWA, ChiikawaRenderer::new);
    }
}
