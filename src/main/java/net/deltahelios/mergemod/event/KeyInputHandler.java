package net.deltahelios.mergemod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MERGEMOD = "key.category.mergemod.mergemod";
    public static final String KEY_ABILITY= "key.mergemod.primary_ability";
    public static KeyBinding abilityKey;
    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (abilityKey.wasPressed()) {
                client.player.sendMessage(Text.literal("You pressed key. Wooo."), true);
            }
        });
    }
        public static void register(){
            abilityKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(KEY_ABILITY, InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_MERGEMOD));

            registerKeyInputs();
        }
    }

