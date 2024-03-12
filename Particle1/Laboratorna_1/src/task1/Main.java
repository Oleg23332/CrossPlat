package task1;

import javax.swing.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                String typeName = args[0];
                TypeInfoAnalyzer analyzer = new TypeInfoAnalyzer();
                System.out.println(analyzer.getTypeInfo(typeName));
            }

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new TypeInfoAnalyzerGUI().setVisible(true);
                }
            });
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
