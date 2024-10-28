/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases_compartidas;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;

public class GraficasVentas {
    
     public static float ventasCategoriaMes(List<Factura> facturas, Categoria categoria, int mes, int annio) {
         float ventasCategoria = 0.0f;
         for(Factura fact: facturas){
             if(fact.getLocalFecha().getMonthValue() == mes && fact.getLocalFecha().getYear() == annio){
                for(DetalleVenta v: fact.getDetalles()){
                    if(v.getCategoria().equals(categoria.getNombre())){
                        ventasCategoria += v.importe();
                    }
                }
             }
         }
         return ventasCategoria;
     }
    
     public static List<Factura> filtrarFacturasPorFechaYCategoria(List<Factura> facturas, LocalDate fechaInicio, LocalDate fechaFin, List<Categoria> categoriasSeleccionadas) {
        return facturas.stream()
                .filter(factura -> factura.getLocalFecha().isAfter(fechaInicio.minusDays(1)) && factura.getLocalFecha().isBefore(fechaFin.plusDays(1)))
                .filter(factura -> factura.getDetalles().stream()
                        .anyMatch(detalle -> categoriasSeleccionadas.contains(detalle.getProducto().getCategoria())))
                .collect(Collectors.toList());
    }
    
    public static void crearYMostrarGraficaEnPanel(JPanel panel, DefaultCategoryDataset dataset) {
        JFreeChart lineChartObject = ChartFactory.createLineChart(
            "Ventas por Categoría", "Mes", "Importe",
            dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = lineChartObject.getCategoryPlot();

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();

        renderer.setSeriesLinesVisible(0, true);

        renderer.setSeriesShapesVisible(0, true); 

        plot.setRenderer(renderer);

        ChartPanel chartPanel = new ChartPanel(lineChartObject);
        chartPanel.setPreferredSize(new Dimension(panel.getWidth(), panel.getHeight()));

        panel.removeAll(); 
        panel.setLayout(new BorderLayout());
        panel.add(chartPanel, BorderLayout.CENTER);
        panel.validate(); 
    }
}
