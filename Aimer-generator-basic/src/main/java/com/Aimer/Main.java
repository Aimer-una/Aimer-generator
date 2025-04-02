package com.Aimer;


import com.Aimer.cli.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        //args = new String[]{"generate","-l","-o","-a"};
        //args = new String[]{"config"};
        //args = new String[]{"list"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);

    }
}