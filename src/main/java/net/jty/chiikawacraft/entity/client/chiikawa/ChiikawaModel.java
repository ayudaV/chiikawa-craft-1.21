package net.jty.chiikawacraft.entity.client.chiikawa;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.ChiikawaEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

/**
 * AI Generated Documentation
 * The ChiikawaModel class is a custom model implementation for the ChiikawaEntity.
 * This model is designed to define the visual parts and animations of the Chiikawa entity in Minecraft.
 * It extends the SinglePartEntityModel class and specifies the model's structure and behaviors.
 *
 * @param <T> The type parameter extending ChiikawaEntity.
 *
 * Features of the model include:
 * - Nested model parts, including Body, Head, Arms, Legs, and their subcomponents.
 * - Settable head angles with clamping for better animation control.
 * - Render method to visualize the model.
 * - Methods for handling entity animations (walking and idle states).
 */
// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17+ for Yarn,
// Paste this class into your mod and generate all required imports
public class ChiikawaModel<T extends ChiikawaEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer CHIIKAWA = new EntityModelLayer(Identifier.of(ChiikawaCraft.MOD_ID, "chiikawa"), "main");
    private final ModelPart Chiikawa;
    private final ModelPart Body;
    private final ModelPart Head;
    public ChiikawaModel(ModelPart root) {
        this.Chiikawa = root.getChild("Chiikawa");
        this.Body = this.Chiikawa.getChild("Body");
        this.Head = this.Chiikawa.getChild("Head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Chiikawa = modelPartData.addChild("Chiikawa", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 26.0F, 0.0F));

        ModelPartData Body = Chiikawa.addChild("Body", ModelPartBuilder.create().uv(0, 21).cuboid(-3.0F, -7.0F, -2.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Legs = Body.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -4.0F, 0.0F));

        ModelPartData LegL = Legs.addChild("LegL", ModelPartBuilder.create().uv(29, 32).cuboid(-1.0F, 0.0F, -0.3F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData LegR = Legs.addChild("LegR", ModelPartBuilder.create().uv(23, 32).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, 0.0F, 0.0F));

        ModelPartData Arms = Body.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -7.0F, 0.0F));

        ModelPartData ArmL = Arms.addChild("ArmL", ModelPartBuilder.create().uv(33, 5).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, -1.0F));

        ModelPartData ArmR = Arms.addChild("ArmR", ModelPartBuilder.create().uv(33, 1).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -1.0F));

        ModelPartData Head = Chiikawa.addChild("Head", ModelPartBuilder.create().uv(1, 1).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(1, 15).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(21, 22).cuboid(-5.0F, -4.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(1, 29).cuboid(4.0F, -4.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -8.0F, 0.0F));

        ModelPartData EarL = Head.addChild("EarL", ModelPartBuilder.create().uv(15, 32).cuboid(0.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -5.0F, 0.0F));

        ModelPartData EarR = Head.addChild("EarR", ModelPartBuilder.create().uv(25, 15).cuboid(-2.0F, -2.0F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -5.0F, 0.0F));
        return TexturedModelData.of(modelData, 31, 31);
    }


    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Chiikawa.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Chiikawa;
    }

    @Override
    public void setAngles(ChiikawaEntity entity, float limbSwing, float limbSwingAmount, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(ChiikawaAnimations.ANIM_CHIIKAWA_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ChiikawaAnimations.ANIM_CHIIKAWA_IDLE, animationProgress, 1f);
    }
    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017F;
        this.Head.pitch = headPitch * 0.017F;
    }


}