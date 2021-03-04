package cn.enaium.learn.client;

import cn.enaium.cf4m.CF4M;

/**
 * Project: MCP918
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public enum Client {

    INSTANCE;

    public void run() {
        CF4M.INSTANCE.run(this);
    }

}

