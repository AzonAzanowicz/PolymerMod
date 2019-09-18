package azon.polymer;

import azon.polymer.proxy.ClientProxy;
import azon.polymer.proxy.CommonProxy;
import azon.polymer.proxy.ServerProxy;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Polymer.MOD_ID)
public class Polymer {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "polymer";

    public static Polymer instance;
    public static CommonProxy proxy;

	public Polymer() {
        instance = this;
        proxy = DistExecutor.runForDist(() -> ClientProxy::new, () -> ServerProxy::new);

    }

}