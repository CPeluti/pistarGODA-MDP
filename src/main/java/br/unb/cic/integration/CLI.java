package br.unb.cic.integration;

import br.unb.cic.goda.model.ModelTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.io.File;

@Command(name = "goda", mixinStandardHelpOptions = true, version = "3.0.0",
        description = "Run the goda framework of an Goal Model file to STDOUT.")
public class CLI implements Callable<Integer> {

    private final IntegrationService service = new IntegrationService();

    static class Type {
        @Option(names = {"--dtmc", "-d"}, required = true, description = "Generate a PRISM DTMC model based on a Goal Model.")
        Boolean dtmc;
        @Option(names = {"--param", "-p"}, required = true, description = "Generate a PRISM PARAM model based on a Goal Model.")
        Boolean param;
    }

    static class FileGeneration {
        @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
        private Type type;

        @Option(names = {"-f"}, required = true, paramLabel = "GOAL_MODEL",description = "Goal Model file")
        File gm;
        @Option(names = {"-o"}, paramLabel = "OUTPUT_PATH", description = "Output path", defaultValue = "./prism.zip")
        String outputPath;
    }

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    Exclusive exclusive;
    static class Exclusive {
        @CommandLine.ArgGroup(exclusive = false)
        private FileGeneration fileGeneration;
        @Option(names = {"--pistar"}, description = "Run piStar Server", defaultValue = "false")
        boolean pistar = false;
    }


    @Override
    public Integer call() throws Exception { // your business logic goes here...
        if(exclusive.pistar){
            Application.server();
        }else{
            Type type = exclusive.fileGeneration.type;
            if(type.dtmc || type.param){
                ModelTypeEnum mType = type.dtmc? ModelTypeEnum.DTMC : ModelTypeEnum.PARAM;
                if(exclusive.fileGeneration.gm.exists()){
                    String content = new Scanner(exclusive.fileGeneration.gm).useDelimiter("\\Z").next();
                    this.service.executePrism(content, mType.getTipo(),  exclusive.fileGeneration.outputPath);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new CLI()).execute(args);
    }
}