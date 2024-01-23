package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            String jrxmlFile = "Ej1.jrxml";
            JasperReport jasperReport = JasperCompileManager.compileReport(jrxmlFile);

            Persona padre = new Persona("Juan", "Gómez", "01/05/1970", "Ciudad Ficticia", "Calle Principal 123", "Ficticiópolis", "Fictonia", "123456789");
            Persona madre = new Persona("María", "López", "15/08/1975", "Ciudad Ficticia", "Avenida Secundaria 456", "Ficticiópolis", "Fictonia", "987654321");
            Persona hijo = new Persona("Lucía", "Gómez López", "10/12/2000", "Ciudad Ficticia", "Calle de los Niños 789", "Ficticiópolis", "Fictonia", "567890123");

            List<Persona> familia = Arrays.asList(padre, madre, hijo);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(familia);

            Map<String, Object> parameters = new HashMap<>();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, System.getProperty("user.home") + "/Downloads/Reporte_Familiar.pdf");

            System.out.println("Informe generado con éxito.");

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}