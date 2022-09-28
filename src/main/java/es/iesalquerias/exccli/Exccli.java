/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.iesalquerias.exccli;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.cli.*;

/**
 *
 * @author lopas
 */
public class Exccli {
    public static void main(String[] args){
        
        //Creamos el objeto Options
        Options op = new Options();
        OptionGroup grp = new OptionGroup();
        
        //Añadimos opcion t
        op.addOption("t", false, "Mostrar hora actual");
        //Añadimos la opcion w
        op.addOption("w", "hello world" , false, "Hello World");
        //Añadimos la opcion h
        op.addOption("h", "help", false, "Mensaje de ayuda");
        //Añadimos la opcion y
        op.addOption("y", "years", true, "años de vida");
        //Añadimos el grupo n c
        grp.addOption(new Option("n", "El mundo es bonito"));
        grp.addOption(new Option("c", "El mundo es cruel"));
        op.addOptionGroup(grp);
        
        
        
        //Fase de Parseo
        CommandLineParser parser = new DefaultParser();
        
        try{
        CommandLine cmd = parser.parse(op, args);

        //Si opcion "w"
        if(cmd.hasOption("w")){
            System.out.println("Hola mundo");
            
        }
        //si opcion n
        if(cmd.hasOption("n")){
            System.out.println("El mundo es bonito");
        }
        //si opcion c
        if(cmd.hasOption("c")){
            System.out.println("El mundo es cruel");
        }
        
        //si opcion h
        if(cmd.hasOption("h")){
            HelpFormatter formater = new HelpFormatter();
            formater.printHelp("h", op);
        }
        
        //si opcion y
        if(cmd.hasOption("y")){
            String anios;
            anios = cmd.getOptionValue("y");
            System.out.println("tras" + anios + "años de vida");
        }
        }catch(ParseException ex){
            ex.printStackTrace(System.err);
        }
        
    }
}
