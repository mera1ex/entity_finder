package entity;

public class CatEntity extends BaseEntity {


    private static final String CAT_IMAGE = "cat.png";

    public CatEntity(int width, int height) {
        super(CAT_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.cat;
    }
}
