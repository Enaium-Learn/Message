package cn.enaium.learn.client.message;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class MessageManager {
    public static CopyOnWriteArrayList<Message> messages = new CopyOnWriteArrayList<>();

    public static void render() {
        for (int i = 0; i < messages.size(); i++) {
            messages.get(i).render(i);
        }
    }

    public static void remove() {
        messages.removeIf(message -> !message.isShow());
    }

}
