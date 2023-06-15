package Units;

public enum UnitType
{
    Piechota("p"), Kawaleria("k"), Artyleria("a");

    private String value;

    UnitType(String value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return this.value;
    }
    public static UnitType fromString(String value)
    {
        for(UnitType unit :UnitType.values())
        {
            if(unit.value.equalsIgnoreCase(value))
            {
                return unit;
            }
        }
        return null;
    }
}