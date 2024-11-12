package com.pouffydev.mimp;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.TridentItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class MimpClient {

    public static void onCtorClient(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(MimpClient::clientInit);
    }

    public static void clientInit(FMLClientSetupEvent event) {
        registerModelPredicates();
    }

    public static void registerModelPredicates() {
        // Slot predicates
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_offhand"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getOffhandItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_mainhand"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getMainHandItem() == pStack ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_head"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getItemBySlot(EquipmentSlot.HEAD) == pStack ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_chest"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getItemBySlot(EquipmentSlot.CHEST) == pStack ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_legs"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getItemBySlot(EquipmentSlot.LEGS) == pStack ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "slot_feet"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.getItemBySlot(EquipmentSlot.FEET) == pStack ? 1.0F : 0.0F);

        // Owner predicates
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_health"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null ? pEntity.getHealth() / pEntity.getMaxHealth() : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_hurt"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.hurtTime > 0 ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_on_fire"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isOnFire() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_sneaking"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isShiftKeyDown() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_sprinting"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isSprinting() && !pEntity.isSwimming() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_swimming"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isSwimming() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_wet"), (pStack, pLevel, pEntity, pSeed) -> pEntity != null && pEntity.isInWater() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "owner_can_see_sky"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pEntity != null && pLevel.canSeeSky(BlockPos.containing(pEntity.getEyePosition())) ? 1.0F : 0.0F);

        // World predicates
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_raining"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.isRaining() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_thundering"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.isThundering() ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_is_peaceful"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.getDifficulty() == Difficulty.PEACEFUL ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_is_easy"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.getDifficulty() == Difficulty.EASY ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_is_normal"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.getDifficulty() == Difficulty.NORMAL ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_is_hard"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.getDifficulty() == Difficulty.HARD ? 1.0F : 0.0F);
        ItemProperties.registerGeneric(new ResourceLocation(Mimp.MODID, "world_is_hardcore"), (pStack, pLevel, pEntity, pSeed) -> pLevel != null && pLevel.getLevelData().isHardcore() ? 1.0F : 0.0F);
    }

}
