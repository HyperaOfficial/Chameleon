/*
 * This file is a part of the Chameleon Framework, licensed under the MIT License.
 *
 * Copyright (c) 2021-2024 The Chameleon Framework Authors.
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
package dev.hypera.chameleon;

import dev.hypera.chameleon.platform.Platform;
import org.jetbrains.annotations.NotNull;

public final class TestChameleonPlatform implements Platform {

    /**
     * Get a unique identifier for this Platform.
     * <p>This will return the common name of the API that is in use, e.g. "BungeeCord" or
     * "Velocity".</p>
     *
     * @return Platform identifier.
     */
    @Override
    public @NotNull String getId() {
        return TestChameleon.PLATFORM_ID;
    }

    /**
     * Get the friendly name of this Platform.
     * <p>This will return the name provided by the Platform, which may not match the name of the
     * API that is in use.</p>
     *
     * @return Platform friendly name.
     */
    @Override
    public @NotNull String getName() {
        return "Test";
    }

    /**
     * Get the version of this Platform.
     * <p>This will return the version provided by the Platform.</p>
     *
     * @return Platform version.
     */
    @Override
    public @NotNull String getVersion() {
        return Chameleon.getVersion() + "-" + Chameleon.getShortCommitHash();
    }

}
