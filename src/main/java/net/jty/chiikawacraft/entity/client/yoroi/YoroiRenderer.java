package net.jty.chiikawacraft.entity.client.yoroi;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.YoroiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class YoroiRenderer extends MobEntityRenderer<YoroiEntity, YoroiModel<YoroiEntity>> {
    public YoroiRenderer(EntityRendererFactory.Context context) {
        super(context, new YoroiModel<>(context.getPart(YoroiModel.YOROI)), 0.5f);
    }

    @Override
    public Identifier getTexture(YoroiEntity entity) {
        return Identifier.of(ChiikawaCraft.MOD_ID, "textures/entity/yoroi/yoroi.png");
    }

    @Override
    public void render(YoroiEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
