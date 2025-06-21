package net.jty.chiikawacraft.entity.client.hachiware;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.HachiwareEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class HachiwareRenderer extends MobEntityRenderer<HachiwareEntity, HachiwareModel<HachiwareEntity>> {
    public HachiwareRenderer(EntityRendererFactory.Context context) {
        super(context, new HachiwareModel<>(context.getPart(HachiwareModel.HACHIWARE)), 0.5f);
    }

    @Override
    public Identifier getTexture(HachiwareEntity entity) {
        return Identifier.of(ChiikawaCraft.MOD_ID, "textures/entity/hachiware/hachiware.png");
    }

    @Override
    public void render(HachiwareEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}