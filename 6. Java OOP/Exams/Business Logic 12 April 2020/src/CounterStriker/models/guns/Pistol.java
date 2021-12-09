package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int BULLETS_FIRED_BY_RIFLE = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int bulletsFired = 0;
        bulletsFired += 1;

        if (getBulletsCount() < BULLETS_FIRED_BY_RIFLE) {
            return 0;
        }

        setBulletCount(getBulletsCount() - BULLETS_FIRED_BY_RIFLE);

        return bulletsFired;
    }
}
