package myApplication;

import mybeans.*;
import mybeans.DataSheetTable;
import xml.*;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    private final DataSheetTable dataSheetTable = new DataSheetTable();
    private DataSheet dataSheet = new DataSheet();
    private final DataSheetGraph graph = new DataSheetGraph();

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 610, 500);
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        dataSheet.addDataItem(new Data());

        JPanel southPanel = new JPanel();
        JButton readButton = new JButton("Open");
        JButton saveButton = new JButton("Save");
        JButton clearButton = new JButton("Clear");
        JButton closeButton = new JButton("Exit");

        closeButton.addActionListener(arg0 -> dispose());
        clearButton.addActionListener(e -> {
            dataSheet = new DataSheet();
            dataSheet.addDataItem(new Data());
            dataSheetTable.setDataSheet(dataSheet);
            dataSheetTable.revalidate();
            graph.setDataSheet(dataSheet);
        });

        saveButton.addActionListener(e -> {
            if (JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
                String fileName = chooser.getSelectedFile().getPath();
                WriteToXML.saveXMLDoc(dataSheet, fileName);
                JOptionPane.showMessageDialog(null,
                        "File " + fileName.trim() + " saved!", "Results are saved",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        readButton.addActionListener(e -> {
            if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
                String fileName = chooser.getSelectedFile().getPath();
                dataSheet = MySAXParser.XMLReadData(fileName);
                dataSheetTable.setDataSheet(dataSheet);
                dataSheetTable.revalidate();
                graph.setDataSheet(dataSheet);
            }
        });

        southPanel.add(readButton);
        southPanel.add(saveButton);
        southPanel.add(clearButton);
        southPanel.add(closeButton);
        add(southPanel, BorderLayout.SOUTH);
        graph.setDataSheet(dataSheet);
        dataSheetTable.getTableModel().setDataSheet(dataSheet);

        dataSheetTable.getTableModel().addTableModelListener(
                e -> {
                    graph.revalidate();
                    graph.repaint();
                });

        graph.setPreferredSize(new Dimension(400, 300));
        dataSheetTable.setPreferredSize(new Dimension(200, 300));
        add(graph, BorderLayout.EAST);
        add(dataSheetTable, BorderLayout.WEST);
    }
}