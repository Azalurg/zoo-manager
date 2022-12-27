import java.beans.ConstructorProperties;

public class SpecieCount {
    private final String specieName;
    private final long animalCount;

    @ConstructorProperties({"specieName", "animalCount"})
    public SpecieCount(String specieName, long animalCount) {
        this.specieName = specieName;
        this.animalCount = animalCount;
    }

    public String getSpecieName() {
        return specieName;
    }

    public long getAnimalCount() {
        return animalCount;
    }
}