public class Bacteria {
    int x;
    int y;
    int health;

    public Bacteria(int x, int y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
    }

    public void varyBacteria(int newX, int newY, int newHealth) {
        this.x = newX;
        this.y = newY;
        this.health = newHealth;
    }

}
