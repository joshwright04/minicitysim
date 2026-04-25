package ui;

import game.*;
import observers.CityObserver;

import javax.swing.*;
import java.awt.*;

public class CityFrame extends JFrame implements CityObserver {
    private final City city;
    private final JLabel moneyLabel;
    private final JPanel gridPanel;

    public CityFrame(City city) {
        this.city = city;
        this.moneyLabel = new JLabel();
        this.gridPanel = new JPanel();

        city.addObserver(this);

        setTitle("MiniCitySim");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        add(moneyLabel, BorderLayout.NORTH);
        add(gridPanel, BorderLayout.CENTER);

        refresh();
    }

    @Override
    public void onCityChanged(City city) {
        refresh();
    }

    private void refresh() {
        moneyLabel.setText("Money: $" + city.getMoney());

        gridPanel.removeAll();

        CityMap map = city.getMap();
        int rows = map.getRows();
        int cols = map.getCols();

        gridPanel.setLayout(new GridLayout(rows, cols));

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                Tile tile = map.getTile(new Position(x, y));

                JButton button = new JButton(getTileText(tile));
                button.setFocusable(false);

                gridPanel.add(button);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private String getTileText(Tile tile) {
        if (tile.getObject() != null) {
            return tile.getObject().getSymbol();
        }

        return switch (tile.getTerrainType()) {
            case LAND -> ".";
            case ROCK -> "R";
            case RIVER -> "~";
        };
    }
}