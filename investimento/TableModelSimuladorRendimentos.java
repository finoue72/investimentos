package investimento;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class TableModelSimuladorRendimentos extends AbstractTableModel {
    
    protected Vector columnNames;
    
    protected Vector data = new Vector();;
    
    public TableModelSimuladorRendimentos(Vector columnNames) {
        this.columnNames = columnNames;
    }
    
    public int getRowCount() {
        return data.size()/columnNames.size();
    }
    
    public int getColumnCount() {
        return columnNames.size();
    }
    
    public String getColumnName(int columnIndex) {
        String colName = "";
        
        if (columnIndex <= getColumnCount())
            colName = (String) columnNames.elementAt(columnIndex);
        
        return colName;
    }
    
    public Class getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }
    
    public boolean isCellEditable(int rowIndex, int columnIndex) {       
        return false;
    }
    
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get((rowIndex *columnNames.size()) + columnIndex);
    }
    
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data.set((rowIndex *columnNames.size()) + columnIndex, aValue);
       
    }
    
    
    /**
     * @param data The data to set.
     */
    public void setData(Vector data) {
        this.data = data;
        fireTableChanged(null);
    }
}