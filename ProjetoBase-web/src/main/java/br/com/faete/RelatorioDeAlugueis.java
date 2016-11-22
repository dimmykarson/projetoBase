/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.faete;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author sticdev30
 */
@ManagedBean
public class RelatorioDeAlugueis implements Serializable {

    private LineChartModel areaModel;

    @PostConstruct
    public void init() {
        createAreaModel();
    }

    public void createAreaModel() {
        areaModel = new LineChartModel();

        LineChartSeries alugueis = new LineChartSeries();
        alugueis.setFill(true);
        alugueis.setLabel("Aluguéis");
        alugueis.set("Janeiro", 100);
        alugueis.set("Fevereiro", 38);
        alugueis.set("Março", 17);
        alugueis.set("Abril", 25);
        alugueis.set("Maio", 212);
        alugueis.set("Junho", 34);
        alugueis.set("Julho", 540);

        areaModel.addSeries(alugueis);

        areaModel.setTitle("Gráfico de Alugués");
//        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Mês");
        areaModel.getAxes().put(AxisType.X, xAxis);
        
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Quantidade");
        yAxis.setMin(0);
        yAxis.setMax(600);

    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    public void setAreaModel(LineChartModel areaModel) {
        this.areaModel = areaModel;
    }
    
    

}
