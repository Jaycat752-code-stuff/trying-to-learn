package net.jaycat.ttl.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final Identifier VT_THEME_ID = Identifier.of("ttl", "vt_theme");
    public static final SoundEvent VT_THEME = Registry.register(
            Registries.SOUND_EVENT,
            VT_THEME_ID,
            SoundEvent.of(VT_THEME_ID)
    );

public static void registerSounds(){

}

}
