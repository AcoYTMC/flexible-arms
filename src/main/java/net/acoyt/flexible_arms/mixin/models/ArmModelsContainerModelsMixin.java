package net.acoyt.flexible_arms.mixin.models;

import net.acoyt.flexible_arms.util.ArmModelProperties;
import net.acoyt.flexible_arms.util.ArmModelsContainer;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin({JsonUnbakedModel.class, BasicBakedModel.class})
public abstract class ArmModelsContainerModelsMixin
        implements ArmModelsContainer {
    @Unique
    private ArmModelProperties leftArmProps = new ArmModelProperties();
    @Unique
    private ArmModelProperties rightArmProps = new ArmModelProperties();

    @Override
    public ArmModelProperties getLeftArmModelProperties() {
        return leftArmProps;
    }

    @Override
    public ArmModelProperties getRightArmModelProperties() {
        return rightArmProps;
    }
}