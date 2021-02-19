package entity;

public class BottleEntity extends BaseEntity {
    private static final String CAT_IMAGE = "bottle.png";

    public BottleEntity(int width, int height) {
        super(CAT_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.bottle;
    }
}
