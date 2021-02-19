package entity;

public class BallEntity extends BaseEntity{

    private static final String BALL_IMAGE = "ball.png";

    public BallEntity(int width, int height) {
        super(BALL_IMAGE, width, height);
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.ball;
    }

}
