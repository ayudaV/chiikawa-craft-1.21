package net.jty.chiikawacraft.entity.client.yoroi;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.YoroiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class YoroiModel<T extends YoroiEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer YOROI = new EntityModelLayer(Identifier.of(ChiikawaCraft.MOD_ID, "yoroi"), "main");

    private final ModelPart Yoroi;
    private final ModelPart Body;
    private final ModelPart Head;
    public YoroiModel(ModelPart root) {
        this.Yoroi = root.getChild("Yoroi");
        this.Body = this.Yoroi.getChild("Body");
        this.Head = this.Yoroi.getChild("Head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Yoroi = modelPartData.addChild("Yoroi", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData LeftLeg = Yoroi.addChild("LeftLeg", ModelPartBuilder.create().uv(0, 32).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -12.0F, 0.0F));

        ModelPartData RightLeg = Yoroi.addChild("RightLeg", ModelPartBuilder.create().uv(32, 0).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -12.0F, 0.0F));

        ModelPartData Body = Yoroi.addChild("Body", ModelPartBuilder.create().uv(0, 16).cuboid(-4.0F, -24.0F, -2.0F, 8.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = Body.addChild("cube_r1", ModelPartBuilder.create().uv(48, 16).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -14.0F, 0.0F, 0.0F, 1.5708F, 0.1745F));

        ModelPartData cube_r2 = Body.addChild("cube_r2", ModelPartBuilder.create().uv(48, 24).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, -14.0F, -2.0F, -0.1731F, -0.0227F, -0.1289F));

        ModelPartData cube_r3 = Body.addChild("cube_r3", ModelPartBuilder.create().uv(48, 8).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -14.0F, -2.0F, -0.1731F, 0.0227F, 0.1289F));

        ModelPartData cube_r4 = Body.addChild("cube_r4", ModelPartBuilder.create().uv(48, 0).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, -14.0F, 0.0F, 0.0F, 1.5708F, -0.1745F));

        ModelPartData cube_r5 = Body.addChild("cube_r5", ModelPartBuilder.create().uv(0, 48).cuboid(-4.0F, 0.0F, 0.0F, 8.0F, 8.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -14.0F, 2.0F, 0.1745F, 0.0F, 0.0F));

        ModelPartData Head = Yoroi.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -24.0F, 0.0F));

        ModelPartData LeftArm = Yoroi.addChild("LeftArm", ModelPartBuilder.create().uv(32, 36).cuboid(0.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -22.0F, 0.0F));

        ModelPartData cube_r6 = LeftArm.addChild("cube_r6", ModelPartBuilder.create().uv(24, 26).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        ModelPartData RightArm = Yoroi.addChild("RightArm", ModelPartBuilder.create().uv(16, 36).cuboid(-4.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -22.0F, 0.0F));

        ModelPartData cube_r7 = RightArm.addChild("cube_r7", ModelPartBuilder.create().uv(24, 16).cuboid(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4887F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Yoroi.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Yoroi;
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017F;
        this.Head.pitch = headPitch * 0.017F;
    }

    @Override
    public void setAngles(YoroiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(YoroiAnimations.ANIM_YOROI_WALK, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, YoroiAnimations.ANIM_YOROI_IDLE, animationProgress, 1f);
    }
}