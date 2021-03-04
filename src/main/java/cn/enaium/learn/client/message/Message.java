package cn.enaium.learn.client.message;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class Message {

    private final String message;
    private final Type type;

    private int end;
    private long start;

    public Message(String message, Type type) {
        this.message = message;
        this.type = type;
        end = 3500;
        start = System.currentTimeMillis();
    }

    public boolean isShow() {
        return getTime() <= end;
    }

    private int getTime() {
        return (int) (System.currentTimeMillis() - start);
    }

    public void render(int index) {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int width = 120;
        int height = 30;

        int x = scaledResolution.getScaledWidth() - width;
        int y = scaledResolution.getScaledHeight() - (height + 10) * (index + 1);

        draw(x, y, width, height, new Color(0, 0, 0).getRGB());

        Color color;

        if (this.type.equals(Type.SUCCESS)) {
            color = new Color(0, 255, 0);
        } else if (this.type.equals(Type.ERROR)) {
            color = new Color(255, 0, 0);
        } else if (this.type.equals(Type.WARNING)) {
            color = new Color(255, 255, 0);
        } else {
            color = new Color(0, 0, 255);
        }

        draw(x, y, 10, height, color.getRGB());
        drawBar(x, y + height - 5, width, 5, end, getTime(), new Color(255, 0, 255).getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.message, x + 20, y + 10, 0xFFFFFF);
    }

    private void draw(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);
    }

    private void drawBar(int x, int y, int width, int height, int value, int current, int color) {
        float each = (float) width / (float) value;
        draw(x, y, (int) (each * current), height, color);
    }

    public enum Type {
        SUCCESS, ERROR, WARNING, NONE
    }
}
