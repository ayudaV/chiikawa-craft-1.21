package net.jty.chiikawacraft.entity.client.usagi;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

/**
 * Renderer class for the UsagiEntity within the ChiikawaCraft mod. This class is responsible
 * for rendering the UsagiEntity in the game world, applying scaling transformations based
 * on the entity's state, and defining the texture to be used for the entity model.
 *
 * Extends:
 * - MobEntityRenderer: Provides rendering capabilities for mob entities.
 *
 * Constructor:
 * - UsagiRenderer(EntityRendererFactory.Context context): Initializes the UsagiRenderer with the
 *   specified rendering context, binding the custom UsagiModel and applying a shadow radius.
 *
 * Methods:
 * - getTexture(UsagiEntity entity): Returns the texture identifier for the UsagiEntity model to be rendered.
 * - render(UsagiEntity livingEntity, float f, float g, MatrixStack matrixStack,
 *          VertexConsumerProvider vertexConsumerProvider, int i):
 *   Overrides the default render method to apply scaling transformations for baby and adult
 *   states of the UsagiEntity before rendering it.
 *
 * Features:
 * - Renders the UsagiEntity with its unique texture.
 * - Adjusts the scaling of the entity depending on whether it is a baby or adult.
 */
public class UsagiRenderer extends MobEntityRenderer<UsagiEntity, UsagiModel<UsagiEntity>> {
    public UsagiRenderer(EntityRendererFactory.Context context) {
        super(context, new UsagiModel<>(context.getPart(UsagiModel.USAGI)), 0.5f);
    }

    @Override
    public Identifier getTexture(UsagiEntity entity) {
        return Identifier.of(ChiikawaCraft.MOD_ID, "textures/entity/usagi/usagi.png");
    }

    @Override
    public void render(UsagiEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
