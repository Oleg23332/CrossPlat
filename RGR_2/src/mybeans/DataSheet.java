package mybeans;

import java.util.*;

public class DataSheet {
    private ArrayList<Data> dataTable;

    public Data getDataItem(int rowIndex) {
        return dataTable.get(rowIndex);
    }

    public int size() {
        return dataTable.size();
    }

    public void addDataItem(Data data) {
        dataTable.add(data);
    }

    public void removeDataItem(int i) {
        dataTable.remove(i);
    }

    public ArrayList<Data> getDataTable() {
        return dataTable;
    }

    public void setDataTable(ArrayList<Data> dataTable) {
        this.dataTable = dataTable;
    }

    @Override
    public String toString() {
        return "DataSheet{" +
                "dataTable =" + dataTable +
                '}';
    }

    public DataSheet(ArrayList<Data> dataTable) {
        this.dataTable = dataTable;
    }

    public DataSheet() {
        this.dataTable = new ArrayList<>();
    }
}