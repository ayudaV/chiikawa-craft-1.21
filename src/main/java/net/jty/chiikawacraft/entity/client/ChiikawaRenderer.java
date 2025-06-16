package net.jty.chiikawacraft.entity.client;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

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
