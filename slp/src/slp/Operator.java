package slp;

/** An enumeration containing all the operation types in the SLP language.
 */
public enum Operator {
	PLUS, MINUS, MULTIPLY, DIVIDE, MOD, LAND, LOR,
	LT, NEQUAL,  GT ,EQUAL,  LNEG, GTE, LTE;
	
	/** Prints the operator in the same way it appears in the program.
	 */
	/*
	public String toString() {
		switch (this) {
		case MINUS: return "-";
		case PLUS: return "+";
		case MULTIPLY: return "*";
		case DIVIDE: return "/";
		case LT: return "<";
		case LTE: return "<=";
		case GT: return ">";
		case GTE: return ">=";
		case MOD: return "%";
		case LAND: return "&&";
		case LOR: return "||";

		case EQUAL: return "==";
		case NEQUAL: return "!=";
		case LNEG: return "!"; 
		default: throw new RuntimeException("Unexpted value: " + this.name());
		}
	}*/
	
	public String toString() {
		switch (this) {
		case MINUS: return "subtraction";
		case PLUS: return "addition";
		case MULTIPLY: return "multiplication";
		case DIVIDE: return "division";
		case LT: return "less than";
		case LTE: return "less than or equal to";
		case GT: return "greater than";
		case GTE: return "greater than or equal to";
		case MOD: return "mod";
		case LAND: return "and";
		case LOR: return "or";

		case EQUAL: return "equality";
		case NEQUAL: return "inequality";
		case LNEG: return "negative"; 
		default: throw new RuntimeException("Unexpted value: " + this.name());
		}
	}
}