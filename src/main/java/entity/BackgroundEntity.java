package entity;

public class BackgroundEntity extends BaseEntity{

    private static final String BACKGROUND_IMAGE = "background.jpg";

    public BackgroundEntity(int width, int height) {
        super(BACKGROUND_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.dog;
    }
}
