package renovation.core;

import renovation.models.Laminate;
import renovation.models.Tile;
import renovation.models.WoodType;

import java.util.*;
import java.util.stream.Collectors;

public class RenovationImpl implements Renovation {
    private Queue<Tile> tileQueue = new LinkedList<>();
    private Deque<Laminate> laminateDeque = new LinkedList<>();
    private double deliveredArea = 0.0;

    @Override
    public void deliverTile(Tile tile) {
        double totalArea = tile.getArea() + deliveredArea;
        if (totalArea <= 30) {
            tileQueue.offer(tile);
            deliveredArea = totalArea;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void deliverFlooring(Laminate laminate) {
        this.laminateDeque.offer(laminate);
    }

    @Override
    public double getDeliveredTileArea() {
        return deliveredArea;
    }

    @Override
    public boolean isDelivered(Laminate laminate) {
        return this.laminateDeque.contains(laminate);
    }

    @Override
    public void returnTile(Tile tile) {
        if (tileQueue.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Tile lastDeliverTile = tileQueue.poll();

        if (!lastDeliverTile.equals(tile)) {
            throw new IllegalArgumentException();
        }

        deliveredArea -= tile.getArea();
    }

    @Override
    public void returnLaminate(Laminate laminate) {
        if (laminateDeque.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Laminate lastDeliveredLaminate = laminateDeque.pollFirst();

        if (!laminate.equals(lastDeliveredLaminate)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Collection<Laminate> getAllByWoodType(WoodType wood) {
       return laminateDeque.stream()
               .filter(laminate -> laminate.getWoodType() == wood)
               .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> getAllTilesFitting(double width, double height) {
        return tileQueue.stream()
                .filter(tile -> tile.getWidth() <= width && tile.getHeight() <= height)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Tile> sortTilesBySize() {
        return tileQueue.stream()
                .sorted(Comparator.comparingDouble(Tile::getArea).thenComparing(Tile::getDepth))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Laminate> layFlooring() {
        return laminateDeque.descendingIterator();
    }
}
