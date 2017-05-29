package flavor.pie.kludge

import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec

val ((CommandSource, CommandContext) -> CommandResult).command: CommandExecutor get() = CommandExecutor { src, args -> this(src, args) }
fun CommandSpec.Builder.executor(executor: (CommandSource, CommandContext) -> CommandResult): CommandSpec.Builder = this.executor(executor.command)