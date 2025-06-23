package net.jty.chiikawacraft.entity.client.usagi;

import net.jty.chiikawacraft.ChiikawaCraft;
import net.jty.chiikawacraft.entity.custom.UsagiEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
/**
 * Represents the UsagiModel, a custom entity model for the UsagiEntity in Minecraft.
 * This class defines the structure and animations for the Usagi entity's appearance in the game.
 *
 * @param <T> The generic type extending UsagiEntity.
 */
// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class UsagiModel<T extends UsagiEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer USAGI = new EntityModelLayer(Identifier.of(ChiikawaCraft.MOD_ID, "usagi"), "main");

    private final ModelPart Usagi;
    private final ModelPart Head;
    private final ModelPart Body;

    public UsagiModel(ModelPart root) {
        this.Usagi = root.getChild("Usagi");
        this.Head = this.Usagi.getChild("Head");
        this.Body = this.Usagi.getChild("Body");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData Usagi = modelPartData.addChild("Usagi", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData Head = Usagi.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-3.0F, -5.0F, -3.0F, 6.0F, 1.0F, 5.0F, new Dilation(0.0F))
                .uv(0, 11).cuboid(-5.0F, -3.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F))
                .uv(10, 11).cuboid(4.0F, -3.0F, -3.0F, 1.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -7.0F, 0.0F));

        ModelPartData EarL = Head.addChild("EarL", ModelPartBuilder.create().uv(11, 20).cuboid(-1.02F, -6.0F, -1.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -4.0F, 0.0F));

        ModelPartData EarR = Head.addChild("EarR", ModelPartBuilder.create().uv(5, 20).cuboid(-0.98F, -6.0F, -1.0F, 2.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -4.0F, 0.0F));

        ModelPartData Body = Usagi.addChild("Body", ModelPartBuilder.create().uv(1, 13).cuboid(-3.0F, -3.0F, -2.0F, 6.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

        ModelPartData Tail = Body.addChild("Tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = Tail.addChild("cube_r1", ModelPartBuilder.create().uv(22, 13).cuboid(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.3F, 2.4F, -1.0527F, 0.4461F, -0.6509F));

        ModelPartData Arms = Body.addChild("Arms", ModelPartBuilder.create(), ModelTransform.pivot(4.0F, -3.0F, 0.0F));

        ModelPartData ArmR = Arms.addChild("ArmR", ModelPartBuilder.create().uv(3, 4).cuboid(0.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-8.0F, 0.0F, 0.0F));

        ModelPartData ArmL = Arms.addChild("ArmL", ModelPartBuilder.create().uv(23, 4).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, -0.5F));

        ModelPartData Legs = Usagi.addChild("Legs", ModelPartBuilder.create(), ModelTransform.pivot(2.0F, -2.0F, 0.0F));

        ModelPartData LegR = Legs.addChild("LegR", ModelPartBuilder.create().uv(1, 13).cuboid(0.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, 0.0F, 0.0F));

        ModelPartData LegL = Legs.addChild("LegL", ModelPartBuilder.create().uv(17, 13).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        Usagi.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return Usagi;
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.Head.yaw = headYaw * 0.017F;
        this.Head.pitch = headPitch * 0.017F;
    }

    @Override
    public void setAngles(UsagiEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(headYaw, headPitch);

        this.animateMovement(UsagiAnimations.ANIM_USAGI_WALK, limbAngle, limbDistance, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, UsagiAnimations.ANIM_USAGI_IDLE, animationProgress, 1f);
    }
}