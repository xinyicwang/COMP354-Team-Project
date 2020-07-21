package gui;

public enum Symbol{
	ZERO("0"),
	ONE("1"),
	TWO("2"),
	THREE("3"),
	FOUR("4"),
	FIVE("5"),
	SIX("6"),
	SEVEN("7"),
	EIGHT("8"),
	NINE("9"),
	DECIMAL("."),
	OPENPAREN("("),
	CLOSEPAREN(")"),
	COMMA(","),
	SIN("SIN("),
	EPOW("e^("),
	PIPOW("π^("),
	XPOW("^"),
	STDEV("STDEV("),
	MAD("MAD(");
	
	
	
	
	private final String value;
    private Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
    public static Symbol getSymbol(String s) {
    	
    	
		return null;
    	
    }
}
