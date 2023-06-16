package Players;

public enum PlayerType
{
    France("F"), Russia("R");

    private final String value;

    PlayerType(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
