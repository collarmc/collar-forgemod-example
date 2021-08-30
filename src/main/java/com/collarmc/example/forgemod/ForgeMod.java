package com.collarmc.example.forgemod;

import com.collarmc.api.CollarPlugin;
import com.collarmc.api.CollarPluginLoadedEvent;
import com.collarmc.client.Collar;
import com.collarmc.client.api.messaging.events.PrivateMessageReceivedEvent;
import com.collarmc.client.events.CollarStateChangedEvent;
import com.collarmc.pounce.EventBus;
import com.collarmc.pounce.Preference;
import com.collarmc.pounce.Subscribe;
import net.minecraftforge.fml.common.Mod;

@Mod(
        modid = ForgeMod.MOD_ID,
        name = ForgeMod.MOD_NAME,
        version = ForgeMod.VERSION
)
public class ForgeMod implements CollarPlugin {

    public static final String MOD_ID = "forge-mod";
    public static final String MOD_NAME = "Collar Example Forge Mod";
    public static final String VERSION = "1.0-SNAPSHOT";

    public static EventBus EVENT_BUS;

    @Override
    public void onLoad(CollarPluginLoadedEvent event) {
        EVENT_BUS = event.eventBus;
        // EVENT_BUS.subscribe(yourListener) here to receive Collar events
    }

    /**
     * Listen to collar state changes
     * @param event state change event
     */
    @Subscribe
    public void onConnecting(CollarStateChangedEvent event) {
        switch (event.state) {
            case CONNECTING:
            case CONNECTED:
            case DISCONNECTING:
            case DISCONNECTED:
            default:
                System.out.println("Collar is " + event.state);
        }
    }

    /**
     * Example that listens to {@link PrivateMessageReceivedEvent}
     * Use {@link Preference} to decide what thread your event runs on
     * @param e event
     */
    @Subscribe(Preference.CALLER)
    public void onMessageReceived(PrivateMessageReceivedEvent e) {
        System.out.println("Message received");
    }
}
