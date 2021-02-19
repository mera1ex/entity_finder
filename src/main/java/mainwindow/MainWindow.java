package mainwindow;

import entity.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import static entity.EntityType.COUNT_ENTITIES;

public class MainWindow extends JFrame {

    private static final String WINDOW_TITLE = "Найти предмет или существо";
    private static final int WINDOW_X = 100;
    private static final int WINDOW_Y = 100;
    private static final int WINDOW_WIDTH = 1024;
    private static final int WINDOW_HEIGHT = 728;
    private static final String QUESTION_TEXT = "Покажи мне ";
    private JLabel label = new JLabel(QUESTION_TEXT);
    private JLabel label_help = new JLabel("");
    private BackgroundEntity backgroundEntity = new BackgroundEntity(WINDOW_WIDTH,WINDOW_HEIGHT);
    private BaseEntity[] entities = new BaseEntity[COUNT_ENTITIES];
    private EntityType[] typesForFound = new EntityType[COUNT_ENTITIES];
    private int positionForFind = 0;


    public MainWindow(){
        super(WINDOW_TITLE);
        setVisible(true);
        initFields();
    }

    private void setCurrentFoundItem(){
        if (positionForFind < typesForFound.length){
            label.setText(QUESTION_TEXT + typesForFound[positionForFind].getName());
            positionForFind++;
        }else{
            positionForFind=0;
            redraw();
            createEntitiesForFound();
            setCurrentFoundItem();
        }
    }

    private void createEntitiesForFound(){
        Random rnd = new Random();
        createEntityTypes();
        for(int i = 0; i < typesForFound.length; i++) {
            int index = rnd.nextInt(i + 1);
            EntityType a = typesForFound[index];
            typesForFound[index] = typesForFound[i];
            typesForFound[i] = a;
        }
    }

    private void initFields(){
        this.setBounds(WINDOW_X,WINDOW_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        redraw();
        createEntitiesForFound();
        setCurrentFoundItem();
    }

    private void redraw(){
        Container container = this.getContentPane();
        container.setLayout(null);
        container.removeAll();
        label.setFont( new Font(label.getName(), Font.PLAIN, 25) );
        label.setBounds(20,0,500,50);
        label_help.setBounds(500,0,300,50);
        label_help.setFont( new Font(label.getName(), Font.PLAIN, 25) );
        container.add(label);
        container.add(label_help);
        backgroundEntity.setBounds(0,75, WINDOW_WIDTH, WINDOW_WIDTH-75);
        createEntities(container);
        container.add(backgroundEntity);
        container.update(container.getGraphics());
    }


    private void createEntities(Container container){

        randomizeEntityPosition();
        for (int i=0;i<entities.length;i++){
            container.add(entities[i]);
        }
    }

    private void randomizeEntityPosition(){
        for (int i=0;i<entities.length;i++){
            int randX = 50 + (int)(Math.random()*(WINDOW_WIDTH-100));
            int randY = 200 + (int)(Math.random()*(WINDOW_HEIGHT-250));
            int randSize = 75 + (int)(Math.random()*100);
            createEntity(i,randSize);
            entities[i].setBounds(randX,randY, randSize, randSize);
        }
    }

    private void createEntity(int position, int randSize){
        switch (position) {
            case 0: entities[position] = new CatEntity(randSize, randSize); break;
            case 1: entities[position] = new DogEntity(randSize, randSize); break;
            case 2: entities[position] = new UmbrellaEntity(randSize, randSize); break;
            case 3: entities[position] = new TennisRocketEntity(randSize, randSize); break;
            case 4: entities[position] = new BottleEntity(randSize, randSize); break;
            case 5: entities[position] = new BallEntity(randSize, randSize); break;
        }
        entities[position].addMouseListener(new EntityEventListener());
    }

    private void createEntityTypes(){
        typesForFound[0] = EntityType.ball;
        typesForFound[1] = EntityType.cat;
        typesForFound[2] = EntityType.dog;
        typesForFound[3] = EntityType.bottle;
        typesForFound[4] = EntityType.umbrella;
        typesForFound[5] = EntityType.tennis_rocket;
    }

    class EntityEventListener implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getSource() instanceof BaseEntity){
                BaseEntity base = (BaseEntity)e.getSource();
                if (base.getEntityType() == typesForFound[positionForFind - 1]){
                    label_help.setText("Молодец нашел!");
                    base.setVisible(false);
                    setCurrentFoundItem();
                }else{
                    label_help.setText("Это не то :(");
                }
                new Thread(waiting).start();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    Runnable waiting = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                label_help.setText("");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

}
