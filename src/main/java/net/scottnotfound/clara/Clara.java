package net.scottnotfound.clara;

import org.apache.commons.cli.*;

public class Clara {

    public static void main(String[] args) throws ParseException {

        Options options = new Options();
        options.addOption("hello", false, "repeats hello back to the user");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        if (cmd.hasOption("hello")) {
            System.out.println("hello");
        }
    }
}
