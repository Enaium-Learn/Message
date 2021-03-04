package cn.enaium.learn.client.modules;

import cn.enaium.cf4m.annotation.module.Disable;
import cn.enaium.cf4m.annotation.module.Enable;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.learn.client.message.Message;
import cn.enaium.learn.client.message.MessageManager;
import org.lwjgl.input.Keyboard;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "Test", key = Keyboard.KEY_V)
public class Test {
    @Enable
    public void enable() {
        MessageManager.messages.add(new Message("Enable", Message.Type.SUCCESS));
    }

    @Disable
    public void disable() {
        MessageManager.messages.add(new Message("Disable", Message.Type.WARNING));
    }
}
