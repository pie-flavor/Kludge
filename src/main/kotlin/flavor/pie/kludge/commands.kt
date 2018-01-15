package flavor.pie.kludge

import org.spongepowered.api.command.CommandResult
import org.spongepowered.api.command.CommandSource
import org.spongepowered.api.command.args.CommandContext
import org.spongepowered.api.command.spec.CommandExecutor
import org.spongepowered.api.command.spec.CommandSpec

fun ((CommandSource, CommandContext) -> CommandResult).command(): CommandExecutor = CommandExecutor(this)
fun CommandSpec.Builder.executor(executor: (CommandSource, CommandContext) -> CommandResult): CommandSpec.Builder = this.executor(executor.command())