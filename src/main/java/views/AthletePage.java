package views;

import models.Athlete.AthleteColumnModel;
import models.Athlete.AthleteModel;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import models.MultiLineCell;

import static utils.Layout.calcH;
import static utils.Layout.calcW;

public class AthletePage extends JPanel {
    
    private ArrayList athData;
    private AthleteModel athModel;
    private JScrollPane scrlPane;
    private JTable table;
    private JButton changeBtn;
    private JButton delBtn;
    private JButton addBtn;
    private AthleteColumnModel acm;
       
    public AthletePage() { 
        CommonSettings.panelSettings(this); 
        athModel = AthleteModel.getAthleteModelInstance(); 
        athData = athModel.getAthleteDataLink();
        setTableSettings();       
        setScrlPaneSettings();
        //display the result
        athModel.setDataSource(); 
        //set columnModel for table
        acm = new AthleteColumnModel(table); 
        acm.setTableColumnsSettings();
        setChangeBtnSettings();
        setDelBtnSettings();
        setAddBtnSettings(); 
        //set a sort
        table.setRowSorter(new TableRowSorter(athModel));
    }
    //TABLE*********************************************************************
    //table settings
    private void setTableSettings() {
        table = new JTable(athModel);
        table.setVisible(true);
        table.setOpaque(true);
        table.setRowHeight(calcH(90));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setEnabled(false);
        CommonSettings.settingFontBold30(table.getTableHeader());
        CommonSettings.settingFont30(table);
        table.setDefaultRenderer(String.class, new MultiLineCell());
    }    
    public JTable getTable() {
        return this.table;
    }
    
    //SCROLL_PANE***************************************************************
    //scroll pane settings
    private void setScrlPaneSettings() {
        scrlPane = new JScrollPane(table);        
        scrlPane.setVisible(true);
        //color
        //scrlPane.setBackground(new Color(80, 80, 80, 30));
        //scrlPane.getViewport().setBackground(new Color(80, 80, 80, 30));
                
        scrlPane.setSize(calcW(3000), calcH(1190));
        scrlPane.setLocation(calcW(84), calcH(230));
        this.add(scrlPane);
    }  
    
    //BUTTONS*******************************************************************
    private void setChangeBtnSettings() {
        changeBtn = new JButton("Изменить");        
        changeBtn.setBackground(Color.LIGHT_GRAY);
        changeBtn.setSize(calcW(250), calcH(100));
        changeBtn.setLocation(calcW(2834), calcH(1440));
        CommonSettings.settingFont30(changeBtn);
        this.add(changeBtn);
        changeBtn.addActionListener(new controllers.AthletePage.
                                        AthChangeBtnListener());                                        
    }    
    private void setDelBtnSettings() {
        delBtn = new JButton("Удалить");        
        delBtn.setBackground(Color.LIGHT_GRAY);
        delBtn.setSize(calcW(250), calcH(100));
        delBtn.setLocation(calcW(2554), calcH(1440));
        delBtn.setVisible(false);
        CommonSettings.settingFont30(delBtn);
        this.add(delBtn);
        delBtn.addActionListener(new controllers.AthletePage.
                                     DelBtnListener());
    }     
    private void setAddBtnSettings() {
        addBtn = new JButton("Добавить");        
        addBtn.setBackground(Color.LIGHT_GRAY);
        addBtn.setSize(calcW(250), calcH(100));
        addBtn.setLocation(calcW(2274), calcH(1440));
        addBtn.setVisible(false);
        CommonSettings.settingFont30(addBtn);
        this.add(addBtn);
        addBtn.addActionListener(new controllers.AthletePage.
                                     AddBtnListener());
    }     
    public void setBtnsMode(boolean mode) {
        //editable or not regime
        if (mode) {changeBtn.setText("Выйти");}
        else {changeBtn.setText("Изменить");}
        delBtn.setVisible(mode);
        addBtn.setVisible(mode);
        table.setEnabled(mode); 
    }
}