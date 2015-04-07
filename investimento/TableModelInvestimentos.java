package investimento;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelInvestimentos extends AbstractTableModel {
    
    private String[] columnNames;
    
    private String[][] data;
    
    public TableModelInvestimentos(String[] columnNames) {
        this.columnNames = columnNames;
    }
    
    public int getRowCount() {
        if (data != null){
            return data.length;
        }
        return 0;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public String getColumnName(int columnIndex) {
        String colName = "";
        
        if (columnIndex <= getColumnCount())
            colName = (String) columnNames[columnIndex];
        
        return colName;
    }
    
    public Class getColumnClass(int columnIndex) {
        return String.class;
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {       
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (data != null && (data.length >=rowIndex) &&(data[0].length >=columnIndex)) {
            return data[rowIndex][columnIndex];
        } 
        return " ";
           
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        return;
    }
    
    
    /**
     * @param data The data to set.
     */
    public void setData(String[][] data) {
        this.data = data;
        fireTableChanged(null);
    }
}