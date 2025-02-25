package net.acoyt.flexible_arms.mixin.models;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.acoyt.flexible_arms.util.ArmModelsContainer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(JsonUnbakedModel.class)
public abstract class JsonUnbakedModelMixin {
    @ModifyReturnValue(
            method = "bake(Lnet/minecraft/client/render/model/Baker;Lnet/minecraft/client/render/model/json/JsonUnbakedModel;Ljava/util/function/Function;Lnet/minecraft/client/render/model/ModelBakeSettings;Z)Lnet/minecraft/client/render/model/BakedModel;",
            at = @At(value = "RETURN", ordinal = 1)
    )
    private BakedModel flexible_arms$processOnBake(BakedModel original) {
        if (!(original instanceof BasicBakedModel)) return original;

        ArmModelsContainer sourceArmModels = (ArmModelsContainer) this;
        ArmModelsContainer targetArmModels = (ArmModelsContainer) original;

        targetArmModels.getLeftArmModelProperties().set(sourceArmModels.getLeftArmModelProperties());
        targetArmModels.getRightArmModelProperties().set(sourceArmModels.getRightArmModelProperties());

        return original;
    }
}