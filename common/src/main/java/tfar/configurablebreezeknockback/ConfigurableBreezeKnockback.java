package tfar.configurablebreezeknockback;

import com.sun.jdi.DoubleValue;
import net.minecraft.world.level.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// This class is part of the common project meaning it is shared between all supported loaders. Code written here can only
// import and access the vanilla codebase, libraries used by vanilla, and optionally third party libraries that provide
// common compatible binaries. This means common code can not directly use loader specific concepts such as Forge events
// however it will be compatible with all supported mod loaders.
public class ConfigurableBreezeKnockback {

    public static final String MOD_ID = "configurablebreezeknockback";
    public static final String MOD_NAME = "ConfigurableBreezeKnockback";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static final float DEFAULT = 1.22F;
    public static final String KEY = "Power";
    public static final String k_KEY = "KnockbackPower";

    // The loader specific projects are able to import and use any code from the common project. This allows you to
    // write the majority of your code here and load it from your loader specific projects. This example has some
    // code that gets invoked by the entry point of the loader specific projects.

    public static void init() {

    }
}