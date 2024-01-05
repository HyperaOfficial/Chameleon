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
package dev.hypera.chameleon.platform.sponge.command;

import dev.hypera.chameleon.command.Command;
import dev.hypera.chameleon.command.context.Context;
import dev.hypera.chameleon.command.context.ContextImpl;
import dev.hypera.chameleon.platform.sponge.SpongeChameleon;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.Internal;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.command.CommandCause;
import org.spongepowered.api.command.CommandCompletion;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.parameter.ArgumentReader.Mutable;

/**
 * Sponge command wrapper.
 */
@Internal
public final class SpongeCommand implements org.spongepowered.api.command.Command.Raw {

    private final @NotNull SpongeChameleon chameleon;
    private final @NotNull Command command;

    /**
     * Sponge command constructor.
     *
     * @param chameleon Chameleon implementation.
     * @param command   Command to be wrapped.
     */
    public SpongeCommand(@NotNull SpongeChameleon chameleon, @NotNull Command command) {
        this.chameleon = chameleon;
        this.command = command;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull CommandResult process(@NotNull CommandCause cause, @NotNull Mutable arguments) {
        String[] args = arguments.input().split(" ");
        if (args.length < 1 || this.command.executeSubCommand(createContext(cause,
            Arrays.copyOfRange(args, 1, args.length)), args[0])) {
            this.command.executeCommand(createContext(cause, args));
        }

        return CommandResult.success();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull List<CommandCompletion> complete(@NotNull CommandCause cause, @NotNull Mutable arguments) {
        return this.command.tabComplete(createContext(cause, arguments.input().split(" ")))
            .stream().map(CommandCompletion::of).collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canExecute(@NotNull CommandCause cause) {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Optional<Component> shortDescription(@NotNull CommandCause cause) {
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Optional<Component> extendedDescription(@NotNull CommandCause cause) {
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @NotNull Component usage(@NotNull CommandCause cause) {
        return Component.text("/" + this.command.getName());
    }


    private @NotNull Context createContext(@NotNull CommandCause cause, @NotNull String[] args) {
        return new ContextImpl(this.chameleon.getUserManager().wrap(cause), this.chameleon, args);
    }

}
