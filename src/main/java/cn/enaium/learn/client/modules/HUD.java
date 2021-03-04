package cn.enaium.learn.client.modules;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.event.Listener;
import cn.enaium.learn.client.events.Render2DEvent;
import cn.enaium.learn.client.message.MessageManager;
import org.lwjgl.input.Keyboard;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "HUD", key = Keyboard.KEY_O)
public class HUD {
    @Event
    public void rendering(Render2DEvent render2DEvent) {
        if (!render2DEvent.getAt().equals(Listener.At.HEAD))
            return;

        MessageManager.render();
    }

    @Event
    public void rendered(Render2DEvent render2DEvent) {
        if (!render2DEvent.getAt().equals(Listener.At.TAIL))
            return;

        MessageManager.remove();
    }
}
