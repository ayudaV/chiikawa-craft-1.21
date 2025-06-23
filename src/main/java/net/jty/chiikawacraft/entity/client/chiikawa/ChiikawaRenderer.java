package net.jty.chiikawacraft.entity.client.chiikawa;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/**
 * ChiikawaRenderer is responsible for rendering the ChiikawaEntity in the game world.
 * This renderer is specifically designed to provide custom visuals and scaling
 * depending on the entity's state.
 *
 * It extends MobEntityRenderer to leverage base functionality for rendering
 * mob-like entities, while overriding specific behaviors for the ChiikawaEntity's
 * appearance and texture management.
 *
 * Features:
 * - Assigns a custom texture for ChiikawaEntity using a texture specific to the mod.
 * - Handles scaling of the entity model based on its age (adult or baby).
 * - Integrates seamlessly with the Minecraft rendering pipeline.
 *
 * Constructor:
 * - Initializes the ChiikawaRenderer with a custom model retrieved from the
 *   rendering context and sets a shadow radius.
 *
 * Methods:
 * - getTexture: Returns the texture identifier for the ChiikawaEntity, which
 *   determines the appearance of the entity in the game.
 * - render: Applies model scaling based on whether the ChiikawaEntity is a baby
 *   or an adult, prior to rendering it.
 *
 * This class is designed to offer a visually accurate and context-aware
 * rendering experience for the ChiikawaEntity.
 */
public class ChiikawaRenderer extends MobEntityRenderer<ChiikawaEntity, ChiikawaModel<ChiikawaEntity>> {
    public ChiikawaRenderer(EntityRendererFactory.Context context) {
        super(context, new ChiikawaModel<>(context.getPart(ChiikawaModel.CHIIKAWA)), 0.5f);
    }

    @Override
    public Identifier getTexture(ChiikawaEntity entity) {
        return Identifier.of(ChiikawaCraft.MOD_ID, "textures/entity/chiikawa/chiikawa.png");
    }

    @Override
    public void render(ChiikawaEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
