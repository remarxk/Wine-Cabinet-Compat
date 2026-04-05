package com.remarxk.wine_cabinet_compat.mixin;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import dev.xkmc.youkaishomecoming.init.YoukaisHomecoming;
import net.minecraftforge.fml.loading.LoadingModList;
import net.satisfy.vinery.core.Vinery;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MixinPlugin implements IMixinConfigPlugin {
    private final static HashSet<String> VineryMixinMap = new HashSet<>();

    private final static String KaleidoscopeTavernPack = "com.remarxk.wine_cabinet_compat.mixin.kaleidoscope_tavern";

    private final static String YoukaisfeastsPack = "com.remarxk.wine_cabinet_compat.mixin.youkaisfeasts";

    static {
        VineryMixinMap.add(KaleidoscopeTavernPack + ".BarCabinetBlockEntityRenderMixin");
        VineryMixinMap.add(KaleidoscopeTavernPack + ".BottleBlockMixin");
        VineryMixinMap.add(KaleidoscopeTavernPack + ".DrinkBlockMixin");


        VineryMixinMap.add(YoukaisfeastsPack + ".ShelfRendererMixin");
        VineryMixinMap.add(YoukaisfeastsPack + ".BottleBlockMixin");
    }

    @Override
    public void onLoad(String s) {

    }

    @Override
    public String getRefMapperConfig() {
        return "";
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.contains(KaleidoscopeTavernPack)) {
            if (!isModLoaded(KaleidoscopeTavern.MOD_ID))
                return false;
        }

        if (mixinClassName.contains(YoukaisfeastsPack)) {
            if (!isModLoaded(YoukaisHomecoming.MODID))
                return false;
        }

        if (VineryMixinMap.contains(mixinClassName) && !isModLoaded(Vinery.MOD_ID)) {
            return false;
        }

        return true;
    }

    private boolean isModLoaded(String modId) {
        return LoadingModList.get().getModFileById(modId) != null;
    }

    @Override
    public void acceptTargets(Set<String> set, Set<String> set1) {

    }

    @Override
    public List<String> getMixins() {
        return List.of();
    }

    @Override
    public void preApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }

    @Override
    public void postApply(String s, ClassNode classNode, String s1, IMixinInfo iMixinInfo) {

    }
}
