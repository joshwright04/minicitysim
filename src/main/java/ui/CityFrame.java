package ui;

import java.util.HashMap;
import java.util.Map;
import game.*;
import game.building.BuildingFactory;
import game.building.RealEstate;
import observers.CityObserver;

import javax.swing.*;
import java.awt.*;

public class CityFrame extends JFrame implements CityObserver {
    private final City city;
    private final JLabel moneyLabel;
    private final JPanel gridPanel;
    private final BuildingFactory buildingFactory = new BuildingFactory();
    private final Map<String, ImageIcon> iconCache = new HashMap<>();

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("Game");

        JMenuItem nextTick = new JMenuItem("Next Tick");
        nextTick.addActionListener(e -> city.tick());

        JMenuItem quit = new JMenuItem("Quit");
        quit.addActionListener(e -> {
            this.city.running = false;
            System.exit(0);
        });

        gameMenu.add(nextTick);
        gameMenu.add(quit);

        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
    }

    public CityFrame(City city) {
        this.city = city;
        this.moneyLabel = new JLabel();
        this.gridPanel = new JPanel();

        moneyLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        moneyLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 15));
        moneyLabel.setFont(new Font("Arial", Font.BOLD, 18));

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
        if(city.getMoney() <= 0){
            this.city.running = false;
            System.exit(0);
        }
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

                Position position = new Position(x, y);
                button.addActionListener(e -> showTileMenu(button, position));

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
            case LAKE -> "/images/lake.png";
        };
    }

    private void showTileMenu(Component parent, Position position) {
        JPopupMenu menu = new JPopupMenu();

        Tile tile = city.getMap().getTile(position);

        if (tile.getObject() instanceof RealEstate realEstate) {
            JMenu tenantMenu = new JMenu("Tenants");

            for (String tenantName : realEstate.getTenantNames()) {
                JMenuItem tenantItem = new JMenuItem(tenantName);
                tenantItem.setEnabled(false);
                tenantMenu.add(tenantItem);
            }

            menu.add(tenantMenu);
            menu.addSeparator();
        }

        JMenu placeMenu = new JMenu("Place Building");

        placeMenu.add(createPlaceMenuItem("Cottage", position));
        placeMenu.add(createPlaceMenuItem("House", position));
        placeMenu.add(createPlaceMenuItem("Mansion", position));
        placeMenu.add(createPlaceMenuItem("Farm", position));
        placeMenu.add(createPlaceMenuItem("Factory", position));

        placeMenu.addSeparator();

        placeMenu.add(createPlaceMenuItem("Budget Apartment Complex", position));
        placeMenu.add(createPlaceMenuItem("Mid-Tier Apartment Complex", position));
        placeMenu.add(createPlaceMenuItem("Luxury Apartment Complex", position));

        JMenuItem removeItem = new JMenuItem("Remove Building");
        removeItem.addActionListener(e -> {
            boolean success = city.demolish(position);

            if (!success) {
                JOptionPane.showMessageDialog(this, "Nothing to remove here.");
            }
        });

        menu.add(placeMenu);
        menu.add(removeItem);

        menu.show(parent, parent.getWidth() / 2, parent.getHeight() / 2);
    }

    private JMenuItem createPlaceMenuItem(String buildingName, Position position) {
        JMenuItem item = new JMenuItem(buildingName);

        item.addActionListener(e -> {
            boolean success = city.place(buildingName, position);

            if (!success) {
                JOptionPane.showMessageDialog(this, "Could not place " + buildingName + " here.");
            }
        });

        return item;
    }
}