/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iesalquerias.ejercicioMVP;


import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author lopas
 */
public class Vista {
    private Controlador controlador;
    
    Vista(Controlador controlador){
        this.controlador = controlador;
    }
    
    public void water(String[] args){
        // FASE DE DEFINICIÓN
        Options options = new Options();
        Option tUp = Option.builder("u").hasArg()
                .desc("Raise the temperature").build();
        Option tDown = Option.builder("b").hasArg()
                .desc("Lower the temperature").build();
        
        OptionGroup grp = new OptionGroup();
        grp.addOption(tUp);
        grp.addOption(tDown);
        options.addOptionGroup(grp);
        options.addOption("h", "help", false, "display help");
        
        // FASE DE PARSEO
        CommandLineParser parser = new DefaultParser();
        
        try{
            CommandLine cmd = parser.parse(options, args);
            
            //FASE PREGUNTA
            //IF OPCIÓN -h
            if(cmd.hasOption("h")){
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("time", options);
            }else{
                //IF SUBIR
                if(cmd.hasOption(tUp)){
                    int temp = Integer.parseInt(cmd.getOptionValue(tUp));
                    controlador.upTemp(temp);
                }
                //IF BAJAR
                if(cmd.hasOption(tDown)){
                    int temp = Integer.parseInt(cmd.getOptionValue(tDown));
                    controlador.downTemp(temp);
                }
            }
            
        }catch(ParseException ex){
            System.err.println(ex.getLocalizedMessage());
        }
        
    }
    
    public void showTemp(int temp){
        System.out.println("Current temperature is "
                + String.format("%, .2f", temp));
    }
}