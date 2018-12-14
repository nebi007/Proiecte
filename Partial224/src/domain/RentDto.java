package domain;

public class RentDto {
    private Enum type;
    private Long nrcarti;

    public Enum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "RentDto{" +
                "type=" + type +
                ", nrcarti=" + nrcarti +
                '}';
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public Long getNrcarti() {
        return nrcarti;
    }

    public void setNrcarti(Long nrcarti) {
        this.nrcarti = nrcarti;
    }

    public RentDto(Enum type, Long nrcarti) {
        this.type = type;
        this.nrcarti = nrcarti;
    }
}
