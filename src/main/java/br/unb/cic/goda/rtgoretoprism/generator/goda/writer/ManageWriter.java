package br.unb.cic.goda.rtgoretoprism.generator.goda.writer;

import br.unb.cic.goda.rtgoretoprism.generator.CodeGenerationException;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class ManageWriter {


    public static PrintWriter createFile(String adf, String outputFolder) throws CodeGenerationException {
        try {
            PrintWriter adfFile = new PrintWriter(
                    new BufferedWriter(new FileWriter(outputFolder + adf)));
            return adfFile;
        } catch (IOException e) {
            String msg = "Error: Can't create output model file.";
            System.out.println(msg);
            throw new CodeGenerationException(msg);
        }
    }

    public static String readFileAsString(String filePath) throws CodeGenerationException {
        InputStream inputStream = null;
        String res = null;
        try {
            ClassLoader classLoader = (new ManageWriter()).getClass().getClassLoader();
            inputStream = classLoader.getResourceAsStream(filePath);
            res = IOUtils.toString(inputStream);
        } catch (IOException e) {
            String msg = "Error: file " + filePath + " not found.";
            System.out.println(msg);
            throw new CodeGenerationException(msg);
        }
        return res;
    }

    public static void printModel(PrintWriter adf, String... modules) {
        for (String module : modules) {
            adf.println(module);
        }
        adf.close();
    }
}
