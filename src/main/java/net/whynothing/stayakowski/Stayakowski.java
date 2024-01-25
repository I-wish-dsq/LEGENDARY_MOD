package net.whynothing.stayakowski;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

public class Stayakowski implements ModInitializer {
    public static final String MOD_ID = "stayakowski";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) ->
                dispatcher.register(literal("get-key")
                        .then(argument("user", StringArgumentType.string())
                                .executes(context -> {
                                    final String uid = StringArgumentType.getString(context, "user");
                                    final String key = RandomPart(7);
                                    context.getSource().sendFeedback(() -> Text.literal("Micah-%s-%s".formatted(uid, key)), false);
                                    return 1;
                                })))));
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) ->
                dispatcher.register(literal("stayakovskiy")
                        .executes(context -> {
                            context.getSource().sendFeedback(() -> Text.literal("Стояковский а что это вы сидите на шкибиди туалете? \n" +
                                    "А будет лучше если я на вас насру?\n" +
                                    "Порно!\n" +
                                    "Но вы же говорили это в Бахмутовской области\n" +
                                    "А я не думал что вы везде за мной говно жрёте\n" +
                                    "Кто как поёт песню Скибиди\n" +
                                    "Стоявковский мы читали ваш фанфик про сигму свинку,но ничего не поняли!\n" +
                                    "Тупая вумэн, шкибиди туалетов надо иметь в жопу!"), false);
                            return 1;
                        }))));
        CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) ->
                dispatcher.register(literal("nijitod")
                        .executes(context -> {
                            context.getSource().sendFeedback(() -> Text.literal("мама насинга"), false);
                            return 1;
                        }))));
    }
    public static String RandomPart(int length) {
        String dictionary = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random rnd = new Random();

        for (int i = 0; i < length; i++) {
            int rndIndex = rnd.nextInt(dictionary.length());
            char rndChar = dictionary.charAt(rndIndex);
            sb.append(rndChar);
        }

        return sb.toString();
    }
}