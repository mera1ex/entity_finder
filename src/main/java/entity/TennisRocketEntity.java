package entity;

public class TennisRocketEntity extends BaseEntity {

    private static final String TENNIS_ROCKET_IMAGE = "tennis_rocket.png";

    public TennisRocketEntity(int width, int height) {
        super(TENNIS_ROCKET_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.tennis_rocket;
    }

}
