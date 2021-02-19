package entity;

public enum EntityType {
    cat("Кошечку"), dog("Собачку"), umbrella("Зонтик"), ball("Мячик"), tennis_rocket("Тенисную ракетку"), bottle("Бутылку водки");
    public static int COUNT_ENTITIES = values().length;

    private String name = "";

    public String getName(){
        return name;
    }

    EntityType(String name){
        this.name = name;
    }

    public static EntityType generateRandomEntity(){
        int randomPosition = (int)(Math.random()* COUNT_ENTITIES);
        return values()[randomPosition];
    }
}
