package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;

public class RenovationImpl implements Renovation {
    private List<Tile> tilePile;
    private List<Laminate> laminatePile;
    private double deliveredArea = 0;

    public RenovationImpl() {
        this.tilePile = new ArrayList<>();
        this.laminatePile = new LinkedList<>();
    }

    @Override
    public void deliverTile(Tile tile) {
        if (deliveredArea + tile.getArea() > 30) {
            throw new IllegalArgumentException();
        }

        this.tilePile.add(tile);
        deliveredArea += tile.getArea();
    }

    @Override
    public void deliverFlooring(Laminate laminate) {
        this.laminatePile.add(laminate);
    }

    @Override
    public double getDeliveredTileArea() {
        return deliveredArea;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {
        return this.laminatePile.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {
        if (!tilePile.contains(tile)) {
            throw new IllegalArgumentException();
        }

        tilePile.remove(tile);
        deliveredArea -= tile.getArea();
    }

    @Override
    public void returnLaminate(Laminate laminate) {
        if (!laminatePile.contains(laminate)) {
            throw new IllegalArgumentException();
        }

        laminatePile.remove(laminate);
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
        List<Laminate> result = new ArrayList<>();

        for (Laminate laminate : laminatePile) {
            if (laminate.getWoodType() == wood) {
                result.add(laminate);
            }
        }
        return result;
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        List<Tile> result = new ArrayList<>();

        for (Tile tile : tilePile) {
            if (tile.getWidth() <= width && tile.getHeight() <= height) {
                result.add(tile);
                }
            }
        return result;
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
        List<Tile> sortedTiles = new ArrayList<>(tilePile);

        sortedTiles.sort(Comparator.comparing(Tile::getArea).thenComparing(Tile::getDepth));

        return sortedTiles;
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        return laminatePile.iterator();
    }
}
