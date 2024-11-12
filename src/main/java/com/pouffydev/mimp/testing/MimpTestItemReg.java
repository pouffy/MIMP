package com.pouffydev.mimp.testing;

import com.pouffydev.mimp.Mimp;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class MimpTestItemReg {
    private static final Supplier<Item> SIMPLE_SUPPLIER = () -> new Item(new Item.Properties());
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            Mimp.MODID);

    public static final RegistryObject<Item> TEST_HANDHELD = ITEMS.register("slot_offhand", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_MAINHAND = ITEMS.register("slot_mainhand", SIMPLE_SUPPLIER);

    public static final RegistryObject<Item> TEST_OWNER_HEALTH = ITEMS.register("owner_health", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_HURT = ITEMS.register("owner_hurt", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_ON_FIRE = ITEMS.register("owner_on_fire", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_SNEAKING = ITEMS.register("owner_sneaking", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_SPRINTING = ITEMS.register("owner_sprinting", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_SWIMMING = ITEMS.register("owner_swimming", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_WET = ITEMS.register("owner_wet", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_OWNER_CAN_SEE_SKY = ITEMS.register("owner_can_see_sky", SIMPLE_SUPPLIER);

    public static final RegistryObject<Item> TEST_WORLD_RAINING = ITEMS.register("world_raining", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_THUNDERING = ITEMS.register("world_thundering", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_IS_PEACEFUL = ITEMS.register("world_is_peaceful", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_IS_EASY = ITEMS.register("world_is_easy", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_IS_NORMAL = ITEMS.register("world_is_normal", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_IS_HARD = ITEMS.register("world_is_hard", SIMPLE_SUPPLIER);
    public static final RegistryObject<Item> TEST_WORLD_IS_HARDCORE = ITEMS.register("world_is_hardcore", SIMPLE_SUPPLIER);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
