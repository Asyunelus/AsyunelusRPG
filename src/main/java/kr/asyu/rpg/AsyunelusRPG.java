package kr.asyu.rpg;

import com.mojang.logging.LogUtils;
import kr.asyu.rpg.statlib.StatCalculator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AsyunelusRPG.MOD_ID)
public class AsyunelusRPG
{
    public static final String MOD_ID = "asyu_rpg";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AsyunelusRPG() {
        StatCalculator.getInstance(Long.class);

        DistExecutor.safeRunForDist(
            () -> SideProxy.Client::new,
            () -> SideProxy.Server::new
        );
    }

    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}