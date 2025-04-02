package com.Aimer.cli;

import com.Aimer.cli.command.ConfigCommand;
import com.Aimer.cli.command.GenerateCommand;
import com.Aimer.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "Aimer",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时发出友好信号
        System.out.println("请输入具体命令，或输入 --help 查看命令提示");
    }

   public Integer doExecute(String[]args){
        return commandLine.execute(args);
   }

}
