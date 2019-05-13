/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author tassio
 */
@ManagedBean
public class alunoBean implements Serializable{
    
    private BarChartModel barModel;
    
    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries data = new ChartSeries();
        data.setLabel("Alunos");
        data.set("Zé", 75);
        data.set("João", 100);
        data.set("Pedro", 44);
        data.set("Lucas", 0);
        data.set("Vitor", 25);
 
        model.addSeries(data);
 
        return model;
    }
 
    private void createBarModels() {
        createBarModel();
    }
 
    private void createBarModel() {
        barModel = initBarModel();
 
        barModel.setTitle("Notas");
        barModel.setLegendPosition("ne");
 
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Alunos");
 
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Notas");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
 
}
