/*
 * This file is a part of the Chameleon Framework, licensed under the MIT License.
 *
 * Copyright (c) 2021-2022 The Chameleon Framework Authors.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.hypera.chameleon.platform.proxy;

import dev.hypera.chameleon.annotations.PlatformSpecific;
import dev.hypera.chameleon.platform.Platform;
import dev.hypera.chameleon.users.platforms.ProxyUser;
import java.net.SocketAddress;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * {@link ProxyPlatform} sub-server.
 */
@PlatformSpecific(Platform.Type.PROXY)
public interface Server {

    /**
     * Get {@link Server} name.
     *
     * @return {@link Server} name.
     */
    @NotNull String getName();

    /**
     * Get {@link Server} socket address.
     *
     * @return {@link Server} socket address.
     */
    @NotNull SocketAddress getSocketAddress();

    /**
     * Get all {@link ProxyUser}s on this {@link Server}.
     *
     * @return set of {@link ProxyUser} currently on this {@link Server}.
     */
    @NotNull Set<ProxyUser> getPlayers();

    /**
     * Send a plugin message to this {@link Server}.
     *
     * @param channel Plugin message channel.
     * @param data    Data.
     */
    void sendData(@NotNull String channel, byte[] data);

}
