package net.giabao.cardcaptor.item;

import net.giabao.cardcaptor.CardCaptor;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CardCaptor.MOD_ID);

    public static final Supplier<CreativeModeTab> WINDY_ITEMS_TAB = CREATIVE_MODE_TAB.register("windy_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WINDY.get()))
                    .title(Component.translatable("Clow Card"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.WINDY);
                        output.accept(ModItems.WATERY);
                    })


                    .build());

    public static void register(IEventBus eventbus) {
        CREATIVE_MODE_TAB.register(eventbus);
    }
}
