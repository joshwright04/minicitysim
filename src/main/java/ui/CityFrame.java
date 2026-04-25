package ui;

import java.util.HashMap;
import java.util.Map;
import game.*;
import game.building.BuildingFactory;
import observers.CityObserver;

import javax.swing.*;
import java.awt.*;

public class CityFrame extends JFrame implements CityObserver {
    private final City city;
    private final JLabel moneyLabel;
    private final JPanel gridPanel;
    private final BuildingFactory buildingFactory = new BuildingFactory();
    private final Map<String, ImageIcon> iconCache = new HashMap<>();

    private JMenuItem createBuildingMenuItem(String name) {
        JMenuItem item = new JMenuItem(name);

        item.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(
                    this,
                    "Enter coordinates as x,y:",
                    "Place " + name,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (input == null) return;

            String[] parts = input.split(",");

            if (parts.length != 2) {
                JOptionPane.showMessageDialog(this, "Use format: x,y");
                return;
            }

            try {
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());

                Position buildingPosition = new Position(x, y);

               city.place(name, buildingPosition);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Coordinates must be numbers.");
            }
        });

        return item;
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");
        JMenu placeMenu = new JMenu("Place");

        JMenuItem nextTick = new JMenuItem("Next Tick");
        nextTick.addActionListener(e -> {
            city.tick();
        });

        JMenuItem remove = new JMenuItem("Remove");
        remove.addActionListener(e -> {
            System.out.println("Remove selected");
        });

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(e -> {
            this.city.running = false;
            System.exit(0);
        });

        placeMenu.add(createBuildingMenuItem("Cottage"));
        placeMenu.add(createBuildingMenuItem("House"));
        placeMenu.add(createBuildingMenuItem("Mansion"));
        placeMenu.add(createBuildingMenuItem("Farm"));
        placeMenu.add(createBuildingMenuItem("Factory"));
        placeMenu.add(createBuildingMenuItem("Apartment Complex"));

        gameMenu.add(placeMenu);
        gameMenu.addSeparator();
        gameMenu.add(remove);
        gameMenu.add(nextTick);
        gameMenu.add(quit);

        menuBar.add(gameMenu);

        setJMenuBar(menuBar);
    }

    public CityFrame(City city) {
        this.city = city;
        this.moneyLabel = new JLabel();
        this.gridPanel = new JPanel();

        city.addObserver(this);

        setTitle("MiniCitySim");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        setupMenu();

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

                JButton button = new JButton();
                button.setFocusable(false);

                String imagePath;

                if (tile.getObject() != null) {
                    imagePath = tile.getObject().getImagePath();
                } else {
                    imagePath = getTerrainImagePath(tile.getTerrainType());
                }

                button.setIcon(loadIcon(imagePath));

                gridPanel.add(button);
            }
        }

        gridPanel.revalidate();
        gridPanel.repaint();
    }


    private ImageIcon loadIcon(String path) {
        return iconCache.computeIfAbsent(path, p -> {
            java.net.URL url = getClass().getResource(p);

            if (url == null) {
                System.out.println("Missing image: " + p);
                return null;
            }

            ImageIcon raw = new ImageIcon(url);
            Image scaled = raw.getImage().getScaledInstance(96, 96, Image.SCALE_SMOOTH);
            return new ImageIcon(scaled);
        });
    }

    private String getTerrainImagePath(TerrainType terrainType) {
        return switch (terrainType) {
            case LAND -> "/images/land.png";
            case ROCK -> "/images/rock.png";
            case RIVER -> "/images/river.png";
        };
    }
}