package org.baseapp.animals;

public class Cat extends Animal {
    private static int catCount = 0;
    private boolean satiety; // Сытость
    private int appetite;  // Сколько кот может покушать еды


    public Cat(String name, int appetite) {
    super(name, 200, 0); // Имя, бег, плавание
    this.appetite = appetite;
    this.satiety = false;
    catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

        public void eat(CatBowl bowl) {
        if (satiety) {
            System.out.println(name + " уже сыт(а).");
            return;
        }

        if (bowl.decreaseFood(this.appetite)) {
            this.satiety = true;
            System.out.println(name + " съел(а) " + appetite + " еды и теперь сыт(а).");
        } else {
            System.out.println(name + " хотел(а) съесть " + appetite + " еды, но в миске недостаточно. Остался(лась) голодным(ой).");
        }
    }

    public void printSatietyInfo() {
        System.out.println(name + ": " + (satiety ? "сыт(а)" : "голоден(дна)") + " (аппетит: " + appetite + ")");
    }

    public static class CatBowl {  // Миска
        private int food;

        public CatBowl(int food) {
            this.food = Math.max(food, 0);
        }

            public void addFood(int amount) {
                if (amount > 0) {
                    this.food += amount;
                    System.out.println("В миску добавили " + amount + " еды. Всего: " + this.food);
                }
            }

            public boolean decreaseFood(int amount) {
                if (this.food >= amount) {
                    this.food -= amount;
                    return true;
                }
            return false;
            }
            public void info() {
                System.out.println("В миске осталось еды: " + food);
        }
    }
}