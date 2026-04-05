package com.remarxk.wine_cabinet_compat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WineCabinetCompat.MODID)
public class WineCabinetCompat {

    public static final String MODID = "wine_cabinet_compat";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WineCabinetCompat() {

    }
}
