public class Tram {
    public double minSpeed;
    public double maxSpeed;
    public double driftChance;
    public String tramName;
    public double chance;

    public Tram(double minSpeed, double maxSpeed, double driftChance, String tramName, double chance) {
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.driftChance = driftChance;
        this.tramName = tramName;
        this.chance = chance;
    }

    public String winnerName() {
        String winnerName = tramName;
        return winnerName;
    }


    public double tramSpeed() {
        double tramSpeed = chance * (maxSpeed - minSpeed) + minSpeed;
        return  tramSpeed;
    }

    public boolean driftFact() {
        if (chance < driftChance) {
            return  true;
        } else {
            return false;
        }
    }
    public double tramsFinishersSpeed() {
        if (driftFact()){
            return 0;
        } else {
            return tramSpeed();
        }
    }


}
