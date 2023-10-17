package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_FIRED_BY_RIFLE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsFired = 0;
        bulletsFired += 10;

        if (getBulletsCount() < BULLETS_FIRED_BY_RIFLE) {
            return 0;
        }

        setBulletCount(getBulletsCount() - BULLETS_FIRED_BY_RIFLE);

        return bulletsFired;
    }
}
