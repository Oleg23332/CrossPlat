package mybeans;

import javax.swing.*;
import java.awt.*;

public class DataSheetTable extends JPanel {
    private final JTable table;
    private DataSheetTableModel tableModel;


    public DataSheetTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DataSheetTableModel tableModel) {
        this.tableModel = tableModel;
        table.revalidate();
    }

    public void revalidate() {
        if (table != null) table.revalidate();
    }

    public void setDataSheet(DataSheet dataSheet) {
        getTableModel().setDataSheet(dataSheet);
        tableModel.fireTableDataChanged();
    }

    public DataSheetTable() {
        table = new JTable();
        DataSheet dataTable = new DataSheet();
        tableModel = new DataSheetTableModel();
        table.setModel(tableModel);
        tableModel.setDataSheet(dataTable);

        JPanel buttonPanel = new JPanel();
        setLayout(new BorderLayout());

        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(e -> {
            tableModel.getDataSheet().addDataItem(new Data());
            tableModel.setRowCount(tableModel.getRowCount() + 1);
            tableModel.fireTableRowsInserted(tableModel.getRowCount() - 1, tableModel.getRowCount() - 1);
        });

        deleteButton.addActionListener(e -> {
            if (tableModel.getRowCount() > 1) {
                tableModel.setRowCount(tableModel.getRowCount() - 1);
                tableModel.getDataSheet().removeDataItem(tableModel.getRowCount());
                tableModel.fireTableRowsDeleted(tableModel.getRowCount(), tableModel.getRowCount());
            } else {
                tableModel.getDataSheet().getDataItem(0).setDate("");
                tableModel.getDataSheet().getDataItem(0).setX(0);
                tableModel.getDataSheet().getDataItem(0).setY(0);
                tableModel.fireTableDataChanged();
            }
        });
    }
}