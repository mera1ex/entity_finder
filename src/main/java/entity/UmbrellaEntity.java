package entity;

public class UmbrellaEntity extends BaseEntity {
    private static final String UMBRELLA_IMAGE = "umbrella.png";

    public UmbrellaEntity(int width, int height) {
        super(UMBRELLA_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.umbrella;
    }
}
