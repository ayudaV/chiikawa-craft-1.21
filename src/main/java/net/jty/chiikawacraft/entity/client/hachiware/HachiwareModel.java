package net.jty.chiikawacraft.entity.client.hachiware;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.HachiwareEntity;
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
public class HachiwareModel<T extends HachiwareEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer HACHIWARE = new EntityModelLayer(Identifier.of(ChiikawaCraft.MOD_ID, "hachiware"), "main");
    private final ModelPart Hachiware;
    private final ModelPart Head;
    private final ModelPart Body;

    public HachiwareModel(ModelPart root) {
        this.Hachiware = root.getChild("Hachiware");
        this.Head = this.Hachiware.getChild("Head");
        this.Body = this.Hachiware.getChild("Body");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Hachiware = modelPartData.addChild("Hachiware", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 22.0F, 0.0F));

        ModelPartData Legs = Hachiware.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, 0.0F, 0.0F));

        ModelPartData LegR = Legs.addChild("LegR", ModelPartBuilder.create().uv(7, 20).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData LegL = Legs.addChild("LegL", ModelPartBuilder.create().uv(11, 20).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Head = Hachiware.addChild("Head", ModelPartBuilder.create().uv(9, 15).cuboid(-4.0F, 1.0F, -4.0F, 8.0F, 0.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-4.0F, -5.0F, -4.0F, 8.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(1, 1).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 22).cuboid(-5.0F, -4.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(11, 22).cuboid(4.0F, -4.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

        ModelPartData EarL = Head.addChild("EarL", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -5.0F, -0.5F));

        ModelPartData EarL_r1 = EarL.addChild("EarL_r1", ModelPartBuilder.create().uv(24, 4).cuboid(-0.7985F, -1.2105F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0047F, 0.0F, 0.0F, 0.0F, -0.7854F));

        ModelPartData EarR = Head.addChild("EarR", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -5.0F, -0.5F));

        ModelPartData EarR_r1 = EarR.addChild("EarR_r1", ModelPartBuilder.create().uv(0, 4).cuboid(-1.2015F, -1.2105F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0861F, -0.0075F, 0.0F, 0.0F, 0.7854F));

        ModelPartData Body = Hachiware.addChild("Body", ModelPartBuilder.create().uv(12, 15).cuboid(-3.0F, -3.0F, -2.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 2.0F));

        ModelPartData cube_r1 = Tail.addChild("cube_r1", ModelPartBuilder.create().uv(24, 0).cuboid(-0.5F, -1.0F, -1.0F, 1.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

        ModelPartData Arms = Body.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -3.0F, 0.0F));

        ModelPartData ArmR = Arms.addChild("ArmR", ModelPartBuilder.create().uv(7, 17).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-7.0F, 0.0F, -0.5F));

        ModelPartData ArmL = Arms.addChild("ArmL", ModelPartBuilder.create().uv(11, 17).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, 0.0F, -0.5F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Hachiware.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Hachiware;
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017F;
        this.Head.pitch = headPitch * 0.017F;
    }

    @Override
    public void setAngles(HachiwareEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(HachiwareAnimations.ANIM_HACHIWARE_WALK, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, HachiwareAnimations.ANIM_HACHIWARE_IDLE, animationProgress, 1f);
    }
}