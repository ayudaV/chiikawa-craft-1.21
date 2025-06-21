package net.jty.chiikawacraft.entity.client.usagi;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

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
