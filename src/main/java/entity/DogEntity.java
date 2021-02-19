package entity;

public class DogEntity extends BaseEntity {
    private static final String DOG_IMAGE = "dog.png";

    public DogEntity(int width, int height) {
        super(DOG_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.dog;
    }
}
